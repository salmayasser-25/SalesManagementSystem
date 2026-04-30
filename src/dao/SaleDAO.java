package dao;

import connection.DBConnection;
import models.Sale;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SaleDAO {

    public List<Sale> getAllSales() {
        List<Sale> list = new ArrayList<>();
        // Using JOIN to get CustomerName from customers table
        String sql = "SELECT s.saleid, c.CustomerName as customerName, s.saledate, s.totalamount " +
                     "FROM sales s " +
                     "LEFT JOIN customers c ON s.customerid = c.CustomerId " +
                     "ORDER BY s.saleid";
                     
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
             
            while (rs.next()) {
                Sale s = new Sale();
                s.setSaleId(rs.getInt("saleid"));
                s.setCustomerName(rs.getString("customerName"));
                s.setSaleDate(rs.getDate("saledate"));
                s.setTotalAmount(rs.getDouble("totalamount"));
                list.add(s);
            }
        } catch (SQLException e) {
            System.err.println("Get all sales error: " + e.getMessage());
        }
        return list;
    }
    public List<Sale> getSalesByDate(String date) {
        List<Sale> list = new ArrayList<>();
        String sql = "SELECT s.saleid, c.CustomerName as customerName, s.saledate, s.totalamount " +
                     "FROM sales s " +
                     "LEFT JOIN customers c ON s.customerid = c.CustomerId " +
                     "WHERE CAST(s.saledate AS DATE) = ? " +
                     "ORDER BY s.saleid";
                     
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, date);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Sale s = new Sale();
                    s.setSaleId(rs.getInt("saleid"));
                    s.setCustomerName(rs.getString("customerName"));
                    s.setSaleDate(rs.getDate("saledate"));
                    s.setTotalAmount(rs.getDouble("totalamount"));
                    list.add(s);
                }
            }
        } catch (SQLException e) {
            System.err.println("Get sales by date error: " + e.getMessage());
        }
        return list;
    }
}

