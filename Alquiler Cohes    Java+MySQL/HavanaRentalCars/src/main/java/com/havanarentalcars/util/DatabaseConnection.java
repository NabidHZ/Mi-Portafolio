package com.havanarentalcars.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/* Esta clase se encarga de establecer la conexion con la base de datos MySql utilizando JDBC*/
//s una API de Java que permite conectar aplicaciones Java con bases de datos como MySQL


public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/havana_rental_cars";
    private static final String USER = "root";  // mi usuario en MySql
    private static final String PASSWORD = "root"; // mi constraseña en MySql

    // Método para obtener la conexión a la base de datos
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
