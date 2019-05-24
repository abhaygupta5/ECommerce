package com.ving.ecommerce.orders.model;

public class CartItem {

    private int merchantId;
    private int productId;
    private int quantity;

    public CartItem() {
    }

    public CartItem(int merchantId, int productId, int quantity) {
        this.merchantId = merchantId;
        this.productId = productId;
        this.quantity = quantity;
    }

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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "merchantId=" + merchantId +
                ", productId=" + productId +
                ", quantity=" + quantity +
                '}';
    }
}
