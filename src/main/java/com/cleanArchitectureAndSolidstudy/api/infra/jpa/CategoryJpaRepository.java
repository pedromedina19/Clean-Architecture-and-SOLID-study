package com.cleanArchitectureAndSolidstudy.api.infra.jpa;

import com.cleanArchitectureAndSolidstudy.api.domain.entities.Category;
import com.cleanArchitectureAndSolidstudy.api.domain.repositories.CategoryRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryJpaRepository extends JpaRepository<Category, Long>, CategoryRepository {
    List<Category> findByName(String name);
}
