package com.cleanArchitectureAndSolidstudy.api.infra.dtos;

import com.cleanArchitectureAndSolidstudy.api.domain.entities.Product;

public record ProductDto(Long id, String name, Double price, CategoryDto category) {
    // Método que converte um Product em ProductDto
    public static ProductDto fromProduct(Product product){
        CategoryDto categoryDto = CategoryDto.fromCategory(product.getCategory());
        return new ProductDto(product.getId(), product.getName(), product.getPrice(), categoryDto);
    }
}
