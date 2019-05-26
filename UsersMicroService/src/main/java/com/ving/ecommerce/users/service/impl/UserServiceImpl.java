package com.ving.ecommerce.users.service.impl;

import com.ving.ecommerce.users.model.*;
import com.ving.ecommerce.users.repository.UserAddressRepository;
import com.ving.ecommerce.users.repository.UserRepository;
import com.ving.ecommerce.users.repository.UserTokenRepository;
import com.ving.ecommerce.users.service.UserService;
import com.ving.ecommerce.users.utilities.TokenGenerator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

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

        returnUser.setUserAddressList(addressList);
        returnUser.setUserPassword("");

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

        // perform validations
        ResponseObject responseObject = validateUser(userDTO);
        if(responseObject != null)
            return responseObject;

        User newUser = new User();
        BeanUtils.copyProperties(userDTO, newUser);

        // save user into the user repo
        User savedUser = userRepository.save(newUser);

        if (savedUser != null) {
            // save user address
            ArrayList<String> userAddressList = userDTO.getUserAddressList();

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
            ArrayList<String> userAddressList = userDTO.getUserAddressList();

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

        // HACKED
        // verify login both from username and useremail
        User matchedUser = userRepository.findByUserName(userName);
        if(matchedUser == null)
            matchedUser = userRepository.findByUserEmail(userName);

        // if a user matches in database
        if (matchedUser != null ) {

            // confirm password before returning token
            if(!matchedUser.getUserPassword().equals(password))
                return new ResponseObject("incorrect password", false);

            if (userTokenRepository.findOne(matchedUser.getUserId()) == null) {

                // create token for new login
                if (matchedUser.getUserPassword().equals(password)) {

                    // generate token for the user
                    TokenGenerator tokenGenerator = new TokenGenerator();
                    String token = tokenGenerator.getNewToken();

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

    @Override
    public ResponseObject getUserIdByToken(String token) {
        UserToken userToken = userTokenRepository.findByToken(token);

        if(userToken != null) {
            return new ResponseObject(userToken.getUserId(), true);
        } else {
            return new ResponseObject("token not found in database", false);
        }
    }

    @Override
    public ResponseObject getUserByToken(String token) {
        ResponseObject responseObject = getUserIdByToken(token);

        if(responseObject.getOk()) {
            return getUserByUserId((int)responseObject.getData());
        } else {
            return responseObject;
        }
    }

    @Override
    public ResponseObject isTokenValid(String token) {
        UserToken userToken = userTokenRepository.findByToken(token);

        if(token != null) {
            return new ResponseObject(true, true);
        } else {
            return new ResponseObject(false, true);
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    // HELPER FUNCTIONS
    ///////////////////////////////////////////////////////////////////////////
    public boolean existsUserName(String userName) {
        return userRepository.findByUserName(userName) != null ? true : false;
    }

    public boolean existsUserEmail(String userEmail) {
        return userRepository.findByUserEmail(userEmail) != null ? true : false;
    }

    public boolean existsUserPhone(long userPhone) {
        return userRepository.findByUserPhone(userPhone) != null ? true : false;
    }

    // TODO
    public ResponseObject validateUser(UserDTO userDTO) {

        // null checks
        if(userDTO.getUserName() == null)
            return new ResponseObject("userName is null.", false);
        if(userDTO.getUserDisplayName() == null)
            return new ResponseObject("userDisplayName is null", false);
        if(userDTO.getUserPassword() == null)
            return new ResponseObject("userPassword is null", false);
        if(userDTO.getUserAddressList() == null)
            return new ResponseObject("userAddressList is null", false);
        if(userDTO.getUserEmail() == null )
            return new ResponseObject("userEmail is null", false);
        if(userDTO.getUserPassword() == null)
            return new ResponseObject("userPassword is null", false);

        //if(userDTO.getUserPhone() == null)
        //    return new ResponseObject("User Password is null", false);

        // empty checks
        if(userDTO.getUserName().isEmpty())
            return new ResponseObject("userName cannot be empty.", false);
        if(userDTO.getUserDisplayName().isEmpty())
            return new ResponseObject("userDisplay Name cannot be empty", false);
        if(userDTO.getUserPassword().isEmpty())
            return new ResponseObject("userPassword cannot be empty", false);
        if(userDTO.getUserAddressList().isEmpty())
            return new ResponseObject("At least one address should be there", false);
        if(userDTO.getUserEmail().isEmpty())
            return new ResponseObject("userEmail cannot be empty", false);

        // special checks
        // email validity check
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";
        Pattern pat = Pattern.compile(emailRegex);
        if(!pat.matcher(userDTO.getUserEmail()).matches())
            return new ResponseObject("Not a valid email address.", false);

        // TODO
        // phone number validity check
        String phoneNoString = Double.toString(userDTO.getUserPhone());
        // 10 digit phone numbers stating with 7,8,9
        //String phoneTenDigitRegex = "^[0-9]{10}$";
        //Pattern phonePat = Pattern.compile(phoneTenDigitRegex);
        //if(!pat.matcher(phoneNoString).matches()) {
        //    return new ResponseObject("Phone number should have 10 digits.", false);
        //}

        // whitespace validations
        // check that username has no whitespace characters
        if(!userDTO.getUserName().matches("\\S+"))
            return new ResponseObject("User Name should not contain whitespace.", false);
        // check if password contains whitespace
        if(!userDTO.getUserPassword().matches("\\S+"))
            return new ResponseObject("User Password should not contain whitespace.", false);

        // collision validations
        // check for username collision
        if(existsUserName(userDTO.getUserName()))
            return new ResponseObject("Username already exists.", false);
        // check for userEmail collision
        if(existsUserEmail(userDTO.getUserEmail()))
            return new ResponseObject("User Email already exists.", false);
        // check for userPhone
        if(existsUserPhone(userDTO.getUserPhone()))
            return new ResponseObject("User Phone already exists.", false);


        return null;
    }
}
