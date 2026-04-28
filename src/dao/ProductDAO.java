package dao;

import connection.DBConnection;
import models.Product;
import java.sql.*;

public class ProductDAO {

    public boolean addProduct(Product product) {
        String sql = "INSERT INTO products (name, price, quantity) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, product.getName());
            pstmt.setDouble(2, product.getPrice());
            pstmt.setInt(3, product.getQuantity());

            return pstmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Add product error: " + e.getMessage());
        }
        return false;
    }

    public Product getProductById(int id) {
        String sql = "SELECT * FROM products WHERE productId = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                Product p = new Product();
                p.setProductId(rs.getInt("productId"));
                p.setName(rs.getString("name"));
                p.setPrice(rs.getDouble("price"));
                p.setQuantity(rs.getInt("quantity"));
                return p;
            }

        } catch (SQLException e) {
            System.err.println("Get product error: " + e.getMessage());
        }
        return null;
    }
}