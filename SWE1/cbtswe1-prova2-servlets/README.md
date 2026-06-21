# CBTSWE1 - Prova 2

Aplicacao Web em Java, Maven e Servlets para cadastrar vendedores, clientes e ordens de venda conforme o modelo da prova.

## Tecnologias

- Java 11 ou superior
- Maven
- Servlets/JSP
- JSTL
- H2 Database

## Funcionalidades

- Cadastro, listagem, edicao e exclusao de vendedores (`salesman`)
- Cadastro, listagem, edicao e exclusao de clientes (`customer`)
- Cadastro, listagem, edicao e exclusao de ordens de venda (`orders`)
- Banco criado automaticamente ao iniciar a aplicacao
- Dados iniciais para facilitar testes e gravacao do video

## Como executar

### Com Docker

Use esta opcao se voce nao quiser instalar Maven na maquina.

```bash
docker compose up --build
```

Acesse:

```text
http://localhost:8080/
```

O Compose usa uma imagem Maven Alpine apenas para gerar o WAR e uma imagem final com Java JRE Alpine + Tomcat 9.

### Com Maven local

1. Abra este projeto em uma IDE com Maven ou use o terminal dentro da pasta do projeto.
2. Gere o arquivo WAR:

```bash
mvn clean package
```

3. Publique `target/cbtswe1-prova2.war` em um servidor Tomcat 9.
4. Acesse:

```text
http://localhost:8080/cbtswe1-prova2/
```

## Banco de dados

A aplicacao usa H2 em arquivo local. Por padrao, o banco e criado em:

```text
./data/cbtswe1_prova2
```

Tambem e possivel informar outra conexao usando variaveis de ambiente:

```text
DB_URL
DB_USER
DB_PASSWORD
```

O script SQL completo esta em `docs/schema.sql`.

## Entrega

Para a entrega da prova:

- Suba este projeto para o GitHub.
- Envie o link do repositorio para `tulermoraes@yahoo.com`.
- Use o titulo do e-mail: `CBTSW1- Trabalho Final`.
- Grave um video mostrando a aplicacao cadastrando vendedores, clientes e ordens.
