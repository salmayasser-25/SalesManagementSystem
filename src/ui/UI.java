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

import dao.UserDAO;
import models.User;
import models.UserSession;
import javax.swing.JOptionPane;

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
        
         // Apply access control
         applyAccessControl();
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
        jLabel7 = new javax.swing.JLabel();
        PhoneTEXT = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        AdderssTEXT = new javax.swing.JTextField();
        Registeration = new javax.swing.JButton();
        btnBackToLogin = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        txtConfirmPassword = new javax.swing.JPasswordField();
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
        btnLogout = new javax.swing.JButton();
        btnFinish = new javax.swing.JButton();
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
        btnLogoutProduct = new javax.swing.JButton();
        btnFinishProduct = new javax.swing.JButton();
        tabReport = new javax.swing.JPanel();
        btnReportRefresh = new javax.swing.JButton();
        jScrollPaneReports = new javax.swing.JScrollPane();
        tblSales = new javax.swing.JTable();
        lblTotalSales = new javax.swing.JLabel();
        txtTotalSales = new javax.swing.JTextField();
        btnLogoutReport = new javax.swing.JButton();
        lblFromDate = new javax.swing.JLabel();
        txtFromDate = new javax.swing.JTextField();
        btnDateRangeFilter = new javax.swing.JButton();
        btnMaxSale = new javax.swing.JButton();
        btnMinSale = new javax.swing.JButton();
        btnAvgSale = new javax.swing.JButton();
        txtMaxSalee = new javax.swing.JTextField();
        txtMinSalee = new javax.swing.JTextField();
        txtAvgSalee = new javax.swing.JTextField();
        btnFinishReport = new javax.swing.JButton();
        lblToDate = new javax.swing.JLabel();
        txtToDate = new javax.swing.JTextField();

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
        jLabel4.setBounds(250, 40, 100, 30);
        tabRegister.add(FristNameTEXT);
        FristNameTEXT.setBounds(350, 40, 250, 30);

        jLabel5.setText("Last Name:");
        tabRegister.add(jLabel5);
        jLabel5.setBounds(250, 90, 100, 30);
        tabRegister.add(LastNameTEXT);
        LastNameTEXT.setBounds(350, 90, 250, 30);

        jLabel7.setText("Phone:");
        tabRegister.add(jLabel7);
        jLabel7.setBounds(260, 280, 100, 30);
        tabRegister.add(PhoneTEXT);
        PhoneTEXT.setBounds(350, 280, 250, 30);

        jLabel9.setText("Address:");
        tabRegister.add(jLabel9);
        jLabel9.setBounds(270, 330, 100, 30);
        tabRegister.add(AdderssTEXT);
        AdderssTEXT.setBounds(350, 330, 250, 30);

        Registeration.setText("Register");
        Registeration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterationActionPerformed(evt);
            }
        });
        tabRegister.add(Registeration);
        Registeration.setBounds(350, 390, 100, 35);

        btnBackToLogin.setText("Back to Login");
        btnBackToLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackToLoginActionPerformed(evt);
            }
        });
        tabRegister.add(btnBackToLogin);
        btnBackToLogin.setBounds(590, 390, 110, 23);

        jLabel1.setText("Email:");
        tabRegister.add(jLabel1);
        jLabel1.setBounds(250, 150, 37, 16);

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        tabRegister.add(txtEmail);
        txtEmail.setBounds(350, 140, 250, 30);

        jLabel6.setText("Password:");
        tabRegister.add(jLabel6);
        jLabel6.setBounds(250, 200, 60, 20);
        tabRegister.add(txtPassword);
        txtPassword.setBounds(350, 190, 250, 30);

        jLabel8.setText("Confirm Password:");
        tabRegister.add(jLabel8);
        jLabel8.setBounds(247, 240, 110, 20);
        tabRegister.add(txtConfirmPassword);
        txtConfirmPassword.setBounds(350, 240, 260, 30);

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

        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        tabCustomer.add(btnLogout);
        btnLogout.setBounds(930, 0, 72, 23);

        btnFinish.setText("Finish");
        btnFinish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinishActionPerformed(evt);
            }
        });
        tabCustomer.add(btnFinish);
        btnFinish.setBounds(930, 470, 72, 23);

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

        btnLogoutProduct.setText("Logout");
        btnLogoutProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutProductActionPerformed(evt);
            }
        });
        tabProduct.add(btnLogoutProduct);
        btnLogoutProduct.setBounds(930, 0, 72, 23);

        btnFinishProduct.setText("Finish");
        btnFinishProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinishProductActionPerformed(evt);
            }
        });
        tabProduct.add(btnFinishProduct);
        btnFinishProduct.setBounds(930, 460, 72, 23);

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

        btnLogoutReport.setText("Logout");
        btnLogoutReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutReportActionPerformed(evt);
            }
        });
        tabReport.add(btnLogoutReport);
        btnLogoutReport.setBounds(930, 0, 72, 23);

        lblFromDate.setText("From Date: (YYYY-MM-DD):");
        tabReport.add(lblFromDate);
        lblFromDate.setBounds(220, 40, 160, 20);

        txtFromDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFromDateActionPerformed(evt);
            }
        });
        tabReport.add(txtFromDate);
        txtFromDate.setBounds(370, 40, 110, 20);

        btnDateRangeFilter.setText("Filter");
        btnDateRangeFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDateRangeFilterActionPerformed(evt);
            }
        });
        tabReport.add(btnDateRangeFilter);
        btnDateRangeFilter.setBounds(670, 40, 72, 23);

        btnMaxSale.setText("Max Sale");
        btnMaxSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaxSaleActionPerformed(evt);
            }
        });
        tabReport.add(btnMaxSale);
        btnMaxSale.setBounds(45, 500, 80, 23);

        btnMinSale.setText("Min Sale");
        btnMinSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinSaleActionPerformed(evt);
            }
        });
        tabReport.add(btnMinSale);
        btnMinSale.setBounds(265, 500, 80, 23);

        btnAvgSale.setText("Avg Sale");
        btnAvgSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvgSaleActionPerformed(evt);
            }
        });
        tabReport.add(btnAvgSale);
        btnAvgSale.setBounds(475, 500, 90, 23);
        tabReport.add(txtMaxSalee);
        txtMaxSalee.setBounds(140, 500, 64, 22);
        tabReport.add(txtMinSalee);
        txtMinSalee.setBounds(360, 500, 64, 22);
        tabReport.add(txtAvgSalee);
        txtAvgSalee.setBounds(580, 500, 71, 22);

        btnFinishReport.setText("Finish");
        btnFinishReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinishReportActionPerformed(evt);
            }
        });
        tabReport.add(btnFinishReport);
        btnFinishReport.setBounds(930, 520, 72, 23);

        lblToDate.setText("To Date:");
        tabReport.add(lblToDate);
        lblToDate.setBounds(490, 40, 50, 16);
        tabReport.add(txtToDate);
        txtToDate.setBounds(540, 40, 100, 22);

        jTabbedPane1.addTab("tab5", tabReport);

        add(jTabbedPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void LogInBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogInBtnActionPerformed
//        String userName = UserNameTEXT.getText();
//        String Password = new String(PasswordTEXT.getPassword());
//        JOptionPane.showMessageDialog(this, "Logged in as " + userName);
                                                  
             String userName = UserNameTEXT.getText();
    String password = new String(PasswordTEXT.getPassword());

    // Check if fields are empty
    if (userName.trim().isEmpty() || password.trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter username and password", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Call DAO to check login
    UserDAO userDAO = new UserDAO();
    User loggedInUser = userDAO.login(userName, password);

    if (loggedInUser != null) {
        // Store logged in user in session
        UserSession.getInstance().setLoggedInUser(loggedInUser);
        
        JOptionPane.showMessageDialog(this, "Welcome " + loggedInUser.getFullname() + "!\nRole: " + loggedInUser.getRole());
        
        // Clear login fields
        UserNameTEXT.setText("");
        PasswordTEXT.setText("");
        
        // Apply access control to tabs (disable/enable based on role)
        applyAccessControl();
        
        // Switch to Report tab after login
        jTabbedPane1.setSelectedIndex(4);
        
    } else {
        JOptionPane.showMessageDialog(this, "Invalid username or password", "Login Failed", JOptionPane.ERROR_MESSAGE);
        UserNameTEXT.setText("");
        PasswordTEXT.setText("");
        UserNameTEXT.requestFocus();
    }
        
    }//GEN-LAST:event_LogInBtnActionPerformed

    private void RegisterationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterationActionPerformed
//        JOptionPane.showMessageDialog(this, "Registered user: " + FristNameTEXT.getText());
    // Get data from fields
                              
    String firstName = FristNameTEXT.getText().trim();
    String lastName = LastNameTEXT.getText().trim();
    String email = txtEmail.getText().trim();
    String password = new String(txtPassword.getPassword()).trim();      // 👈 جديد
    String confirmPassword = new String(txtConfirmPassword.getPassword()).trim(); // 👈 جديد
    String phone = PhoneTEXT.getText().trim();
    String address = AdderssTEXT.getText().trim();
    
    // Check if any field is empty
    if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || 
        password.isEmpty() || confirmPassword.isEmpty() || phone.isEmpty() || address.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please fill all fields", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    // Check if password matches confirm password
    if (!password.equals(confirmPassword)) {
        JOptionPane.showMessageDialog(this, "Password and Confirm Password do not match!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    // Check password length (at least 4 characters)
    if (password.length() < 4) {
        JOptionPane.showMessageDialog(this, "Password must be at least 4 characters", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    // Check if email is valid
    if (!email.contains("@")) {
        JOptionPane.showMessageDialog(this, "Please enter valid email address", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    // Create username from first name + last name
    String username = (firstName + lastName).toLowerCase();
    
    // Full name
    String fullName = firstName + " " + lastName;
    
    // Create User object
    User newUser = new User();
    newUser.setUsername(username);
    newUser.setPassword(password);  // 👈 الباسورد من الحقل
    newUser.setFullname(fullName);
    newUser.setRole("user");
    newUser.setEmail(email);
    newUser.setAddress(address);
    
    // Check if username already exists
    UserDAO userDAO = new UserDAO();
    if (userDAO.usernameExists(username)) {
        JOptionPane.showMessageDialog(this, "Username already exists! Try different name.\nUsername would be: " + username, "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    // Check if email already exists
    if (userDAO.emailExists(email)) {
        JOptionPane.showMessageDialog(this, "Email already registered! Please use another email.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    // Register the user
    if (userDAO.register(newUser)) {
        JOptionPane.showMessageDialog(this, "Registration successful!\n\nYour Username: " + username + "\nYour Password: " + password, "Success", JOptionPane.INFORMATION_MESSAGE);
        
        // Clear fields
        FristNameTEXT.setText("");
        LastNameTEXT.setText("");
        txtEmail.setText("");
        txtPassword.setText("");
        txtConfirmPassword.setText("");
        PhoneTEXT.setText("");
        AdderssTEXT.setText("");
        
        // Switch to Login tab
        jTabbedPane1.setSelectedIndex(0);
    } else {
        JOptionPane.showMessageDialog(this, "Registration failed! Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
    }

        
    }//GEN-LAST:event_RegisterationActionPerformed

    // Customer Actions
    private void btnCustAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustAddActionPerformed
          try {
        String name = txtCustName.getText().trim();
        String phone = txtCustPhone.getText().trim();
        String email = txtCustEmail.getText().trim();
        String address = txtCustAddress.getText().trim();
        
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter customer name");
            return;
        }
        
        Customer c = new Customer(name, phone, email, address);
        if (customerDAO.addCustomer(c)) {
            JOptionPane.showMessageDialog(this, "Customer added successfully");
            loadCustomers();
            clearCustomerFields();
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error adding customer: " + e.getMessage());
    }
    }//GEN-LAST:event_btnCustAddActionPerformed

    private void btnCustUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustUpdateActionPerformed
         try {
        if (selectedCustomerId == -1) {
            JOptionPane.showMessageDialog(this, "Please select a customer from the table first");
            return;
        }
        
        String name = txtCustName.getText().trim();
        String phone = txtCustPhone.getText().trim();
        String email = txtCustEmail.getText().trim();
        String address = txtCustAddress.getText().trim();
        
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter customer name");
            return;
        }
        
        Customer c = new Customer(name, phone, email, address);
        c.setCustomerId(selectedCustomerId);
        
        if (customerDAO.updateCustomer(c)) {
            JOptionPane.showMessageDialog(this, "Customer updated successfully");
            loadCustomers();
            clearCustomerFields();
            selectedCustomerId = -1;
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error updating customer: " + e.getMessage());
    }
    }//GEN-LAST:event_btnCustUpdateActionPerformed

    private void btnCustDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustDeleteActionPerformed
        try {
        if (selectedCustomerId == -1) {
            JOptionPane.showMessageDialog(this, "Please select a customer from the table first");
            return;
        }
        
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this customer?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            if (customerDAO.deleteCustomer(selectedCustomerId)) {
                JOptionPane.showMessageDialog(this, "Customer deleted successfully");
                loadCustomers();
                clearCustomerFields();
                selectedCustomerId = -1;
            }
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error deleting customer: " + e.getMessage());
    }
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
    txtFromDate.setText("");
    txtMaxSalee.setText("");
    txtMinSalee.setText("");
    txtAvgSalee.setText("");
    }//GEN-LAST:event_btnReportRefreshActionPerformed

    private void btnBackToLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackToLoginActionPerformed
        // TODO add your handling code here:
         jTabbedPane1.setSelectedIndex(0);
    }//GEN-LAST:event_btnBackToLoginActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        UserSession.getInstance().logout();
    applyAccessControl();
    jTabbedPane1.setSelectedIndex(0); // Switch to Login tab
    JOptionPane.showMessageDialog(this, "Logged out successfully");
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnFinishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinishActionPerformed
        // TODO add your handling code here:
          int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Exit", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        System.exit(0);
    }
    }//GEN-LAST:event_btnFinishActionPerformed

    private void btnLogoutProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutProductActionPerformed
        // TODO add your handling code here:
        UserSession.getInstance().logout();
    applyAccessControl();
    jTabbedPane1.setSelectedIndex(0);
    JOptionPane.showMessageDialog(this, "Logged out successfully");
    }//GEN-LAST:event_btnLogoutProductActionPerformed

    private void btnFinishProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinishProductActionPerformed
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit?", "Exit", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        System.exit(0);
    }
    }//GEN-LAST:event_btnFinishProductActionPerformed

    private void txtFromDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFromDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFromDateActionPerformed

    private void btnDateRangeFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDateRangeFilterActionPerformed
        // TODO add your handling code here:
        String fromDate = txtFromDate.getText().trim();
    String toDate = txtToDate.getText().trim();
    
    if (fromDate.isEmpty() && toDate.isEmpty()) {
        loadSales();
        return;
    }
    
    if (fromDate.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter From Date", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    if (toDate.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter To Date", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    // Load filtered sales by date range (without strict format check)
    DefaultTableModel model = (DefaultTableModel) tblSales.getModel();
    model.setRowCount(0);
    double total = 0;
    
    for (Sale s : saleDAO.getSalesByDateRange(fromDate, toDate)) {
        model.addRow(new Object[]{s.getSaleId(), s.getCustomerName(), s.getSaleDate(), s.getTotalAmount()});
        total += s.getTotalAmount();
    }
    txtTotalSales.setText(String.format("%.2f", total));
    
    txtMaxSalee.setText("");
    txtMinSalee.setText("");
    txtAvgSalee.setText("");
    }//GEN-LAST:event_btnDateRangeFilterActionPerformed

    private void btnMaxSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaxSaleActionPerformed
        // TODO add your handling code here:
         if (tblSales.getRowCount() == 0) {
        txtMaxSalee.setText("0");
        return;
    }
    double max = 0;
    for (int i = 0; i < tblSales.getRowCount(); i++) {
        double val = Double.parseDouble(tblSales.getValueAt(i, 3).toString());
        if (val > max) max = val;
    }
    txtMaxSalee.setText(String.format("%.2f", max));
    }//GEN-LAST:event_btnMaxSaleActionPerformed

    private void btnMinSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinSaleActionPerformed
        // TODO add your handling code here:
         if (tblSales.getRowCount() == 0) {
        txtMinSalee.setText("0");
        return;
    }
    double min = Double.MAX_VALUE;
    for (int i = 0; i < tblSales.getRowCount(); i++) {
        double val = Double.parseDouble(tblSales.getValueAt(i, 3).toString());
        if (val < min) min = val;
    }
    txtMinSalee.setText(String.format("%.2f", min));
    }//GEN-LAST:event_btnMinSaleActionPerformed

    private void btnAvgSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvgSaleActionPerformed
        // TODO add your handling code here:
          if (tblSales.getRowCount() == 0) {
        txtAvgSalee.setText("0");
        return;
    }
    double sum = 0;
    for (int i = 0; i < tblSales.getRowCount(); i++) {
        sum += Double.parseDouble(tblSales.getValueAt(i, 3).toString());
    }
    double avg = sum / tblSales.getRowCount();
    txtAvgSalee.setText(String.format("%.2f", avg));
    }//GEN-LAST:event_btnAvgSaleActionPerformed

    private void btnLogoutReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutReportActionPerformed
        // TODO add your handling code here:
        UserSession.getInstance().logout();
    applyAccessControl();
    jTabbedPane1.setSelectedIndex(0);
    JOptionPane.showMessageDialog(this, "Logged out successfully");
    }//GEN-LAST:event_btnLogoutReportActionPerformed

    private void btnFinishReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinishReportActionPerformed
        // TODO add your handling code here:
         int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to exit the application?", "Exit", JOptionPane.YES_NO_OPTION);
    if (confirm == JOptionPane.YES_OPTION) {
        System.exit(0);
    }
    }//GEN-LAST:event_btnFinishReportActionPerformed

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


    
    
    
    private void applyAccessControl() {
    boolean isLoggedIn = UserSession.getInstance().isLoggedIn();
    boolean isAdmin = UserSession.getInstance().isAdmin();
    
    // Tab 0 (Login) - only if NOT logged in
    jTabbedPane1.setEnabledAt(0, !isLoggedIn);
    
    // Tab 1 (Register) - only if NOT logged in
    jTabbedPane1.setEnabledAt(1, !isLoggedIn);
    
    // Tab 2 (Customer) - only admin
    jTabbedPane1.setEnabledAt(2, isLoggedIn && isAdmin);
    
    // Tab 3 (Product) - only admin
    jTabbedPane1.setEnabledAt(3, isLoggedIn && isAdmin);
    
    // Tab 4 (Report) - any logged in user
    jTabbedPane1.setEnabledAt(4, isLoggedIn);
}
    private void clearProductFields() {
    txtProdName.setText("");
    txtProdPrice.setText("");
    txtProdQty.setText("");
}

