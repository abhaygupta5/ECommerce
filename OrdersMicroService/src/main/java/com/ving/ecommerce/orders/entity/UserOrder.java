package com.ving.ecommerce.orders.entity;

import com.ving.ecommerce.orders.model.UserDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class UserOrder {

    @Id
    private String orderId;
    private int userId;
    private UserDTO userDTO;
    private List<OrderItem> orderItemList;

    public UserOrder() {
    }

    public UserOrder(String orderId, int userId, UserDTO userDTO, List<OrderItem> orderItemList) {
        this.orderId = orderId;
        this.userId = userId;
        this.userDTO = userDTO;
        this.orderItemList = orderItemList;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    @Override
    public String toString() {
        return "UserOrder{" +
                "orderId='" + orderId + '\'' +
                ", userId=" + userId +
                ", userDTO=" + userDTO +
                ", orderItemList=" + orderItemList +
                '}';
    }
}
