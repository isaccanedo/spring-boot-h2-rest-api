# Spring Boot REST API com H2 Database

Este é um projeto **Spring Boot REST API** para gerenciamento de **funcionários**, utilizando um banco de dados **H2 em memória**. Ele permite criar, listar, atualizar e excluir funcionários através de endpoints REST.

## 📌 Tecnologias Utilizadas

- **Java 11+**
- **Spring Boot**
- **Spring Data JPA**
- **Banco de dados H2 (em memória)**
- **Maven**

## 🚀 Configuração do Banco de Dados H2 em Memória

O projeto utiliza um banco de dados **H2** em memória, sendo criado automaticamente ao iniciar a aplicação.

### 📄 Configuração no `application.properties`:
```properties
# Banco de dados H2
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

# Configuração do Hibernate para H2
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update

# Habilitar console H2
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```
Acesse o console H2 em: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

## 🔧 Como Rodar o Projeto

### 1️⃣ Clonar o repositório
```sh
git clone https://github.com/seu-usuario/seu-repositorio.git
cd seu-repositorio
```

### 2️⃣ Compilar o projeto
```sh
mvn clean install
```

### 3️⃣ Executar a aplicação
```sh
mvn spring-boot:run
```

A API estará disponível em: [http://localhost:8080/api](http://localhost:8080/api)

## 📡 Endpoints da API

### 🔍 Listar todos os funcionários
```http
GET /api/funcionarios
```

### ➕ Criar um novo funcionário
```http
POST /api/funcionario/novo
Content-Type: application/json

{
  "nome": "João Silva",
  "cargo": "Analista de Sistemas"
}
```

### 🔎 Buscar funcionário por ID
```http
GET /api/funcionario/{id}
```

### ✏️ Atualizar um funcionário
```http
PUT /api/funcionario/{id}
Content-Type: application/json

{
  "nome": "João Pedro Silva",
  "cargo": "Desenvolvedor Backend"
}
```

### ❌ Deletar um funcionário
```http
DELETE /api/funcionario/{id}
```

## 🛠 Estrutura do Projeto
```
├── src
│   ├── main
│   │   ├── java/br/com/isaccanedo
│   │   │   ├── controller
│   │   │   │   ├── FuncionariosController.java
│   │   │   ├── model
│   │   │   │   ├── FuncionarioModel.java
│   │   │   ├── repository
│   │   │   │   ├── FuncionarioRepository.java
│   │   │   ├── exception
│   │   │   │   ├── ResourceNotFoundException.java
│   │   │   ├── SpringBootH2Application.java
│   ├── resources
│   │   ├── application.properties
│   ├── test
├── pom.xml
└── README.md
```
