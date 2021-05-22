//package com.akanksha.ecommerce.entity;
//
//import com.akanksha.ecommerce.entity.Product;
//import com.akanksha.ecommerce.repository.ProductRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.List;
//
//@Configuration
//public class ProductConfig {
//
//    @Bean
//    CommandLineRunner commandLineRunner(ProductRepository productRepository) {
//        return args -> {
//            Product shampoo = new Product(
//                    "wowshampoo",
//                    123,
//                    2
//            );
//
//            Product concealer = new Product(
//                    "lakmeConcealer",
//                    123,
//                    3
//            );
//
//            productRepository.saveAll(List.of(shampoo, concealer));
//
//        };
//    }
//}
