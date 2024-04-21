package com.cleanArchitectureAndSolidstudy.api.infra.jpa;

import com.cleanArchitectureAndSolidstudy.api.domain.entities.Product;
import com.cleanArchitectureAndSolidstudy.api.domain.repositories.ProductRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductJpaRepository extends JpaRepository<Product, Long>, ProductRepository{
    List<Product> findByName(String name);
    List<Product> findByPriceGreaterThan(Double price);
    List<Product> findByCategoryName(String nameCategory);
}
