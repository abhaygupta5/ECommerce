package com.ving.ecommerce.orders.entity;

import com.ving.ecommerce.orders.model.MerchantDTO;
import com.ving.ecommerce.orders.model.ProductDTO;
import com.ving.ecommerce.orders.model.UserDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Document
public class UserOrder {

    private String orderId;
    @Id
    private String orderItemId;
    private int userId;
    private UserDTO userDTO;
    private String orderAddress;
    private int productId;
    private ProductDTO productDTO;
    private int merchantId;
    private MerchantDTO merchantDTO;
    double productPrice;
    double totalPrice;
    int quantity;
    Date orderDate;

    public UserOrder() {
    }

    public UserOrder(String orderId, String orderItemId, int userId, UserDTO userDTO, String orderAddress, int productId, ProductDTO productDTO, int merchantId, MerchantDTO merchantDTO, double productPrice, double totalPrice, int quantity, Date orderDate) {
        this.orderId = orderId;
        this.orderItemId = orderItemId;
        this.userId = userId;
        this.userDTO = userDTO;
        this.orderAddress = orderAddress;
        this.productId = productId;
        this.productDTO = productDTO;
        this.merchantId = merchantId;
        this.merchantDTO = merchantDTO;
        this.productPrice = productPrice;
        this.totalPrice = totalPrice;
        this.quantity = quantity;
        this.orderDate = orderDate;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(String orderItemId) {
        this.orderItemId = orderItemId;
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

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public ProductDTO getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }

    public int getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(int merchantId) {
        this.merchantId = merchantId;
    }

    public MerchantDTO getMerchantDTO() {
        return merchantDTO;
    }

    public void setMerchantDTO(MerchantDTO merchantDTO) {
        this.merchantDTO = merchantDTO;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "UserOrder{" +
                "orderId='" + orderId + '\'' +
                ", orderItemId='" + orderItemId + '\'' +
                ", userId=" + userId +
                ", userDTO=" + userDTO +
                ", orderAddress='" + orderAddress + '\'' +
                ", productId=" + productId +
                ", productDTO=" + productDTO +
                ", merchantId=" + merchantId +
                ", merchantDTO=" + merchantDTO +
                ", productPrice=" + productPrice +
                ", totalPrice=" + totalPrice +
                ", quantity=" + quantity +
                ", orderDate=" + orderDate +
                '}';
    }
}
