/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Database Connection
 * 
 * @author ssalm
 */
public class DBConnectionTest {
    
    private static Connection connection;
    
    public DBConnectionTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        System.out.println("========================================");
        System.out.println("Starting Database Connection Tests");
        System.out.println("========================================");
    }
    
    @AfterAll
    public static void tearDownClass() {
        System.out.println("========================================");
        System.out.println("All Tests Completed");
        System.out.println("========================================");
    }
    
    @BeforeEach
    public void setUp() {
        System.out.println("\n>>> Before each test - Setting up...");
    }
    
    @AfterEach
    public void tearDown() {
        System.out.println(">>> After each test - Cleaning up...");
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("    Connection closed successfully");
            }
        } catch (Exception e) {
            System.out.println("    Error closing connection: " + e.getMessage());
        }
    }

    /**
     * Test 1: Check if database connection is successful
     */
    @Test
    public void testDatabaseConnection() {
        System.out.println("\n🧪 TEST 1: Database Connection Test");
        
        try {
            connection = DBConnection.getConnection();
            
            // Assertions
            assertNotNull(connection, "Connection should not be null");
            assertFalse(connection.isClosed(), "Connection should be open");
            
            System.out.println("✅ PASSED: Database connected successfully!");
            System.out.println("    Connection: " + connection.toString());
            
        } catch (Exception e) {
            fail("❌ FAILED: Database connection error - " + e.getMessage());
        }
    }
    
    /**
     * Test 2: Check if we can query the users table
     */
    @Test
    public void testQueryUsersTable() {
        System.out.println("\n🧪 TEST 2: Query Users Table Test");
        
        try {
            connection = DBConnection.getConnection();
            assertNotNull(connection, "Connection should not be null");
            
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM users");
            
            assertNotNull(rs, "ResultSet should not be null");
            
            if (rs.next()) {
                int userCount = rs.getInt(1);
                System.out.println("    Users count: " + userCount);
                assertTrue(userCount >= 0, "User count should be 0 or more");
            }
            
            rs.close();
            stmt.close();
            
            System.out.println("✅ PASSED: Query executed successfully!");
            
        } catch (Exception e) {
            fail("❌ FAILED: Query error - " + e.getMessage());
        }
    }
    
    /**
     * Test 3: Check if we can query the products table
     */
    @Test
    public void testQueryProductsTable() {
        System.out.println("\n🧪 TEST 3: Query Products Table Test");
        
        try {
            connection = DBConnection.getConnection();
            assertNotNull(connection, "Connection should not be null");
            
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM products");
            
            assertNotNull(rs, "ResultSet should not be null");
            
            if (rs.next()) {
                int productCount = rs.getInt(1);
                System.out.println("    Products count: " + productCount);
                assertTrue(productCount >= 0, "Product count should be 0 or more");
            }
            
            rs.close();
            stmt.close();
            
            System.out.println("✅ PASSED: Products query executed successfully!");
            
        } catch (Exception e) {
            fail("❌ FAILED: Products query error - " + e.getMessage());
        }
    }
    
    /**
     * Test 4: Check if we can query the customers table
     */
    @Test
    public void testQueryCustomersTable() {
        System.out.println("\n🧪 TEST 4: Query Customers Table Test");
        
        try {
            connection = DBConnection.getConnection();
            assertNotNull(connection, "Connection should not be null");
            
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM customers");
            
            assertNotNull(rs, "ResultSet should not be null");
            
            if (rs.next()) {
                int customerCount = rs.getInt(1);
                System.out.println("    Customers count: " + customerCount);
                assertTrue(customerCount >= 0, "Customer count should be 0 or more");
            }
            
            rs.close();
            stmt.close();
            
            System.out.println("✅ PASSED: Customers query executed successfully!");
            
        } catch (Exception e) {
            fail("❌ FAILED: Customers query error - " + e.getMessage());
        }
    }
    
    /**
     * Test 5: Check SQL Server version
     */
    @Test
    public void testSQLServerVersion() {
        System.out.println("\n🧪 TEST 5: SQL Server Version Test");
        
        try {
            connection = DBConnection.getConnection();
            assertNotNull(connection, "Connection should not be null");
            
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT @@VERSION");
            
            assertNotNull(rs, "ResultSet should not be null");
            
            if (rs.next()) {
                String version = rs.getString(1);
                System.out.println("    SQL Version: " + version.substring(0, Math.min(60, version.length())) + "...");
                assertNotNull(version, "Version should not be null");
                assertFalse(version.isEmpty(), "Version should not be empty");
            }
            
            rs.close();
            stmt.close();
            
            System.out.println("✅ PASSED: SQL Server version retrieved!");
            
        } catch (Exception e) {
            fail("❌ FAILED: Version check error - " + e.getMessage());
        }
    }
}