package com.cleanArchitectureAndSolidstudy.api.infra.controllers;

import com.cleanArchitectureAndSolidstudy.api.application.useCases.CategoryUseCases;
import com.cleanArchitectureAndSolidstudy.api.infra.Exceptions.ResourceNotFoundException;
import com.cleanArchitectureAndSolidstudy.api.infra.dtos.CategoryDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryUseCases categoryUseCases;

    public CategoryController(CategoryUseCases categoryUseCases) {
        this.categoryUseCases = categoryUseCases;
    }

    @PostMapping
    public CategoryDto create(@RequestBody CategoryDto categoryDto) {
        return categoryUseCases.save(categoryDto);
    }

    @GetMapping
    public List<CategoryDto> findAll() {
        return categoryUseCases.findAll();
    }

    @GetMapping("/{id}")
    public CategoryDto findById(@PathVariable Long id) {
        CategoryDto category = categoryUseCases.findById(id);
        if (category == null) {
            throw new ResourceNotFoundException("Categoria não encontrada");
        }
        return category;
    }

    @PutMapping("/{id}")
    public CategoryDto update(@PathVariable Long id, @RequestBody CategoryDto categoryDto) {
        CategoryDto existingCategoryDto = categoryUseCases.findById(id);
        if (existingCategoryDto == null) {
            throw new ResourceNotFoundException("Categoria não encontrada");
        }
        existingCategoryDto = categoryDto;
        return categoryUseCases.save(existingCategoryDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        categoryUseCases.deleteById(id);
    }

    @GetMapping("/name/{name}")
    public List<CategoryDto> findByNome(@PathVariable String name) {
        return categoryUseCases.findByName(name);
    }
}