private void clearCustomerFields() {
    txtCustName.setText("");
    txtCustPhone.setText("");
    txtCustEmail.setText("");
    txtCustAddress.setText("");
}
//private boolean isValidDate(String date) {
//    // Allows format: YYYY-M-D or YYYY-MM-DD
//    return date.matches("\\d{4}-\\d{1,2}-\\d{1,2}");
//}




//    private javax.swing.JTextField txtEmail;
private javax.swing.JTextField txtFilterDate;
private javax.swing.JTextField txtMinSale;
private javax.swing.JTextField txtAvgSale;
private javax.swing.JTextField txtMaxSale;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AdderssTEXT;
    private javax.swing.JTextField FristNameTEXT;
    private javax.swing.JTextField LastNameTEXT;
    private javax.swing.JButton LogInBtn;
    private javax.swing.JPasswordField PasswordTEXT;
    private javax.swing.JTextField PhoneTEXT;
    private javax.swing.JButton Registeration;
    private javax.swing.JTextField UserNameTEXT;
    private javax.swing.JButton btnAvgSale;
    private javax.swing.JButton btnBackToLogin;
    private javax.swing.JButton btnCustAdd;
    private javax.swing.JButton btnCustDelete;
    private javax.swing.JButton btnCustUpdate;
    private javax.swing.JButton btnDateRangeFilter;
    private javax.swing.JButton btnFinish;
    private javax.swing.JButton btnFinishProduct;
    private javax.swing.JButton btnFinishReport;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnLogoutProduct;
    private javax.swing.JButton btnLogoutReport;
    private javax.swing.JButton btnMaxSale;
    private javax.swing.JButton btnMinSale;
    private javax.swing.JButton btnProdAdd;
    private javax.swing.JButton btnProdDelete;
    private javax.swing.JButton btnProdUpdate;
    private javax.swing.JButton btnReportRefresh;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblCustAddress;
    private javax.swing.JLabel lblCustEmail;
    private javax.swing.JLabel lblCustName;
    private javax.swing.JLabel lblCustPhone;
    private javax.swing.JLabel lblFromDate;
    private javax.swing.JLabel lblProdName;
    private javax.swing.JLabel lblProdPrice;
    private javax.swing.JLabel lblProdQty;
    private javax.swing.JLabel lblToDate;
    private javax.swing.JLabel lblTotalSales;
    private javax.swing.JPanel tabCustomer;
    private javax.swing.JPanel tabLogin;
    private javax.swing.JPanel tabProduct;
    private javax.swing.JPanel tabRegister;
    private javax.swing.JPanel tabReport;
    private javax.swing.JTable tblCustomers;
    private javax.swing.JTable tblProducts;
    private javax.swing.JTable tblSales;
    private javax.swing.JTextField txtAvgSalee;
    private javax.swing.JPasswordField txtConfirmPassword;
    private javax.swing.JTextField txtCustAddress;
    private javax.swing.JTextField txtCustEmail;
    private javax.swing.JTextField txtCustName;
    private javax.swing.JTextField txtCustPhone;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtFromDate;
    private javax.swing.JTextField txtMaxSalee;
    private javax.swing.JTextField txtMinSalee;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtProdName;
    private javax.swing.JTextField txtProdPrice;
    private javax.swing.JTextField txtProdQty;
    private javax.swing.JTextField txtToDate;
    private javax.swing.JTextField txtTotalSales;
    // End of variables declaration//GEN-END:variables
}
