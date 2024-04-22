package com.cleanArchitectureAndSolidstudy.api.application.useCases;

import com.cleanArchitectureAndSolidstudy.api.domain.entities.Product;
import com.cleanArchitectureAndSolidstudy.api.domain.repositories.ProductRepository;
import com.cleanArchitectureAndSolidstudy.api.infra.dtos.ProductDto;

import java.util.List;

public interface ProductUseCases {
//    Podemos perceber que temos métodos parecidos com os do ProductRepository e isso é bem comum, segue a explicação:
//    Na Arquitetura Limpa, é comum que as interfaces de Caso de Uso (UseCase) e Repositório (Repository) tenham métodos
//    semelhantes, pois ambas representam operações que podem ser realizadas no domínio. No entanto, elas têm
//    responsabilidades diferentes:
//
//    A interface do Repositório define operações de persistência de dados, como salvar, encontrar ou deletar entidades
//    do domínio. Essas operações são geralmente mapeadas diretamente para operações do banco de dados.
//      - A interface do Caso de Uso define operações que representam ações que um usuário pode realizar no sistema.
//      - Cada caso de uso corresponde a um requisito de negócio específico.
//    Embora os métodos possam parecer semelhantes, a semântica por trás deles pode ser diferente. Por exemplo, o método
//    save em um repositório pode simplesmente persistir uma entidade no banco de dados, enquanto o método save em um caso
//    de uso pode incluir lógica de negócios adicional, como validação, aplicação de regras de negócios, disparo de
//    eventos, etc.
//
//    Ter interfaces separadas para casos de uso e repositórios permite que você siga o Princípio de
//    Segregação de Interface (ISP) e o Princípio de Inversão de Dependência (DIP) do SOLID. Isso torna seu código mais
//    modular e fácil de testar e manter.
    ProductDto save(ProductDto productDto);
    List<ProductDto> findAll();
    ProductDto findById(Long id);
    void deleteById(Long id);
    List<ProductDto> findByName(String name);
    List<ProductDto> findByPriceGreaterThan(Double price);
    List<ProductDto> findByCategoryName(String nameCategory);
}
