package com.ving.ecommerce.search.service;

import com.ving.ecommerce.search.model.ProductDTO;
import com.ving.ecommerce.search.model.ResponseObject;

import java.util.List;

public interface SearchService {
    ResponseObject getProduct(int productId);
    ResponseObject createProduct(ProductDTO productDTO);
    ResponseObject updateProduct(ProductDTO productDTO);
    ResponseObject deleteProduct(int productId);
    ResponseObject searchResults(String query);


}
