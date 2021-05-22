package com.akanksha.ecommerce.repository;

import com.akanksha.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(nativeQuery = true, value = "select * from product order by random() limit :limitVal")
    List<Product> pickItemsRandomly(@Param("limitVal") int limitVal);
}
