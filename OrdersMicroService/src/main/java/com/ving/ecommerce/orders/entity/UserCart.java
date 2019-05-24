package com.ving.ecommerce.orders.entity;

import com.ving.ecommerce.orders.entity.CartItem;
import com.ving.ecommerce.orders.model.UserDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class UserCart {

    @Id
    int userId;
    UserDTO userDTO;
    List<CartItem> cartItems;

    public UserCart() {
    }

    public UserCart(int userId, List<CartItem> cartItems) {
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
}