# Projeto NovaOportunidade

`NovaOportunidade` é uma aplicação web de exemplo para gerenciamento de alunos e tipos de alunos. O projeto é construído usando **Spring Boot**, **Spring Data JPA**, e **Thymeleaf** para o frontend.

Uma funcionalidade notável é a integração com a API externa **ViaCEP**, que permite preencher automaticamente os campos de endereço (rua, bairro, cidade, UF) no formulário de cadastro de aluno, bastando informar o CEP e o número.

## 🚀 Tecnologias Utilizadas

* **Backend:** Java (Spring Boot)
* **Acesso a Dados:** Spring Data JPA
* **Banco de Dados:** H2 (compatível com qualquer SGBD suportado pelo JPA, como PostgreSQL, MySQL)
* **Template Engine (Frontend):** Thymeleaf
* **Estilização:** Bootstrap 5
* **Cliente HTTP:** `RestTemplate` (para consumir a API ViaCEP)
* **Servidor:** Tomcat (embutido)

---

## ✨ Funcionalidades Principais

O projeto é dividido em dois módulos principais de CRUD (Create, Read, Update, Delete):

### 1. Gerenciamento de Alunos (`/`)

* **Listar Alunos:** A página inicial (`/` ou `aluno.html`) exibe uma tabela com todos os alunos cadastrados, seus tipos e endereços.
* **Adicionar/Editar Alunos:** O formulário (`/add` ou `/edit/{id}`) permite o cadastro e a atualização de dados do aluno, incluindo nome, data de nascimento e tipo.
* **Excluir Alunos:** Permite a remoção de um aluno do banco de dados (`/delete/{id}`), com uma confirmação via JavaScript.
* **Integração ViaCEP:**
    * No formulário de aluno, o usuário digita o **CEP** e o **Número**.
    * Ao clicar em "Buscar CEP", um script JavaScript (`fetch`) chama o endpoint backend `/buscar-endereco-json/{cep}/{numero}`.
    * O `CepService` no backend consulta a API `https://viacep.com.br/ws/`.
    * Os campos de Rua, Bairro, Cidade e UF são preenchidos automaticamente na tela, sem recarregar a página.

### 2. Gerenciamento de Tipos de Aluno (`/tipos/`)

* **Listar Tipos:** A página (`/tipos/` ou `tipoAluno.html`) exibe os tipos de aluno existentes (ex: "Bolsista", "Pagante", "Ex-aluno").
* **Adicionar/Editar Tipos:** Formulário simples (`/tipos/add` ou `/tipos/edit/{id}`) para criar ou atualizar a descrição de um tipo.
* **Excluir Tipos:** Permite a remoção de um tipo de aluno (`/tipos/delete/{id}`).

---

## 📂 Estrutura do Projeto

A aplicação segue a arquitetura padrão Model-View-Controller (MVC), organizada da seguinte forma:

```text
src/main/java/com/nossoprojeto/novaoportunidade
│
├── controller/      (Recebe requisições HTTP e retorna Views ou JSON)
│   ├── AlunoController.java
│   └── TipoAlunoController.java
│
├── model/           (Entidades de domínio (JPA) e DTOs)
│   ├── Aluno.java
│   ├── TipoAluno.java
│   └── ViaCepResponse.java  (DTO para a resposta da API ViaCEP)
│
├── repository/      (Interfaces Spring Data JPA para operações de BD)
│   ├── AlunoRepository.java
│   └── TipoAlunoRepository.java
│
├── service/         (Camada de regras de negócio)
│   ├── AlunoService.java
│   ├── TipoAlunoService.java
│   └── CepService.java      (Serviço que consome a API externa ViaCEP)
│
├── PrincipalApplication.java (Ponto de entrada da aplicação Spring Boot)
│
src/main/resources
│
├── templates/       (Arquivos HTML com Thymeleaf)
│   ├── aluno.html
│   ├── alunoAdd.html
│   ├── tipoAluno.html
│   └── tipoAlunoAdd.html
│
└── application.properties (Configurações da aplicação, como banco de dados)---
```
## 🏁 Como Executar

1.  **Pré-requisitos:**
    * Java (JDK 17 ou superior)
    * Maven 3+
    * Um SGBD (H2)

2.  **Configuração:**
    * Configure sua fonte de dados (URL do banco, usuário, senha) no arquivo `src/main/resources/application.properties`.
    * Banco H2 em memória (não exige instalação):
        ```properties
        spring.datasource.url=jdbc:h2:mem:testdb
        spring.datasource.driverClassName=org.h2.Driver
        spring.datasource.username=sa
        spring.datasource.password=password
        spring.h2.console.enabled=true
        ```

3.  **Execução:**
    * Execute a aplicação pela sua IDE (IntelliJ, Eclipse, VSCode) rodando a classe principal `PrincipalApplication.java`.
    * Ou, via terminal, na raiz do projeto (assumindo Maven):
        ```sh
        ./mvnw spring-boot:run
        ```

4.  **Acesso:**
    * **Aplicação:** Abra seu navegador em `http://localhost:8080`
    * **Console H2 (se habilitado):** `http://localhost:8080/h2-console` (use o JDBC URL `jdbc:h2:mem:testdb`)
