package com.ving.ecommerce.merchants.repository;

import org.springframework.data.repository.CrudRepository;
import com.ving.ecommerce.merchants.entity.Merchant;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantRepository extends CrudRepository<Merchant,Integer> {

}
