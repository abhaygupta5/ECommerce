package com.ving.ecommerce.merchants.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.ving.ecommerce.merchants.entity.Merchant;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MerchantRepository extends CrudRepository<Merchant,Integer> {
    // all merchant lists
    @Query(value = "SELECT merchant_id from merchant", nativeQuery = true)
    List<Integer> getAllMechantList();

}
