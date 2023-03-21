package com.mycompany.propertymanagement.repository;

import com.mycompany.propertymanagement.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface OwnerRepository extends CrudRepository<UserEntity, Long> {

    // for reference
//    @Query("SELECT userEntity FROM UserEntity userEntity WHERE userEntity.email = :email and userEntity.password = :password")
//    Optional<UserEntity> findByEmailAndPassword(@Param("email") String email , @Param("password") String password);

    // here we are taking help of JPA so that we dont have to write query
    Optional<UserEntity> findByEmailAndPassword(String email , String password);

    Optional<UserEntity> findByEmail(String email);
}
