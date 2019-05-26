package com.ving.ecommerce.orders.model;

import jdk.internal.dynalink.linker.LinkerServices;

import java.util.List;

public class CartItemDetailsDTO {

    private int productId;
    private int merchantId;
    private int qty;
    private String productName;
    private String merchantName;
    List<String> productImages;
    private double price;

    public CartItemDetailsDTO() {
    }

    public CartItemDetailsDTO(int productId, int merchantId, int qty, String productName, String merchantName, List<String> productImages, double price) {
        this.productId = productId;
        this.merchantId = merchantId;
        this.qty = qty;
        this.productName = productName;
        this.merchantName = merchantName;
        this.productImages = productImages;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(int merchantId) {
        this.merchantId = merchantId;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public List<String> getProductImages() {
        return productImages;
    }

    public void setProductImages(List<String> productImages) {
        this.productImages = productImages;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CartItemDetailsDTO{" +
                "productId=" + productId +
                ", merchantId=" + merchantId +
                ", qty=" + qty +
                ", productName='" + productName + '\'' +
                ", merchantName='" + merchantName + '\'' +
                ", productImages=" + productImages +
                ", price=" + price +
                '}';
    }
}
