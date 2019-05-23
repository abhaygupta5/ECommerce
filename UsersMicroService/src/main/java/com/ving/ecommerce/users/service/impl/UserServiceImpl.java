package com.ving.ecommerce.users.service.impl;

import com.ving.ecommerce.users.model.*;
import com.ving.ecommerce.users.repository.UserAddressRepository;
import com.ving.ecommerce.users.repository.UserRepository;
import com.ving.ecommerce.users.repository.UserTokenRepository;
import com.ving.ecommerce.users.service.UserService;
import com.ving.ecommerce.users.utilities.HashGenerator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserAddressRepository userAddressRepository;

    @Autowired
    private UserTokenRepository userTokenRepository;

    private final static String salt = "vingecommerce";

    public ResponseObject getUserByUserId(int userId) {
        User user = userRepository.findOne(userId);

        UserDTO returnUser = new UserDTO();
        BeanUtils.copyProperties(user, returnUser);

        // get in the list of address
        List<UserAddress> listOfAddress = userAddressRepository.findByUserId(userId);
        ArrayList<String> addressList= new ArrayList<String>();

        for(UserAddress address: listOfAddress) {
            addressList.add(address.getUserAddress());
        }

        returnUser.setUserAddress(addressList);

        if(user == null) {
            return new ResponseObject("User not found", false);
        }
        else {
            return new ResponseObject(returnUser, true);
        }
    }

    // returns boolean in data
    @Override
    public ResponseObject createUser(UserDTO userDTO) {

        // check for username collision
        if(existsUserName(userDTO.getUserName()))
            return new ResponseObject("Username already exists.", false);

        User newUser = new User();
        BeanUtils.copyProperties(userDTO, newUser);

        // save user into the user repo
        User savedUser = userRepository.save(newUser);

        if (savedUser != null) {
            // save user address
            ArrayList<String> userAddressList = userDTO.getUserAddress();

            for (String address : userAddressList) {
                UserAddress userAddress = new UserAddress();
                userAddress.setUserId(savedUser.getUserId());
                userAddress.setUserAddress(address);

                userAddressRepository.save(userAddress);
            }

            return new ResponseObject(true, true);
        } else {
            return new ResponseObject("User not created", false);
        }
    }

    // returns boolean in data
    @Override
    public ResponseObject updateUser(UserDTO userDTO) {

        User existingUser = userRepository.findOne(userDTO.getUserId());

        // ensure user exists before
        if(existingUser == null)
            return new ResponseObject("user id not found", false);
        // ensure user exists and username matched
        if(!existingUser.getUserName().equals(userDTO.getUserName())) {
            return new ResponseObject("username do not match", false);
        }

        User updateUser = new User();
        BeanUtils.copyProperties(userDTO, updateUser);

        // save user into the user repo
        User savedUser = userRepository.save(updateUser);

        if (savedUser != null) {
            // save user address
            ArrayList<String> userAddressList = userDTO.getUserAddress();

            for (String address : userAddressList) {
                UserAddress userAddress = new UserAddress();
                userAddress.setUserId(savedUser.getUserId());
                userAddress.setUserAddress(address);

                userAddressRepository.save(userAddress);
            }

            return new ResponseObject(true, true);
        } else {
            return new ResponseObject("User update failed", false);
        }
    }

    // returns token for the user
    @Override
    public ResponseObject loginUser(String userName, String password) {

        // verify username and password
        User matchedUser = userRepository.findByUserName(userName);

        if (matchedUser != null) {
            if (userTokenRepository.findOne(matchedUser.getUserId()) == null) {

                // create token for new login
                if (matchedUser.getUserPassword().equals(password)) {

                    // generate token for the user
                    String token = HashGenerator.getSHA(Integer.toString(matchedUser.getUserId()) + salt);

                    //store token in db
                    UserToken newUserToken = new UserToken(matchedUser.getUserId(), token);
                    userTokenRepository.save(newUserToken);

                    // return response with token
                    return new ResponseObject(token, true);
                }
            } else {
                // return old token if already logged in
                UserToken savedUserToken = userTokenRepository.findOne(matchedUser.getUserId());
                return new ResponseObject(savedUserToken.getToken(), true);
            }
        }

        // username not found
        return new ResponseObject("username not found", false);
    }

    @Override
    public ResponseObject logoutUser(String token) {
        UserToken userToken = userTokenRepository.findByToken(token);

        if(userToken != null) {
            userTokenRepository.delete(userToken);

            return new ResponseObject("deleted. logout success.", true);
        } else {
                return new ResponseObject("token not found in database", false);
        }


    }

    /*@Override
    public boolean isTokenValid(String token) {
        UserToken userToken = userTokenRepository.findByToken(token);

        if(token != null) {
            return new ResponseObject(true, true);
        } else {
            return new ResponseObject(false, true);
        }
    }*/


    // Helper functions
    public boolean existsUserName(String userName) {
        return userRepository.findByUserName(userName) != null ? true : false;
    }
}
