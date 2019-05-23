package com.ving.ecommerce.users.repository;

import com.ving.ecommerce.users.model.UserAddress;
import com.ving.ecommerce.users.model.UserAddressId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAddressRepository extends CrudRepository<UserAddress, UserAddressId> {
    List<UserAddress> findByUserId(int userId);
}
