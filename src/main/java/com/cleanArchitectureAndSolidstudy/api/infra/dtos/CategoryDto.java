package com.cleanArchitectureAndSolidstudy.api.infra.dtos;

import com.cleanArchitectureAndSolidstudy.api.domain.entities.Category;

public record CategoryDto(Long id, String name) {
    // Método que converte Category em CategoryDto
    public static CategoryDto fromCategory(Category category){
        return new CategoryDto(category.getId(), category.getName());
    }
}
