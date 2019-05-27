package com.ving.ecommerce.orders.controller;

import com.ving.ecommerce.orders.entity.ResponseObject;
import com.ving.ecommerce.orders.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/order/{token}")
    ResponseObject placeOrder(@PathVariable String token, @RequestParam String orderAddress) {
        System.out.println("PLACE ORDER: Token: " + token + " Address: " + orderAddress);
        return orderService.placeOrder(token, orderAddress);
    }

    @GetMapping("orderCount/{merchantId}")
    ResponseObject getOrderCount(@PathVariable int merchantId) {
        return orderService.getOrderCountByMerchantId(merchantId);
    }

    @GetMapping("/order/{token}")
    ResponseObject getUserOrderHistory(@PathVariable String token) {
        System.out.println("ORDER HISTORY: " + token);
        return orderService.getUserOrderHistory(token);
    }

    @GetMapping("/isEligibleForReviewProduct")
    ResponseObject isEligibleForReviewProduct(@RequestParam String token, @RequestParam int productId) {
        return orderService.isEligibleForReviewProduct(token, productId);
    }

    @GetMapping("/isEligibleForRatingMerchant")
    ResponseObject isEligibleForRatingMerchant(@RequestParam String token, @RequestParam int merchantId){
        return orderService.isEligibleForReviewProduct(token, merchantId);
    }

}
