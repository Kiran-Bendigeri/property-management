package com.mycompany.propertymanagement.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    private Long id;

    @NotNull(message = "Owner email is mandatory")
    @NotEmpty(message = "email cannot be empty")
    private String ownerName;

    @NotNull(message = "Owner email is mandatory")
    @NotEmpty(message = "email cannot be empty")
    @Size(min = 8, max = 30, message = "email should be length between 8 character to 25 character")
    private String email;

    private Long phno;
    @NotNull(message = "Password cannot be null")
    @NotEmpty(message = "Password cannot be empty")
    private String password;

    @NotNull(message = "House number cannot be NULL")
    @NotEmpty(message = "House number cannot be EMPTY")
    @Size(min = 1)
    @JsonProperty(value = "house_no")
    private Long houseNo;

    private String street;

    private String city;

    private String country;

    @JsonProperty(value = "country_code")
    private Long countryCode;
}
