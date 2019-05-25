package com.ving.ecommerce.merchants.model;

public class ProductMerchantDTO {
    private int merchantId;
    private int productId;
    private int stock;
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

    @Override
    public String toString() {
        return "ProductMerchantDTO{" +
                "merchantId=" + merchantId +
                ", productId=" + productId +
                ", stock=" + stock +
                ", productPrice=" + productPrice +
                '}';
    }
}
