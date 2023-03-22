package com.mycompany.propertymanagement.repository;

import com.mycompany.propertymanagement.entity.UserAddressEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserAddressRepository extends CrudRepository<UserAddressEntity, Long> {

}
