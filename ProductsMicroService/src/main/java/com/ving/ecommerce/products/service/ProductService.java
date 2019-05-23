package com.ving.ecommerce.products.service;

import com.ving.ecommerce.products.model.FilterDTO;
import com.ving.ecommerce.products.model.ProductDTO;
import com.ving.ecommerce.products.model.ResponseObject;

import java.util.ArrayList;
import java.util.List;

public interface ProductService {
    ResponseObject getTopProducts();
    ResponseObject getCategoryProducts(String category);
    ResponseObject getSubCategoryProducts(String category, String subcategory);
    ResponseObject getFilteredProducts(FilterDTO filterDTO);
    ResponseObject getProduct(int productId);
    ResponseObject getAllProducts();
    ResponseObject getFilters(String category, String subcategory);
    ResponseObject createFilters(FilterDTO filterDTO);
    ResponseObject getListOfProductReview(int productId);
    ResponseObject setProductReview(int productId, String token, String review, int rating);
    ResponseObject deleteProductReview(String token, int productId);
    ResponseObject createProduct(ProductDTO productDTO);
    ResponseObject createProducts(List<ProductDTO> productDTOS);
    ResponseObject updateProduct(ProductDTO productDTO);
    ResponseObject deleteProduct(int productId);
}
