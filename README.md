# 📋 Agenda de Contatos — JDBC com MySQL

Projeto desenvolvido acompanhando a playlist de **JDBC** do canal [KaneChan](https://www.youtube.com/@KaneChan), onde é ensinado como realizar um CRUD completo em Java utilizando JDBC para comunicação com o banco de dados MySQL.

---

## 📚 Sobre o Projeto

Uma aplicação Java que implementa as operações básicas de um CRUD (Create, Read, Update, Delete) em uma tabela de contatos, utilizando JDBC puro — sem frameworks como Hibernate ou Spring Data.

---

## 🛠️ Tecnologias Utilizadas

- Java
- JDBC (Java Database Connectivity)
- MySQL

---

## 🗂️ Estrutura do Projeto

```
src/
└── br/com/agenda/
    ├── dao/
    │   └── ContatoDAO.java       # Operações com o banco de dados
    ├── factory/
    │   └── ConnectionFactory.java # Gerenciamento da conexão com MySQL
    └── model/
        └── Contato.java          # Modelo de dados
```

---

## 🔍 Conceitos Abordados

### DAO (Data Access Object)
Padrão de projeto utilizado para separar a lógica de acesso ao banco de dados do restante da aplicação. Toda query SQL fica centralizada nas classes DAO.

### ConnectionFactory
Responsável por guardar as configurações de conexão (URL, usuário, senha) e criar a conexão com o banco quando necessário.

### PreparedStatement
Utilizado para executar comandos SQL de forma segura, prevenindo ataques de **SQL Injection**. Os valores são passados separadamente da estrutura do SQL através dos `?` (placeholders).

### ResultSet
Objeto que recebe e armazena os dados retornados pelo banco após uma query `SELECT`. É percorrido linha por linha para montar os objetos Java.

### Gerenciamento de Recursos
Todas as conexões, `PreparedStatement` e `ResultSet` são fechados no bloco `finally`, garantindo que os recursos sejam liberados mesmo em caso de erro.

---

## ⚙️ Como Executar

1. Clone o repositório:
```bash
git clone https://github.com/seu-usuario/seu-repositorio.git
```

2. Configure as credenciais do banco em `ConnectionFactory.java`

3. Crie a tabela no MySQL:
```sql
CREATE TABLE contatos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100),
    idade INT,
    dataCadastro DATE
);
```

4. Compile e execute o projeto pela sua IDE favorita (Eclipse, IntelliJ, etc.)

---
