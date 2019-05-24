package com.ving.ecommerce.orders.service.impl;

import com.ving.ecommerce.orders.ServerConfiguration;
import com.ving.ecommerce.orders.entity.CartItem;
import com.ving.ecommerce.orders.entity.ResponseObject;
import com.ving.ecommerce.orders.entity.UserCart;
import com.ving.ecommerce.orders.model.UserCartDTO;
import com.ving.ecommerce.orders.repository.UserCartRepository;
import com.ving.ecommerce.orders.service.CartService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static com.ving.ecommerce.orders.ServerConfiguration.BASE_USER_SERVICE;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private UserCartRepository userCartRepository;

    public ResponseObject addProductToCart(String token, int productId, int merchantId, int qty) {

        // get userid from token using the userservice
        ResponseObject responseObject = getUserIdFromToken(token);

        int userId;
        // check if token is valid
        if(responseObject.getOk() == false) {
            return new ResponseObject("invalid token", false);
        } else {
            userId = (int)responseObject.getData();
        }

        // check if cart exists for the user
        if(userCartRepository.exists(userId)) {
            // case add in the existing cart

            // get user cart
            UserCart userCart = userCartRepository.findOne(userId);

            // if item exits in cart
            boolean updatedExistingItem = false;
            for(CartItem c: userCart.getCartItems()) {
                if(c.getProductId() == productId && c.getMerchantId() == merchantId) {
                    c.setQuantity(qty);
                    updatedExistingItem = true;
                }
            }

            if(!updatedExistingItem) {
                // create cart item
                CartItem cartItem = new CartItem();
                cartItem.setMerchantId(merchantId);
                cartItem.setProductId(productId);
                cartItem.setQuantity(qty);

                userCart.getCartItems().add(cartItem);
            }

            // update the cart in the repository
            userCartRepository.save(userCart);

        } else {
            // case create a new cart and add
            UserCart userCart = new UserCart();

            userCart.setUserId(userId);

            CartItem cartItem = new CartItem();
            cartItem.setMerchantId(merchantId);
            cartItem.setProductId(productId);
            cartItem.setQuantity(qty);

            List<CartItem> listOfCartItems = new ArrayList<CartItem>();
            listOfCartItems.add(cartItem);

            userCart.setCartItems(listOfCartItems);

            // update the user cart
            userCartRepository.save(userCart);
        }

        // get updated UserCart
        UserCart updatedUserCart = userCartRepository.findOne(userId);
        UserCartDTO userCartDTO = new UserCartDTO();
        BeanUtils.copyProperties(updatedUserCart, userCartDTO);

        return new ResponseObject(userCartDTO, true);
    }

    public ResponseObject deleteCartItem(String token, int productId, int merchantId) {

        // get userid from token using the userservice
        ResponseObject responseObject = getUserIdFromToken(token);

        int userId;
        // check if token is valid
        if(responseObject.getOk() == false) {
            return new ResponseObject("invalid token", false);
        } else {
            userId = (int)responseObject.getData();
        }

        // check if cart exists for the user
        if(userCartRepository.exists(userId)) {
            // get user cart
            UserCart userCart = userCartRepository.findOne(userId);

            // if item exits in cart
            CartItem existingCartItem = new CartItem();
            boolean foundExistingItem = false;
            for(CartItem c: userCart.getCartItems()) {
                if(c.getProductId() == productId && c.getMerchantId() == merchantId) {
                    foundExistingItem = true;
                    existingCartItem = c;
                }
            }
            if(foundExistingItem) {
                userCart.getCartItems().remove(existingCartItem);

                if(userCart.getCartItems().size() == 0) {
                    // delete entry of user
                    userCartRepository.delete(userId);
                    return new ResponseObject(null, true);
                } else {
                    // update database
                    userCartRepository.save(userCart);

                    // return UserCartDTO
                    UserCart userCart1 = userCartRepository.findOne(userId);
                    return new ResponseObject(userCart1, true);
                }

            } else {
                // ERR did not find the specified item
                return new ResponseObject("did not find specified product merchant combo in user cart", false);
            }
        } else {
            // ERR user cart does not exist
            return new ResponseObject("user cart does not exist.", false);
        }
    }

    @Override
    public ResponseObject getUserCart(String token) {
        // get userid from token using the userservice
        ResponseObject responseObject = getUserIdFromToken(token);

        int userId;
        // check if token is valid
        if(responseObject.getOk() == false) {
            return new ResponseObject("invalid token", false);
        } else {
            userId = (int)responseObject.getData();
        }

        if(userCartRepository.exists(userId)) {
            // get user cart
            UserCart userCart = userCartRepository.findOne(userId);

            UserCartDTO userCartDTO = new UserCartDTO();
            BeanUtils.copyProperties(userCart, userCartDTO);

            return new ResponseObject(userCartDTO, true);
        } else {
            return new ResponseObject(null, true);
        }
    }

    // helper function
    private ResponseObject getUserIdFromToken(String token) {
        String uri = BASE_USER_SERVICE+"/users/"+token;
        RestTemplate restTemplate = new RestTemplate();
        ResponseObject responseObject = restTemplate.getForObject(uri, ResponseObject.class);

        return responseObject;
    }
}
