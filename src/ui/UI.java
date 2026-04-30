package ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import dao.CustomerDAO;
import dao.ProductDAO;
import dao.SaleDAO;
import models.Customer;
import models.Product;
import models.Sale;
import java.util.List;

/**
 *
 * @author Ali
 */
public class UI extends javax.swing.JPanel {

    private CustomerDAO customerDAO = new CustomerDAO();
    private ProductDAO productDAO = new ProductDAO();
    private SaleDAO saleDAO = new SaleDAO();
    private int selectedCustomerId = -1;
    private int selectedProductId = -1;

    public UI() {
        initComponents();
        
        // Force Tab Names so NetBeans doesn't reset them
        if (jTabbedPane1.getTabCount() >= 5) {
            jTabbedPane1.setTitleAt(0, "Login");
            jTabbedPane1.setTitleAt(1, "Register");
            jTabbedPane1.setTitleAt(2, "Customer");
            jTabbedPane1.setTitleAt(3, "Product");
            jTabbedPane1.setTitleAt(4, "Report");
        }
        
        loadCustomers();
        loadProducts();
        loadSales();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        tabLogin = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        UserNameTEXT = new javax.swing.JTextField();
        PasswordTEXT = new javax.swing.JPasswordField();
        LogInBtn = new javax.swing.JButton();
        tabRegister = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        FristNameTEXT = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        LastNameTEXT = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        AgeTEXT = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        PhoneTEXT = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        AdderssTEXT = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        maleRadioButton = new javax.swing.JRadioButton();
        femaleRadioButton = new javax.swing.JRadioButton();
        Registeration = new javax.swing.JButton();
        tabCustomer = new javax.swing.JPanel();
        lblCustName = new javax.swing.JLabel();
        txtCustName = new javax.swing.JTextField();
        lblCustPhone = new javax.swing.JLabel();
        txtCustPhone = new javax.swing.JTextField();
        lblCustEmail = new javax.swing.JLabel();
        txtCustEmail = new javax.swing.JTextField();
        lblCustAddress = new javax.swing.JLabel();
        txtCustAddress = new javax.swing.JTextField();
        btnCustAdd = new javax.swing.JButton();
        btnCustUpdate = new javax.swing.JButton();
        btnCustDelete = new javax.swing.JButton();
        jScrollPaneCustomers = new javax.swing.JScrollPane();
        tblCustomers = new javax.swing.JTable();
        tabProduct = new javax.swing.JPanel();
        lblProdName = new javax.swing.JLabel();
        txtProdName = new javax.swing.JTextField();
        lblProdPrice = new javax.swing.JLabel();
        txtProdPrice = new javax.swing.JTextField();
        lblProdQty = new javax.swing.JLabel();
        txtProdQty = new javax.swing.JTextField();
        btnProdAdd = new javax.swing.JButton();
        btnProdUpdate = new javax.swing.JButton();
        btnProdDelete = new javax.swing.JButton();
        jScrollPaneProducts = new javax.swing.JScrollPane();
        tblProducts = new javax.swing.JTable();
        tabReport = new javax.swing.JPanel();
        btnReportRefresh = new javax.swing.JButton();
        jScrollPaneReports = new javax.swing.JScrollPane();
        tblSales = new javax.swing.JTable();
        lblTotalSales = new javax.swing.JLabel();
        txtTotalSales = new javax.swing.JTextField();

        setLayout(new java.awt.BorderLayout());

        tabLogin.setLayout(null);

        jLabel2.setText("User Name:");
        tabLogin.add(jLabel2);
        jLabel2.setBounds(350, 200, 100, 30);

        jLabel3.setText("Password:");
        tabLogin.add(jLabel3);
        jLabel3.setBounds(350, 250, 100, 30);
        tabLogin.add(UserNameTEXT);
        UserNameTEXT.setBounds(450, 200, 200, 30);
        tabLogin.add(PasswordTEXT);
        PasswordTEXT.setBounds(450, 250, 200, 30);

        LogInBtn.setText("LogIn");
        LogInBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogInBtnActionPerformed(evt);
            }
        });
        tabLogin.add(LogInBtn);
        LogInBtn.setBounds(450, 300, 100, 35);

        jTabbedPane1.addTab("tab1", tabLogin);

        tabRegister.setLayout(null);

        jLabel4.setText("First Name:");
        tabRegister.add(jLabel4);
        jLabel4.setBounds(300, 50, 100, 30);
        tabRegister.add(FristNameTEXT);
        FristNameTEXT.setBounds(400, 50, 250, 30);

        jLabel5.setText("Last Name:");
        tabRegister.add(jLabel5);
        jLabel5.setBounds(300, 100, 100, 30);
        tabRegister.add(LastNameTEXT);
        LastNameTEXT.setBounds(400, 100, 250, 30);

        jLabel6.setText("Age:");
        tabRegister.add(jLabel6);
        jLabel6.setBounds(300, 150, 100, 30);
        tabRegister.add(AgeTEXT);
        AgeTEXT.setBounds(400, 150, 250, 30);

        jLabel7.setText("Phone:");
        tabRegister.add(jLabel7);
        jLabel7.setBounds(300, 200, 100, 30);
        tabRegister.add(PhoneTEXT);
        PhoneTEXT.setBounds(400, 200, 250, 30);

        jLabel9.setText("Address:");
        tabRegister.add(jLabel9);
        jLabel9.setBounds(300, 250, 100, 30);
        tabRegister.add(AdderssTEXT);
        AdderssTEXT.setBounds(400, 250, 250, 30);

        jLabel8.setText("Gender:");
        tabRegister.add(jLabel8);
        jLabel8.setBounds(300, 300, 100, 30);

        buttonGroup1.add(maleRadioButton);
        maleRadioButton.setText("Male");
        tabRegister.add(maleRadioButton);
        maleRadioButton.setBounds(400, 300, 80, 30);

        buttonGroup1.add(femaleRadioButton);
        femaleRadioButton.setText("Female");
        tabRegister.add(femaleRadioButton);
        femaleRadioButton.setBounds(500, 300, 80, 30);

        Registeration.setText("Register");
        Registeration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterationActionPerformed(evt);
            }
        });
        tabRegister.add(Registeration);
        Registeration.setBounds(400, 360, 100, 35);

        jTabbedPane1.addTab("tab2", tabRegister);

        tabCustomer.setLayout(null);

        lblCustName.setText("Name:");
        tabCustomer.add(lblCustName);
        lblCustName.setBounds(50, 90, 100, 30);
        tabCustomer.add(txtCustName);
        txtCustName.setBounds(150, 90, 250, 30);

        lblCustPhone.setText("Phone:");
        tabCustomer.add(lblCustPhone);
        lblCustPhone.setBounds(50, 140, 100, 30);
        tabCustomer.add(txtCustPhone);
        txtCustPhone.setBounds(150, 140, 250, 30);

        lblCustEmail.setText("Email:");
        tabCustomer.add(lblCustEmail);
        lblCustEmail.setBounds(50, 190, 100, 30);
        tabCustomer.add(txtCustEmail);
        txtCustEmail.setBounds(150, 190, 250, 30);

        lblCustAddress.setText("Address:");
        tabCustomer.add(lblCustAddress);
        lblCustAddress.setBounds(50, 240, 100, 30);
        tabCustomer.add(txtCustAddress);
        txtCustAddress.setBounds(150, 240, 250, 30);

        btnCustAdd.setText("Add");
        btnCustAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustAddActionPerformed(evt);
            }
        });
        tabCustomer.add(btnCustAdd);
        btnCustAdd.setBounds(50, 320, 90, 35);

        btnCustUpdate.setText("Update");
        btnCustUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustUpdateActionPerformed(evt);
            }
        });
        tabCustomer.add(btnCustUpdate);
        btnCustUpdate.setBounds(160, 320, 90, 35);

        btnCustDelete.setText("Delete");
        btnCustDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustDeleteActionPerformed(evt);
            }
        });
        tabCustomer.add(btnCustDelete);
        btnCustDelete.setBounds(270, 320, 90, 35);

        tblCustomers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Phone", "Email", "Address"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCustomers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCustomersMouseClicked(evt);
            }
        });
        jScrollPaneCustomers.setViewportView(tblCustomers);

        tabCustomer.add(jScrollPaneCustomers);
        jScrollPaneCustomers.setBounds(450, 40, 550, 400);

        jTabbedPane1.addTab("tab3", tabCustomer);

        tabProduct.setLayout(null);

        lblProdName.setText("Name:");
        tabProduct.add(lblProdName);
        lblProdName.setBounds(50, 90, 100, 30);
        tabProduct.add(txtProdName);
        txtProdName.setBounds(150, 90, 250, 30);

        lblProdPrice.setText("Price:");
        tabProduct.add(lblProdPrice);
        lblProdPrice.setBounds(50, 140, 100, 30);
        tabProduct.add(txtProdPrice);
        txtProdPrice.setBounds(150, 140, 250, 30);

        lblProdQty.setText("Quantity:");
        tabProduct.add(lblProdQty);
        lblProdQty.setBounds(50, 190, 100, 30);
        tabProduct.add(txtProdQty);
        txtProdQty.setBounds(150, 190, 250, 30);

        btnProdAdd.setText("Add");
        btnProdAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdAddActionPerformed(evt);
            }
        });
        tabProduct.add(btnProdAdd);
        btnProdAdd.setBounds(50, 270, 90, 35);

        btnProdUpdate.setText("Update");
        btnProdUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdUpdateActionPerformed(evt);
            }
        });
        tabProduct.add(btnProdUpdate);
        btnProdUpdate.setBounds(160, 270, 90, 35);

        btnProdDelete.setText("Delete");
        btnProdDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProdDeleteActionPerformed(evt);
            }
        });
        tabProduct.add(btnProdDelete);
        btnProdDelete.setBounds(270, 270, 90, 35);

        tblProducts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Price", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductsMouseClicked(evt);
            }
        });
        jScrollPaneProducts.setViewportView(tblProducts);

        tabProduct.add(jScrollPaneProducts);
        jScrollPaneProducts.setBounds(450, 40, 550, 400);

        jTabbedPane1.addTab("tab4", tabProduct);

        tabReport.setLayout(null);

        btnReportRefresh.setText("Refresh Sales");
        btnReportRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportRefreshActionPerformed(evt);
            }
        });
        tabReport.add(btnReportRefresh);
        btnReportRefresh.setBounds(50, 30, 150, 35);

        tblSales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sale ID", "Customer Name", "Sale Date", "Total Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPaneReports.setViewportView(tblSales);

        tabReport.add(jScrollPaneReports);
        jScrollPaneReports.setBounds(50, 80, 900, 350);

        lblTotalSales.setText("Total Sales Amount:");
        tabReport.add(lblTotalSales);
        lblTotalSales.setBounds(50, 450, 150, 30);

        txtTotalSales.setEditable(false);
        tabReport.add(txtTotalSales);
        txtTotalSales.setBounds(200, 450, 200, 30);

        
        lblFilterDate = new javax.swing.JLabel();
        txtFilterDate = new javax.swing.JTextField();
        btnFilterDate = new javax.swing.JButton();
        btnMaxSale = new javax.swing.JButton();
        txtMaxSale = new javax.swing.JTextField();
        btnMinSale = new javax.swing.JButton();
        txtMinSale = new javax.swing.JTextField();
        btnAvgSale = new javax.swing.JButton();
        txtAvgSale = new javax.swing.JTextField();

        lblFilterDate.setText("Date (YYYY-MM-DD):");
        tabReport.add(lblFilterDate);
        lblFilterDate.setBounds(300, 30, 150, 30);

        tabReport.add(txtFilterDate);
        txtFilterDate.setBounds(450, 30, 150, 30);

        btnFilterDate.setText("Filter");
        btnFilterDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterDateActionPerformed(evt);
            }
        });
        tabReport.add(btnFilterDate);
        btnFilterDate.setBounds(620, 30, 100, 35);

        btnMaxSale.setText("Max Sale");
        btnMaxSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaxSaleActionPerformed(evt);
            }
        });
        tabReport.add(btnMaxSale);
        btnMaxSale.setBounds(50, 500, 100, 35);

        txtMaxSale.setEditable(false);
        tabReport.add(txtMaxSale);
        txtMaxSale.setBounds(160, 500, 150, 30);

        btnMinSale.setText("Min Sale");
        btnMinSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinSaleActionPerformed(evt);
            }
        });
        tabReport.add(btnMinSale);
        btnMinSale.setBounds(350, 500, 100, 35);

        txtMinSale.setEditable(false);
        tabReport.add(txtMinSale);
        txtMinSale.setBounds(460, 500, 150, 30);

        btnAvgSale.setText("Avg Sale");
        btnAvgSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvgSaleActionPerformed(evt);
            }
        });
        tabReport.add(btnAvgSale);
        btnAvgSale.setBounds(650, 500, 100, 35);

        txtAvgSale.setEditable(false);
        tabReport.add(txtAvgSale);
        txtAvgSale.setBounds(760, 500, 150, 30);

        jTabbedPane1.addTab("tab5", tabReport);

        add(jTabbedPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void LogInBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogInBtnActionPerformed
        String userName = UserNameTEXT.getText();
        String Password = new String(PasswordTEXT.getPassword());
        JOptionPane.showMessageDialog(this, "Logged in as " + userName);
    }//GEN-LAST:event_LogInBtnActionPerformed

    private void RegisterationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterationActionPerformed
        JOptionPane.showMessageDialog(this, "Registered user: " + FristNameTEXT.getText());
    }//GEN-LAST:event_RegisterationActionPerformed

    // Customer Actions
    private void btnCustAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustAddActionPerformed
        Customer c = new Customer(txtCustName.getText(), txtCustPhone.getText(), txtCustEmail.getText(), txtCustAddress.getText());
        if (customerDAO.addCustomer(c)) {
            JOptionPane.showMessageDialog(this, "Customer added");
            loadCustomers();
            selectedCustomerId = -1;
        }
    }//GEN-LAST:event_btnCustAddActionPerformed

    private void btnCustUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustUpdateActionPerformed
        try {
            int id = selectedCustomerId;
            if (id == -1) { JOptionPane.showMessageDialog(this, "Please select a customer from the table first."); return; }
            Customer c = new Customer(txtCustName.getText(), txtCustPhone.getText(), txtCustEmail.getText(), txtCustAddress.getText());
            c.setCustomerId(id);
            if (customerDAO.updateCustomer(c)) {
                JOptionPane.showMessageDialog(this, "Customer updated");
                loadCustomers();
            selectedCustomerId = -1;
        }
        } catch (Exception e) {}
    }//GEN-LAST:event_btnCustUpdateActionPerformed

    private void btnCustDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustDeleteActionPerformed
        try {
            int id = selectedCustomerId;
            if (id == -1) { JOptionPane.showMessageDialog(this, "Please select a customer from the table first."); return; }
            if (customerDAO.deleteCustomer(id)) {
                JOptionPane.showMessageDialog(this, "Customer deleted");
                loadCustomers();
            selectedCustomerId = -1;
        }
        } catch (Exception e) {}
    }//GEN-LAST:event_btnCustDeleteActionPerformed

    private void tblCustomersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCustomersMouseClicked
        int row = tblCustomers.getSelectedRow();
        if (row >= 0) {
            selectedCustomerId = (int) tblCustomers.getValueAt(row, 0);
            txtCustName.setText(tblCustomers.getValueAt(row, 1).toString());
            txtCustPhone.setText(tblCustomers.getValueAt(row, 2).toString());
            txtCustEmail.setText(tblCustomers.getValueAt(row, 3).toString());
            txtCustAddress.setText(tblCustomers.getValueAt(row, 4).toString());
        }
    }//GEN-LAST:event_tblCustomersMouseClicked

    // Product Actions
    private void btnProdAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdAddActionPerformed
        try {
            Product p = new Product(txtProdName.getText(), Double.parseDouble(txtProdPrice.getText()), Integer.parseInt(txtProdQty.getText()));
            if (productDAO.addProduct(p)) {
                JOptionPane.showMessageDialog(this, "Product added");
                loadProducts();
            selectedProductId = -1;
        }
        } catch (Exception e) {}
    }//GEN-LAST:event_btnProdAddActionPerformed

    private void btnProdUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdUpdateActionPerformed
        try {
            int id = selectedProductId;
            if (id == -1) { JOptionPane.showMessageDialog(this, "Please select a product from the table first."); return; }
            Product p = new Product(txtProdName.getText(), Double.parseDouble(txtProdPrice.getText()), Integer.parseInt(txtProdQty.getText()));
            p.setProductId(id);
            if (productDAO.updateProduct(p)) {
                JOptionPane.showMessageDialog(this, "Product updated");
                loadProducts();
            selectedProductId = -1;
        }
        } catch (Exception e) {}
    }//GEN-LAST:event_btnProdUpdateActionPerformed

    private void btnProdDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProdDeleteActionPerformed
        try {
            int id = selectedProductId;
            if (id == -1) { JOptionPane.showMessageDialog(this, "Please select a product from the table first."); return; }
            if (productDAO.deleteProduct(id)) {
                JOptionPane.showMessageDialog(this, "Product deleted");
                loadProducts();
            selectedProductId = -1;
        }
        } catch (Exception e) {}
    }//GEN-LAST:event_btnProdDeleteActionPerformed

    private void tblProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductsMouseClicked
        int row = tblProducts.getSelectedRow();
        if (row >= 0) {
            selectedProductId = (int) tblProducts.getValueAt(row, 0);
            txtProdName.setText(tblProducts.getValueAt(row, 1).toString());
            txtProdPrice.setText(tblProducts.getValueAt(row, 2).toString());
            txtProdQty.setText(tblProducts.getValueAt(row, 3).toString());
        }
    }//GEN-LAST:event_tblProductsMouseClicked

    // Report Actions
    private void btnReportRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportRefreshActionPerformed
        loadSales();
        txtMaxSale.setText("");
        txtMinSale.setText("");
        txtAvgSale.setText("");
    }//GEN-LAST:event_btnReportRefreshActionPerformed

    // Data Loaders
    private void loadCustomers() {
        DefaultTableModel model = (DefaultTableModel) tblCustomers.getModel();
        model.setRowCount(0);
        for (Customer c : customerDAO.getAllCustomers()) {
            model.addRow(new Object[]{c.getCustomerId(), c.getName(), c.getPhone(), c.getEmail(), c.getAddress()});
        }
    }

    private void loadProducts() {
        DefaultTableModel model = (DefaultTableModel) tblProducts.getModel();
        model.setRowCount(0);
        for (Product p : productDAO.getAllProducts()) {
            model.addRow(new Object[]{p.getProductId(), p.getName(), p.getPrice(), p.getQuantity()});
        }
    }

    private void loadSales() {
        DefaultTableModel model = (DefaultTableModel) tblSales.getModel();
        model.setRowCount(0);
        double total = 0;
        for (Sale s : saleDAO.getAllSales()) {
            model.addRow(new Object[]{s.getSaleId(), s.getCustomerName(), s.getSaleDate(), s.getTotalAmount()});
            total += s.getTotalAmount();
        }
        txtTotalSales.setText(String.format("%.2f", total));
    }


    private void btnFilterDateActionPerformed(java.awt.event.ActionEvent evt) {
        String dateStr = txtFilterDate.getText().trim();
        if (dateStr.isEmpty()) {
            loadSales(); // load all if empty
            return;
        }
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) tblSales.getModel();
        model.setRowCount(0);
        double total = 0;
        for (models.Sale s : saleDAO.getSalesByDate(dateStr)) {
            model.addRow(new Object[]{s.getSaleId(), s.getCustomerName(), s.getSaleDate(), s.getTotalAmount()});
            total += s.getTotalAmount();
        }
        txtTotalSales.setText(String.format("%.2f", total));
        
        // Reset min/max/avg fields
        txtMaxSale.setText("");
        txtMinSale.setText("");
        txtAvgSale.setText("");
    }

    private void btnMaxSaleActionPerformed(java.awt.event.ActionEvent evt) {
        if (tblSales.getRowCount() == 0) { txtMaxSale.setText("0"); return; }
        double max = 0;
        for (int i=0; i<tblSales.getRowCount(); i++) {
            double val = Double.parseDouble(tblSales.getValueAt(i, 3).toString());
            if (val > max) max = val;
        }
        txtMaxSale.setText(String.format("%.2f", max));
    }

    private void btnMinSaleActionPerformed(java.awt.event.ActionEvent evt) {
        if (tblSales.getRowCount() == 0) { txtMinSale.setText("0"); return; }
        double min = Double.MAX_VALUE;
        for (int i=0; i<tblSales.getRowCount(); i++) {
            double val = Double.parseDouble(tblSales.getValueAt(i, 3).toString());
            if (val < min) min = val;
        }
        txtMinSale.setText(String.format("%.2f", min));
    }

    private void btnAvgSaleActionPerformed(java.awt.event.ActionEvent evt) {
        if (tblSales.getRowCount() == 0) { txtAvgSale.setText("0"); return; }
        double sum = 0;
        for (int i=0; i<tblSales.getRowCount(); i++) {
            sum += Double.parseDouble(tblSales.getValueAt(i, 3).toString());
        }
        double avg = sum / tblSales.getRowCount();
        txtAvgSale.setText(String.format("%.2f", avg));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AdderssTEXT;
    private javax.swing.JTextField AgeTEXT;
    private javax.swing.JTextField FristNameTEXT;
    private javax.swing.JTextField LastNameTEXT;
    private javax.swing.JButton LogInBtn;
    private javax.swing.JPasswordField PasswordTEXT;
    private javax.swing.JTextField PhoneTEXT;
    private javax.swing.JButton Registeration;
    private javax.swing.JTextField UserNameTEXT;
    private javax.swing.JButton btnCustAdd;
    private javax.swing.JButton btnCustDelete;
    private javax.swing.JButton btnCustUpdate;
    private javax.swing.JButton btnProdAdd;
    private javax.swing.JButton btnProdDelete;
    private javax.swing.JButton btnProdUpdate;
    private javax.swing.JButton btnReportRefresh;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton femaleRadioButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPaneCustomers;
    private javax.swing.JScrollPane jScrollPaneProducts;
    private javax.swing.JScrollPane jScrollPaneReports;
    
    private javax.swing.JLabel lblFilterDate;
    private javax.swing.JTextField txtFilterDate;
    private javax.swing.JButton btnFilterDate;
    private javax.swing.JButton btnMaxSale;
    private javax.swing.JTextField txtMaxSale;
    private javax.swing.JButton btnMinSale;
    private javax.swing.JTextField txtMinSale;
    private javax.swing.JButton btnAvgSale;
    private javax.swing.JTextField txtAvgSale;

    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblCustAddress;
    private javax.swing.JLabel lblCustEmail;
    private javax.swing.JLabel lblCustName;
    private javax.swing.JLabel lblCustPhone;
    private javax.swing.JLabel lblProdName;
    private javax.swing.JLabel lblProdPrice;
    private javax.swing.JLabel lblProdQty;
    private javax.swing.JLabel lblTotalSales;
    private javax.swing.JRadioButton maleRadioButton;
    private javax.swing.JPanel tabCustomer;
    private javax.swing.JPanel tabLogin;
    private javax.swing.JPanel tabProduct;
    private javax.swing.JPanel tabRegister;
    private javax.swing.JPanel tabReport;
    private javax.swing.JTable tblCustomers;
    private javax.swing.JTable tblProducts;
    private javax.swing.JTable tblSales;
    private javax.swing.JTextField txtCustAddress;
    private javax.swing.JTextField txtCustEmail;
    private javax.swing.JTextField txtCustName;
    private javax.swing.JTextField txtCustPhone;
    private javax.swing.JTextField txtProdName;
    private javax.swing.JTextField txtProdPrice;
    private javax.swing.JTextField txtProdQty;
    private javax.swing.JTextField txtTotalSales;
    // End of variables declaration//GEN-END:variables
}
