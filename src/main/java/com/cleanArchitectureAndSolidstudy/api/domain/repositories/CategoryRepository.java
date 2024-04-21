package com.cleanArchitectureAndSolidstudy.api.domain.repositories;

import com.cleanArchitectureAndSolidstudy.api.domain.entities.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {
    Category save(Category category);
    List<Category> findAll();
    Optional<Category> findById(Long id);
    void deleteById(Long id);
    List<Category> findByName(String name);
}
