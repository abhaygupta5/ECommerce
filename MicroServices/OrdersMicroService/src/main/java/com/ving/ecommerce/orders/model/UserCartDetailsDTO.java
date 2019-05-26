package com.ving.ecommerce.orders.model;

import java.util.List;

public class UserCartDetailsDTO {

    private int userId;
    private List<CartItemDetailsDTO> cartItemDetails;

    public UserCartDetailsDTO() {
    }

    public UserCartDetailsDTO(int userId, List<CartItemDetailsDTO> cartItemDetails) {
        this.userId = userId;
        this.cartItemDetails = cartItemDetails;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<CartItemDetailsDTO> getCartItemDetails() {
        return cartItemDetails;
    }

    public void setCartItemDetails(List<CartItemDetailsDTO> cartItemDetails) {
        this.cartItemDetails = cartItemDetails;
    }

    @Override
    public String toString() {
        return "UserCartDetailsDTO{" +
                "userId=" + userId +
                ", cartItemDetails=" + cartItemDetails +
                '}';
    }
}
