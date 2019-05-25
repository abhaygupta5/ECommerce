package com.ving.ecommerce.merchants.entity;

import java.io.Serializable;

public class MerchantProductId implements Serializable {
    int merchantId;
    int productId;

    public MerchantProductId(int merchantId, int productId) {
        this.merchantId = merchantId;
        this.productId = productId;
    }

    public MerchantProductId(){

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
}
