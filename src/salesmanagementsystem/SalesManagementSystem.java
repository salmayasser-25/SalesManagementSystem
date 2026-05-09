package salesmanagementsystem;

import ui.WelcomeFrame;
import connection.DBConnection;
import java.sql.*;

public class SalesManagementSystem {

    public static void main(String[] args) {
        System.out.println("========== Testing Database Connection ==========");
        
        try {
            Connection con = DBConnection.getConnection();

            if (con != null) {
                System.out.println("✅ Connected successfully to NewSalesDB!");
                
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM [users]"); // User اسم الجدول

                while (rs.next()) {
                    System.out.println("User: " + rs.getString(1));
                }

                System.out.println("========== FINISHED ==========");
                con.close();
                
                // بعد نجاح الاتصال، نفتح WelcomeFrame
                java.awt.EventQueue.invokeLater(() -> {
                    new WelcomeFrame().setVisible(true);
                });
            }
            
        } catch (SQLException e) {
            System.out.println("❌ Database Connection Failed!");
            e.printStackTrace();
            
            // لو فشل الاتصال، نعرض رسالة وما نفتحش البرنامج
            javax.swing.JOptionPane.showMessageDialog(null, 
                "Database Connection Failed!\n" + e.getMessage(),
                "Error", 
                javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }
}