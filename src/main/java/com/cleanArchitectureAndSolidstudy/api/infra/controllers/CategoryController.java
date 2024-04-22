package com.cleanArchitectureAndSolidstudy.api.infra.controllers;

import com.cleanArchitectureAndSolidstudy.api.application.useCases.CategoryUseCases;
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
        return categoryUseCases.findById(id);
    }

    @PutMapping("/{id}")
    public CategoryDto update(@PathVariable Long id, @RequestBody CategoryDto categoryDto) {
        CategoryDto existingCategoriaDto = categoryUseCases.findById(id);
        if (existingCategoriaDto != null) {
            existingCategoriaDto = categoryDto;
            return categoryUseCases.save(existingCategoriaDto);
        }
        return null;
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
