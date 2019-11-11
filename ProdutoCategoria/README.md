# CADASTRO DE PRODUTOS E CATEGORIAS
## Criação da base de dados
A base de dados está no postgres. A base de dados é criada desta forma:
* sudo -u postgres createdb -E UTF8 cadastroprd

A base de dados será inicializada sempre que a aplicação iniciar (configuração de desenvolvimento)

Os dados configurados para o acesso são:
* usuário: postgres
* senha: postgres
* servidor: localhost
* conexão: jdbc:postgresql://localhost:5432/cadastroprd

## Acesso via api REST
* GET    http://localhost:8080/api/v1/admin/produtos - Lista os produtos
* GET    http://localhost:8080/api/v1/admin/produtos?size=3&page=1 - Lista com dados de paginação
* POST   http://localhost:8080/api/v1/admin/produtos - Grava um produto com o JSON no corpo da requisição
* DELETE http://localhost:8080/api/v1/admin/produtos/4 - Exclui o produto com ID=4
