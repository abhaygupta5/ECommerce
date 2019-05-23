package com.ving.ecommerce.products.model;

import com.ving.ecommerce.products.entity.ProductReviewId;

public class ProductReviewDTO {
    private ProductReviewId productReviewIdId;
    private String userName;
    private int rating;
    private String reviewBody;

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

    @Override
    public String toString() {
        return "ProductReviewDTO{" +
                "productReviewIdId=" + productReviewIdId +
                ", userName='" + userName + '\'' +
                ", rating=" + rating +
                ", reviewBody='" + reviewBody + '\'' +
                '}';
    }
}
