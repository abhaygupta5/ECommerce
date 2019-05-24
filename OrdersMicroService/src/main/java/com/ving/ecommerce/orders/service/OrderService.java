package com.ving.ecommerce.orders.service;

import com.ving.ecommerce.orders.entity.ResponseObject;

public interface OrderService {

    ResponseObject placeOrder(String token);
}
