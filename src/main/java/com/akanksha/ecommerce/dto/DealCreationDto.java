package com.akanksha.ecommerce.dto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class DealCreationDto {

    Integer dealsCount;
    Integer validityInMinutes;
}
