package com.mycompany.propertymanagement.service.impl;

import com.mycompany.propertymanagement.converter.UserConverter;
import com.mycompany.propertymanagement.dto.User;
import com.mycompany.propertymanagement.entity.UserEntity;
import com.mycompany.propertymanagement.repository.OwnerRepository;
import com.mycompany.propertymanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public User register(User user) {
        UserEntity userEntity = ownerRepository.save(userConverter.convertToEntity(user));
        return userConverter.convertToDTO(userEntity);
    }

    @Override
    public User login(String username, String password) {
        return null;
    }
}
