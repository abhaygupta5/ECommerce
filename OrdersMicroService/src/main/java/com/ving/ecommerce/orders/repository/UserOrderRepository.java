package com.ving.ecommerce.orders.repository;

import com.ving.ecommerce.orders.entity.UserOrder;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserOrderRepository extends MongoRepository<UserOrder, String> {
}
