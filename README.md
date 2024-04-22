# Clean-Architecture-and-SOLID-study
 
# Documentação da API

## Rotas

### Categoria

- **POST /categories**: Cria uma nova categoria.
- **GET /categories**: Retorna todas as categorias.
- **GET /categories/{id}**: Retorna a categoria com o ID especificado.
- **PUT /categories/{id}**: Atualiza a categoria com o ID especificado.
- **DELETE /categories/{id}**: Deleta a categoria com o ID especificado.
- **GET /categories/name/{name}**: Retorna todas as categorias com o nome especificado.

### Produto

- **POST /products**: Cria um novo produto.
- **GET /products**: Retorna todos os produtos.
- **GET /products/{id}**: Retorna o produto com o ID especificado.
- **PUT /products/{id}**: Atualiza o produto com o ID especificado.
- **DELETE /products/{id}**: Deleta o produto com o ID especificado.
- **GET /products/name/{name}**: Retorna todos os produtos com o nome especificado.
- **GET /products/price/{price}**: Retorna todos os produtos com preço maior que o especificado.
- **GET /products/category/{name}**: Retorna todos os produtos da categoria com o nome especificado.

## Arquitetura Limpa

A Arquitetura Limpa, ou Clean Architecture, é um conjunto de práticas de design que priorizam a separação de responsabilidades e a criação de sistemas independentes de frameworks, interfaces de usuário e bancos de dados. 

Neste projeto, a Arquitetura Limpa é implementada da seguinte maneira:

- **Domínio**: Contém as entidades (`Produto` e `Categoria`) e as interfaces de repositório (`ProdutoRepository` e `CategoriaRepository`). Esta camada não tem dependências externas e contém a lógica de negócios central.
- **Aplicação**: Contém os casos de uso (`ProdutoUseCase` e `CategoriaUseCase`) que coordenam as operações de alto nível que o aplicativo pode realizar (Perceba que os casos de uso poderiam ser divididos, mas para um projeto simples como esse, isso seria uma otimização prematura).
- **Infraestrutura**: Contém as implementações de repositório (`ProdutoJpaRepository` e `CategoriaJpaRepository`) que interagem com o banco de dados, e os controladores (`ProdutoController` e `CategoriaController`) que lidam com as solicitações HTTP.

## Princípios SOLID

Os princípios SOLID são um conjunto de princípios de design orientado a objetos que ajudam a criar sistemas mais compreensíveis, flexíveis e sustentáveis. Aqui está como eles são aplicados neste projeto:

- **Single Responsibility Principle (SRP)**: Cada classe tem uma única responsabilidade. Por exemplo, as classes `ProdutoController` e `CategoriaController` são responsáveis apenas por lidar com as solicitações HTTP, e as classes `Product` e `Category`, que têm a única responsabilidade de representar as entidades do domínio.
- **Open-Closed Principle (OCP)**: As entidades e os casos de uso são abertos para extensão (por exemplo, adicionando novos métodos), mas fechados para modificação. Isso é alcançado através do uso de interfaces e injeção de dependência.
- **Liskov Substitution Principle (LSP)**: As interfaces de repositório (`ProdutoRepository` e `CategoriaRepository`) podem ser substituídas por qualquer uma de suas implementações sem afetar a correção do programa.
- **Interface Segregation Principle (ISP)**: As interfaces são mantidas pequenas e específicas para suas responsabilidades (por exemplo, `ProdutoRepository` e `CategoriaRepository`). 
- **Dependency Inversion Principle (DIP)**: As dependências em detalhes concretos (como JPA) são invertidas usando interfaces. Por exemplo, `ProdutoUseCaseImpl` depende da interface `ProdutoRepository`, não da implementação concreta `ProdutoJpaRepository`. Outro exemplo seria os controladores, onde eles dependem das interfaces dos casos de uso, e não de suas implementações concretas.
