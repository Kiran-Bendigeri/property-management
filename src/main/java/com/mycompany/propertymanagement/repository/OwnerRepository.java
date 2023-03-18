package com.mycompany.propertymanagement.repository;

import com.mycompany.propertymanagement.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<UserEntity, Long> {
}
