package com.mycompany.propertymanagement.service;

import com.mycompany.propertymanagement.dto.User;
import com.mycompany.propertymanagement.exception.BusinessException;

public interface UserService {

    User register(User user);

    User login(String username, String password) throws BusinessException;
}
