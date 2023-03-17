package com.mycompany.propertymanagement.controller;


import com.mycompany.propertymanagement.dto.Property;
import com.mycompany.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/property")
public class Controller {

    @Value("${pms.somejunktext:}")
    private String localDummy;

    //colon at the end used to manage error if the mentioned property not available in the "properties" file
    @Value("${spring.datasource.url:}")
    private String localURL;

    @Autowired
    private PropertyService propertyService;

    @PostMapping("/properties")
    public ResponseEntity<Property> saveProperty(@RequestBody Property property){
        Property propertyFromDB = propertyService.saveProperty(property);
        ResponseEntity<Property> responseEntity = new ResponseEntity<>(propertyFromDB, HttpStatus.CREATED);
        return responseEntity;
    }

    @GetMapping("/properties")
    public ResponseEntity<List<Property>> getAllProperty(){
        System.out.println(localDummy);
        System.out.println("This is URL for local environment"+localURL);
        return new ResponseEntity<List<Property>>(propertyService.getAllProperty(), HttpStatus.FOUND);
    }

    @PutMapping("/properties?{property_id}")
    public ResponseEntity<Property> updateProperty(@RequestBody Property property, @Param("property_id") Long id){
        Property prty = propertyService.updateProperty(property, id);
        ResponseEntity<Property> responseEntity = null;
        if(prty != null){
            responseEntity = new ResponseEntity<>(prty, HttpStatus.valueOf("Updated"));
            return responseEntity;
        }else {
            responseEntity = new ResponseEntity<>(prty, HttpStatus.NOT_FOUND);
            return responseEntity;
        }
    }

    @GetMapping("/properties/{id}")
    public Property getById(@PathVariable Long id){
        return propertyService.findById(id);
    }

    @PatchMapping("/properties/update-description/{id}")
    public ResponseEntity<Property> updateDescription(@RequestBody Property property, @PathVariable Long id){
        Property property1 = propertyService.updateDescription(property, id);
        return new ResponseEntity<Property>(property1, HttpStatus.OK);
    }

    @PatchMapping("/properties/update-price/{id}")
    public ResponseEntity<Property> updatePrice(@RequestBody Property property, @PathVariable Long id){
        Property property1 = propertyService.updatePrice(property, id);
        return new ResponseEntity<Property>(property1, HttpStatus.OK);
    }

    @DeleteMapping("/properties/delete/{id}")
    public ResponseEntity<String> deleteProperty(@PathVariable Long id){
        ResponseEntity<String> responseEntity = null;
        Boolean bool = propertyService.deleteProperty(id);

        if(bool)
            return new ResponseEntity<>("Property deleted Successfully", HttpStatus.FOUND);
        else
            return new ResponseEntity<>("Property not found with given id", HttpStatus.NOT_FOUND);
    }



}
