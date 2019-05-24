package com.ving.ecommerce.search.service.impl;

import com.ving.ecommerce.search.entity.Product;
import com.ving.ecommerce.search.model.ProductDTO;
import com.ving.ecommerce.search.model.ResponseObject;
import com.ving.ecommerce.search.repository.SearchRepository;
import com.ving.ecommerce.search.service.SearchService;
import org.elasticsearch.common.unit.Fuzziness;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.*;

import static org.elasticsearch.index.query.MatchQueryBuilder.Operator.AND;
import static org.elasticsearch.index.query.QueryBuilders.matchPhraseQuery;
import static org.elasticsearch.index.query.QueryBuilders.matchQuery;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private SearchRepository searchRepository;

    @Override
    public ResponseObject getProduct(int productId) {
        if(searchRepository.exists(productId)){
            Product product = searchRepository.findOne(productId);
            ProductDTO productDTO = new ProductDTO();
            BeanUtils.copyProperties(product, productDTO);
            return new ResponseObject(productDTO, true);
        }

        return new ResponseObject("Sorry No product found", false);
    }

    @Override
    public ResponseObject createProduct(ProductDTO productDTO) {
        Product product = new Product();
        BeanUtils.copyProperties(productDTO, product);
        if(searchRepository.save(product) !=null){
            return new ResponseObject(searchRepository.findOne(product.getProductId()),true);
        }
        return new ResponseObject("Sorry try again later", false);
    }

    @Override
    public ResponseObject updateProduct(ProductDTO productDTO) {
        Product product = new Product();
        BeanUtils.copyProperties(productDTO, product);
        if(searchRepository.exists(productDTO.getProductId())){
            return new ResponseObject(searchRepository.save(product),true);
        }
        return new ResponseObject("Sorry try again later", false);
    }

    @Override
    public ResponseObject deleteProduct(int productId) {
        Product product = searchRepository.findOne(productId);
        if(product !=null){
            searchRepository.delete(productId);
            return new ResponseObject(true,true);
        }
        return new ResponseObject("Sorry try again later", false);
    }

    @Override
    public ResponseObject searchResults(String query) {
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(matchQuery("category", query))
                .build();
        SearchQuery searchQuery1 = new NativeSearchQueryBuilder()
                .withQuery(matchQuery("subCategory", query))
                .build();
        SearchQuery searchQuery2 = new NativeSearchQueryBuilder()
                .withQuery(matchPhraseQuery("description", query)
                        .slop(1)
                        .operator(AND)
                        .fuzziness(Fuzziness.ONE)
                        .prefixLength(3))
                .build();
        SearchQuery searchQuery3 = new NativeSearchQueryBuilder()
                .withQuery(matchQuery("brand", query))
                .build();

        List<Product> result = new ArrayList<>();

        Page<Product> search_results =  searchRepository.search(searchQuery);
        List<Product> result4 = search_results.getContent();

        Page<Product> search_results1 =  searchRepository.search(searchQuery1);
        List<Product> result1 = search_results1.getContent();

        if(result1.size() != 0){
            result.addAll(Collections.unmodifiableCollection(result1));
        }


        Page<Product> search_results2 =  searchRepository.search(searchQuery2);
        List<Product> result2 = search_results2.getContent();
        if(result2.size() != 0){
            result.addAll(Collections.unmodifiableCollection(result2));
        }

        Page<Product> search_results3 =  searchRepository.search(searchQuery3);
        List<Product> result3 = search_results3.getContent();
        if(result3.size() != 0){
            result.addAll(Collections.unmodifiableCollection(result3));
        }
        if(result4.size() != 0){
            result.addAll(Collections.unmodifiableCollection(result4));
        }
        List<Product> list_to_send = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for(Product product:result){
            if(!set.contains(product.toString())) {
                set.add(product.toString());
                list_to_send.add(product);
            }
        }

        if(list_to_send.size() > 0) {
            return new ResponseObject(list_to_send, true);
        }
        return new ResponseObject("No Search Results Found", false);
    }

}
