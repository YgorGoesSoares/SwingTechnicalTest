# Instruções para Executar o Projeto

Este projeto requer algumas etapas de configuração antes de ser executado. Siga as instruções abaixo para configurar o ambiente e executar o projeto.

## Configuração do Banco de Dados

1. Abra o pacote `br.com.edamatec.factory`.
2. No arquivo `ConnectionFactory.java`, altere os campos `USERNAME` e `PASSWORD` com suas credenciais do MySQL. Isso permite que o aplicativo acesse o banco de dados.

   ```java
   private static final String URL = "jdbc:mysql://localhost:3306/seu_banco_de_dados";
   private static final String USERNAME = "seu_nome_de_usuario";
   private static final String PASSWORD = "sua_senha";

## Criação das Tabelas no MySQL

1. No arquivo `Codigos_SQL.txt`, você encontrará códigos SQL para criar as tabelas necessárias no MySQL. Execute esses comandos SQL no seu sistema de gerenciamento de banco de dados para criar as tabelas requeridas.

## Execução do Projeto

1. Após a configuração do banco de dados e criação das tabelas, você pode executar o projeto.
2. Abra a classe `Main.java`.
3. Execute a classe `Main.java`. Isso iniciará o aplicativo e permitirá que você use a interface.

Agora, o projeto está configurado e pronto para ser executado. Aproveite a sua experiência com o aplicativo!

Desenvolvido por Ygor Goes.
