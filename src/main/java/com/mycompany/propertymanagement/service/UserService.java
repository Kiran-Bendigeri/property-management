package com.mycompany.propertymanagement.service;

import com.mycompany.propertymanagement.dto.User;

public interface UserService {

    User register(User user);

    User login(String username, String password);
}
