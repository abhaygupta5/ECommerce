package com.ving.ecommerce.merchants.controller;

import com.ving.ecommerce.merchants.model.ResponseObject;
import com.ving.ecommerce.merchants.service.Impl.MerchantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

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
    ResponseObject getBestMerchantPriceOfProductWithName(@RequestParam int productId){
        return merchantService.getBestMerchantPriceOfProductWithName(productId);
    }

    @GetMapping("/merchants")
    ResponseObject getMerchantList(@RequestParam int productId){
        return merchantService.getMerchantList(productId);
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

    @PutMapping("/updateStock/{merchantId}")
    ResponseObject updateStock(@PathVariable int merchantId, @RequestParam int productId, @RequestParam int stock){
        return merchantService.updateStock(merchantId,productId, stock);
    }

    @GetMapping("/checkInStock")
    ResponseObject checkInStock(@RequestParam int merchantId, @RequestParam int productId, @RequestParam int quantity){
        return merchantService.checkInStock(merchantId, productId, quantity);
    }

}
