package com.cleanArchitectureAndSolidstudy.api.application.useCasesImpl;

import com.cleanArchitectureAndSolidstudy.api.domain.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryUseCasesImpl {
    private final CategoryRepository categoryRepository;

    public CategoryUseCasesImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    
}
