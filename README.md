# Ecommerce Spring Boot

API REST para gerenciamento simplificado de e-commerce desenvolvida com Spring Boot para a disciplina de Programação Cliente Servidor.

## Integrantes

* Diogo Alves
* Julia Freitas
* Norton de França

## Objetivo do Projeto

Desenvolver uma API REST utilizando Spring Boot aplicando conceitos de arquitetura em camadas, persistência de dados com JPA/Hibernate, documentação automática com Swagger/OpenAPI e testes automatizados.

## Tecnologias Utilizadas

* Java 17
* Spring Boot 3
* Spring Data JPA
* Hibernate
* H2 Database
* Lombok
* Swagger / OpenAPI
* JUnit 5
* Mockito

## Arquitetura

O projeto foi desenvolvido seguindo o padrão:

Controller → Service → Repository → Banco de Dados

### Camadas

* Controller: recebe as requisições HTTP
* Service: contém as regras de negócio
* Repository: acesso aos dados utilizando Spring Data JPA
* Entity: representação das tabelas do banco
* DTO: transferência de dados entre API e cliente
* Exception: tratamento global de exceções

## Funcionalidades

### Categorias

* Listar categorias
* Cadastrar categorias

### Produtos

* Listar produtos
* Buscar produto por ID
* Cadastrar produto
* Atualizar produto
* Remover produto

## Relacionamentos JPA

* Categoria → Produto (@OneToMany)
* Produto → Categoria (@ManyToOne)
* Produto → Avaliacao (@OneToMany)
* Produto → Promocao (@ManyToMany)

## Testes Implementados

### Repository Test

Validação das operações de persistência utilizando banco H2 em memória.

### Service Test

Validação da lógica de negócio utilizando Mockito.

### Controller Test

Validação dos endpoints REST utilizando MockMvc.

## Como Executar

```bash
./mvnw spring-boot:run
```

## Documentação da API

Swagger UI:

http://localhost:8080/swagger-ui.html

## Banco de Dados

H2 Console:

http://localhost:8080/h2-console

Configuração:

* JDBC URL: jdbc:h2:mem:projetodb
* Usuário: sa
* Senha: (vazia)

## Autor

Projeto desenvolvido para fins acadêmicos na disciplina de Programação Cliente Servidor.
