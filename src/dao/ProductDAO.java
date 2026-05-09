//package dao;
//
//import connection.DBConnection;
//import models.Product;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class ProductDAO {
//
//    // ── CREATE ────────────────────────────────────────────────────────────────
//    public boolean addProduct(Product product) {
//        String sql = "INSERT INTO products (productname, price, quantity, ProductDescription) VALUES (?, ?, ?, 'N/A')";
//        try (Connection conn = DBConnection.getConnection();
//             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//            pstmt.setString(1, product.getName());
//            pstmt.setDouble(2, product.getPrice());
//            pstmt.setInt(3, product.getQuantity());
//            return pstmt.executeUpdate() > 0;
//        } catch (SQLException e) {
//            System.err.println("Add product error: " + e.getMessage());
//        }
//        return false;
//    }
//
//    // ── READ (single) ─────────────────────────────────────────────────────────
//    public Product getProductById(int id) {
//        String sql = "SELECT * FROM products WHERE productid = ?";
//        try (Connection conn = DBConnection.getConnection();
//             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//            pstmt.setInt(1, id);
//            ResultSet rs = pstmt.executeQuery();
//            if (rs.next()) {
//                return mapRow(rs);
//            }
//        } catch (SQLException e) {
//            System.err.println("Get product error: " + e.getMessage());
//        }
//        return null;
//    }
//
//    // ── READ (all) ────────────────────────────────────────────────────────────
//    public List<Product> getAllProducts() {
//        List<Product> list = new ArrayList<>();
//        String sql = "SELECT * FROM products ORDER BY productid";
//        try (Connection conn = DBConnection.getConnection();
//             PreparedStatement pstmt = conn.prepareStatement(sql);
//             ResultSet rs = pstmt.executeQuery()) {
//            while (rs.next()) {
//                list.add(mapRow(rs));
//            }
//        } catch (SQLException e) {
//            System.err.println("Get all products error: " + e.getMessage());
//        }
//        return list;
//    }
//
//    // ── UPDATE ────────────────────────────────────────────────────────────────
//    public boolean updateProduct(Product product) {
//        String sql = "UPDATE products SET name = ?, price = ?, quantity = ? "
//                   + "WHERE productId = ?";
//        try (Connection conn = DBConnection.getConnection();
//             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//            pstmt.setString(1, product.getName());
//            pstmt.setDouble(2, product.getPrice());
//            pstmt.setInt(3, product.getQuantity());
//            pstmt.setInt(4, product.getProductId());
//            return pstmt.executeUpdate() > 0;
//        } catch (SQLException e) {
//            System.err.println("Update product error: " + e.getMessage());
//        }
//        return false;
//    }
//
//    // ── DELETE ────────────────────────────────────────────────────────────────
//    public boolean deleteProduct(int id) {
//        String sql = "DELETE FROM products WHERE productid = ?";
//        try (Connection conn = DBConnection.getConnection();
//             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//            pstmt.setInt(1, id);
//            return pstmt.executeUpdate() > 0;
//        } catch (SQLException e) {
//            System.err.println("Delete product error: " + e.getMessage());
//        }
//        return false;
//    }
//
//    // ── Helper ────────────────────────────────────────────────────────────────
//    private Product mapRow(ResultSet rs) throws SQLException {
//        Product p = new Product();
//        p.setProductId(rs.getInt("productid"));
//        p.setName(rs.getString("productname"));
//        p.setPrice(rs.getDouble("price"));
//        p.setQuantity(rs.getInt("quantity"));
//        return p;
//    }
//}

package dao;

import connection.DBConnection;
import models.Product;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    public boolean addProduct(Product product) {
        String sql = "INSERT INTO products (product_name, price, quantity, product_description) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, product.getName());
            pstmt.setDouble(2, product.getPrice());
            pstmt.setInt(3, product.getQuantity());
            pstmt.setString(4, "N/A");
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Add product error: " + e.getMessage());
        }
        return false;
    }

    public Product getProductById(int id) {
        String sql = "SELECT * FROM products WHERE product_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return mapRow(rs);
            }
        } catch (SQLException e) {
            System.err.println("Get product error: " + e.getMessage());
        }
        return null;
    }

    public List<Product> getAllProducts() {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM products ORDER BY product_id";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                list.add(mapRow(rs));
            }
        } catch (SQLException e) {
            System.err.println("Get all products error: " + e.getMessage());
        }
        return list;
    }

    public boolean updateProduct(Product product) {
        String sql = "UPDATE products SET product_name = ?, price = ?, quantity = ? WHERE product_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, product.getName());
            pstmt.setDouble(2, product.getPrice());
            pstmt.setInt(3, product.getQuantity());
            pstmt.setInt(4, product.getProductId());
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Update product error: " + e.getMessage());
        }
        return false;
    }

    public boolean deleteProduct(int id) {
        String sql = "DELETE FROM products WHERE product_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Delete product error: " + e.getMessage());
        }
        return false;
    }

    private Product mapRow(ResultSet rs) throws SQLException {
        Product p = new Product();
        p.setProductId(rs.getInt("product_id"));
        p.setName(rs.getString("product_name"));
        p.setPrice(rs.getDouble("price"));
        p.setQuantity(rs.getInt("quantity"));
        return p;
    }
}