package com.mycompany.propertymanagement.controller;

import com.mycompany.propertymanagement.dto.User;
import com.mycompany.propertymanagement.exception.BusinessException;
import com.mycompany.propertymanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user){
        User user1 = userService.register(user);
        return new ResponseEntity<>(user1, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        User user1 = userService.login(user.getEmail(), user.getPassword());
        return new ResponseEntity<>(user1, HttpStatus.OK);
    }
}
