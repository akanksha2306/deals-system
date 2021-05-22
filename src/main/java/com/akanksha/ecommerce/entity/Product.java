package com.akanksha.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Data
@Table
public class Product {


    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_sequence"
    )
    private long id;

    private String name;
    private Integer price;

    @ManyToOne(optional = false, cascade = CascadeType.DETACH)
    @JoinColumn(name = "categoryId", referencedColumnName = "id", nullable = false)
    private Category category;

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private Set<Deal> deals;

    public Product(String name, Integer price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public Product(long id, String name, Integer price, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public Product() {
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category=" + category +
//                ", deal=" + deal +
                '}';
    }
}
