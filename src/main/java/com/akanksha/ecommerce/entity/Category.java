package com.akanksha.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

//have to add
@Getter
@Setter
@NoArgsConstructor
@Data
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

//    @OneToOne(mappedBy = "category")
//    private Product product;

    @OneToMany(mappedBy = "category")
    @JsonIgnore
    private Set<Product> products;
}


