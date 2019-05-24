package com.ving.ecommerce.orders.service.impl;

import com.ving.ecommerce.orders.entity.CartItem;
import com.ving.ecommerce.orders.entity.OrderItem;
import com.ving.ecommerce.orders.entity.ResponseObject;
import com.ving.ecommerce.orders.entity.UserOrder;
import com.ving.ecommerce.orders.model.MerchantDTO;
import com.ving.ecommerce.orders.model.ProductDTO;
import com.ving.ecommerce.orders.model.UserCartDTO;
import com.ving.ecommerce.orders.model.UserDTO;
import com.ving.ecommerce.orders.repository.UserCartRepository;
import com.ving.ecommerce.orders.repository.UserOrderRepository;
import com.ving.ecommerce.orders.service.CartService;
import com.ving.ecommerce.orders.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    UserOrderRepository userOrderRepository;

    @Autowired
    UserCartRepository userCartRepository;

    @Autowired
    CartService cartService;

    String BASE_PRODUCT_SERVICE = "http://localhost:8080";
    String BASE_MERCHANT_SERVICE = "http://localhost:8081";
    String BASE_ORDER_SERVICE = "http://localhost:8082";
    String BASE_USER_SERVICE = "http://localhost:8083";
    String BASE_EMAIL_SERVICE = "http://localhost:8084";
    String BASE_SEARCH_SERVICE = "http://localhost:8085";

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
        // API GET /users?userId={}
        String getUserUri = BASE_USER_SERVICE+"/users?userId=" + userCartDTO.getUserId();
        RestTemplate userRestTemplate = new RestTemplate();
        ResponseObject userResponseObject = userRestTemplate.getForObject(getUserUri, ResponseObject.class);
        UserDTO userDTO = (UserDTO) userResponseObject.getData();

        newUserOrder.setUserId(userDTO.getUserId());
        newUserOrder.setUserDTO(userDTO);

        // now for each cart item get productDTO and merchantDTO
        for(CartItem cartItem: cartItemList) {
            // get productDTO
            // API GET /getProduct?productId={productId}
            String productUri = BASE_PRODUCT_SERVICE+"/getProduct?productId=" + cartItem.getProductId();
            RestTemplate productRestTemplate = new RestTemplate();
            ResponseObject productResponseObject = productRestTemplate.getForObject(productUri, ResponseObject.class);
            ProductDTO productDTO = (ProductDTO) productResponseObject.getData();

            // get merchantDTO
            // API GET /merchants/{merchantId}
            String merchantUri = BASE_MERCHANT_SERVICE+"/merchants?" +cartItem.getMerchantId();
            RestTemplate merchantRestTemplate = new RestTemplate();
            ResponseObject merchantResponseObject = merchantRestTemplate.getForObject(merchantUri, ResponseObject.class);
            MerchantDTO merchantDTO = (MerchantDTO) merchantResponseObject.getData();

            // get the stock
            // API GET /getStockOfProduct?productId={}&mechantId={}
            String getStockUri = BASE_MERCHANT_SERVICE+"/getStockOfProduct?productId="+cartItem.getProductId()+
                    "&merchantId="+cartItem.getMerchantId();
            RestTemplate getStockRestTemplate = new RestTemplate();
            ResponseObject getStockResponseObject = getStockRestTemplate.getForObject(getStockUri, ResponseObject.class);
            int stock = (int) getStockResponseObject.getData();

            // update the stock - decrement by order quantity
            // API PUT /updateStock/{merchantId}?productId={}&stock={}
            int updatedStock = stock - cartItem.getQuantity();
            String updateStockUri = BASE_MERCHANT_SERVICE+"/updateStock/"+cartItem.getMerchantId()+"?productId="
                    +cartItem.getProductId()+"&stock=" + updatedStock;
            RestTemplate updateStockRestTemplate = new RestTemplate();
            updateStockRestTemplate.put(updateStockUri, null);

            OrderItem orderItem= new OrderItem();
            orderItem.setMerchantDTO(merchantDTO);
            orderItem.setProductDTO(productDTO);
            newUserOrder.getOrderItemList().add(orderItem);
        }

        // save the order in the database
        userOrderRepository.save(newUserOrder);

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
