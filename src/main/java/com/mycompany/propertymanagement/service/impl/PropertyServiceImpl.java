package com.mycompany.propertymanagement.service.impl;

import com.mycompany.propertymanagement.converter.PropertyConverter;
import com.mycompany.propertymanagement.dto.Property;
import com.mycompany.propertymanagement.entity.PropertyEntity;
import com.mycompany.propertymanagement.entity.UserEntity;
import com.mycompany.propertymanagement.exception.BusinessException;
import com.mycompany.propertymanagement.exception.ErrorModel;
import com.mycompany.propertymanagement.repository.OwnerRepository;
import com.mycompany.propertymanagement.repository.PropertyRepository;
import com.mycompany.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    // for conversion of data from Entity to DTO or vice-versa
    @Autowired
    private PropertyConverter propertyConverter;

    @Autowired
    private OwnerRepository ownerRepository;

    @Override
    public Property saveProperty(Property property) {

        Optional<UserEntity> optionalUserEntity = ownerRepository.findById(property.getUserId());

        if(optionalUserEntity.isPresent()){
            PropertyEntity propertyEntity = propertyConverter.convertToEntity(property);
            propertyEntity.setUserEntity(optionalUserEntity.get());
            propertyEntity = propertyRepository.save(propertyEntity);
            return propertyConverter.convertToDTO(propertyEntity);
        }else{
            ErrorModel errorModel = new ErrorModel();
            errorModel.setErrorCode(HttpStatus.NOT_FOUND.toString());
            errorModel.setMessage("User doesn't exist");
            throw new BusinessException(Arrays.asList(errorModel));
        }

    }

    @Override
    public List<Property> getAllProperty() {
        List<PropertyEntity> properties = (List<PropertyEntity>) propertyRepository.findAll();
        List<Property> allProperty = new ArrayList<>();

        for (PropertyEntity property: properties) {
            Property p = propertyConverter.convertToDTO(property);
            allProperty.add(p);
        }
        return allProperty;
    }

    @Override
    public List<Property> getAllUserProperty(Long userId) {
        List<PropertyEntity> properties = propertyRepository.findByUserEntityId(userId);
        List<Property> allProperty = new ArrayList<>();
        if(!properties.isEmpty()){
            for (PropertyEntity property: properties) {
                Property p = propertyConverter.convertToDTO(property);
                allProperty.add(p);
            }
        }else {
            ErrorModel errorModel = new ErrorModel();
            errorModel.setErrorCode(HttpStatus.NOT_FOUND.toString());
            errorModel.setMessage("User doesn't exist");
            throw new BusinessException(Arrays.asList(errorModel));
        }

        return allProperty;
    }


    @Override
    public Property updateProperty(Property property, Long propertyId) {
        Optional<PropertyEntity> optEntity = propertyRepository.findById(propertyId);

        Property proprtyUpdated = null;

        if(optEntity.isPresent()){
            PropertyEntity propertyEntity = optEntity.get();
            propertyEntity.setTitle(property.getTitle());
            propertyEntity.setPrice(property.getPrice());
            propertyEntity.setAddress(property.getAddress());
            propertyEntity.setDescription(property.getDescription());
            proprtyUpdated = propertyConverter.convertToDTO(propertyEntity);
            propertyRepository.save(propertyEntity);
            return proprtyUpdated;
        }else{
            return proprtyUpdated;
        }
    }

    @Override
    public Property findById(Long id) {
        Optional<PropertyEntity> optEntity = propertyRepository.findById(id);
        return propertyConverter.convertToDTO(optEntity.get());
    }

    @Override
    public Property updateDescription(Property property, Long id) {
        Optional<PropertyEntity> optEntity = propertyRepository.findById(id);
        if(optEntity.isPresent()){
            PropertyEntity propertyEntity = optEntity.get();
            propertyEntity.setDescription(property.getDescription());
            propertyRepository.save(propertyEntity);
            return propertyConverter.convertToDTO(propertyEntity);
        }else return null;
    }

    @Override
    public Property updatePrice(Property property, Long id) {
        Optional<PropertyEntity> optEntity = propertyRepository.findById(id);
        if(optEntity.isPresent()){
            PropertyEntity propertyEntity = optEntity.get();
            propertyEntity.setPrice(property.getPrice());
            propertyRepository.save(propertyEntity);
            return propertyConverter.convertToDTO(propertyEntity);
        }else return null;
    }

    @Override
    public Boolean deleteProperty(Long id) {
        Optional<PropertyEntity> optEntity = propertyRepository.findById(id);

        if(optEntity.isPresent()){
            propertyRepository.delete(optEntity.get());
            return true;
        } else return false;
    }


}
