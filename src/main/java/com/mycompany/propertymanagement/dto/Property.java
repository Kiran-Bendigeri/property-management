package com.mycompany.propertymanagement.dto;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;

import org.springframework.stereotype.Component;


@Getter
@Setter
@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Property {

    private Long id;
    private String title;
    private String description;
    private double price;
    private String address;

    @JsonProperty(value = "owner_id")
    private Long userId;

    @Override
    public String toString(){
        return "[title="+this.title+" description="+this.description+" price="+this.price+" address="+this.address+"]";
    }
}
