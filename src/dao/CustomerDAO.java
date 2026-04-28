package dao;

import connection.DBConnection;
import models.Customer;
import java.sql.*;

public class CustomerDAO {

    public boolean addCustomer(Customer customer) {
        String sql = "INSERT INTO customers (name, phone, email, address) VALUES (?, ?, ?, ?)";

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

    public Customer getCustomerById(int id) {
        String sql = "SELECT * FROM customers WHERE customerId = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                Customer c = new Customer();
                c.setCustomerId(rs.getInt("customerId"));
                c.setName(rs.getString("name"));
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
}