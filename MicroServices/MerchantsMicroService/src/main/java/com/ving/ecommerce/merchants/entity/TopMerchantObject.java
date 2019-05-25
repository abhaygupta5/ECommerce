package com.ving.ecommerce.merchants.entity;

import java.io.Serializable;

public class TopMerchantObject implements Serializable {
    int merchantId;
    String merchantName;

    public TopMerchantObject(int merchantId, String merchantName) {
        this.merchantId = merchantId;
        this.merchantName = merchantName;
    }

    public TopMerchantObject() {
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

    @Override
    public String toString() {
        return merchantId+":"+merchantName;
    }
}
