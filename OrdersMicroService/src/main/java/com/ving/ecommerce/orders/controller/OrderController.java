package com.ving.ecommerce.orders.controller;

import com.ving.ecommerce.orders.entity.ResponseObject;
import com.ving.ecommerce.orders.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/order/{token}")
    ResponseObject placeOrder(@PathVariable String token) {
        return orderService.placeOrder(token);
    }
}
