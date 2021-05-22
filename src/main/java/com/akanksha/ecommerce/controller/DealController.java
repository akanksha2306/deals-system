package com.akanksha.ecommerce.controller;

import com.akanksha.ecommerce.dto.DealCreationDto;
import com.akanksha.ecommerce.entity.Deal;
import com.akanksha.ecommerce.service.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/deal")
public class DealController {

    @Autowired
    DealService dealService;

    public DealController(DealService dealService) {
        this.dealService = dealService;
    }

    @GetMapping(path = "active")
    public List<Deal> getAllActiveDeals() {
        return dealService.getAllActiveDeals();
    }

    @PostMapping
    public Deal addDeal(@RequestBody Deal deal) {
        return dealService.addDeal(deal);
    }

    @PostMapping(path = "generateRandom")
    public List<Deal> createRandomDeals(@RequestBody DealCreationDto dealCreationDto) {
        return dealService.createRandomDeals(dealCreationDto.getDealsCount(),
                dealCreationDto.getValidityInMinutes());
    }
}
