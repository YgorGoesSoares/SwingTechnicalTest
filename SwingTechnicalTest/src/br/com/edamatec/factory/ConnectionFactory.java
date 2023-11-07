package br.com.edamatec.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    //Nome do usuário no banco de dados MYSQL
    private static final String USERNAME = "USERNAME DO BANCO DE DADOS";

    //Senha do usuário no banco de dados MYSQL
    private static final String PASSWORD = "SENHA BANCO DE DADOS";

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/edamatec";

    public ConnectionFactory() {
    }

    public static Connection criandoConexao() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

        return connection;
    }

    public static void main(String[] args) {

        Connection con = null;
        try {
            con = criandoConexao();
            if (con != null) {
                System.out.println("Conexão com sucesso.");
            } else {
                System.out.println("Erro na conexão!");
            }
        } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
}


