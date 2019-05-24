package com.ving.ecommerce.orders.model;

import com.ving.ecommerce.orders.entity.CartItem;

import java.util.List;

public class UserCartDTO {

    private int userId;
    private List<CartItem> cartItems;

    public UserCartDTO() {
    }

    public UserCartDTO(int userId, List<CartItem> cartItems) {
        this.userId = userId;
        this.cartItems = cartItems;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    @Override
    public String toString() {
        return "UserCartDTO{" +
                "userId=" + userId +
                ", cartItems=" + cartItems +
                '}';
    }
}
