package com.ving.ecommerce.users.service;

import com.ving.ecommerce.users.model.ResponseObject;
import com.ving.ecommerce.users.model.UserDTO;

public interface UserService {

    /**
     * Get's details of a single user from the database
     * returns userDTO for the token
    public ResponseObject getUser(String token);*/

    /**
     * Creates a user in the database
     * returns boolean indicating success
     */
    ResponseObject createUser(UserDTO userDTO);

    /**
     * Updates the details of a user in the database
     * return boolean indicating success
     */
    ResponseObject updateUser(UserDTO userDTO);

    /**
     * Returns token for user after authenticating
     */
    ResponseObject loginUser(String userName, String password);

    /**
     * Deletes user and token for the given token
     */
    ResponseObject logoutUser(String token);

    /**
     * Returns boolean in data field, whether the given token is valid
     */
    ResponseObject isTokenValid(String token);


    /**
     * Return the userId in tha data field of the response object
     */
    ResponseObject getUserIdByToken(String token);

    /**
     * Return the userDTO in tha data field of the response object
     */
    ResponseObject getUserByToken(String token);
}
