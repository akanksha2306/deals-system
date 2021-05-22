package com.akanksha.ecommerce.repository;

import com.akanksha.ecommerce.entity.Deal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DealRepository extends JpaRepository<Deal, Long> {

//    @Query("select a from deal a where a.deal_expire_time > :dealExpireTime")
//    List<Deal> findAllDealsWithExpireTimeBefore(
//            @Param("dealExpireTime") Date dealExpireTime);

    @Query(nativeQuery = true, value = "select * from deal where deal_expire_time > CURRENT_TIMESTAMP")
    List<Deal> findAllActiveDeals();
}
