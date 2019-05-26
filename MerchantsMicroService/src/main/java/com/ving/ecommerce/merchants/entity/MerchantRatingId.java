package com.ving.ecommerce.merchants.entity;

import java.io.Serializable;

public class MerchantRatingId implements Serializable {
    int merchantId;
    int userId;

    public MerchantRatingId(int merchantId, int userId) {
        this.merchantId = merchantId;
        this.userId = userId;
    }

    public MerchantRatingId(){

    }

    public int getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(int merchantId) {
        this.merchantId = merchantId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
