package com.ving.ecommerce.merchants.controller;

import com.ving.ecommerce.merchants.model.ResponseObject;
import com.ving.ecommerce.merchants.service.Impl.MerchantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MerchantController {

    @Autowired
    private MerchantServiceImpl merchantService;

    @GetMapping("/ping")
    String hello(){
        return "hello! its working";
    }

    @GetMapping("/merchants/{merchantId}")
    ResponseObject getMerchant(@PathVariable int merchantId){
        System.out.println("Coming here!!");
        return merchantService.getMerchant(merchantId);
    }

    @GetMapping("/getPriceOfProduct")
    ResponseObject getPriceOfProduct(@RequestParam int productId, @RequestParam int merchantId){
        return merchantService.getPriceOfProduct(productId,merchantId);
    }

    @GetMapping("/getStockOfProduct")
    ResponseObject getStockOfProduct(@RequestParam int productId, @RequestParam int merchantId){
        return merchantService.getStockOfProduct(productId,merchantId);
    }

    @GetMapping("/getBestMerchantPriceOfProduct")
    ResponseObject getBestMerchantPriceOfProduct(@RequestParam int productId){
        return merchantService.getBestMerchantPriceOfProduct(productId);
    }

    @GetMapping("/merchants/")
    ResponseObject getSortedMerchantList(@RequestParam int productId){
        return merchantService.getSortedMerchantList(productId);
    }

    @GetMapping("/merchantAverageRating/{merchantId}")
    ResponseObject getAverageMerchantRating(@PathVariable int merchantId){
        return merchantService.getAverageMerchantRating(merchantId);
    }

    @GetMapping("/merchantRating/{merchantId}")
    ResponseObject getMerchantRatingByUser(@PathVariable int merchantId, @RequestParam String token){
        return merchantService.getMerchantRatingByUser(merchantId,token);
    }

    @PostMapping("/merchantRating/{merchantId}")
    ResponseObject setMerchantRating(@PathVariable int merchantId, @RequestParam String token, @RequestParam int rating){
        return merchantService.setMerchantRating(merchantId, token, rating);
    }
}
