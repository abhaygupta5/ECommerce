package com.ving.ecommerce.orders.service;

import com.ving.ecommerce.orders.entity.ResponseObject;

public interface CartService {

    ResponseObject addProductToCart(String token, int productId, int merchantId, int qty);
    ResponseObject deleteCartItem(String token, int product, int merchant);
    ResponseObject getUserCart(String token);
    ResponseObject getDetailsUserCart(String token);
}
