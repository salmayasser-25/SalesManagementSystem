package connection;

import java.sql.*;

public class DBConnection {
    
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=Sales;integratedSecurity=true;encrypt=false;trustServerCertificate=true";
    private static boolean tablesInitialized = false;
    
    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(URL);
            
            if (!tablesInitialized) {
                initializeTables(conn);
                tablesInitialized = true;
            }
            
            return conn;
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver not found: " + e.getMessage());
        }
    }
    
    private static void initializeTables(Connection conn) {
        try (Statement stmt = conn.createStatement()) {
            // Create customers table
            stmt.executeUpdate("IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='customers' AND xtype='U') " +
                               "CREATE TABLE customers (" +
                               "customerId INT IDENTITY(1,1) PRIMARY KEY, " +
                               "name VARCHAR(100), phone VARCHAR(50), email VARCHAR(100), address VARCHAR(200))");
                               
            // Create products table
            stmt.executeUpdate("IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='products' AND xtype='U') " +
                               "CREATE TABLE products (" +
                               "productId INT IDENTITY(1,1) PRIMARY KEY, " +
                               "name VARCHAR(100), price DECIMAL(10,2), quantity INT)");
                               
            // Create sales table
            stmt.executeUpdate("IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='sales' AND xtype='U') " +
                               "CREATE TABLE sales (" +
                               "saleId INT IDENTITY(1,1) PRIMARY KEY, " +
                               "customerName VARCHAR(100), saleDate DATE DEFAULT GETDATE(), totalAmount DECIMAL(10,2))");
                               
            System.out.println("Database tables initialized successfully!");
        } catch (SQLException e) {
            System.err.println("Failed to initialize tables: " + e.getMessage());
        }
    }
}