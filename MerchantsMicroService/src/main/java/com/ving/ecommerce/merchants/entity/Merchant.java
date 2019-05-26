package com.ving.ecommerce.merchants.entity;


import javax.persistence.*;

@Entity
public class Merchant {
    @Id
    private int merchantId;
    @Column(unique = true)
    private String merchantName;
    private String merchantAddress;
    @Column(unique = true)
    private String merchantEmail;
    @Column(unique = true)
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
}
