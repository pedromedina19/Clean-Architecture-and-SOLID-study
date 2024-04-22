package com.cleanArchitectureAndSolidstudy.api.infra.controllers;

import com.cleanArchitectureAndSolidstudy.api.application.useCases.ProductUseCases;
import com.cleanArchitectureAndSolidstudy.api.infra.dtos.ProductDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductUseCases productUseCases;

    public ProductController(ProductUseCases productUseCases){
        this.productUseCases = productUseCases;
    }

    
}
