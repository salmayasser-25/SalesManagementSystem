import connection.DBConnection;
import java.sql.*;

public class TestConnection {
    
    public static void main(String[] args) {
        System.out.println("========== Testing Database Connection ==========");
        
        try {
            Connection con = DBConnection.getConnection();
            if (con != null) {
                System.out.println("Connected successfully to Sales!");
            }
            
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");
            
            while (rs.next()) {
                System.out.println("User: " + rs.getString("username"));
            }
            
            con.close();
            System.out.println("=============================================");
            
        } catch (Exception e) {
            System.out.println("Failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
}