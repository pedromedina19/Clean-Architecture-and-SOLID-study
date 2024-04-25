package com.cleanArchitectureAndSolidstudy.api.domain.entities;

import com.cleanArchitectureAndSolidstudy.api.infra.dtos.CategoryDto;
import com.cleanArchitectureAndSolidstudy.api.infra.dtos.ProductDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Product> products;

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome da categoria não pode estar vazio");
        }
        this.name = name;
    }


    //convert DTO into entity
    public Category(CategoryDto categoryDto){
        this.id = categoryDto.id();
        this.setName(categoryDto.name());
    }


}
