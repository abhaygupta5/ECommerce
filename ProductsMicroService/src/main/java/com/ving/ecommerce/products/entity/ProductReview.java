package com.ving.ecommerce.products.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ProductReview {
    @Id
    private ProductReviewId productReviewIdId;
    private String userName;
    private int rating;
    private String reviewBody;

    public ProductReview(ProductReviewId productReviewIdId, String userName, int rating, String reviewBody) {
        this.productReviewIdId = productReviewIdId;
        this.userName = userName;
        this.rating = rating;
        this.reviewBody = reviewBody;
    }

    public ProductReviewId getProductReviewIdId() {
        return productReviewIdId;
    }

    public void setProductReviewIdId(ProductReviewId productReviewIdId) {
        this.productReviewIdId = productReviewIdId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getReviewBody() {
        return reviewBody;
    }

    public void setReviewBody(String reviewBody) {
        this.reviewBody = reviewBody;
    }
}
