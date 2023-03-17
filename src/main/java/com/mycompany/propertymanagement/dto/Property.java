package com.mycompany.propertymanagement.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class Property {

    private Long id;
    private String title;
    private String description;
    private String ownerName;
    private String email;
    private double price;
    private String address;

    @Override
    public String toString(){
        return "[title="+this.title+" description="+this.description+" ownerName="+this.ownerName+" price="+this.price+" address="+this.address+"]";
    }
}
