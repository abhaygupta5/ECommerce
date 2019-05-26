package com.ving.ecommerce.products.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ProductReview")
public class ProductReview {
    @Id
    private int productId;
    private int userId;
    private String userName;
    private int rating;
    private String reviewBody;

    public ProductReview(int productId, int userId, String userName, int rating, String reviewBody) {
        this.productId = productId;
        this.userId = userId;
        this.userName = userName;
        this.rating = rating;
        this.reviewBody = reviewBody;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
