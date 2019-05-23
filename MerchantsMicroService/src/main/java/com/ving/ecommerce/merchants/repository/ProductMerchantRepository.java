package com.ving.ecommerce.merchants.repository;

import com.ving.ecommerce.merchants.entity.MerchantProductId;
import com.ving.ecommerce.merchants.entity.ProductMerchant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductMerchantRepository extends CrudRepository<ProductMerchant,MerchantProductId> {
}
