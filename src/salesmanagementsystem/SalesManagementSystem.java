package salesmanagementsystem;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import ui.UI;

public class SalesManagementSystem {

    public static void main(String[] args) {
        // Set look and feel
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            try {
                javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ex2) {
                System.err.println("Failed to set LookAndFeel");
            }
        }

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Sales Management System");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            // Create and add the UI panel
            UI mainUI = new UI();
            frame.setContentPane(mainUI);
            frame.setSize(1200, 700);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            
            System.out.println("[INFO] Sales Management System launched successfully.");
        });
    }
}