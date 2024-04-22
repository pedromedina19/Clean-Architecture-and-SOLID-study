package com.cleanArchitectureAndSolidstudy.api.infra.controllers;

import com.cleanArchitectureAndSolidstudy.api.application.useCases.ProductUseCases;
import com.cleanArchitectureAndSolidstudy.api.infra.dtos.ProductDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductUseCases productUseCases;

    public ProductController(ProductUseCases productUseCases){
        this.productUseCases = productUseCases;
    }

    @PostMapping
    public ProductDto create(@RequestBody ProductDto productDto){
        return productUseCases.save(productDto);
    }

    @GetMapping
    public List<ProductDto> findAll() {
        return productUseCases.findAll();
    }

    @GetMapping("/{id}")
    public ProductDto findById(@PathVariable Long id) {
        return productUseCases.findById(id);
    }

    @PutMapping("/{id}")
    public ProductDto update(@PathVariable Long id, @RequestBody ProductDto produtoDto) {
        ProductDto existingProdutoDto = productUseCases.findById(id);
        if (existingProdutoDto != null) {
            existingProdutoDto = produtoDto;
            return productUseCases.save(existingProdutoDto);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productUseCases.deleteById(id);
    }

    @GetMapping("/name/{name}")
    public List<ProductDto> findByNome(@PathVariable String name) {
        return productUseCases.findByName(name);
    }

    @GetMapping("/price/{price}")
    public List<ProductDto> findByPrecoGreaterThan(@PathVariable Double price) {
        return productUseCases.findByPriceGreaterThan(price);
    }

    @GetMapping("/category/{name}")
    public List<ProductDto> findByCategoryName(@PathVariable String name) {
        return productUseCases.findByCategoryName(name);
    }
}
