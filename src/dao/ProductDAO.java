package dao;

import connection.DBConnection;
import models.Product;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    // CREATE - Add new product
    public boolean addProduct(Product product) {
        String sql = "INSERT INTO products (productname, price, quantity, description) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, product.getProductName());
            pstmt.setDouble(2, product.getPrice());
            pstmt.setInt(3, product.getQuantity());
            pstmt.setString(4, product.getDescription());

            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Add product error: " + e.getMessage());
        }
        return false;
    }

    // READ - Get product by ID
    public Product getProductById(int id) {
        String sql = "SELECT * FROM products WHERE productid = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                Product p = new Product();
                p.setProductId(rs.getInt("productid"));
                p.setProductName(rs.getString("productname"));
                p.setPrice(rs.getDouble("price"));
                p.setQuantity(rs.getInt("quantity"));
                p.setDescription(rs.getString("description"));
                return p;
            }

        } catch (SQLException e) {
            System.err.println("Get product error: " + e.getMessage());
        }
        return null;
    }

    // READ - Get all products (مهم لـ SalePanel)
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM products ORDER BY productid";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Product p = new Product();
                p.setProductId(rs.getInt("productid"));
                p.setProductName(rs.getString("productname"));
                p.setPrice(rs.getDouble("price"));
                p.setQuantity(rs.getInt("quantity"));
                p.setDescription(rs.getString("description"));
                products.add(p);
            }

        } catch (SQLException e) {
            System.err.println("Get all products error: " + e.getMessage());
        }
        return products;
    }

    // UPDATE - Update product
    public boolean updateProduct(Product product) {
        String sql = "UPDATE products SET productname = ?, price = ?, quantity = ?, description = ? WHERE productid = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, product.getProductName());
            pstmt.setDouble(2, product.getPrice());
            pstmt.setInt(3, product.getQuantity());
            pstmt.setString(4, product.getDescription());
            pstmt.setInt(5, product.getProductId());

            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Update product error: " + e.getMessage());
        }
        return false;
    }

    // DELETE - Delete product
    public boolean deleteProduct(int id) {
        String sql = "DELETE FROM products WHERE productid = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Delete product error: " + e.getMessage());
        }
        return false;
    }

    // SEARCH - Search products by name
    public List<Product> searchProductsByName(String name) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM products WHERE productname LIKE ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, "%" + name + "%");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Product p = new Product();
                p.setProductId(rs.getInt("productid"));
                p.setProductName(rs.getString("productname"));
                p.setPrice(rs.getDouble("price"));
                p.setQuantity(rs.getInt("quantity"));
                p.setDescription(rs.getString("description"));
                products.add(p);
            }

        } catch (SQLException e) {
            System.err.println("Search products error: " + e.getMessage());
        }
        return products;
    }
}