# API REST - Balanceador de Times com Spring Boot

Este projeto é uma API REST desenvolvida em Java com Spring Boot, projetada para resolver um problema comum em jogos amadores: a formação de times desequilibrados.

A aplicação permite o gerenciamento completo (CRUD) de jogadores, onde cada jogador possui um nome e uma nota de habilidade. Os jogadores são armazenados em um banco de dados MySQL. O recurso principal é um endpoint que recebe uma lista de jogadores selecionados e, através de um algoritmo de balanceamento, retorna duas equipes com o nível de habilidade total o mais próximo possível, tornando as partidas mais equilibradas, justas e divertidas.

Foi criado como um projeto de portfólio para demonstrar habilidades em desenvolvimento backend com o ecossistema Spring, incluindo a criação de APIs, persistência de dados com Spring Data JPA e implementação de lógica de negócio.

## Tecnologias Utilizadas

* **Java 21**
* **Spring Boot**
* **Spring Web**: Para a construção de endpoints REST.
* **Spring Data JPA**: Para a camada de persistência de dados.
* **Hibernate**: Como implementação da JPA para o mapeamento objeto-relacional (ORM).
* **MySQL**: Banco de dados relacional para persistência dos dados.
* **Maven**: Para o gerenciamento de dependências e build do projeto.

## Funcionalidades

* **Gerenciamento de Jogadores (CRUD):**
    * Cadastrar um novo jogador.
    * Listar todos os jogadores cadastrados.
    * Buscar um jogador específico por seu ID.
    * Atualizar os dados de um jogador existente.
    * Excluir um jogador.
* **Balanceamento de Times:**
    * Um endpoint que recebe uma lista de IDs de jogadores e retorna duas equipes equilibradas com base em suas notas.

## Endpoints da API

### Jogadores (`/jogadores`)

| Método HTTP | Rota | Descrição |
| :--- | :--- | :--- |
| `POST` | `/jogadores` | Cadastra um novo jogador no sistema. |
| `GET` | `/jogadores` | Retorna a lista de todos os jogadores cadastrados. |
| `GET` | `/jogadores/{id}` | Busca um jogador específico pelo seu ID. |
| `PUT` | `/jogadores/{id}` | Atualiza as informações de um jogador existente. |
| `DELETE` | `/jogadores/{id}`| Exclui um jogador do sistema pelo seu ID. |

**Exemplo de corpo da requisição (POST/PUT) para `/jogadores`:**
```json
{
    "nome": "Zico",
    "nota": 5
}
```

### Times (`/times`)

| Método HTTP | Rota | Descrição |
| :--- | :--- | :--- |
| `POST` | `/times/balancear` | Recebe uma lista de IDs e retorna dois times balanceados. |

**Exemplo de corpo da requisição para `/times/balancear`:**
```json
[1, 2, 3, 4, 5, 6]
```

**Exemplo de corpo da resposta:**
```json
{
    "timeA": [
        { "id": 1, "nome": "Zico", "nota": 5 },
        { "id": 4, "nome": "Bebeto", "nota": 4 },
        { "id": 6, "nome": "Júnior", "nota": 3 }
    ],
    "timeB": [
        { "id": 2, "nome": "Romário", "nota": 5 },
        { "id": 3, "nome": "Ronaldo", "nota": 5 },
        { "id": 5, "nome": "Adílio", "nota": 2 }
    ]
}
```

## ⚙️ Como Executar o Projeto

### Pré-requisitos

Antes de começar, você vai precisar ter instalado em sua máquina:
* [JDK](https://www.oracle.com/java/technologies/downloads/) (versão 21 ou superior)
* [Maven](https://maven.apache.org/download.cgi) (ou pode usar o Maven Wrapper incluso)
* [MySQL](https://dev.mysql.com/downloads/mysql/) (ou um container Docker com MySQL)

### Configuração do Banco de Dados

1.  No seu MySQL, crie um novo schema (banco de dados):
    ```sql
    CREATE DATABASE balanceador_db;
    ```
2.  Abra o arquivo `src/main/resources/application.properties`.
3.  Altere as seguintes propriedades com suas credenciais do MySQL:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/balanceador_db
    spring.datasource.username=seu_usuario_mysql
    spring.datasource.password=sua_senha_mysql
    ```

### Rodando a Aplicação

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/seu-usuario/balanceador-times-api.git](https://github.com/seu-usuario/balanceador-times-api.git)
    ```

2.  **Acesse o diretório do projeto:**
    ```bash
    cd balanceador-times-api
    ```

3.  **Execute a aplicação usando o Maven Wrapper:**
    * No Linux ou macOS:
        ```bash
        ./mvnw spring-boot:run
        ```
    * No Windows:
        ```bash
        mvnw.cmd spring-boot:run
        ```

A aplicação estará disponível em `http://localhost:8080`. Você pode usar ferramentas como o [Postman](https://www.postman.com/) ou [Insomnia](https://insomnia.rest/) para interagir com a API.
