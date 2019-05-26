package com.ving.ecommerce.products.repository;

import com.ving.ecommerce.products.entity.ProductReview;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProductReviewRepository extends MongoRepository<ProductReview, String> {
    List<ProductReview> findByProductId(int productId);
    ProductReview findByProductIdAndUserId(int productId, int userId);
}
