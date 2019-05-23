package com.ving.ecommerce.merchants.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TopMerchants {
    @Id
    private int productId;

    private String merchantList;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getMerchantList() {
        return merchantList;
    }

    public void setMerchantList(String merchantList) {
        this.merchantList = merchantList;
    }
}
