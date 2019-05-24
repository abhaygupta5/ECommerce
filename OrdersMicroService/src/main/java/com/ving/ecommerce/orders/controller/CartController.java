package com.ving.ecommerce.orders.controller;

import com.ving.ecommerce.orders.model.ResponseObject;
import com.ving.ecommerce.orders.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/ping")
    public String hello() {
        return "Cart Micro Service: Pong";
    }

    @PostMapping("/cart/{token}")
    public ResponseObject addToUserCart(@PathVariable String token, @RequestParam int product,
                                @RequestParam int merchant, @RequestParam int qty) {
        return cartService.addProductToCart(token, product, merchant, qty);
    }

    @DeleteMapping("/cart/{token}")
    public ResponseObject addToUserCart(@PathVariable String token, @RequestParam int product,
                                        @RequestParam int merchant) {
        return cartService.deleteCartItem(token, product, merchant);
    }

    @GetMapping("/cart/{token}")
    public ResponseObject getUserCart(@PathVariable String token) {
        return cartService.getUserCart(token);
    }
}
