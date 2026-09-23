# Conta Bancária — API RESTful

API RESTful desenvolvida em Java com Spring Boot para gerenciamento de contas bancárias de uma cooperativa de crédito.

O projeto foi desenvolvido como parte de um desafio técnico, com foco em orientação a objetos, desenvolvimento de APIs REST, persistência de dados com JPA/Hibernate e aplicação de regras de negócio bancárias.

## Tecnologias utilizadas

* Java 8
* Spring Boot 2.7.18
* Spring Web
* Spring Data JPA
* Hibernate
* H2 Database
* Maven

## Funcionalidades

### Correntistas

* Cadastro de correntistas
* Consulta de todos os correntistas
* Consulta de correntista por ID
* Atualização de correntista
* Exclusão de correntista

### Contas

* Criação de contas
* Consulta de todas as contas
* Consulta de conta por ID
* Associação da conta a um correntista
* Conta Corrente com limite
* Conta Poupança

### Movimentações

* Realização de depósitos
* Realização de saques
* Validação de saldo disponível
* Utilização do limite para Conta Corrente
* Registro das movimentações
* Consulta das transações realizadas

## Regras de negócio

* Um correntista pode possuir mais de uma conta.
* A Conta Corrente possui um limite disponível para utilização.
* O saque em Conta Corrente pode utilizar o saldo disponível somado ao limite.
* A Conta Poupança não permite saque acima do saldo disponível.
* O depósito aumenta o saldo da conta e registra uma transação.
* O saque reduz o saldo da conta e registra uma transação.

## Estrutura do projeto

```text
src
└── main
    └── java
        └── com.pactomais.contabancaria
            ├── controller
            ├── model
            ├── repository
            └── service
```

A aplicação utiliza herança para representar os diferentes tipos de conta:

```text
Conta
├── ContaCorrente
└── ContaPoupanca
```

## Banco de dados

O projeto utiliza o banco de dados H2 em memória para facilitar a execução local.

Configuração utilizada:

```text
jdbc:h2:mem:contabancaria
```

Como o banco está configurado em memória, os dados são perdidos quando a aplicação é encerrada ou reiniciada.

O Hibernate é responsável pela criação das tabelas e relacionamentos a partir das entidades JPA.

## Como executar o projeto

### Pré-requisitos

* Java 8 instalado
* Maven instalado ou utilização do Maven Wrapper
* IDE de preferência, como IntelliJ IDEA ou Eclipse

### Executando

1. Clone o repositório:

```bash
git clone URL_DO_REPOSITORIO
```

2. Acesse a pasta do projeto:

```bash
cd conta-bancaria
```

3. Execute a aplicação utilizando Maven:

```bash
mvn spring-boot:run
```

Ou execute a classe principal da aplicação pela IDE.

A API será iniciada, por padrão, em:

```text
http://localhost:8080
```

## Endpoints

### Correntistas

#### Listar correntistas

```http
GET /correntistas
```

#### Buscar correntista por ID

```http
GET /correntistas/{id}
```

#### Cadastrar correntista

```http
POST /correntistas
Content-Type: application/json
```

Exemplo:

```json
{
  "nome": "Maria da Silva",
  "documento": "98765432100",
  "telefone": "83999999999",
  "email": "maria@email.com"
}
```

#### Atualizar correntista

```http
PUT /correntistas/{id}
Content-Type: application/json
```

#### Excluir correntista

```http
DELETE /correntistas/{id}
```

### Contas

#### Listar contas

```http
GET /contas
```

#### Buscar conta por ID

```http
GET /contas/{id}
```

#### Criar conta

```http
POST /contas
Content-Type: application/json
```

Exemplo:

```json
{
  "numero": "000001",
  "saldo": 0,
  "correntista": {
    "id": 1
  }
}
```

### Depósito

```http
POST /contas/{id}/depositos?valor=100
```

Exemplo:

```http
POST /contas/1/depositos?valor=100
```

### Saque

```http
POST /contas/{id}/saques?valor=50
```

Exemplo:

```http
POST /contas/1/saques?valor=50
```

### Transações

As movimentações realizadas são registradas no banco de dados por meio da entidade `Transacao`, contendo informações como tipo, valor, data e conta de origem.

## Persistência

A aplicação utiliza:

* JPA para o mapeamento objeto-relacional;
* Hibernate como implementação JPA;
* Spring Data JPA para acesso aos dados;
* H2 como banco de dados.

As entidades principais são:

* `Correntista`
* `Conta`
* `ContaCorrente`
* `ContaPoupanca`
* `Transacao`

## O que foi implementado

* API REST para gerenciamento de correntistas e contas;
* Persistência utilizando JPA/Hibernate;
* Banco de dados H2;
* Relacionamento entre correntista e conta;
* Herança entre os tipos de conta;
* Depósitos;
* Saques;
* Regra de limite para Conta Corrente;
* Regra de saldo para Conta Poupança;
* Registro de transações;
* Consulta das informações por meio dos endpoints REST.

## Observações

O projeto priorizou a implementação das funcionalidades principais propostas no desafio, mantendo a estrutura organizada entre controllers, services, repositories e models.

Funcionalidades adicionais, como testes automatizados, documentação Swagger/OpenAPI e tratamento padronizado de erros, não foram implementadas nesta versão.
