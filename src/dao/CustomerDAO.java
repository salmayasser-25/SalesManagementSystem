package dao;

import connection.DBConnection;
import models.Customer;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

    // CREATE - Add new customer
    public boolean addCustomer(Customer customer) {
        String sql = "INSERT INTO customers (customername, phone, email, address) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, customer.getCustomerName());
            pstmt.setString(2, customer.getPhone());
            pstmt.setString(3, customer.getEmail());
            pstmt.setString(4, customer.getAddress());

            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Add customer error: " + e.getMessage());
        }
        return false;
    }

    // READ - Get customer by ID
    public Customer getCustomerById(int id) {
        String sql = "SELECT * FROM customers WHERE customerid = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                Customer c = new Customer();
                c.setCustomerId(rs.getInt("customerid"));
                c.setCustomerName(rs.getString("customername"));
                c.setPhone(rs.getString("phone"));
                c.setEmail(rs.getString("email"));
                c.setAddress(rs.getString("address"));
                return c;
            }

        } catch (SQLException e) {
            System.err.println("Get customer error: " + e.getMessage());
        }
        return null;
    }

    // READ - Get all customers (مهم لـ SalePanel)
    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT * FROM customers ORDER BY customerid";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Customer c = new Customer();
                c.setCustomerId(rs.getInt("customerid"));
                c.setCustomerName(rs.getString("customername"));
                c.setPhone(rs.getString("phone"));
                c.setEmail(rs.getString("email"));
                c.setAddress(rs.getString("address"));
                customers.add(c);
            }

        } catch (SQLException e) {
            System.err.println("Get all customers error: " + e.getMessage());
        }
        return customers;
    }

    // UPDATE - Update customer
    public boolean updateCustomer(Customer customer) {
        String sql = "UPDATE customers SET customername = ?, phone = ?, email = ?, address = ? WHERE customerid = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, customer.getCustomerName());
            pstmt.setString(2, customer.getPhone());
            pstmt.setString(3, customer.getEmail());
            pstmt.setString(4, customer.getAddress());
            pstmt.setInt(5, customer.getCustomerId());

            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Update customer error: " + e.getMessage());
        }
        return false;
    }

    // DELETE - Delete customer
    public boolean deleteCustomer(int id) {
        String sql = "DELETE FROM customers WHERE customerid = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Delete customer error: " + e.getMessage());
        }
        return false;
    }

    // SEARCH - Search customers by name
    public List<Customer> searchCustomersByName(String name) {
        List<Customer> customers = new ArrayList<>();
        String sql = "SELECT * FROM customers WHERE customername LIKE ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, "%" + name + "%");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Customer c = new Customer();
                c.setCustomerId(rs.getInt("customerid"));
                c.setCustomerName(rs.getString("customername"));
                c.setPhone(rs.getString("phone"));
                c.setEmail(rs.getString("email"));
                c.setAddress(rs.getString("address"));
                customers.add(c);
            }

        } catch (SQLException e) {
            System.err.println("Search customers error: " + e.getMessage());
        }
        return customers;
    }
}