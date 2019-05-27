package com.ving.ecommerce.orders.controller;

import com.ving.ecommerce.orders.entity.ResponseObject;
import com.ving.ecommerce.orders.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;

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
        System.out.println("ADD CART ITEM: " + "ProductId: " + product + ",MerchantId: " + merchant + "Token: " + token);
        return cartService.addProductToCart(token, product, merchant, qty);
    }

    @DeleteMapping("/cart/{token}")
    public ResponseObject deleteCartItem(@PathVariable String token, @RequestParam int product,
                                        @RequestParam int merchant) {
        System.out.println("DELETE CART ITEM: " + "ProductId: " + product + ",MerchantId: " + merchant + "Token: " + token);
        return cartService.deleteCartItem(token, product, merchant);
    }

    @GetMapping("/cart/{token}")
    public ResponseObject getUserCart(@PathVariable String token) {
        System.out.println("GET USER CART:" + token);
        return cartService.getUserCart(token);
    }

    @GetMapping("/detailsCart/{token}")
    public ResponseObject getDetailsUserCart(@PathVariable String token) {
        System.out.println("GET USER DETAILS CART:" + token);
        return cartService.getDetailsUserCart(token);
    }
}
