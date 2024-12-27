# Sistema de Solicitação de Serviços

Um sistema para gerenciar clientes e solicitações de serviços, permitindo operações de cadastro, edição, exclusão e listagem. Desenvolvido com Spring Boot, Thymeleaf, e JPA com MySQL, oferece uma base sólida para aprendizado de CRUD (Create, Read, Update, Delete), utilizando boas práticas de organização e tecnologias modernas.
## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.x**
- **Thymeleaf** para renderização de templates
- **Spring Data JPA** para interação com o banco de dados
- **MySQL** como banco de dados
- **Bootstrap** para estilização da interface

## Funcionalidades

1. **Clientes**
   - Listar todos os clientes.
   - Visualizar detalhes de um cliente.
   - Adicionar novos clientes.
   - Editar informações de clientes existentes.
   - Excluir clientes.

2. **Serviços**
   - Gerenciar solicitações de serviços vinculadas a clientes.

## Configuração do Ambiente

### Dependências Necessárias

Certifique-se de ter as seguintes dependências no arquivo `pom.xml`:

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-thymeleaf</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
    </dependency>
</dependencies>
```

### Configuração do Banco de Dados

Certifique-se de configurar o acesso ao banco de dados no arquivo `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/solicitacao_servicos
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

Substitua `seu_usuario` e `sua_senha` pelas credenciais do seu banco de dados.

### Estrutura do Banco de Dados

O sistema utiliza as seguintes entidades principais:

1. **Cliente**:
   - `id` (chave primária)
   - `nome`
   - `email`
   - `telefone`
   - `endereco`
   - Relação: Um cliente pode ter um serviço vinculado.

2. **Servico**:
   - `id` (chave primária)
   - `descricao`
   - `dataSolicitacao`
   - `status` (enum: `PENDENTE`, `EM_ANDAMENTO`, `FINALIZADO`)
   - `cliente` (relacionamento `@OneToOne` com Cliente)

O banco de dados será gerado automaticamente ao rodar o sistema, devido à configuração `spring.jpa.hibernate.ddl-auto=update`.

## Execução do Projeto

1. Clone este repositório para sua máquina local.
2. Configure o banco de dados conforme explicado anteriormente.
3. Execute o projeto pelo seu IDE (como IntelliJ ou Eclipse) ou via linha de comando:
   ```bash
   ./mvnw spring-boot:run
   ```
4. Acesse o sistema no navegador em [http://localhost:8080/clientes](http://localhost:8080/clientes).

## Estrutura do Projeto

### Diretório: `src/main/java`

- **Controller**: Contém os controladores do sistema, como `ClienteController`.
- **Model**: Contém as entidades `Cliente` e `Servico`.
- **Repository**: Contém as interfaces do JPA para acesso ao banco de dados.
- **Service**: Contém as classes de serviço que implementam a lógica de negócios.

### Diretório: `src/main/resources/templates`

- **clientes/**: Diretório que contém os templates Thymeleaf para as páginas de cliente.
  - `listar.html`: Lista todos os clientes.
  - `novo.html`: Formulário para adicionar um novo cliente.
  - `editar.html`: Formulário para editar um cliente existente.

## Funcionalidades e Rotas

| Verbo HTTP | Rota                  | Descrição                               |
|------------|-----------------------|-------------------------------------------|
| GET        | `/clientes`           | Lista todos os clientes.                  |
| GET        | `/clientes/{id}`      | Exibe detalhes de um cliente.             |
| GET        | `/clientes/novo`      | Exibe o formulário para novo cliente.      |
| POST       | `/clientes`           | Salva um novo cliente.                    |
| GET        | `/clientes/{id}/editar` | Exibe o formulário de edição de cliente. |
| POST       | `/clientes/{id}/editar` | Atualiza as informações de um cliente.    |
| POST       | `/clientes/{id}/excluir` | Exclui um cliente.                        |

## Personalização

- Caso queira adicionar novos campos ao cliente ou serviço, edite as respectivas classes no pacote `model` e ajuste os formulários e templates.
- Para mudar o comportamento, atualize as classes no pacote `service`.

## Contribuição

Contribuições são bem-vindas! Fique à vontade para abrir issues ou enviar pull requests para melhorias.
