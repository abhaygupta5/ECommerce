package com.ving.ecommerce.users.repository;

import com.ving.ecommerce.users.model.UserToken;
import org.springframework.data.repository.CrudRepository;

public interface UserTokenRepository extends CrudRepository<UserToken, Integer> {

    UserToken findByToken(String token);
}
