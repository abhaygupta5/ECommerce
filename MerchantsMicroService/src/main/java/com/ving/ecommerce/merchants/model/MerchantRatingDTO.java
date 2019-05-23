package com.ving.ecommerce.merchants.model;

public class MerchantRatingDTO {
    private int merchantId;
    private int userId;
    private int rating;

    public MerchantRatingDTO(int merchantId, int userId, int rating) {
        this.merchantId = merchantId;
        this.userId = userId;
        this.rating = rating;
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

    @Override
    public String toString() {
        return "MerchantRatingDTO{" +
                "merchantId=" + merchantId +
                ", userId=" + userId +
                ", rating=" + rating +
                '}';
    }
}
