# Gestão de Vagas

## Descrição
   O Gestão de Vagas é um sistema desenvolvido para gerenciar processos seletivos, permitindo que anunciem vagas e candidatos se candidatem a essas oportunidades. Este projeto foi construído usando o Spring Boot com JPA, com suporte a autenticação via JWT, configuração de Swagger para documentos e modularização para maior escalabilidade.

------------------------------------------------------------------------
### Funcionalidades

- Gestão de Vagas : Empresas podem criar, listar, editar e remover vagas.
- Cadastro e Gerenciamento de Usuários : Cadastro de empresas e candidatos, incluindo autenticação e autorização.
- Autenticação JWT : Tokens para autenticação segura de candidatos e empresas.
- Documentação com Swagger : APIs documentadas para facilitar o uso e a integração.
- Tratamento de Exceções Centralizado : Garantia de respostas claras em casos de erro.
--------------------------------------
### Tecnologias Utilizadas

- Java : Linguagem de programação principal.
- Spring Boot : Framework para desenvolvimento rápido de aplicações Java.
- JWT (JSON Web Token) : Para autenticação e autorização.
-  Swagger : Para documentação interativa das APIs.
-  Docker : Suporte para conteinerização do projeto.
-  Maven : Gerenciador de dependências.
-  PostgreSQL : Banco de dados relacional utilizado.
----------------------
### Requisitos para Execução
- Java 17 ou superior
- Maven 3.8+
-  Docker (para rodar a aplicação via containers, se necessário)
-  PostgreSQL configurado e rodando

1. Configurar o banco de dados : Edite o arquivo ``application.properties`` para configurar as credenciais do banco de dados.

2. Construir o projeto :
./mvnw clean install

3. Executar a aplicação :
./mvnw spring-boot:run

4. Acessar o Swagger: Acesse a documentação da API em: http://localhost:8080/swagger-ui.html
-----------------------------
### Uso do Docker
- Para executar com Docker:

1. Construa e carregue os containers :
   docker-compose up --build

2. Acesse o aplicativo : O serviço estará disponível em http://localhost:8080 