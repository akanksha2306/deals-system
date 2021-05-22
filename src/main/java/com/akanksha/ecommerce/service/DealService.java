package com.akanksha.ecommerce.service;

import com.akanksha.ecommerce.entity.Deal;
import com.akanksha.ecommerce.entity.Product;
import com.akanksha.ecommerce.repository.DealRepository;
import com.akanksha.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DealService {

    @Autowired
    private final DealRepository dealRepository;

    @Autowired
    private final ProductRepository productRepository;

    public DealService(DealRepository dealRepository, ProductRepository productRepository) {
        this.dealRepository = dealRepository;
        this.productRepository = productRepository;
    }

    public List<Deal> getAllActiveDeals() {
        return dealRepository.findAllActiveDeals();
    }

    public Deal addDeal(Deal deal) {
        return dealRepository.save(deal);
    }

    public List<Deal> createRandomDeals(int count, Integer validityInMinutes) {

        // fetch random products
        List<Product> products = productRepository.pickItemsRandomly(count);
        //run a for loop to create deals from product, and save them to DB

        List<Deal> deals = new ArrayList<>();

        for (Product prd : products) {
            Deal deal = new Deal(prd, getRandomNumber(10, 20), validityInMinutes);
            dealRepository.save(deal);
            deals.add(deal);
        }
        return deals;
    }

    private Integer getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
