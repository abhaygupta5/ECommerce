package com.ving.ecommerce.merchants.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Entity
public class TopMerchants {
    @Id
    private int productId;
    private String merchantList;

    public TopMerchants(int productId, String merchantList) {
        this.productId = productId;
        this.merchantList = merchantList;
    }

    public TopMerchants(){

    }

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

