package com.cleanArchitectureAndSolidstudy.api.infra.dtos;

public record ProductDto(Long id, String name, Double price, CategoryDto category) {
}
