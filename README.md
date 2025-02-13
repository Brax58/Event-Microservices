# Event Microservices

Este é um projeto demo de microserviços para gerenciamento de eventos desenvolvido com Spring Boot. O objetivo é demonstrar como criar uma API RESTful robusta para gerenciar eventos, incluindo funcionalidades para listar eventos, cadastrar novos eventos e registrar participantes.

## Objetivo do Projeto

- **Gerenciar Eventos:** Permitir o cadastro, listagem e filtragem de eventos (todos e futuros).
- **Registro de Participantes:** Facilitar a inscrição de participantes em eventos específicos, tratando casos de evento cheio ou inexistente.
- **Documentação da API:** Fornecer uma interface interativa de documentação via Swagger (Springdoc OpenAPI).
- **Integração e Comunicação:** Utilizar o OpenFeign para facilitar chamadas entre serviços (quando necessário) e enviar notificações por e-mail através do Spring Boot Starter Mail.

## Tecnologias Utilizadas

- **Java 21:** Aproveitando as últimas melhorias e recursos da linguagem.
- **Spring Boot 3.4.2:** Framework para desenvolvimento rápido de aplicações.
- **Spring Cloud OpenFeign:** Para comunicação declarativa entre microserviços.
- **Spring Data JPA:** Simplifica o acesso a dados com persistência utilizando JPA.
- **H2 Database:** Banco de dados em memória para desenvolvimento e testes.
- **Spring Boot Starter Mail:** Para integração com serviços de envio de e-mails.
- **Springdoc OpenAPI:** Geração automática de documentação interativa da API (Swagger UI).
- **Lombok:** Reduz a quantidade de código boilerplate (getters, setters, construtores, etc).
- **Maven:** Gerenciamento de dependências e build do projeto.
