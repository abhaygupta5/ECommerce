package com.ving.ecommerce.merchants.repository;

import com.ving.ecommerce.merchants.entity.MerchantRating;
import com.ving.ecommerce.merchants.entity.MerchantRatingId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MerchantRatingRepository extends CrudRepository<MerchantRating, MerchantRatingId> {
    @Query(value = "SELECT AVG(rating) from merchant_rating where merchant_id = ?1", nativeQuery = true)
    double getAverageMerchantRating(int merchantId);

   List<MerchantRating> findByMerchantId(int merchantId);
}
