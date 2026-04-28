package dao;

import connection.DBConnection;
import models.Sale;
import models.SaleDetail;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SaleDAO {
    
    // Save sale with details (transaction)
    public boolean saveSale(Sale sale, List<SaleDetail> details) {
        Connection conn = null;
        PreparedStatement pstmtSale = null;
        PreparedStatement pstmtDetail = null;
        PreparedStatement pstmtUpdateProduct = null;
        ResultSet generatedKeys = null;
        
        try {
            conn = DBConnection.getConnection();
            conn.setAutoCommit(false); // Start transaction
            
            // 1. Insert into sales table
            String sqlSale = "INSERT INTO sales (customerid, saledate, totalamount) VALUES (?, ?, ?)";
            pstmtSale = conn.prepareStatement(sqlSale, Statement.RETURN_GENERATED_KEYS);
            pstmtSale.setInt(1, sale.getCustomerId());
            pstmtSale.setDate(2, new Date(System.currentTimeMillis()));
            pstmtSale.setDouble(3, sale.getTotalAmount());
            pstmtSale.executeUpdate();
            
            // Get generated sale ID
            generatedKeys = pstmtSale.getGeneratedKeys();
            int saleId = -1;
            if (generatedKeys.next()) {
                saleId = generatedKeys.getInt(1);
            }
            
            if (saleId == -1) {
                conn.rollback();
                return false;
            }
            
            // 2. Insert into saledetails table and update product quantity
            String sqlDetail = "INSERT INTO saledetails (saleid, productid, quantity, unitprice, subtotal) VALUES (?, ?, ?, ?, ?)";
            String sqlUpdateProduct = "UPDATE products SET quantity = quantity - ? WHERE productid = ?";
            
            pstmtDetail = conn.prepareStatement(sqlDetail);
            pstmtUpdateProduct = conn.prepareStatement(sqlUpdateProduct);
            
            for (SaleDetail detail : details) {
                // Insert detail
                pstmtDetail.setInt(1, saleId);
                pstmtDetail.setInt(2, detail.getProductId());
                pstmtDetail.setInt(3, detail.getQuantity());
                pstmtDetail.setDouble(4, detail.getUnitPrice());
                pstmtDetail.setDouble(5, detail.getSubtotal());
                pstmtDetail.addBatch();
                
                // Update product quantity
                pstmtUpdateProduct.setInt(1, detail.getQuantity());
                pstmtUpdateProduct.setInt(2, detail.getProductId());
                pstmtUpdateProduct.addBatch();
            }
            
            pstmtDetail.executeBatch();
            pstmtUpdateProduct.executeBatch();
            
            conn.commit(); // Commit transaction
            return true;
            
        } catch (SQLException e) {
            System.err.println("Save sale error: " + e.getMessage());
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException ex) {
                System.err.println("Rollback error: " + ex.getMessage());
            }
            return false;
        } finally {
            try {
                if (pstmtSale != null) pstmtSale.close();
                if (pstmtDetail != null) pstmtDetail.close();
                if (pstmtUpdateProduct != null) pstmtUpdateProduct.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.err.println("Close error: " + e.getMessage());
            }
        }
    }
    
    // Get all sales
    public List<Sale> getAllSales() {
        List<Sale> sales = new ArrayList<>();
        String sql = "SELECT s.saleid, s.customerid, c.customername, s.saledate, s.totalamount " +
                     "FROM sales s JOIN customers c ON s.customerid = c.customerid " +
                     "ORDER BY s.saledate DESC";
        
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Sale sale = new Sale();
                sale.setSaleId(rs.getInt("saleid"));
                sale.setCustomerId(rs.getInt("customerid"));
                sale.setCustomerName(rs.getString("customername"));
                sale.setSaleDate(rs.getDate("saledate"));
                sale.setTotalAmount(rs.getDouble("totalamount"));
                sales.add(sale);
            }
            
        } catch (SQLException e) {
            System.err.println("Get all sales error: " + e.getMessage());
        }
        return sales;
    }
    
    // Get sale details by sale ID
    public List<SaleDetail> getSaleDetails(int saleId) {
        List<SaleDetail> details = new ArrayList<>();
        String sql = "SELECT sd.detailid, sd.productid, p.productname, sd.quantity, sd.unitprice, sd.subtotal " +
                     "FROM saledetails sd JOIN products p ON sd.productid = p.productid " +
                     "WHERE sd.saleid = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, saleId);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                SaleDetail detail = new SaleDetail();
                detail.setDetailId(rs.getInt("detailid"));
                detail.setProductId(rs.getInt("productid"));
                detail.setProductName(rs.getString("productname"));
                detail.setQuantity(rs.getInt("quantity"));
                detail.setUnitPrice(rs.getDouble("unitprice"));
                detail.setSubtotal(rs.getDouble("subtotal"));
                details.add(detail);
            }
            
        } catch (SQLException e) {
            System.err.println("Get sale details error: " + e.getMessage());
        }
        return details;
    }
    
    // Get sales between dates
    public List<Sale> getSalesByDateRange(java.util.Date startDate, java.util.Date endDate) {
        List<Sale> sales = new ArrayList<>();
        String sql = "SELECT s.saleid, s.customerid, c.customername, s.saledate, s.totalamount " +
                     "FROM sales s JOIN customers c ON s.customerid = c.customerid " +
                     "WHERE s.saledate BETWEEN ? AND ? ORDER BY s.saledate DESC";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setDate(1, new Date(startDate.getTime()));
            pstmt.setDate(2, new Date(endDate.getTime()));
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Sale sale = new Sale();
                sale.setSaleId(rs.getInt("saleid"));
                sale.setCustomerId(rs.getInt("customerid"));
                sale.setCustomerName(rs.getString("customername"));
                sale.setSaleDate(rs.getDate("saledate"));
                sale.setTotalAmount(rs.getDouble("totalamount"));
                sales.add(sale);
            }
            
        } catch (SQLException e) {
            System.err.println("Get sales by date range error: " + e.getMessage());
        }
        return sales;
    }
    
    // Get total sales amount
    public double getTotalSalesAmount() {
        String sql = "SELECT SUM(totalamount) as total FROM sales";
        
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            if (rs.next()) {
                return rs.getDouble("total");
            }
            
        } catch (SQLException e) {
            System.err.println("Get total sales error: " + e.getMessage());
        }
        return 0;
    }
}