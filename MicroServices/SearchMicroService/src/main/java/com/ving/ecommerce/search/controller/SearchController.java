package com.ving.ecommerce.search.controller;

import com.ving.ecommerce.search.model.ProductDTO;
import com.ving.ecommerce.search.model.ResponseObject;
import com.ving.ecommerce.search.service.impl.SearchServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {
    @Autowired
    private SearchServiceImpl searchService;

    @GetMapping("/getProduct")
    ResponseObject getProduct(@RequestParam int productId){
        return searchService.getProduct(productId);
    }

    @PostMapping(value = "/createProduct", produces = "application/json")
    ResponseObject createProduct(@RequestBody ProductDTO productDTO){
        return searchService.createProduct(productDTO);
    }

    @PutMapping(value = "/updateProduct", produces = "application/json")
    ResponseObject updateProduct(@RequestBody ProductDTO productDTO){
        return searchService.updateProduct(productDTO);
    }

    @DeleteMapping("/deleteProduct")
    ResponseObject deleteProduct(@RequestParam int productId){
        return searchService.deleteProduct(productId);
    }

    @GetMapping("")
    ResponseObject searchResults(@RequestParam String query){
        return searchService.searchResults(query);
    }
}
