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

    // Convert dto into entity
    public Product(ProductDto productDto){
        this.id = productDto.id();
        this.name = productDto.name();
        this.price = productDto.price();
        this.category = new Category(productDto.category());
    }
}
