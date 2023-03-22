package com.mycompany.propertymanagement.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "PROPERTY_TABLE")
@Getter
@Setter
@NoArgsConstructor
public class PropertyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PROPERTY_ID")
    private Long id;

    @Column(name = "PROPERTY_TITLE", nullable = false)
    private String title;

    @Column(name = "PROPERTY_DESCRIPTION")
    private String description;

    @Column(name = "PROPERTY_VALUE", nullable = false)
    private Double price;

    @Column(name = "PROPERTY_ADDRESS")
    private String address;

    // It will not fetch user details while fetching property details
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "OWNER_ID", nullable = false)
    private UserEntity userEntity;

}
