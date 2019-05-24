package com.ving.ecommerce.merchants.repository;

import com.ving.ecommerce.merchants.entity.MerchantProductId;
import com.ving.ecommerce.merchants.entity.ProductMerchant;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductMerchantRepository extends CrudRepository<ProductMerchant,MerchantProductId> {
    // number of products merchant need to sell
    Long countByMerchantId(int merchantId);

    @Query(value = "SELECT * FROM product_merchant WHERE product_id = ? AND stock > 0", nativeQuery = true)
    List<ProductMerchant> findByProductIdWithCondition(int productId);

    // current stock of product
    @Query(value = "SELECT stock FROM product_merchant WHERE merchant_id = ? AND product_id = ?", nativeQuery = true)
    int getStockFromId(int merchantId, int productId);

    // price of product
    @Query(value = "SELECT product_price FROM product_merchant WHERE merchant_id = ? AND product_id = ?", nativeQuery = true)
    int getPriceFromId(int merchantId, int productId);

    // get all products a merchant is selling
    @Query(value = "SELECT merchant_id FROM product_merchant WHERE product_id = ?", nativeQuery = true)
    List<Integer> getAllMerchantsByProduct(int productId);

    // get all product ids
    @Query(value = "SELECT DISTINCT(product_id) FROM product_merchant", nativeQuery = true)
    List<Integer> getAllProductIds();

}
