package com.ving.ecommerce.orders.entity;

import com.ving.ecommerce.orders.model.MerchantDTO;
import com.ving.ecommerce.orders.model.ProductDTO;

public class OrderItem {
    ProductDTO productDTO;
    MerchantDTO merchantDTO;
    int quantity;

    public OrderItem() {
    }

    public OrderItem(ProductDTO productDTO, MerchantDTO merchantDTO, int quantity) {
        this.productDTO = productDTO;
        this.merchantDTO = merchantDTO;
        this.quantity = quantity;
    }

    public ProductDTO getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }

    public MerchantDTO getMerchantDTO() {
        return merchantDTO;
    }

    public void setMerchantDTO(MerchantDTO merchantDTO) {
        this.merchantDTO = merchantDTO;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "productDTO=" + productDTO +
                ", merchantDTO=" + merchantDTO +
                ", quantity=" + quantity +
                '}';
    }
}
