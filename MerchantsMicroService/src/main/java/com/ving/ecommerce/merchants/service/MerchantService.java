package com.ving.ecommerce.merchants.service;

import com.ving.ecommerce.merchants.model.MerchantDTO;
import com.ving.ecommerce.merchants.model.ProductMerchantDTO;
import com.ving.ecommerce.merchants.model.ResponseObject;

public interface MerchantService {
    ResponseObject getMerchant(int merchantId);
    ResponseObject getPriceOfProduct(int productId, int merchantId);
    ResponseObject getStockOfProduct(int productId, int merchantId);
    ResponseObject getBestMerchantPriceOfProduct(int productId);
    ResponseObject getSortedMerchantList(int productId);
    ResponseObject getAverageMerchantRating(int merchantId);
    ResponseObject getMerchantRatingByUser(int merchantId, String token);
    ResponseObject setMerchantRating(int merchantId, String token, int rating);
}
