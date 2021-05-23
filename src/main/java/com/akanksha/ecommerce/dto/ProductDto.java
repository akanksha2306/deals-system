package com.akanksha.ecommerce.dto;

import com.akanksha.ecommerce.entity.Category;
import com.akanksha.ecommerce.entity.Deal;
import com.akanksha.ecommerce.entity.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@NoArgsConstructor
@Setter
@Getter
public class ProductDto {

    private long id;
    private String name;
    private Integer price;
    private Integer categoryId;
    private String productImage;
}
