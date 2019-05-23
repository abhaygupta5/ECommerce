package com.ving.ecommerce.products.service.impl;

import com.ving.ecommerce.products.entity.Filter;
import com.ving.ecommerce.products.entity.Product;
import com.ving.ecommerce.products.entity.ProductReview;
import com.ving.ecommerce.products.entity.ProductReviewId;
import com.ving.ecommerce.products.model.FilterDTO;
import com.ving.ecommerce.products.model.ProductDTO;
import com.ving.ecommerce.products.model.ResponseObject;
import com.ving.ecommerce.products.repository.FilterRepository;
import com.ving.ecommerce.products.repository.ProductRepository;
import com.ving.ecommerce.products.repository.ProductReviewRepository;
import com.ving.ecommerce.products.service.ProductService;
import org.json.JSONObject;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompare;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {
    String BASE_PRODUCT_SERVICE = "http://localhost:8080";
    String BASE_MERCHANT_SERVICE = "http://localhost:8081";
    String BASE_ORDER_SERVICE = "http://localhost:8082";
    String BASE_USER_SERVICE = "http://localhost:8083";
    String BASE_EMAIL_SERVICE = "http://localhost:8084";
    String BASE_SEARCH_SERVICE = "http://localhost:8085";

    @Autowired
    private FilterRepository filterRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductReviewRepository productReviewRepository;

    @Override
    public ResponseObject getTopProducts() {
        return null;
    }

    @Override
    public ResponseObject getCategoryProducts(String category) {
        List<Product> products = productRepository.findByCategory(category);
        if(products != null){
            return new ResponseObject(products, true);
        }
        return new ResponseObject(null, false);
    }

    @Override
    public ResponseObject getSubCategoryProducts(String category, String subcategory) {
        List<Product> products = productRepository.findByCategoryAndSubCategory(category, subcategory);
        if(products != null){
            return new ResponseObject(products, true);
        }
        return new ResponseObject(null, false);
    }

    @Override
    public ResponseObject getFilteredProducts(FilterDTO filterDTO) {
        Filter filter = new Filter();
        BeanUtils.copyProperties(filterDTO, filter);
        List<Product> products = productRepository.findByCategoryAndSubCategory(filter.getCategory(), filter.getSubCategory());
        JSONObject filters = new JSONObject(filterDTO.getFilters());
        ArrayList<Product> filteredProducts = new ArrayList<>();
        for(Product product : products){
            int flag=0;
            JSONObject productJson = new JSONObject(product.getAttributes());
            Iterator iterator = productJson.keys();

            while(iterator.hasNext()){
                String key = iterator.next().toString();
                if (filters.get(key) != productJson.get(key)){
                    flag=1;
                    break;
                }
            }
            if(flag == 0){
                filteredProducts.add(product);
            }

        }
        if(filteredProducts.size() != 0){
            ArrayList<ProductDTO> productDTOS = new ArrayList<>();
            for(Product product:filteredProducts){
                ProductDTO productDTO = new ProductDTO();
                BeanUtils.copyProperties(product, productDTO);
                productDTOS.add(productDTO);
            }
            return new ResponseObject(productDTOS, true);
        }
        return new ResponseObject(null, false);
    }

    @Override
    public ResponseObject getProduct(int productId) {
        if(productRepository.exists(productId)){
            Product product = productRepository.findOne(productId);
            ProductDTO productDTO = new ProductDTO();
            BeanUtils.copyProperties(product, productDTO);
            return new ResponseObject(productDTO, true);
        }

        return new ResponseObject(null, false);
    }

    @Override
    public ResponseObject getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productDTOS = new ArrayList<>();
        for(Product product: products){
            ProductDTO productDTO = new ProductDTO();
            BeanUtils.copyProperties(product, productDTO);
            productDTOS.add(productDTO);

        }
        if(productDTOS.size() != 0){
            return new ResponseObject(productDTOS, true);
        }
        return new ResponseObject(null, false);
    }

    @Override
    public ResponseObject getFilters(String category, String subcategory) {
        if(filterRepository.findByCategoryAndSubCategory(category,subcategory) !=null){
            return new ResponseObject(filterRepository.findByCategoryAndSubCategory(category, subcategory), true);
        }
        return new ResponseObject(null, false);
    }

    @Override
    public ResponseObject getListOfProductReview(int productId) {
        if(productReviewRepository.findByProductId(productId) != null){
            return new ResponseObject(productReviewRepository.findByProductId(productId), true);
        }
        return new ResponseObject(null, false);
    }

    @Override
    public ResponseObject setProductReview(int productId, String token, String review, int rating) {
        String uri = BASE_USER_SERVICE+"/users/"+token;
        RestTemplate restTemplate = new RestTemplate();
        ResponseObject responseObject = restTemplate.getForObject(uri, ResponseObject.class);
        int userId = (int)responseObject.getData();
        uri = BASE_USER_SERVICE+"/users?userId="+userId;
        responseObject = restTemplate.getForObject(uri, ResponseObject.class);
        Map<String,String> data = (HashMap<String,String>)responseObject.getData();
        String username = data.get("userDisplayName");
        ProductReview productReview = productReviewRepository.save(new ProductReview(new ProductReviewId(productId,userId),username,rating, review));
        if(productReview !=null){
            return new ResponseObject(true,true);
        }
        return new ResponseObject(null, false);
    }

    @Override
    public ResponseObject deleteProductReview(String token, int productId) {
        String uri = BASE_USER_SERVICE+"/users/"+token;
        RestTemplate restTemplate = new RestTemplate();
        ResponseObject responseObject = restTemplate.getForObject(uri, ResponseObject.class);
        int userId = (int)responseObject.getData();
        if(productReviewRepository.exists(new ProductReviewId(productId, userId))){
            productReviewRepository.delete(new ProductReviewId(productId, userId));
            return new ResponseObject(true, true);
        }
        return new ResponseObject(null, false);
    }

    @Override
    public ResponseObject createProduct(ProductDTO productDTO) {
        Product product = new Product();
        BeanUtils.copyProperties(productDTO, product);
        if(productRepository.save(product) !=null){
            return new ResponseObject(productRepository.findOne(product.getProductId()),true);
        }
        return new ResponseObject(null, false);
    }

    @Override
    public ResponseObject createProducts(List<ProductDTO> productDTOS) {
        List<Product> products = new ArrayList<>();
        for(ProductDTO productDTO: productDTOS){
            Product product = new Product();
            BeanUtils.copyProperties(productDTO, product);
            productRepository.save(product);
            products.add(product);
            }
        return new ResponseObject(products, true);
    }



    @Override
    public ResponseObject updateProduct(ProductDTO productDTO) {
        Product product = new Product();
        BeanUtils.copyProperties(productDTO, product);
        if(!productRepository.exists(productDTO.getProductId())){
            return new ResponseObject(productRepository.save(product),true);
        }
        return new ResponseObject(null, false);
    }

    @Override
    public ResponseObject deleteProduct(int productId) {
        Product product = productRepository.findOne(productId);
        if(product !=null){
            productRepository.delete(productId);
            return new ResponseObject(true,true);
        }
        return new ResponseObject(null, false);
    }
}
