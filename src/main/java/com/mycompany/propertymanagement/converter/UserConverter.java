package com.mycompany.propertymanagement.converter;

import com.mycompany.propertymanagement.dto.User;
import com.mycompany.propertymanagement.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public UserEntity convertToEntity(User user){
        UserEntity userEntity = new UserEntity();
        userEntity.setOwnerName(user.getOwnerName());
        userEntity.setEmail(user.getEmail());
        userEntity.setPassword(user.getPassword());
        userEntity.setPhno(user.getPhno());
        return userEntity;
    }

    public User convertToDTO(UserEntity userEntity){
        User user = new User();
        user.setOwnerName(userEntity.getOwnerName());
        user.setEmail(userEntity.getEmail());
        user.setPhno(userEntity.getPhno());
        user.setId(userEntity.getId());
        return user;
    }
}
