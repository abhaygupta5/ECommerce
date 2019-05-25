package com.ving.ecommerce.merchants.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity @IdClass(MerchantRatingId.class)
public class MerchantRating {
    @Id
    private int merchantId;
    @Id
    private int userId;
    @Column(nullable = false)
    private int rating;

    public MerchantRating(int merchantId, int userId, int rating) {
        this.merchantId = merchantId;
        this.userId = userId;
        this.rating = rating;
    }

    public MerchantRating(){

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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
