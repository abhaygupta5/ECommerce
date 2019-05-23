package com.ving.ecommerce.products.controller;

import com.ving.ecommerce.products.entity.Filter;
import com.ving.ecommerce.products.model.FilterDTO;
import com.ving.ecommerce.products.model.ProductDTO;
import com.ving.ecommerce.products.model.ResponseObject;
import com.ving.ecommerce.products.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @GetMapping("/getTopProducts")
    ResponseObject getTopProducts(){
        return productService.getTopProducts();
    }

    @GetMapping("/products/{category}")
    ResponseObject getCategoryProducts(@PathVariable String category){
        return productService.getCategoryProducts(category);
    }

    @GetMapping("/products/{category}/{subcategory}")
    ResponseObject getSubCategoryProducts(@PathVariable String category, @PathVariable String subcategory){
        return productService.getSubCategoryProducts(category,subcategory);
    }

    @GetMapping(value = "/getFilteredProducts", produces = "application/json")
    ResponseObject getFilteredProducts(@RequestBody FilterDTO filterDTO){
        return productService.getFilteredProducts(filterDTO);
    }

    @GetMapping("/getProduct")
    ResponseObject getProduct(@RequestParam int productId){
        return productService.getProduct(productId);
    }

    @GetMapping("/products")
    ResponseObject getAllProduct(){
        return productService.getAllProducts();
    }

    @GetMapping("/filters/{category}/{subcategory}")
    ResponseObject getFilters(@PathVariable String category, @PathVariable String subcategory){
        return productService.getFilters(category, subcategory);
    }

    @PostMapping(value = "/createFilters", produces = "application/json")
    ResponseObject createFilters(@RequestBody FilterDTO filterDTO){
        return productService.createFilters(filterDTO);
    }

    @GetMapping("/productReviews/{productId}")
    ResponseObject getListOfProductReview(@PathVariable int productId){
        return productService.getListOfProductReview(productId);
    }

    @PostMapping("/productReview/{productId}")
    ResponseObject setProductReview(@PathVariable int productId, @RequestParam String token, @RequestParam String review, @RequestParam int rating){
        return productService.setProductReview(productId, token, review, rating);
    }

    @DeleteMapping("/productReview")
    ResponseObject deleteProductReview(@RequestParam String token, @RequestParam int productId){
        return productService.deleteProductReview(token, productId);
    }

    @PostMapping(value = "/createProduct", produces = "application/json")
    ResponseObject createProduct(@RequestBody ProductDTO productDTO){
        return productService.createProduct(productDTO);
    }

    @PostMapping(value = "/createProducts", produces = "application/json")
    ResponseObject createProduct(@RequestBody List<ProductDTO> productDTOS){
        return productService.createProducts(productDTOS);
    }

    @PutMapping(value = "/updateProduct", produces = "application/json")
    ResponseObject updateProduct(@RequestBody ProductDTO productDTO){
        return productService.updateProduct(productDTO);
    }

    @DeleteMapping("/deleteProduct")
    ResponseObject deleteProduct(@RequestParam int productId){
        return productService.deleteProduct(productId);
    }
}
