package com.mycompany.propertymanagement.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class Calculator {



    private Double num1;
    private Double num2;
    
    @JsonProperty("num123")
    private Double num3;


}
