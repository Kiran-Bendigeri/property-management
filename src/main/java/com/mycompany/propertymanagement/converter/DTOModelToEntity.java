package com.mycompany.propertymanagement.converter;

import com.mycompany.propertymanagement.dto.Property;
import com.mycompany.propertymanagement.entity.PropertyEntity;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@NoArgsConstructor
public class DTOModelToEntity {

    public PropertyEntity convertToEntity(Property property){
        PropertyEntity propertyEntity = new PropertyEntity();
        propertyEntity.setTitle(property.getTitle());
        propertyEntity.setAddress(property.getAddress());
        propertyEntity.setDescription(property.getDescription());
        propertyEntity.setOwnerName(property.getOwnerName());
        propertyEntity.setEmail(property.getEmail());
        propertyEntity.setPrice(property.getPrice());
        return propertyEntity;
    }

    public Property convertToDTO(PropertyEntity propertyEntity){
        Property property = new Property();
        property.setId(propertyEntity.getId());
        property.setTitle(propertyEntity.getTitle());
        property.setAddress(propertyEntity.getAddress());
        property.setDescription(propertyEntity.getDescription());
        property.setOwnerName(propertyEntity.getOwnerName());
        property.setEmail(propertyEntity.getEmail());
        property.setPrice(propertyEntity.getPrice());
        return property;
    }

}
