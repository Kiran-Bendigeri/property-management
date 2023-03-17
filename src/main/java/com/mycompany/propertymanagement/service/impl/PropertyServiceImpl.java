package com.mycompany.propertymanagement.service.impl;

import com.mycompany.propertymanagement.converter.DTOModelToEntity;
import com.mycompany.propertymanagement.dto.Property;
import com.mycompany.propertymanagement.entity.PropertyEntity;
import com.mycompany.propertymanagement.repository.PropertyRepository;
import com.mycompany.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.tools.OptionChecker;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    // for conversion of data from Entity to DTO or vice-versa
    @Autowired
    private DTOModelToEntity dtoModelToEntity;

    @Override
    public Property saveProperty(Property property) {
        PropertyEntity propertyEntity = dtoModelToEntity.convertToEntity(property);
        propertyEntity = propertyRepository.save(propertyEntity);
        return dtoModelToEntity.convertToDTO(propertyEntity);
    }

    @Override
    public List<Property> getAllProperty() {
        List<PropertyEntity> properties = (List<PropertyEntity>) propertyRepository.findAll();
        List<Property> allProperty = new ArrayList<>();

        for (PropertyEntity property: properties) {
            Property p = dtoModelToEntity.convertToDTO(property);
            allProperty.add(p);
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
            propertyEntity.setEmail(property.getEmail());
            propertyEntity.setPrice(property.getPrice());
            propertyEntity.setAddress(property.getAddress());
            propertyEntity.setDescription(property.getDescription());
            propertyEntity.setOwnerName(property.getOwnerName());
            proprtyUpdated = dtoModelToEntity.convertToDTO(propertyEntity);
            propertyRepository.save(propertyEntity);
            return proprtyUpdated;
        }else{
            return proprtyUpdated;
        }
    }

    @Override
    public Property findById(Long id) {
        Optional<PropertyEntity> optEntity = propertyRepository.findById(id);
        return dtoModelToEntity.convertToDTO(optEntity.get());
    }

    @Override
    public Property updateDescription(Property property, Long id) {
        Optional<PropertyEntity> optEntity = propertyRepository.findById(id);
        if(optEntity.isPresent()){
            PropertyEntity propertyEntity = optEntity.get();
            propertyEntity.setDescription(property.getDescription());
            propertyRepository.save(propertyEntity);
            return dtoModelToEntity.convertToDTO(propertyEntity);
        }else return null;
    }

    @Override
    public Property updatePrice(Property property, Long id) {
        Optional<PropertyEntity> optEntity = propertyRepository.findById(id);
        if(optEntity.isPresent()){
            PropertyEntity propertyEntity = optEntity.get();
            propertyEntity.setPrice(property.getPrice());
            propertyRepository.save(propertyEntity);
            return dtoModelToEntity.convertToDTO(propertyEntity);
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
