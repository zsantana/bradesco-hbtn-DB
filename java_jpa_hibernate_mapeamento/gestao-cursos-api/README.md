
## Descrição

Projeto administrativo em Java utilizando **Hibernate**, **JPA** e banco de dados **SQLite** para cadastro e gerenciamento de *Clientes* (Pessoa) e *Produtos*.

Este projeto possui:

- CRUD completo para entidades Pessoa e Produto
- Mapeamento JPA das tabelas com Hibernate
- Persistência automática no banco SQLite
- Gerenciamento via API Java Persistence

## Estrutura

src/ ├── main/ │ ├── java/ │ │ ├── demo/ │ │ │ └── AdministrativoApp.java │ │ ├── entities/ │ │ │ ├── Pessoa.java │ │ │ └── Produto.java │ │ └── models/ │ │ ├── PessoaModel.java │ │ └── ProdutoModel.java │ └── resources/ │ └── META-INF/ │ └── persistence.xml ├── pom.xml ├── database_admin.db └── sqlschemadatabase_admin.sql

## Dependências (Maven)

O projeto utiliza as seguintes bibliotecas:

- hibernate-core (5.4.12.Final)
- hibernate-entitymanager (5.4.12.Final)
- sqlite-jdbc (3.36.0.3)
- sqlite-dialect (0.1.2)

Veja o arquivo `pom.xml` para detalhes e versões.

## Como Executar

1. **Clone o projeto:**

   ```sh
   git clone https://github.com/seuusuario/seurepo.git
   cd seurepo/jpa_hibernate

Compile o projeto com Maven:

mvn clean install

Execute a aplicação de exemplo:

mvn exec:java -Dexec.mainClass="demo.AdministrativoApp"

(ou execute pelo IDE, rodando a classe AdministrativoApp)

O banco de dados SQLite será criado (ou atualizado) automaticamente como database_admin.db na raiz do projeto.

Configuração do JPA & Banco de Dados
A configuração está no arquivo src/main/resources/META-INF/persistence.xml. O projeto utiliza [com.github.gwenn.sqlite.dialect.SQLiteDialect] para suporte ao SQLite.

Exportando o SQL Schema
O arquivo sqlschemadatabase_admin.sql contém o schema das tabelas pessoa e produto, exportado do banco SQLite após rodar o projeto.

Exemplo de conteúdo:

CREATE TABLE pessoa (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nome TEXT NOT NULL,
    email TEXT NOT NULL UNIQUE,
    idade INTEGER,
    cpf TEXT NOT NULL UNIQUE,
    dataNascimento DATE
);

CREATE TABLE produto (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nome TEXT NOT NULL,
    quantidade INTEGER NOT NULL,
    preco REAL NOT NULL,
    status BOOLEAN NOT NULL
);

Observações
As classes Pessoa e Produto utilizam mapeamento JPA.
Os métodos CRUD estão implementados nas classes PessoaModel e ProdutoModel.
O repositório e os arquivos estão prontos para testes, dev e integração.
O arquivo de banco database_admin.db é criado automaticamente ao rodar o projeto.