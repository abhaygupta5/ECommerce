package com.ving.ecommerce.orders.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ving.ecommerce.orders.entity.*;
import com.ving.ecommerce.orders.model.MerchantDTO;
import com.ving.ecommerce.orders.model.ProductDTO;
import com.ving.ecommerce.orders.model.UserCartDTO;
import com.ving.ecommerce.orders.model.UserDTO;
import com.ving.ecommerce.orders.repository.UserCartRepository;
import com.ving.ecommerce.orders.repository.UserOrderRepository;
import com.ving.ecommerce.orders.service.CartService;
import com.ving.ecommerce.orders.service.EmailService;
import com.ving.ecommerce.orders.service.OrderService;
import com.ving.ecommerce.orders.utilities.OrderIdGenerator;
import org.apache.catalina.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static com.ving.ecommerce.orders.ServerConfiguration.BASE_MERCHANT_SERVICE;
import static com.ving.ecommerce.orders.ServerConfiguration.BASE_PRODUCT_SERVICE;
import static com.ving.ecommerce.orders.ServerConfiguration.BASE_USER_SERVICE;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    UserOrderRepository userOrderRepository;

    @Autowired
    UserCartRepository userCartRepository;

    @Autowired
    EmailService emailService;

    @Autowired
    CartService cartService;

    @Override
    public ResponseObject placeOrder(String token, String orderAddress) {

        // use userId to get cart
        ResponseObject userCartResponse = cartService.getUserCart(token);

        if(!userCartResponse.getOk()){
            // ERR some error in cart
            return userCartResponse;
        }


        UserCartDTO userCartDTO = (UserCartDTO) userCartResponse.getData();

        // check if items in cart
        if(userCartDTO == null) {
            return new ResponseObject("no items in cart", false);
        }
        List<CartItem> cartItemList = userCartDTO.getCartItems();

        // for each cart item check if in stock
        for(CartItem cartItem: cartItemList) {

            // check validity
            String uri = BASE_MERCHANT_SERVICE+"/checkInStock?merchantId="+cartItem.getMerchantId()
                    +"&productId="+cartItem.getProductId()+"&quantity="+cartItem.getQuantity();
            RestTemplate restTemplate = new RestTemplate();
            ResponseObject responseObject = restTemplate.getForObject(uri, ResponseObject.class);

            // check if stock is satisfied
            if(responseObject.getOk()) {
                if(!(boolean)responseObject.getData()) {
                    // get product name and merchant name

                    // get merchantDTO
                    // API GET /merchants/{merchantId}
                    ObjectMapper mapper = new ObjectMapper();
                    String merchantUri = BASE_MERCHANT_SERVICE+"/merchants/" +cartItem.getMerchantId();
                    responseObject = restTemplate.getForObject(merchantUri, ResponseObject.class);
                    MerchantDTO merchantDTO = mapper.convertValue(responseObject.getData(), MerchantDTO.class);

                    // get productDTO
                    // API GET /getProduct?productId={productId}
                    String productUri = BASE_PRODUCT_SERVICE+"/getProduct?productId=" + cartItem.getProductId();
                    responseObject = restTemplate.getForObject(productUri, ResponseObject.class);
                    ProductDTO productDTO = mapper.convertValue(responseObject.getData(), ProductDTO.class);

                    String errorString = productDTO.getProductName() + " by merchant "
                            + merchantDTO.getMerchantName() + " does not have enough stock.";


                    return new ResponseObject(errorString, false);
                }
            } else {
                return new ResponseObject("some error in merchant service, during checking stock.",false);
            }
        }
        // stock is met now

        // place order for product
        ObjectMapper mapper = new ObjectMapper();
        ResponseObject responseObject = new ResponseObject();
        RestTemplate restTemplate = new RestTemplate();
        // API GET /users?userId={}
        String getUserUri = BASE_USER_SERVICE+"/users?userId=" + userCartDTO.getUserId();
        responseObject = restTemplate.getForObject(getUserUri, ResponseObject.class);
        UserDTO userDTO = mapper.convertValue(responseObject.getData(), UserDTO.class);


        // create new order summary
        String orderItemString = "Hello " + userDTO.getUserName() + "! Here's your order summary.\n"
                + "ORDER SUMMARY\n"
                +"-------------\n";
        Double totalCost = 0.0;

        // now for each cart item get productDTO and merchantDTO
        // generate the order summary also
        for(CartItem cartItem: cartItemList) {

            // create a new Order
            UserOrder newUserOrder = new UserOrder();
            newUserOrder.setUserId(userDTO.getUserId());
            newUserOrder.setUserDTO(userDTO);
            OrderIdGenerator orderIdGenerator = new OrderIdGenerator();
            newUserOrder.setOrderId(orderIdGenerator.getNewOrderId());
            newUserOrder.setOrderAddress(orderAddress);

            // get productDTO
            // API GET /getProduct?productId={productId}
            String productUri = BASE_PRODUCT_SERVICE+"/getProduct?productId=" + cartItem.getProductId();
            responseObject = restTemplate.getForObject(productUri, ResponseObject.class);
            ProductDTO productDTO = mapper.convertValue(responseObject.getData(), ProductDTO.class);

            double productPrice = productDTO.getPrice();
            int productQuantity = cartItem.getQuantity();
            orderItemString = orderItemString
                    + "Product Brand: "+ productDTO.getBrand() + "\n"
                    + "Product Name: " + productDTO.getProductName() + "\n"
                    + "Price: " + Double.toString(productPrice) + "\n"
                    + "Quantity: " + productQuantity + "\n";

            totalCost += productPrice * productQuantity;

            // get merchantDTO
            // API GET /merchants/{merchantId}
            String merchantUri = BASE_MERCHANT_SERVICE+"/merchants/" +cartItem.getMerchantId();
            responseObject = restTemplate.getForObject(merchantUri, ResponseObject.class);
            MerchantDTO merchantDTO = mapper.convertValue(responseObject.getData(), MerchantDTO.class);

            // get the stock
            // API GET /getStockOfProduct?productId={}&mechantId={}
            String getStockUri = BASE_MERCHANT_SERVICE+"/getStockOfProduct?productId="+cartItem.getProductId()+
                    "&merchantId="+cartItem.getMerchantId();
            responseObject = restTemplate.getForObject(getStockUri, ResponseObject.class);
            int stock = (int) responseObject.getData();

            // update the stock - decrement by order quantity
            // API PUT /updateStock/{merchantId}?productId={}&stock={}
            int updatedStock = stock - productQuantity;
            String updateStockUri = BASE_MERCHANT_SERVICE+"/updateStock/"+cartItem.getMerchantId()+"?productId="
                    +cartItem.getProductId()+"&stock=" + updatedStock;
            RestTemplate updateStockRestTemplate = new RestTemplate();
            updateStockRestTemplate.put(updateStockUri, null);

            // set the merchant for the order
            newUserOrder.setMerchantId(merchantDTO.getMerchantId());
            newUserOrder.setMerchantDTO(merchantDTO);
            // set the product for the order
            newUserOrder.setProductId(productDTO.getProductId());
            newUserOrder.setProductDTO(productDTO);
            // set the quantity for the order
            newUserOrder.setQuantity(productQuantity);

            // save order to repository
            userOrderRepository.save(newUserOrder);

            orderItemString = orderItemString
                    + "Merchant Name: " + merchantDTO.getMerchantName() + "\n";

            orderItemString = orderItemString +
                    "OrderId: " + newUserOrder.getOrderId() + "\n"
                    + "-----" + "\n";
        }

        orderItemString = orderItemString
                + "Order Address: " + orderAddress + "\n"
                + "Total Cost: " + Double.toString(totalCost) + "\n";

        emailService.sendSimpleMessage(userDTO.getUserEmail(),
                "Your order has been placed successfully!",
                orderItemString);

        // clear cart of the user
        UserCart usercart = userCartRepository.findOne(userCartDTO.getUserId());
        userCartRepository.delete(usercart);

        // return cartDTO
        return new ResponseObject(userCartDTO, true);
    }

    @Override
    public ResponseObject getOrderCountByMerchantId(int merchantId) {
        List<UserOrder> userOrderList = userOrderRepository.findBymerchantId(merchantId);

        if(userOrderList == null) {
            return new ResponseObject("Mongo Order Repository erroe", false);
        } else {
            return new ResponseObject(userOrderList.size(), true);
        }
    }

    @Override
    public ResponseObject getUserOrderHistory(String token) {
        // get userid from token using the userservice
        ResponseObject responseObject = getUserIdFromToken(token);

        int userId;
        // check if token is valid
        if(responseObject.getOk() == false) {
            return new ResponseObject("invalid token", false);
        } else {
            userId = (int)responseObject.getData();
        }

        List<UserOrder> userOrderList = userOrderRepository.findByuserId(userId);

        if(userOrderList != null) {
            //check if list is empty
            return userOrderList.isEmpty()?
                    new ResponseObject(null, true)
                    : new ResponseObject(userOrderList, true);
        } else {
            return new ResponseObject("Mongo Order Repository error", false);
        }
    }

    @Override
    public ResponseObject isEligibleForReviewProduct(String token, int productId) {
        // get userid from token using the userservice
        ResponseObject responseObject = getUserIdFromToken(token);

        int userId;
        // check if token is valid
        if(responseObject.getOk() == false) {
            return new ResponseObject("invalid token", false);
        } else {
            userId = (int)responseObject.getData();
        }

        List<UserOrder> userOrderList = userOrderRepository.findByUserIdAndProductId(userId,  productId);

        if(userOrderList != null) {
            return userOrderList.isEmpty() ?
                new ResponseObject(false, true) :
                new ResponseObject(true, true);
        } else {
            return new ResponseObject("Mongo Order Repository error", false);
        }
    }

    @Override
    public ResponseObject isEligibleForRatingMerchant(String token, int merchantId) {
        // get userid from token using the userservice
        ResponseObject responseObject = getUserIdFromToken(token);

        int userId;
        // check if token is valid
        if(responseObject.getOk() == false) {
            return new ResponseObject("invalid token", false);
        } else {
            userId = (int)responseObject.getData();
        }

        List<UserOrder> userOrderList = userOrderRepository.findByUserIdAndMerchantId(userId,  merchantId);

        if(userOrderList != null) {
            return userOrderList.isEmpty() ?
                    new ResponseObject(false, true) :
                    new ResponseObject(true, true);
        } else {
            return new ResponseObject("Mongo Order Repository error", false);
        }
    }

    // ****************************************************************
    // HELPER FUNCTIONS
    // ****************************************************************
    private ResponseObject getUserIdFromToken(String token) {
        String uri = BASE_USER_SERVICE+"/users/"+token;
        RestTemplate restTemplate = new RestTemplate();
        ResponseObject responseObject = restTemplate.getForObject(uri, ResponseObject.class);

        return responseObject;
    }
}
