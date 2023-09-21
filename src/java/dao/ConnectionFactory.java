package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @brief Classe ConnectionFactory
 * @author Paulo Henrique
 * @date   criado em: 01/09/2023
 */
public class ConnectionFactory {
    
    private final String DRIVER = "org.apache.derby.jdbc.ClientDriver";
    private final String URL = "jdbc:derby://localhost:1527/apostilaAlura";
    private final String USER = "root";
    private final String PASS = "root";
    
    public Connection getConnection() {
        try {
            Class.forName(DRIVER);
            //Establishing a connection with desired database
            Connection connection = DriverManager.getConnection(URL, USER, PASS); 
            if (connection != null) {
                System.out.println("Open conection");
            }
            return connection;
            //return java.sql.DriverManager.getConnection(URL, USER, PASS);

        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Err in conection: ", ex);
        }
    }
    
    public void closeConnection(Connection con) {

        try {
            if (con != null) {
                con.close();
                System.out.println("Closed conection");
            }
        } catch (SQLException ex) {
            //menssagem
        }

    }

}
