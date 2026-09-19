# LeiloesTDSat

Sistema informatizado desenvolvido para auxiliar uma casa de leilões em suas rotinas.

## Tecnologias utilizadas

- Java
- Java Swing
- MariaDB
- JDBC

## Configuração do banco de dados

O projeto usa o driver MySQL JDBC, compatível com o servidor MariaDB. As credenciais não ficam no código-fonte.

1. Crie o banco `uc11` no MariaDB.
2. Copie `db.properties.example` para `db.properties`.
3. Preencha o usuário e a senha do banco em `db.properties`.
4. Execute o projeto pelo NetBeans.

Exemplo de configuração:

```properties
db.url=jdbc:mysql://127.0.0.1:3306/uc11
db.user=senac
db.password=sua_senha
```

O arquivo `db.properties` é ignorado pelo Git e não deve ser enviado ao repositório.

## Banco de dados para entrega

O arquivo `database/uc11.sql` deve conter a exportação das tabelas e dos dados necessários para testar o sistema. Para restaurá-lo:

```bash
mariadb -u senac -p uc11 < database/uc11.sql
```
