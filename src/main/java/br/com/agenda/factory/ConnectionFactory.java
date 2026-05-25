package br.com.agenda.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    private static final String username = "root";
    private static final String password = "1234";
    private static final String database_url = "jdbc:mysql://localhost:3306/agenda";

    public static Connection createConnectionToMySQL() throws Exception {

        Class.forName("com.mysql.jdbc.Driver");

        Connection connection = DriverManager.getConnection(database_url, username, password);
        return connection;
    }

    public static void main(String[] args) throws Exception {

        Connection con = createConnectionToMySQL();

        if (con != null) {
            System.out.println("Conectado com sucesso!");
            con.close();
        }
    }

}
