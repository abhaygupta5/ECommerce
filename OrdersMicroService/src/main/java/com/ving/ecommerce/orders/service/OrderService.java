package com.ving.ecommerce.orders.service;

import com.ving.ecommerce.orders.entity.ResponseObject;

public interface OrderService {

    ResponseObject placeOrder(String token, String orderAddress);
    ResponseObject getOrderCountByMerchantId(int merchantId);
    ResponseObject getUserOrderHistory(String token);
    ResponseObject isEligibleForReviewProduct(String token, int productId);
    ResponseObject isEligibleForRatingMerchant(String token, int merchantId);
}
