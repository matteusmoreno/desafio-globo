# Desafio Globo - Registro de Pessoas

[![Java](https://img.shields.io/badge/Java-17-brightgreen)](https://www.java.com/)
[![Spring](https://img.shields.io/badge/Spring-5.0-brightgreen)](https://spring.io/)
[![MySQL](https://img.shields.io/badge/MySQL-8.0-brightgreen)](https://www.mysql.com/)
[![Feign](https://img.shields.io/badge/Feign-2.3-brightgreen)](https://github.com/OpenFeign/feign)
[![Lombok](https://img.shields.io/badge/Lombok-1.18-brightgreen)](https://projectlombok.org/)
[![SpringDoc](https://img.shields.io/badge/SpringDoc-2.1-brightgreen)](https://springdoc.org/)

Este projeto é uma adaptação do desafio da Globo: [Desafio Básico BE](https://github.com/ckwglobo/desafio-basico-be).

## Funcionamento da Aplicação

A aplicação de Registro de Pessoas permite criar, listar, detalhar, atualizar, desativar e ativar registros de pessoas. Ela oferece um conjunto de endpoints RESTful que podem ser usados para gerenciar informações de pessoas, incluindo nome, data de nascimento, CPF, telefone e CEP. Além disso, a aplicação utiliza a integração com o serviço ViaCep para buscar informações de endereço com base no CEP fornecido.

### Endpoints Principais

- `POST /person/create`: Crie um novo registro de pessoa.
- `GET /person/detailsbycpf/{cpf}`: Obtenha detalhes de uma pessoa com base no CPF.
- `GET /person/listbyactive`: Liste pessoas ativas.
- `GET /person/listbyinactive`: Liste pessoas desativadas.
- `PUT /person/update`: Atualize informações de uma pessoa.
- `DELETE /person/delete/{cpf}`: Desative uma pessoa.
- `PUT /person/activate/{cpf}`: Ative uma pessoa.

A aplicação utiliza validações de dados, integração com o serviço ViaCep e oferece tratamento de exceções para fornecer uma experiência amigável ao usuário.

## Como Executar o Projeto

Para executar o projeto localmente, siga estas etapas:

1. Certifique-se de ter o Java 17 e o MySQL 8.0 instalados.
2. Clone o repositório: `git clone https://github.com/matteusmoreno/desafio-globo.git`
3. Configure as propriedades do banco de dados no arquivo `application.properties`.
4. Execute o projeto com o Maven: `./mvnw spring-boot:run`.
5. Acesse a documentação da API em [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html) para testar os endpoints.

## Contribuição

Se desejar contribuir para o projeto, fique à vontade para abrir problemas (issues) ou enviar solicitações de pull (pull requests).

---

**Observação:** Este projeto foi adaptado do desafio proposto pela Globo. Agradecemos à Globo por fornecer o desafio e a oportunidade de aprendizado.

