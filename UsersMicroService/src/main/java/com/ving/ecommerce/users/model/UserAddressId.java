package com.ving.ecommerce.users.model;

import java.io.Serializable;

public class UserAddressId implements Serializable {
    int userId;
    String userAddress;

    public UserAddressId() {
    }

    public UserAddressId(int userId, String userAddress) {
        this.userId = userId;
        this.userAddress = userAddress;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }
}
