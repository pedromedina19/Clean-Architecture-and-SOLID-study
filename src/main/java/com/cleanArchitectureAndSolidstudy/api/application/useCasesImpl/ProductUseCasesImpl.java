package com.cleanArchitectureAndSolidstudy.api.application.useCasesImpl;

import com.cleanArchitectureAndSolidstudy.api.application.useCases.ProductUseCases;
import com.cleanArchitectureAndSolidstudy.api.domain.entities.Product;
import com.cleanArchitectureAndSolidstudy.api.domain.repositories.ProductRepository;
import com.cleanArchitectureAndSolidstudy.api.infra.dtos.ProductDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductUseCasesImpl implements ProductUseCases {
    private final ProductRepository productRepository;

    public ProductUseCasesImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public ProductDto save(ProductDto productDto){
        Product product = new Product(productDto);
        Product savedProduct = productRepository.save(product);
        return ProductDto.fromProduct(savedProduct);
    }

    
}
