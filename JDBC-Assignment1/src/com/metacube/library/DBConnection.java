package com.metacube.library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.metacube.library.constants.Constants;

public class DBConnection {
    public static Connection getConnection(String dbName) throws SQLException {
        String mysqlURL = Constants.HOST + dbName;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading Driver: " + e.getMessage());
        }
        
        Connection connection = DriverManager.getConnection(mysqlURL, Constants.USER_ID, Constants.PASSWORD);
        return connection;
    }
}
