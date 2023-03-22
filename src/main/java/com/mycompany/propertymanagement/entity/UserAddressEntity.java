package com.mycompany.propertymanagement.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "USER_ADDRESS_TABLE")
@Getter
@Setter
@NoArgsConstructor
public class UserAddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "HOUSENO", nullable = false, precision = 3)
    private Long houseNo;

    @Column(name = "STREET", nullable = false)
    private String street;

    @Column(name = "CITY", nullable = false)
    private String city;

    @Column(name = "COUNTRY", nullable = false)
    private String country;

    @Column(name = "COUNTRY_CODE", nullable = false)
    private Long countryCode;


}
