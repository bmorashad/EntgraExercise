package com.entgra.task1.restdeviceapi.db;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class Database {
    private static final String URL = "jdbc:mysql://localhost:3306/entgra";
    private static final String USER = "root";
    private static final String PASS = "root";
    private static Connection connection;

    static {

        try {
//            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            throw new RuntimeException("Error connecting to the database", ex);
        }

    }

    public Connection getConnection()
    {
        return connection;
    }

    public static void main(String[] args) {
//        Connection connection = getConnection();
    }

}
