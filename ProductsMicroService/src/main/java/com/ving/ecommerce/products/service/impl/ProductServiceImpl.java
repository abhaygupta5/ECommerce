package com.ving.ecommerce.products.service.impl;

import com.ving.ecommerce.products.ServerConfiguration;
import com.ving.ecommerce.products.entity.Filter;
import com.ving.ecommerce.products.entity.Product;
import com.ving.ecommerce.products.entity.ProductReview;
import com.ving.ecommerce.products.model.FilterDTO;
import com.ving.ecommerce.products.model.ProductDTO;
import com.ving.ecommerce.products.model.ResponseObject;
import com.ving.ecommerce.products.repository.FilterRepository;
import com.ving.ecommerce.products.repository.ProductRepository;
import com.ving.ecommerce.products.repository.ProductReviewRepository;
import com.ving.ecommerce.products.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

import static com.ving.ecommerce.products.ServerConfiguration.BASE_ORDER_SERVICE;
import static com.ving.ecommerce.products.ServerConfiguration.BASE_SEARCH_SERVICE;
import static com.ving.ecommerce.products.ServerConfiguration.BASE_USER_SERVICE;

@Service
public class ProductServiceImpl implements ProductService {


    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductReviewRepository productReviewRepository;
    @Autowired
    private FilterRepository filterRepository;

    @Override
    public ResponseObject getTopProducts() {
        long total = productRepository.count();
        ArrayList<Integer> numbers = new ArrayList<>();
        //Generates 10 Random Numbers in the range 1 - total
        if(total>8) {
            for (int i = 0; i < 8; ) {
                int number = (int) (Math.random() * total + 1);
                if (numbers.contains(number)) {
                    continue;
                }
                numbers.add(number);
                i++;
            }
            List<Product> products = new ArrayList<>();
            for(int productId : numbers){
                products.add(productRepository.findOne(productId));
            }
            return new ResponseObject(products, true);
        }
        return getAllProducts();
    }

    @Override
    public ResponseObject getCategoryProducts(String category) {
        List<Product> products = productRepository.findByCategory(category);
        if(!products.isEmpty()){
            return new ResponseObject(products, true);
        }
        return new ResponseObject("No category products found", false);
    }

    @Override
    public ResponseObject getSubCategoryProducts(String category, String subcategory) {
        List<Product> products = productRepository.findByCategoryAndSubCategory(category, subcategory);
        if(!products.isEmpty()){
            return new ResponseObject(products, true);
        }
        return new ResponseObject("No sub category products found", false);
    }

