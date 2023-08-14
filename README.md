Projeto BanhoDePote - API

# Visão geral

O projeto é uma aplicação back-end com objetivo de demonstrar a produtividade de construir APIs utilizando os frameworks [Spring Boot](https://projects.spring.io/spring-boot), [Spring MVC](https://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html) e [Spring Data](http://projects.spring.io/spring-data) em conjunto.

## Tecnologias

- [Spring Boot] [Spring MVC] [Spring Data]

## Pré-requisito

Antes de rodar a aplicação é preciso garantir que as seguintes dependências estejam corretamente instaladas:
```
Java 17
PostgreSQL 15.4
Maven 4.0.0 
```

## Preparando ambiente

É necessário a criação da base de dados relacional no Postgres

```
CREATE DATABASE "banhodepote";
```

## Instalação da aplicação

Primeiramente, faça o clone do repositório:
```
https://github.com/KadsonLima/BanhodePote_API
```
Feito isso, acesse o projeto:
```
cd BanhodePote_API
```
É preciso compilar o código e baixar as dependências do projeto:
```
mvn clean package
```
Finalizado esse passo, vamos iniciar a aplicação:
```
mvn spring-boot:run
```
Pronto. A aplicação está disponível em http://localhost:8080


# APIs

O projeto disponibiliza algumas APIs em 3 contextos diferentes: Items, Waiter e Order, onde utilizam o padrão Rest de comunicação, produzindo e consumindo arquivos no formato JSON.

Segue abaixo as APIs disponíveis no projeto:

#### Items

 - /items (GET)
 - /items/{categoryId} (GET)
 - /items (POST)
	 - Cria um Novo Item
     - Critérios de busca no body da requisição, exemplo:
 ```
    {
	  "itemName":"Batata Frita",
	  "price": 15.60,
	  "categoryId":1
    }
  ```

#### Waiter

 - /waiter (GET)
 - /waiter/{name} (GET)
 - /waiter  (POST)
	 - Critérios de busca no body da requisição, exemplo:
    ```
    {
	  "user_name":"waiter1",
	  "name": "Kadson Lima",
	  "email":"waiter@hotmail.com",
	  "password":"dsadasdsa"
    }
    ```
 
 #### Order
 
  - /order/ (GET)
  - /order/{status}/{id} (PATCH) - Sendo status "cancel ou received"
  - /order/{mesa}/{waiterId}  (POST)
	 - Header passando Numero da Mesa e WaiterId.
	 - Critérios de busca no body da requisição, exemplo:
    ```
    {
	  [1,2,3] // Sendo os ids dos Items
    }
    ```
  - /order/updateListOrders/  (PATCH)
	 - Critérios de busca no body da requisição, exemplo:
    ```
    {
	  [1,2,3] // Sendo os ids das Orders para dar como Entregues
    }
    ```
