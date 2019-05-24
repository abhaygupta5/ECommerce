package com.ving.ecommerce.products.repository;

import com.ving.ecommerce.products.entity.Product;
import org.springframework.data.mongodb.repository.CountQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

public interface ProductRepository extends MongoRepository<Product,Integer> {
    List<Product> findByCategory(String category);
    List<Product> findByCategoryAndSubCategory(String category, String subCategory);


}
