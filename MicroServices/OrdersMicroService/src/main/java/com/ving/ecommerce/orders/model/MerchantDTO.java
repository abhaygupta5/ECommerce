package com.ving.ecommerce.orders.model;

public class MerchantDTO {
    private int merchantId;
    private String merchantName;
    private String merchantAddress;
    private String merchantEmail;
    private Long merchantPhone;

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

    public String getMerchantAddress() {
        return merchantAddress;
    }

    public void setMerchantAddress(String merchantAddress) {
        this.merchantAddress = merchantAddress;
    }

    public String getMerchantEmail() {
        return merchantEmail;
    }

    public void setMerchantEmail(String merchantEmail) {
        this.merchantEmail = merchantEmail;
    }

    public Long getMerchantPhone() {
        return merchantPhone;
    }

    public void setMerchantPhone(Long merchantPhone) {
        this.merchantPhone = merchantPhone;
    }

    @Override
    public String toString() {
        return "MerchantDTO{" +
                "merchantId=" + merchantId +
                ", merchantName='" + merchantName + '\'' +
                ", merchantAddress='" + merchantAddress + '\'' +
                ", merchantEmail='" + merchantEmail + '\'' +
                ", merchantPhone=" + merchantPhone +
                '}';
    }
}
