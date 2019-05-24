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
    public ResponseObject placeOrder(String token) {

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

        UserOrder newUserOrder = new UserOrder();
        newUserOrder.setOrderItemList(new ArrayList<OrderItem>());

        List<CartItem> cartItemList = userCartDTO.getCartItems();

        // for each cart item check if in stock
        for(CartItem c: cartItemList) {

            // check validity
            String uri = BASE_MERCHANT_SERVICE+"/checkInStock?merchantId="+c.getMerchantId()
                    +"&productId="+c.getProductId()+"&quantity="+c.getQuantity();
            RestTemplate restTemplate = new RestTemplate();
            ResponseObject responseObject = restTemplate.getForObject(uri, ResponseObject.class);

            // check if stock is satisfied
            if(responseObject.getOk()) {
                if(!(boolean)responseObject.getData()) {
                    return new ResponseObject("Some product out of stock.", false);
                }
            } else {
                return new ResponseObject("some error in merchant service, during checking stock.",false);
            }
        }
        // stock is met now

        // place order for product
        ObjectMapper mapper = new ObjectMapper();
        // API GET /users?userId={}
        String getUserUri = BASE_USER_SERVICE+"/users?userId=" + userCartDTO.getUserId();
        RestTemplate userRestTemplate = new RestTemplate();
        ResponseObject userResponseObject = userRestTemplate.getForObject(getUserUri, ResponseObject.class);
        UserDTO userDTO = mapper.convertValue(userResponseObject.getData(), UserDTO.class);

        newUserOrder.setUserId(userDTO.getUserId());
        newUserOrder.setUserDTO(userDTO);

        String orderItemString = "ORDER SUMMARY\n"
                                +"-------------\n";
        Double totalCost = 0.0;

        // now for each cart item get productDTO and merchantDTO
        // generate the order summary also
        for(CartItem cartItem: cartItemList) {
            // get productDTO
            // API GET /getProduct?productId={productId}
            String productUri = BASE_PRODUCT_SERVICE+"/getProduct?productId=" + cartItem.getProductId();
            RestTemplate productRestTemplate = new RestTemplate();
            ResponseObject productResponseObject = productRestTemplate.getForObject(productUri, ResponseObject.class);
            ProductDTO productDTO = mapper.convertValue(productResponseObject.getData(), ProductDTO.class);

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
            RestTemplate merchantRestTemplate = new RestTemplate();
            ResponseObject merchantResponseObject = merchantRestTemplate.getForObject(merchantUri, ResponseObject.class);
            MerchantDTO merchantDTO = mapper.convertValue(merchantResponseObject.getData(), MerchantDTO.class);

            orderItemString = orderItemString
                    + "Merchant Name: " + merchantDTO.getMerchantName() + "\n"
                    + "-----" + "\n";

            // get the stock
            // API GET /getStockOfProduct?productId={}&mechantId={}
            String getStockUri = BASE_MERCHANT_SERVICE+"/getStockOfProduct?productId="+cartItem.getProductId()+
                    "&merchantId="+cartItem.getMerchantId();
            RestTemplate getStockRestTemplate = new RestTemplate();
            ResponseObject getStockResponseObject = getStockRestTemplate.getForObject(getStockUri, ResponseObject.class);
            int stock = (int) getStockResponseObject.getData();

            // update the stock - decrement by order quantity
            // API PUT /updateStock/{merchantId}?productId={}&stock={}
            int updatedStock = stock - productQuantity;
            String updateStockUri = BASE_MERCHANT_SERVICE+"/updateStock/"+cartItem.getMerchantId()+"?productId="
                    +cartItem.getProductId()+"&stock=" + updatedStock;
            RestTemplate updateStockRestTemplate = new RestTemplate();
            updateStockRestTemplate.put(updateStockUri, null);

            OrderItem orderItem= new OrderItem();
            orderItem.setMerchantDTO(merchantDTO);
            orderItem.setProductDTO(productDTO);
            newUserOrder.getOrderItemList().add(orderItem);
        }

        orderItemString = orderItemString
                + "Total Cost: " + Double.toString(totalCost) + "\n";

        // save the order in the database
        userOrderRepository.save(newUserOrder);

        emailService.sendSimpleMessage(userDTO.getUserEmail(),
                "Your order has been placed successfully!",
                orderItemString);

        // clear cart of the user
        UserCart usercart = userCartRepository.findOne(userCartDTO.getUserId());
        userCartRepository.delete(usercart);

        // return cartDTO
        return new ResponseObject(userCartDTO, true);
    }

    // helper function
    private ResponseObject getUserIdFromToken(String token) {
        String uri = BASE_USER_SERVICE+"/users/"+token;
        RestTemplate restTemplate = new RestTemplate();
        ResponseObject responseObject = restTemplate.getForObject(uri, ResponseObject.class);

        return responseObject;
    }
}
