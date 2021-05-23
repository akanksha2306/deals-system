package com.akanksha.ecommerce.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Calendar;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Data
@Entity
@Table(name = "deal")
public class Deal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Temporal(TemporalType.TIMESTAMP)
    Date dealStartTime;

    @Temporal(TemporalType.TIMESTAMP)
    Date dealExpireTime;
//    private String dealName;

    @ManyToOne(optional = false, cascade = CascadeType.DETACH)
    @JoinColumn(name = "productId", referencedColumnName = "id", nullable = false)
    private Product product;

    private Integer discount;

    private Float dealPrice;

    public Deal(Product product, Integer discount, Integer dealValidityMinute) {
//        this.dealStartTime = LocalDateTime.now();
        this.dealStartTime = java.util.Calendar.getInstance().getTime();
        this.dealExpireTime = addMinutes(dealStartTime, dealValidityMinute);
        this.product = product;
        this.discount = discount;
        this.dealPrice = this.product.getPrice() * (1 - ((float)discount / 100));
    }

    private Date addMinutes(Date startTime, int minutes) {

        Calendar c = Calendar.getInstance();
        c.setTime(startTime);

        c.add(Calendar.MINUTE, minutes);
        return c.getTime();
    }
}
