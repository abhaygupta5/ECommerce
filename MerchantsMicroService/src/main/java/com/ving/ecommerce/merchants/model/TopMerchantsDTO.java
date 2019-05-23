package com.ving.ecommerce.merchants.model;

public class TopMerchantsDTO {
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

    @Override
    public String toString() {
        return "TopMerchantsDTO{" +
                "productId=" + productId +
                ", merchantList='" + merchantList + '\'' +
                '}';
    }
}
