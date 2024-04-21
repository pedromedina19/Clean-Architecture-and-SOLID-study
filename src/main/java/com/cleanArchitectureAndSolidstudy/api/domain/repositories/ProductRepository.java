package com.cleanArchitectureAndSolidstudy.api.domain.repositories;

import com.cleanArchitectureAndSolidstudy.api.domain.entities.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    Product save(Product product);
    List<Product> findAll();
    Optional<Product> findById(Long id);
    void deleteById(Long id);
    List<Product> findByName(String name);
    List<Product> findByPriceGreaterThan(Double price);
    List<Product> findByCategoryName(String nameCategory);
}
