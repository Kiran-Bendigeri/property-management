package com.mycompany.propertymanagement.service.impl;

import com.mycompany.propertymanagement.entity.UserAddressEntity;
import com.mycompany.propertymanagement.repository.UserAddressRepository;
import com.mycompany.propertymanagement.service.UserAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAddressServiceImpl implements UserAddressService {

    @Autowired
    private UserAddressRepository userAddressRepository;

    @Override
    public UserAddressEntity saveUserAddress(UserAddressEntity userAddressEntity) {
        return userAddressRepository.save(userAddressEntity);
    }
}
