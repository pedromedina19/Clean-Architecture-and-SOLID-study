package com.cleanArchitectureAndSolidstudy.api.domain.entities;

import com.cleanArchitectureAndSolidstudy.api.infra.dtos.ProductDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Double price;

    @ManyToOne
    private Category category;

    public void setPrice(Double price) {
        if (price < 0) {
            throw new IllegalArgumentException("O preço do produto não pode ser negativo");
        }
        this.price = price;
    }

    public void setCategory(Category category) {
        if (category == null) {
            throw new IllegalArgumentException("O produto deve ter uma categoria");
        }
        this.category = category;
    }



    // Convert dto into entity
    public Product(ProductDto productDto){
        this.id = productDto.id();
        this.name = productDto.name();
        this.setPrice(productDto.price());
        this.setCategory(new Category(productDto.category()));
    }
}
