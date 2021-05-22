package com.akanksha.ecommerce.controller;

import com.akanksha.ecommerce.entity.Category;
import com.akanksha.ecommerce.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping(path = "{categroyId}")
    public Category getCategoriesById(@PathVariable("categroyId") Long categroyId) {
        return categoryService.getById(categroyId);
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @PostMapping
    public Category addCategory(@RequestBody Category category) {

        return categoryService.addCategory(category);
    }

    @PostMapping(path = "/bulk")
    public List<Category> addCategories(@RequestBody List<Category> categories) {

        List<Category> categoryList = new ArrayList<>();
        for (Category cat : categories) {

            Category category = addCategory(cat);
            categoryList.add(category);
        }
        return categoryList;
    }

    @PutMapping(path = "{categoryId}")
    public void updateCategory(@PathVariable("categoryId") Long categoryId,
                               @RequestBody Category category) {
        categoryService.updateCategory(categoryId, category);
    }

}
