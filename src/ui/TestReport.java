package ui;

import javax.swing.*;

public class TestReport {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Sales Reports - Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 450);
        frame.setLocationRelativeTo(null);
        frame.setContentPane(new ReportPanel());
        frame.setVisible(true);
    }
}