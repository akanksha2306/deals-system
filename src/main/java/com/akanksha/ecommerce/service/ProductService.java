package com.akanksha.ecommerce.service;

import com.akanksha.ecommerce.entity.Product;
import com.akanksha.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private final ProductRepository productRepo;

    public ProductService(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }

//    @Autowired
//    private final CategoryRepository cateRepo;

//    public ProductService(ProductRepository productRepo, CategoryRepository cateRepo) {
//        this.productRepo = productRepo;
//        this.cateRepo = cateRepo;
//    }

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Product addProduct(Product product) {
        return productRepo.save(product);
    }

    public Product getById(long id) {
        return productRepo.findById(id).orElseThrow(() -> new
                IllegalStateException("product with Id" + id + " " + "does not exist"));
    }

    public void updateProduct(Long productId, Product prd) {

        Product product = productRepo.findById(productId).orElseThrow(() -> new
                IllegalStateException("product with Id" + productId + " " + "does not exist"));

        product.setName(prd.getName());
        product.setPrice(prd.getPrice());
        product.setCategory(prd.getCategory());
        product.setProductImage(prd.getProductImage());

        productRepo.save(product);

    }

    public List<Product> pickProductsRandomly(int limit) {
        return productRepo.pickItemsRandomly(limit);
    }

}
