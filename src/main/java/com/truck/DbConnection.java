package com.truck;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static final String URL="jdbc:mysql://localhost:3306/truckmgt";
    private static final String USERNAME="root";
    private static final String PASS="nikh@9312";

    public static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USERNAME, PASS);
        return connection;
    }
}
