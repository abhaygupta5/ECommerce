package com.ving.ecommerce.merchants.service.Impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.ving.ecommerce.merchants.entity.*;
import com.ving.ecommerce.merchants.model.MerchantDTO;
import com.ving.ecommerce.merchants.model.ProductDTO;
import com.ving.ecommerce.merchants.model.ProductMerchantDTO;
import com.ving.ecommerce.merchants.model.ResponseObject;
import com.ving.ecommerce.merchants.repository.MerchantRatingRepository;
import com.ving.ecommerce.merchants.repository.MerchantRepository;
import com.ving.ecommerce.merchants.repository.ProductMerchantRepository;
import com.ving.ecommerce.merchants.repository.TopMerchantsRepository;
import com.ving.ecommerce.merchants.service.MerchantService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

import static com.ving.ecommerce.merchants.ServerConfiguration.BASE_USER_SERVICE;
import static com.ving.ecommerce.merchants.ServerConfiguration.BASE_PRODUCT_SERVICE;

@Service
public class MerchantServiceImpl implements MerchantService {

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
        return new ResponseObject("Could not find merchant", false);
    }

    @Override
    public ResponseObject getPriceOfProduct(int productId, int merchantId) {
        //return double
        ProductMerchant productMerchant = productMerchantRepository.findOne(new MerchantProductId(merchantId,productId));
        if(productMerchant !=null){
            return new ResponseObject(productMerchant.getProductPrice(),true);
        }
        return new ResponseObject("Product or Merchant does not exist",false);
    }

    @Override
    public ResponseObject getStockOfProduct(int productId, int merchantId) {
        //return double
        ProductMerchant productMerchant = productMerchantRepository.findOne(new MerchantProductId(merchantId,productId));
        if(productMerchant !=null){
            return new ResponseObject(productMerchant.getStock(),true);
        }
        return new ResponseObject("Product or Merchant does not exist",false);
    }

    @Override
    public ResponseObject getBestMerchantPriceOfProductWithName(int productId) {
        //returns double
        if(topMerchantsRepository.exists(productId)){
            TopMerchants topMerchants = topMerchantsRepository.findOne(productId);
            int merchantId = Integer.parseInt(topMerchants.getMerchantList().split(":")[0]);
            String merchantName = topMerchants.getMerchantList().split(":")[1];
            ProductMerchant productMerchant = productMerchantRepository.findOne(new MerchantProductId(merchantId, productId));
            return new ResponseObject(productMerchant.getProductPrice()+":"+merchantName, true);
        }
        return new ResponseObject("Product or Merchant does not exist", false);
    }

    @Override
    public ResponseObject getMerchantList(int productId) {
        // returns ProductMerchantDTO
        List<ProductMerchant> productMerchants = productMerchantRepository.findByProductIdWithCondition(productId);
        System.out.println(productMerchants);
        if(productMerchants.size() != 0){
            return new ResponseObject(productMerchants, true);
        }
        return new ResponseObject("Merchant does not exist", false);
    }

    @Override
    public ResponseObject getAverageMerchantRating(int merchantId) {
        // returns double
        if(merchantRatingRepository.findByMerchantId(merchantId) !=null ){
            double averageRating = merchantRatingRepository.getAverageMerchantRating(merchantId);
            return new ResponseObject(averageRating, true);
        }
        return new ResponseObject("Merchant does not exist", false);
    }

    @Override
    public ResponseObject getMerchantRatingByUser(int merchantId, String token) {
        // returns integer rating
        String uri = BASE_USER_SERVICE+"/users/"+token;
        RestTemplate restTemplate = new RestTemplate();
        ResponseObject responseObject = restTemplate.getForObject(uri, ResponseObject.class);
        if(!responseObject.getOk()) {
            int userId = (int) responseObject.getData();
            if (merchantRatingRepository.exists(new MerchantRatingId(merchantId, userId))) {
                return new ResponseObject(merchantRatingRepository.findOne(new MerchantRatingId(merchantId, userId)), true);
            }
        }
        return new ResponseObject("No Merchant rating found", false);
    }

    @Override
    public ResponseObject setMerchantRating(int merchantId, String token, int rating) {
        // returns true or false
        String uri = BASE_USER_SERVICE+"/users/"+token;
        RestTemplate restTemplate = new RestTemplate();
        ResponseObject responseObject = restTemplate.getForObject(uri, ResponseObject.class);
        if(!responseObject.getOk()) {
            int userId = (int) responseObject.getData();

            MerchantRating merchantRating = merchantRatingRepository.save(new MerchantRating(merchantId, userId, rating));
            if (merchantRating != null) {
                return new ResponseObject(merchantRating, true);
            }
        }
        return new ResponseObject("Sorry please try again", false);
    }

    @Override
    public ResponseObject updateStock(int merchantId, int productId, int stock) {
        ProductMerchant productMerchant = productMerchantRepository.findOne(new MerchantProductId(merchantId, productId));
        if(productMerchant != null){
            productMerchant.setStock(stock);
            return new ResponseObject(productMerchantRepository.save(productMerchant), true);
        }
        return new ResponseObject("Sorry please try again", false);
    }

    @Override
    public ResponseObject checkInStock(int merchantId, int productId, int quantity) {
        ProductMerchant productMerchant = productMerchantRepository.findOne(new MerchantProductId(merchantId, productId));
        if(productMerchant.getStock() > quantity){
            return new ResponseObject(true, true);
        }
        return new ResponseObject("Sorry please try again", false);
    }

    @Scheduled(fixedDelay =1800000)
    public void updateTopMerchantsTable(){

        List<Integer> productList = productMerchantRepository.getAllProductIds();


        for(int productId : productList){
            List<TopMerchantObject> sorted_merchants = new ArrayList<>();
            List<Integer> merchantListForProduct = productMerchantRepository.getAllMerchantsByProduct(productId);

            Map<Merchant, Double> merchantScoreForProduct = new HashMap<>();
            for(int merchantId : merchantListForProduct){
                Merchant merchant = merchantRepository.findOne(merchantId);
                Long numberOfProductsMerchantSelling = productMerchantRepository.countByMerchantId(merchantId);
                int currentStockOfProduct = productMerchantRepository.getStockFromId(merchantId, productId);
                double averageMerchantRating = (double)getAverageMerchantRating(merchantId).getData();
                double priceOfProduct = productMerchantRepository.getPriceFromId(merchantId, productId);
                double merchantScore = (numberOfProductsMerchantSelling + currentStockOfProduct + averageMerchantRating + priceOfProduct)/4;
                merchantScoreForProduct.put(merchant, merchantScore);

            }
            MyComparator comp=new MyComparator(merchantScoreForProduct);

            Map<Merchant,Double> sorted = new TreeMap(comp);
            sorted.putAll(merchantScoreForProduct);

            for(Merchant merchant: sorted.keySet()){
                sorted_merchants.add(new TopMerchantObject(merchant.getMerchantId(),merchant.getMerchantName()));
            }
            TopMerchantObject toUpdateProduct = sorted_merchants.get(0);
            int merchantIdToUpdate = toUpdateProduct.getMerchantId();
            String uri = BASE_PRODUCT_SERVICE+"/getProduct?productId="+productId;
            RestTemplate restTemplate = new RestTemplate();
            ResponseObject responseObject1 = restTemplate.getForObject(uri, ResponseObject.class);

            ObjectMapper mapper = new ObjectMapper();
            ProductDTO productDTO = mapper.convertValue(responseObject1.getData(), ProductDTO.class);
            productDTO.setPrice((double)getPriceOfProduct(productId, merchantIdToUpdate).getData());

            String[] merchant_sorted = new String[1];
            int index=0;
            for(TopMerchantObject topMerchantObject: sorted_merchants){
                merchant_sorted[index] = topMerchantObject.toString();
            }
            String finalMerchantList = String.join("|",merchant_sorted);

            // left to implement update of price
            uri = BASE_PRODUCT_SERVICE+"/updateProduct";
            restTemplate = new RestTemplate();
            restTemplate.put(uri, productDTO);

            topMerchantsRepository.save(new TopMerchants(productId, finalMerchantList));
        }

    }

}

class MyComparator implements Comparator {

    Map map;

    public MyComparator(Map map) {
        this.map = map;
    }

    public int compare(Object o1, Object o2) {

        return ((Double) map.get(o2)).compareTo((Double) map.get(o1));

    }
}
