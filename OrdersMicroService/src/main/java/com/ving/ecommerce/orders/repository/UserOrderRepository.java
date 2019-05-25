package com.ving.ecommerce.orders.repository;

import com.ving.ecommerce.orders.entity.UserOrder;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserOrderRepository extends MongoRepository<UserOrder, String> {

    List<UserOrder> findBymerchantId(int merchantId);
    List<UserOrder> findByuserId(int userId);
    List<UserOrder> findByUserIdAndProductId(int userId, int productId);
    List<UserOrder> findByUserIdAndMerchantId(int userId, int merchantId);
}
