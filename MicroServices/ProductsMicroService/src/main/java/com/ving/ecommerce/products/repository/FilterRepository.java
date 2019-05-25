package com.ving.ecommerce.products.repository;

import com.ving.ecommerce.products.entity.Filter;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FilterRepository extends MongoRepository<Filter,String> {
    Filter findByCategoryAndSubCategory(String category, String subCategory);

}
