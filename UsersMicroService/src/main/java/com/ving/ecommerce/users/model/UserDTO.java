package com.ving.ecommerce.users.model;

import java.util.ArrayList;

public class UserDTO {

    private int userId;
    private String userName;
    private String userDisplayName;
    private ArrayList<String> userAddress;
    private String userEmail;
    private long userPhone;
    private String userPassword;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserDisplayName() {
        return userDisplayName;
    }

    public void setUserDisplayName(String userDisplayName) {
        this.userDisplayName = userDisplayName;
    }

    public ArrayList<String> getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(ArrayList<String> userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public long getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(long userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userDisplayName='" + userDisplayName + '\'' +
                ", userAddress=" + userAddress +
                ", userEmail='" + userEmail + '\'' +
                ", userPhone=" + userPhone +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }
}