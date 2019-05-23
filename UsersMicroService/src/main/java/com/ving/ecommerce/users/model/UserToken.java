package com.ving.ecommerce.users.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class UserToken {

    @Id
    private int userId;
    private String token;

    public UserToken() {
    }

    public UserToken(int userId, String token) {
        this.userId = userId;
        this.token = token;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "UserToken{" +
                "userId=" + userId +
                ", token='" + token + '\'' +
                '}';
    }
}
