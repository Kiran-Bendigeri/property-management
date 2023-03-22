package com.mycompany.propertymanagement.service;

import com.mycompany.propertymanagement.dto.Property;
import com.mycompany.propertymanagement.entity.PropertyEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface PropertyService {

    public Property saveProperty(Property property);

    public List<Property> getAllProperty();

    public List<Property> getAllUserProperty(Long userId);

    Property updateProperty(Property property, Long propertyId);

    Property findById(Long id);

    Property updateDescription(Property property, Long id);

    Property updatePrice(Property property, Long id);

    Boolean deleteProperty(Long id);
}
