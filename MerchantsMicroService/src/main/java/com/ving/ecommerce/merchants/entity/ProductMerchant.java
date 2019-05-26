package com.ving.ecommerce.merchants.entity;

import javax.persistence.*;

@Entity @IdClass(MerchantProductId.class)
public class ProductMerchant {

    @Id
    private int merchantId;
    @Id
    private int productId;
    @Column(nullable = false)
    private int stock;
    @Column(nullable = false)
    private double productPrice;

    public int getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(int merchantId) {
        this.merchantId = merchantId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
}
