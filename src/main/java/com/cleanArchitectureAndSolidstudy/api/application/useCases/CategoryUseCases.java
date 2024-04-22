package com.cleanArchitectureAndSolidstudy.api.application.useCases;

import com.cleanArchitectureAndSolidstudy.api.infra.dtos.CategoryDto;

import java.util.List;

public interface CategoryUseCases {
    CategoryDto save(CategoryDto categoryDto);
    List<CategoryDto> findAll();
    CategoryDto findById(Long id);
    void deleteById(Long id);
    List<CategoryDto> findByName(String name);
}
