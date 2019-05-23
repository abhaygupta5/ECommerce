package com.ving.ecommerce.products.entity;

import java.io.Serializable;

public class ProductReviewId implements Serializable {
    int productId;
    int userId;

    public ProductReviewId(int productId, int userId) {
        this.productId = productId;
        this.userId = userId;
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
}
