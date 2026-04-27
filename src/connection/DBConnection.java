package connection;

import java.sql.*;

public class DBConnection {
    
    private static final String URL = "jdbc:sqlserver://localhost:1434;databaseName=NewSalesDB;integratedSecurity=true;encrypt=false;trustServerCertificate=true";
    
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("Driver loaded");
            Connection conn = DriverManager.getConnection(URL);
            System.out.println("Connected successfully!");
            return conn;
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver not found: " + e.getMessage());
        }
    }
}