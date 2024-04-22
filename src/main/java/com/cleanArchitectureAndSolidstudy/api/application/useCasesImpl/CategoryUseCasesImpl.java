package com.cleanArchitectureAndSolidstudy.api.application.useCasesImpl;

import com.cleanArchitectureAndSolidstudy.api.application.useCases.CategoryUseCases;
import com.cleanArchitectureAndSolidstudy.api.domain.entities.Category;
import com.cleanArchitectureAndSolidstudy.api.domain.repositories.CategoryRepository;
import com.cleanArchitectureAndSolidstudy.api.infra.dtos.CategoryDto;
import org.springframework.stereotype.Service;

@Service
public class CategoryUseCasesImpl implements CategoryUseCases {
    private final CategoryRepository categoryRepository;

    public CategoryUseCasesImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryDto save(CategoryDto categoryDto){
        Category category = new Category(categoryDto);
        Category savedCategory = categoryRepository.save(category);
        return CategoryDto.fromCategory(savedCategory);
    }

    
}
