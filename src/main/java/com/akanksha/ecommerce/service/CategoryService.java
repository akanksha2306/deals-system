package com.akanksha.ecommerce.service;

import com.akanksha.ecommerce.entity.Category;
import com.akanksha.ecommerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getById(long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new
                IllegalStateException("category with Id" + id + " " + "does not exist"));
    }

    public Category addCategory(Category category) {
        return categoryRepository.save(category);

    }

    public void updateCategory(Long categoryId, Category category) {

        Category categoryTobeUpdated = categoryRepository.findById(categoryId).orElseThrow(() -> new
                IllegalStateException("category with Id" + categoryId + " " + "does not exist"));

        categoryRepository.save(category);
    }
}