    @Override
    public ResponseObject getFilteredProducts(FilterDTO filterDTO) {
        Filter filter = new Filter();
        BeanUtils.copyProperties(filterDTO, filter);
        List<Product> products = productRepository.findByCategoryAndSubCategory(filter.getCategory(), filter.getSubCategory());
        Map<String,Object> filters = filterDTO.getFilters();
        ArrayList<Product> filteredProducts = new ArrayList<>();
        for(Product product : products){
            Map<String,Object> attributes = product.getAttributes();
            if (attributes.entrySet().containsAll(filters.entrySet())) {
                // filters is subset of attributes
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
        return new ResponseObject("Sorry No products found", false);
    }

    @Override
    public ResponseObject getProduct(int productId) {
        if(productRepository.exists(productId)){
            Product product = productRepository.findOne(productId);
            ProductDTO productDTO = new ProductDTO();
            BeanUtils.copyProperties(product, productDTO);
            return new ResponseObject(productDTO, true);
        }

        return new ResponseObject("Sorry No product found", false);
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
        return new ResponseObject("Sorry No products found", false);
    }

    @Override
    public ResponseObject getFilters(String category, String subcategory) {
        if(filterRepository.findByCategoryAndSubCategory(category,subcategory) !=null){
            Filter filter = filterRepository.findByCategoryAndSubCategory(category, subcategory);
            return new ResponseObject(filter.getFilters(), true);
        }
        return new ResponseObject("Sorry No filters found", false);
    }

    @Override
    public ResponseObject getListOfProductReview(int productId) {
        if(productReviewRepository.findByProductId(productId) != null){
            return new ResponseObject(productReviewRepository.findByProductId(productId), true);
        }
        return new ResponseObject("Sorry No reviews found", false);
    }

    @Override
    public ResponseObject setProductReview(int productId, String token, String review, int rating) {
        //TODO Check for eligibility for review from order service
        String url = BASE_ORDER_SERVICE+"/isEligibleForReviewProduct?token="+token+"&productId="+productId;
        RestTemplate restTemplate = new RestTemplate();
        ResponseObject res = restTemplate.getForObject(url,ResponseObject.class);
        if((boolean)res.getData()) {
            String uri = BASE_USER_SERVICE + "/users/" + token;
            restTemplate = new RestTemplate();
            ResponseObject responseObject = restTemplate.getForObject(uri, ResponseObject.class);
            if (responseObject.getOk()) {
                int userId = (int) responseObject.getData();
                uri = BASE_USER_SERVICE + "/users?userId=" + userId;
                responseObject = restTemplate.getForObject(uri, ResponseObject.class);
                Map<String, String> data = (HashMap<String, String>) responseObject.getData();
                String username = data.get("userDisplayName");
                ProductReview productReview = productReviewRepository.save(new ProductReview(productId, userId, username, rating, review));
                if (productReview != null) {
                    return new ResponseObject(true, true);
                }
            }
        }
        return new ResponseObject("Sorry please try again later", false);
    }

    @Override
    public ResponseObject deleteProductReview(String token, int productId) {
        String uri = BASE_USER_SERVICE+"/users/"+token;
        RestTemplate restTemplate = new RestTemplate();
        ResponseObject responseObject = restTemplate.getForObject(uri, ResponseObject.class);
        if(!responseObject.getOk()) {
            int userId = (int) responseObject.getData();
            if (productReviewRepository.findByProductIdAndUserId(productId, userId) != null) {
                productReviewRepository.delete(productReviewRepository.findByProductIdAndUserId(productId, userId));
                return new ResponseObject(true, true);
            }
        }
        return new ResponseObject("Sorry could not delete. Please try again later", false);
    }

    @Override
    public ResponseObject createProduct(ProductDTO productDTO) {
        Product product = new Product();
        BeanUtils.copyProperties(productDTO, product);
        if(!productRepository.exists(product.getProductId())){
            productRepository.save(product);
            String uri = BASE_SEARCH_SERVICE+"/search/createProduct";
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.postForObject(uri, productDTO, ProductDTO.class);
            return new ResponseObject(productRepository.findOne(product.getProductId()),true);
        }
        return new ResponseObject("Sorry try again", false);
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
        if(productRepository.exists(productDTO.getProductId())){
            String uri = BASE_SEARCH_SERVICE+"/search/updateProduct";
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.put(uri, productDTO);
            return new ResponseObject(productRepository.save(product),true);
        }
        return new ResponseObject("Sorry try again later", false);
    }

    @Override
    public ResponseObject deleteProduct(int productId) {
        Product product = productRepository.findOne(productId);
        if(product !=null){
            productRepository.delete(productId);
            String uri = BASE_SEARCH_SERVICE+"/search/deleteProduct?productId="+productId;
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.delete(uri);
            return new ResponseObject(true,true);
        }
        return new ResponseObject("Sorry try again later", false);
    }

    @Override
    public ResponseObject createFilters(FilterDTO filterDTO) {
        Filter filter = new Filter();
        BeanUtils.copyProperties(filterDTO, filter);
        Filter result = filterRepository.save(filter);
        if(result != null){
            return new ResponseObject(result, true);
        }
        return new ResponseObject("Sorry try again later", false);
    }


}
