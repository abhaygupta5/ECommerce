package com.ving.ecommerce.users.controller;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.ving.ecommerce.users.model.ResponseObject;
import com.ving.ecommerce.users.model.UserDTO;
import com.ving.ecommerce.users.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @GetMapping("/ping")
    public String hello() {
        return "UserMicorService: Pong";
    }

    @PostMapping(value = "/users", consumes = "application/json")
    public ResponseObject createUser(@RequestBody UserDTO userDTO) {
        return userService.createUser(userDTO);
    }

    @PutMapping(value = "/users", consumes = "application/json")
    public ResponseObject updateUser(@RequestBody UserDTO userDTO) {
        return userService.updateUser(userDTO);
    }

    @PostMapping(value = "/signup", consumes = "application/json")
    public ResponseObject signupUser(@RequestBody UserDTO userDTO) {
        return this.createUser(userDTO);
    }

    @PostMapping("/login")
    public ResponseObject loginUser(@RequestParam String username, @RequestParam String password) {
        return userService.loginUser(username, password);
    }

    @DeleteMapping("/logout")
    public ResponseObject logoutUser(@RequestParam String token) {
        return userService.logoutUser(token);
    }

    @GetMapping("/users/{token}")
    public ResponseObject getUserIdByToken(@PathVariable String token) {
        return userService.getUserIdByToken(token);
    }

    @GetMapping("/user")
    public ResponseObject getUserByToken(@RequestParam String token) {
        return userService.getUserByToken(token);
    }

    @GetMapping("/users")
    public ResponseObject getUserByUserId(@RequestParam Integer userId) {
        return userService.getUserByUserId(userId);
    }
}
