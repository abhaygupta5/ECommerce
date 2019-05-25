package com.ving.ecommerce.orders.repository;

import com.ving.ecommerce.orders.entity.UserCart;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserCartRepository extends MongoRepository<UserCart, Integer> {
}
