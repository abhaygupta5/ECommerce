package com.ving.ecommerce.orders.entity;

import com.ving.ecommerce.orders.model.MerchantDTO;
import com.ving.ecommerce.orders.model.ProductDTO;
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
    private String orderAddress;
    private int productId;
    private ProductDTO productDTO;
    private int merchantId;
    private MerchantDTO merchantDTO;
    int quantity;

    public UserOrder() {
    }

    public UserOrder(String orderId, int userId, UserDTO userDTO, String orderAddress, int productId, ProductDTO productDTO, int merchantId, MerchantDTO merchantDTO, int quantity) {
        this.orderId = orderId;
        this.userId = userId;
        this.userDTO = userDTO;
        this.orderAddress = orderAddress;
        this.productId = productId;
        this.productDTO = productDTO;
        this.merchantId = merchantId;
        this.merchantDTO = merchantDTO;
        this.quantity = quantity;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "UserOrder{" +
                "orderId='" + orderId + '\'' +
                ", userId=" + userId +
                ", userDTO=" + userDTO +
                ", orderAddress='" + orderAddress + '\'' +
                ", productId=" + productId +
                ", productDTO=" + productDTO +
                ", merchantId=" + merchantId +
                ", merchantDTO=" + merchantDTO +
                ", quantity=" + quantity +
                '}';
    }
}
