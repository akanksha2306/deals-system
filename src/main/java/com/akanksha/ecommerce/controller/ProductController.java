package com.akanksha.ecommerce.controller;

import com.akanksha.ecommerce.dto.ProductDto;
import com.akanksha.ecommerce.entity.Category;
import com.akanksha.ecommerce.entity.Product;
import com.akanksha.ecommerce.service.CategoryService;
import com.akanksha.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;

    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping(path = "random/{limit}")
    public List<Product> pickProductsRandomly(@PathVariable("limit") Integer limit) {
        return productService.pickProductsRandomly(limit);
    }

    @GetMapping(path = "{productId}")
    public Product getProductById(@PathVariable("productId") Long productId) {
        return productService.getById(productId);
    }

    @PostMapping
    public Product addProduct(@RequestBody ProductDto productDto) {

        Category category = categoryService.getById(productDto.getCategoryId());
        Product product = new Product(productDto.getName(), productDto.getPrice(), category);

        return productService.addProduct(product);
    }

    @PostMapping(path = "/bulk")
    public List<Product> addProducts(@RequestBody List<ProductDto> productDtos) {

        List<Product> ListOfProducts = new ArrayList<>();
        for (ProductDto prDto : productDtos) {

            Product product = addProduct(prDto);
            ListOfProducts.add(product);
        }
        return ListOfProducts;
    }


    @PutMapping(path = "{productId}")
    public void updateProduct(@PathVariable("productId") Long productId,
                              @RequestBody Product product) {
        productService.updateProduct(productId, product);
    }

}
