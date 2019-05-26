package com.ving.ecommerce.merchants.repository;

import com.ving.ecommerce.merchants.entity.TopMerchants;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopMerchantsRepository extends CrudRepository<TopMerchants,Integer> {
}
