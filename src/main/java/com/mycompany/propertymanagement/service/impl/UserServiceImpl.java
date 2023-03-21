package com.mycompany.propertymanagement.service.impl;

import com.mycompany.propertymanagement.converter.UserConverter;
import com.mycompany.propertymanagement.dto.User;
import com.mycompany.propertymanagement.entity.UserEntity;
import com.mycompany.propertymanagement.exception.BusinessException;
import com.mycompany.propertymanagement.exception.ErrorModel;
import com.mycompany.propertymanagement.repository.OwnerRepository;
import com.mycompany.propertymanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public User register(User user) {
        Optional<UserEntity> optionalUserEntity = ownerRepository.findByEmail(user.getEmail());
        if(optionalUserEntity.isPresent()){
            ErrorModel errorModel = new ErrorModel();
            errorModel.setErrorCode(HttpStatus.ALREADY_REPORTED.toString());
            errorModel.setMessage("User already exist with given Email-ID");
            throw new BusinessException(Arrays.asList(errorModel));
        }else {
            UserEntity userEntity = ownerRepository.save(userConverter.convertToEntity(user));
            return userConverter.convertToDTO(userEntity);
        }
    }

    @Override
    public User login(String username, String password) {
        User user = null;
        Optional<UserEntity> optionalUserEntity = ownerRepository.findByEmailAndPassword(username, password);
        if(optionalUserEntity.isPresent()){
            user = userConverter.convertToDTO(optionalUserEntity.get());
        }else{
            ErrorModel errorModel = new ErrorModel();
            errorModel.setErrorCode(HttpStatus.NOT_FOUND.toString());
            errorModel.setMessage("User doesn't exist");
            throw new BusinessException(Arrays.asList(errorModel));
        }
        return user;
    }
}
