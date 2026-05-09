//package dao;
//
//import connection.DBConnection;
//import models.User;
//import java.sql.*;
//
//public class UserDAO {
//    
//    
//    public boolean register(User user) {a
//        String sql = "INSERT INTO users (username, password, fullname, role, email, address) VALUES (?, ?, ?, ?, ?, ?)";
//        
//        try (Connection conn = DBConnection.getConnection();
//             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//            
//            pstmt.setString(1, user.getUsername());
//            pstmt.setString(2, user.getPassword());
//            pstmt.setString(3, user.getFullname());
//            pstmt.setString(4, user.getRole());
//            pstmt.setString(5, user.getEmail());
//            pstmt.setString(6, user.getAddress());
//            
//            int result = pstmt.executeUpdate();
//            System.out.println("Register result: " + result + " row(s) inserted");
//            return result > 0;
//            
//        } catch (SQLException e) {
//            System.err.println("Register error: " + e.getMessage());
//            return false;
//        }
//    }
//    
//   
//    public User login(String usernameOrEmail, String password) {
//        String sql = "SELECT * FROM users WHERE (username = ? OR email = ?) AND password = ?";
//        
//        try (Connection conn = DBConnection.getConnection();
//             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//            
//            pstmt.setString(1, usernameOrEmail);
//            pstmt.setString(2, usernameOrEmail);
//            pstmt.setString(3, password);
//            ResultSet rs = pstmt.executeQuery();
//            
//            if (rs.next()) {
//                User user = new User();
//                user.setUserId(rs.getInt("userid"));
//                user.setUsername(rs.getString("username"));
//                user.setPassword(rs.getString("password"));
//                user.setFullname(rs.getString("fullname"));
//                user.setRole(rs.getString("role"));
//                user.setEmail(rs.getString("email"));
//                user.setAddress(rs.getString("address"));
//                System.out.println("Login successful: " + usernameOrEmail);
//                return user;
//            } else {
//                System.out.println("Login failed: Invalid credentials for " + usernameOrEmail);
//            }
//            
//        } catch (SQLException e) {
//            System.err.println("Login error: " + e.getMessage());
//        }
//        return null;
//    }
//    
//    
//    public boolean usernameOrEmailExists(String username, String email) {
//        String sql = "SELECT COUNT(*) FROM users WHERE username = ? OR email = ?";
//        
//        try (Connection conn = DBConnection.getConnection();
//             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//            
//            pstmt.setString(1, username);
//            pstmt.setString(2, email);
//            ResultSet rs = pstmt.executeQuery();
//            if (rs.next()) {
//                return rs.getInt(1) > 0;
//            }
//            
//        } catch (SQLException e) {
//            System.err.println("Check error: " + e.getMessage());
//        }
//        return false;
//    }
//    
//    
//    public boolean usernameExists(String username) {
//        String sql = "SELECT COUNT(*) FROM users WHERE username = ?";
//        
//        try (Connection conn = DBConnection.getConnection();
//             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//            
//            pstmt.setString(1, username);
//            ResultSet rs = pstmt.executeQuery();
//            if (rs.next()) {
//                return rs.getInt(1) > 0;
//            }
//            
//        } catch (SQLException e) {
//            System.err.println("Check username error: " + e.getMessage());
//        }
//        return false;
//    }
//}


package dao;

import connection.DBConnection;
import models.User;
import java.sql.*;

public class UserDAO {
    
    // REGISTER - Add new user (default role = 'user')
    public boolean register(User user) {
        String sql = "INSERT INTO users (username, password, full_name, role, email, user_address) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setString(3, user.getFullname());
            pstmt.setString(4, "user");  // Always 'user' for registration (not admin)
            pstmt.setString(5, user.getEmail());
            pstmt.setString(6, user.getAddress());
            
            int result = pstmt.executeUpdate();
            System.out.println("Register result: " + result + " row(s) inserted");
            return result > 0;
            
        } catch (SQLException e) {
            System.err.println("Register error: " + e.getMessage());
            return false;
        }
    }
    
    // LOGIN - Check credentials and return user
    public User login(String usernameOrEmail, String password) {
        String sql = "SELECT * FROM users WHERE (username = ? OR email = ?) AND password = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, usernameOrEmail);
            pstmt.setString(2, usernameOrEmail);
            pstmt.setString(3, password);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt("user_id"));        // Changed from userid
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setFullname(rs.getString("full_name")); // Changed from fullname
                user.setRole(rs.getString("role"));
                user.setEmail(rs.getString("email"));
                user.setAddress(rs.getString("user_address")); // Changed from address
                System.out.println("Login successful: " + usernameOrEmail);
                return user;
            } else {
                System.out.println("Login failed: Invalid credentials for " + usernameOrEmail);
            }
            
        } catch (SQLException e) {
            System.err.println("Login error: " + e.getMessage());
        }
        return null;
    }
    
    // Check if username OR email already exists
    public boolean usernameOrEmailExists(String username, String email) {
        String sql = "SELECT COUNT(*) FROM users WHERE username = ? OR email = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, username);
            pstmt.setString(2, email);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
            
        } catch (SQLException e) {
            System.err.println("Check error: " + e.getMessage());
        }
        return false;
    }
    
    // Check if username exists
    public boolean usernameExists(String username) {
        String sql = "SELECT COUNT(*) FROM users WHERE username = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
            
        } catch (SQLException e) {
            System.err.println("Check username error: " + e.getMessage());
        }
        return false;
    }
    public boolean emailExists(String email) {
    String sql = "SELECT COUNT(*) FROM users WHERE email = ?";
    
    try (Connection conn = DBConnection.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        
        pstmt.setString(1, email);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            return rs.getInt(1) > 0;
        }
        
    } catch (SQLException e) {
        System.err.println("Check email error: " + e.getMessage());
    }
    return false;
}
}