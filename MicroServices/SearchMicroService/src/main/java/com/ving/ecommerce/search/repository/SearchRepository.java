package com.ving.ecommerce.search.repository;

import com.ving.ecommerce.search.entity.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface SearchRepository extends ElasticsearchRepository<Product, Integer> {
}
