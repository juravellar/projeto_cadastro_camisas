## Projeto de Gerenciamento de Camisetas

Este é um projeto em Java que permite o gerenciamento de produtos, especificamente camisetas, utilizando um banco de dados PostgreSQL para armazenar os dados. A interface com o usuário é construída usando a biblioteca Swing.

### Requisitos
Java Development Kit (JDK) instalado na sua máquina
PostgreSQL instalado e em execução
Conhecimento básico de Java e SQL

### Passo a Passo
Clone o Repositório:

bash

#### Copiar código

git clone [https://github.com/seu-usuario/nome-do-repositorio.git](https://github.com/seu-usuario/nome-do-repositorio.git)

 Configure o Banco de Dados:

- Certifique-se de que o PostgreSQL está instalado e em execução.

#### Crie um banco de dados chamado produtos.
Execute o script script_bd.sql fornecido no diretório sql para criar a tabela necessária.
Importe o Projeto na sua IDE:

Importe o projeto na sua IDE de preferência (Eclipse, IntelliJ, etc.).
Adicione o Driver JDBC do PostgreSQL:

- Certifique-se de incluir o driver JDBC do PostgreSQL (postgresql-<version>.jar) no classpath do projeto.

#### Configure as Credenciais do Banco de Dados:

Abra a classe Cadastro.java.
Modifique a URL, usuário e senha de conexão com o banco de dados de acordo com suas configurações.

#### Compile o Projeto:

Compile todas as classes do projeto.
Execute a Classe MenuUsuario:

Execute a classe MenuUsuario para iniciar a interface gráfica.
Você deve ser apresentado com a interface de usuário para gerenciamento de camisetas.
Interaja com a Interface:

Use os botões fornecidos na interface para adicionar, remover, buscar e listar produtos.

#### Encerre a Aplicação:

Ao terminar, feche a interface gráfica.
Certifique-se de fechar a conexão com o banco de dados corretamente.

### Contribuindo
Contribuições são bem-vindas! Se você encontrar algum problema ou tiver sugestões para melhorias, sinta-se à vontade para abrir uma issue ou enviar um pull request.
