# Sistema de Gerenciamento de Equipamentos

Projeto desenvolvido para a atividade prática de Spring Boot.

## Tecnologias

- Java 17
- Spring Boot 3.5.7
- Spring Web
- Spring Data JPA
- Spring Security
- MySQL Driver
- Lombok (dependência incluída)
- HTML, CSS e JavaScript puro

## 1. Pré-requisitos

Instale e configure:

1. JDK 17 ou superior.
2. MySQL Server e MySQL Workbench (ou outro cliente).
3. Maven (ou utilize o Maven integrado da IDE).
4. IntelliJ IDEA, Eclipse ou VS Code com suporte a Java.

## 2. Criar o banco de dados

Abra o MySQL Workbench e execute o arquivo:

`banco_de_dados/db_equipamentos.sql`

O script cria o banco `db_equipamentos`. As tabelas `usuarios` e `equipamentos` são criadas automaticamente pelo Spring Data JPA na primeira execução.

## 3. Configurar a conexão

Abra `src/main/resources/application.properties`.

Por padrão, o projeto usa:

- URL: `jdbc:mysql://localhost:3306/db_equipamentos`
- Usuário: `root`
- Senha: vazia

Se seu MySQL possuir outra senha, configure a variável de ambiente `DB_PASSWORD`. Também é possível configurar `DB_USERNAME`.

### Windows PowerShell

Na mesma janela do terminal em que iniciará a aplicação:

```powershell
$env:DB_USERNAME="root"
$env:DB_PASSWORD="SUA_SENHA_MYSQL"
```

Não envie sua senha real junto com o projeto.

## 4. Abrir e executar

1. Extraia o ZIP.
2. Abra a pasta `equipamentos` na IDE como projeto Maven.
3. Aguarde o Maven baixar as dependências.
4. Confira se o MySQL está iniciado.
5. Execute a classe `EquipamentosApplication.java`.
6. Acesse no navegador: `http://localhost:8080/login.html`.

Também é possível executar pela raiz do projeto:

```bash
mvn spring-boot:run
```

## 5. Como utilizar

1. Na tela de login, clique em **Criar conta**.
2. Cadastre nome, e-mail e senha com pelo menos 8 caracteres.
3. Volte ao login e entre com o e-mail e a senha cadastrados.
4. Cadastre, selecione, altere e remova equipamentos.
5. Clique em **Sair do sistema** para encerrar a sessão.

A senha é armazenada com BCrypt. O navegador utiliza o cookie de sessão e envia o token CSRF nas operações que modificam dados.

## 6. Rotas da API

| Método | Rota | Acesso |
|---|---|---|
| POST | `/usuarios/cadastrar` | Público |
| POST | `/login` | Público |
| POST | `/logout` | Autenticado |
| GET | `/listar` | Autenticado |
| POST | `/cadastrar` | Autenticado |
| PUT | `/alterar` | Autenticado |
| DELETE | `/remover/{codigo}` | Autenticado |

O endpoint `GET /csrf` é auxiliar: fornece o token CSRF utilizado pelo JavaScript.

## 7. Testes no Thunder Client

As rotas protegidas precisam de sessão autenticada. Para testar:

1. Faça uma requisição `GET http://localhost:8080/csrf` e copie o valor `token`.
2. Cadastre usuário com `POST /usuarios/cadastrar`, usando JSON e o cabeçalho `X-XSRF-TOKEN` com o token obtido. O Thunder Client deve manter o cookie `XSRF-TOKEN`.
3. Para fazer login, obtenha um token CSRF atualizado e envie `POST /login` como `application/x-www-form-urlencoded`, com os campos `email` e `senha`, o cabeçalho `X-XSRF-TOKEN` e mantendo os cookies.
4. Após o login, mantenha o cookie `JSESSIONID` nas próximas requisições.
5. Para cadastrar, alterar e excluir, obtenha o token CSRF atual e envie `X-XSRF-TOKEN` junto com o cookie de sessão.
6. Teste também o acesso a `GET /listar` sem cookie de sessão: deve retornar HTTP 401.
7. Faça `POST /logout` com sessão e token CSRF; depois, a rota `/listar` deve voltar a exigir autenticação.

### Exemplos de JSON

Cadastro de usuário:

```json
{
  "nome": "Maria da Silva",
  "email": "maria@email.com",
  "senha": "Senha123"
}
```

Cadastro de equipamento:

```json
{
  "nome": "Notebook",
  "marca": "Dell",
  "modelo": "Inspiron 15",
  "status": "Aguardando manutenção"
}
```

Alteração de equipamento (informe o código existente):

```json
{
  "codigo": 1,
  "nome": "Notebook",
  "marca": "Dell",
  "modelo": "Inspiron 15",
  "status": "Em manutenção"
}
```

## 8. Observações

- O código do usuário e do equipamento é gerado automaticamente.
- O e-mail do usuário é único.
- A senha nunca é devolvida pela API.
- Todos os usuários autenticados podem gerenciar os equipamentos.
- Os dados permanecem no MySQL após reiniciar a aplicação.
- As capturas de tela dos testes no Thunder Client devem ser feitas após executar os testes no seu próprio ambiente; elas não são simuladas neste projeto.
