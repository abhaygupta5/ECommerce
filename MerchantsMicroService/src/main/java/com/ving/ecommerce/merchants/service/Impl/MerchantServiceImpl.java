package com.ving.ecommerce.merchants.service.Impl;

import com.ving.ecommerce.merchants.entity.Merchant;
import com.ving.ecommerce.merchants.entity.MerchantProductId;
import com.ving.ecommerce.merchants.entity.MerchantRatingId;
import com.ving.ecommerce.merchants.entity.ProductMerchant;
import com.ving.ecommerce.merchants.model.MerchantDTO;
import com.ving.ecommerce.merchants.model.ProductMerchantDTO;
import com.ving.ecommerce.merchants.model.ResponseObject;
import com.ving.ecommerce.merchants.repository.MerchantRatingRepository;
import com.ving.ecommerce.merchants.repository.MerchantRepository;
import com.ving.ecommerce.merchants.repository.ProductMerchantRepository;
import com.ving.ecommerce.merchants.repository.TopMerchantsRepository;
import com.ving.ecommerce.merchants.service.MerchantService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MerchantServiceImpl implements MerchantService {
    String BASE_PRODUCT_SERVICE = "http://localhost:8080";
    String BASE_MERCHANT_SERVICE = "http://localhost:8081";
    String BASE_ORDER_SERVICE = "http://localhost:8082";
    String BASE_USER_SERVICE = "http://localhost:8083";
    String BASE_EMAIL_SERVICE = "http://localhost:8084";
    String BASE_SEARCH_SERVICE = "http://localhost:8085";

    @Autowired
    private MerchantRatingRepository merchantRatingRepository;
    @Autowired
    private MerchantRepository merchantRepository;
    @Autowired
    private ProductMerchantRepository productMerchantRepository;
    @Autowired
    private TopMerchantsRepository topMerchantsRepository;

    @Override
    public ResponseObject getMerchant(int merchantId) {
        Merchant merchant = merchantRepository.findOne(merchantId);
        if(merchant !=null) {
            MerchantDTO merchantDTO = new MerchantDTO();
            BeanUtils.copyProperties(merchant, merchantDTO);
            return new ResponseObject(merchantDTO, true);
        }
        //returns Merchant DTO
        return new ResponseObject(null, false);
    }

    @Override
    public ResponseObject getPriceOfProduct(int productId, int merchantId) {
        //return double
        ProductMerchant productMerchant = productMerchantRepository.findOne(new MerchantProductId(merchantId,productId));
        if(productMerchant !=null){
            return new ResponseObject(productMerchant.getProductPrice(),true);
        }
        return new ResponseObject(null,false);
    }

    @Override
    public ResponseObject getStockOfProduct(int productId, int merchantId) {
        //return double
        ProductMerchant productMerchant = productMerchantRepository.findOne(new MerchantProductId(merchantId,productId));
        if(productMerchant !=null){
            return new ResponseObject(productMerchant.getStock(),true);
        }
        return new ResponseObject(null,false);
    }

    @Override
    public ResponseObject getBestMerchantPriceOfProduct(int productId) {
        //returns double
        return null;
    }

    @Override
    public ResponseObject getSortedMerchantList(int productId) {
        // returns ProductMerchantDTO
        return null;
    }

    @Override
    public ResponseObject getAverageMerchantRating(int merchantId) {
        // returns double
        if(merchantRatingRepository.findByMerchantId(merchantId) !=null ){
            double averageRating = merchantRatingRepository.getAverageMerchantRating(merchantId);
            return new ResponseObject(averageRating, true);
        }
        return new ResponseObject(null, false);
    }

    @Override
    public ResponseObject getMerchantRatingByUser(int merchantId, String token) {
        // returns integer rating
        String uri = BASE_USER_SERVICE+"/users/"+token;
        RestTemplate restTemplate = new RestTemplate();
        ResponseObject responseObject = restTemplate.getForObject(uri, ResponseObject.class);
        int userId = (int)responseObject.getData();
        if(merchantRatingRepository.exists(new MerchantRatingId(merchantId, userId))){
            return new ResponseObject(merchantRatingRepository.findOne(new MerchantRatingId(merchantId, userId)), true);
        }
        return new ResponseObject(null, false);
    }

    @Override
    public ResponseObject setMerchantRating(int merchantId, String token, int rating) {
        // returns true or false
        return null;
    }

    @Scheduled(fixedDelay =1800000)
    public void updateTopMerchantsTable(){
        System.out.println("Scheduler is working");
    }
}
