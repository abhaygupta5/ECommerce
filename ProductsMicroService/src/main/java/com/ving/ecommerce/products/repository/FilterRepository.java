package com.ving.ecommerce.products.repository;

import com.ving.ecommerce.products.entity.Filter;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface FilterRepository extends MongoRepository<Filter,String> {
    List<Filter> findByCategoryAndSubCategory(String category, String subCategory);

}
