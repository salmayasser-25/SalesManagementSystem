package dao;

import connection.DBConnection;
import models.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

    // ── CREATE ────────────────────────────────────────────────────────────────
    public boolean addCustomer(Customer customer) {
        String sql = "INSERT INTO customers (CustomerName, Phone, Email, CsutAddress) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, customer.getName());
            pstmt.setString(2, customer.getPhone());
            pstmt.setString(3, customer.getEmail());
            pstmt.setString(4, customer.getAddress());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Add customer error: " + e.getMessage());
        }
        return false;
    }

    // ── READ (single) ─────────────────────────────────────────────────────────
    public Customer getCustomerById(int id) {
        String sql = "SELECT * FROM customers WHERE CustomerId = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return mapRow(rs);
            }
        } catch (SQLException e) {
            System.err.println("Get customer error: " + e.getMessage());
        }
        return null;
    }

    // ── READ (all) ────────────────────────────────────────────────────────────
    public List<Customer> getAllCustomers() {
        List<Customer> list = new ArrayList<>();
        String sql = "SELECT * FROM customers ORDER BY CustomerId";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                list.add(mapRow(rs));
            }
        } catch (SQLException e) {
            System.err.println("Get all customers error: " + e.getMessage());
        }
        return list;
    }

    // ── UPDATE ────────────────────────────────────────────────────────────────
    public boolean updateCustomer(Customer customer) {
        String sql = "UPDATE customers SET name = ?, phone = ?, email = ?, address = ? "
                   + "WHERE customerId = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, customer.getName());
            pstmt.setString(2, customer.getPhone());
            pstmt.setString(3, customer.getEmail());
            pstmt.setString(4, customer.getAddress());
            pstmt.setInt(5,    customer.getCustomerId());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Update customer error: " + e.getMessage());
        }
        return false;
    }

    // ── DELETE ────────────────────────────────────────────────────────────────
    public boolean deleteCustomer(int id) {
        String sql = "DELETE FROM customers WHERE CustomerId = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Delete customer error: " + e.getMessage());
        }
        return false;
    }

    // ── Helper ────────────────────────────────────────────────────────────────
    private Customer mapRow(ResultSet rs) throws SQLException {
        Customer c = new Customer();
        c.setCustomerId(rs.getInt("CustomerId"));
        c.setName(rs.getString("CustomerName"));
        c.setPhone(rs.getString("Phone"));
        c.setEmail(rs.getString("Email"));
        c.setAddress(rs.getString("CsutAddress"));
        return c;
    }
}