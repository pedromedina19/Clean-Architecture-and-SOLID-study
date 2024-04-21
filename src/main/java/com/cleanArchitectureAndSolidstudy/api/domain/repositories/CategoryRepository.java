package com.cleanArchitectureAndSolidstudy.api.domain.repositories;

import com.cleanArchitectureAndSolidstudy.api.domain.entities.Category;

import java.util.List;

public interface CategoryRepository {
    Category save(Category category);
    List<Category> findAll();
    Category findById(Long id);
    void deleteById(Long id);
    List<Category> findByName(String name);
}
