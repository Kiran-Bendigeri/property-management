package com.mycompany.propertymanagement.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "OWNER_TABLE")
@Getter
@Setter
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "OWNER_ID")
    private Long id;

    @Column(name = "PROPERTY_OWNER", nullable = false)
    private String ownerName;

    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "PHONE", nullable = false)
    private long phno;

    @Column(name = "PASSWORD", nullable = false)
    private String password;
}
