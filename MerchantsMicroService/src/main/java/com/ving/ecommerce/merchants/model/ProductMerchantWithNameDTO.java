package com.ving.ecommerce.merchants.model;

public class ProductMerchantWithNameDTO {
    private int merchantId;
    private String merchantName;
    private int productId;
    private int stock;
    private double averageRating;
    private double productPrice;

    public ProductMerchantWithNameDTO(int merchantId, String merchantName, int productId, int stock, double averageRating, double productPrice) {
        this.merchantId = merchantId;
        this.merchantName = merchantName;
        this.productId = productId;
        this.stock = stock;
        this.averageRating = averageRating;
        this.productPrice = productPrice;
    }

    public ProductMerchantWithNameDTO(){

    }

    public int getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(int merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
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

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "ProductMerchantWithNameDTO{" +
                "merchantId=" + merchantId +
                ", merchantName='" + merchantName + '\'' +
                ", productId=" + productId +
                ", stock=" + stock +
                ", averageRating=" + averageRating +
                ", productPrice=" + productPrice +
                '}';
    }
}
