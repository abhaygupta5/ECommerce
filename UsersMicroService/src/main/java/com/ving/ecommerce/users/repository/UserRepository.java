package com.ving.ecommerce.users.repository;

import com.ving.ecommerce.users.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUserName(String userName);
}
