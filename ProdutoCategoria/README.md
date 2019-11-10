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

