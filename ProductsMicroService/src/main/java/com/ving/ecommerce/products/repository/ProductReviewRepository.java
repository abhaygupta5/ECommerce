package com.ving.ecommerce.products.repository;

import com.ving.ecommerce.products.entity.ProductReview;
import com.ving.ecommerce.products.entity.ProductReviewId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductReviewRepository extends MongoRepository<ProductReview, ProductReviewId> {
    List<ProductReview> findByProductId(int productId);

}
