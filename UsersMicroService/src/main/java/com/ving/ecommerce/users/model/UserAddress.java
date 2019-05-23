package com.ving.ecommerce.users.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity @IdClass(UserAddressId.class)
public class UserAddress{
    @Id
    private int userId;
    @Id
    private String userAddress;

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

    @Override
    public String toString() {
        return "UserAddress{" +
                "userId=" + userId +
                ", userAddress='" + userAddress + '\'' +
                '}';
    }
}
