package ui;

import dao.CustomerDAO;
import models.Customer;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class CustomerFrame extends JPanel {

    // ── DAO ───────────────────────────────────────────────────────────────────
    private final CustomerDAO customerDAO = new CustomerDAO();

    // ── Form Fields ───────────────────────────────────────────────────────────
    private JTextField txtCustomerId;
    private JTextField txtName;
    private JTextField txtPhone;
    private JTextField txtEmail;
    private JTextField txtAddress;
    private JLabel     lblStatus;

    // ── Table ─────────────────────────────────────────────────────────────────
    private JTable            table;
    private DefaultTableModel tableModel;

    // ── Buttons ───────────────────────────────────────────────────────────────
    private JButton btnAdd;
    private JButton btnUpdate;
    private JButton btnDelete;
    private JButton btnClear;
    private JButton btnRefresh;

    // ── Colors ────────────────────────────────────────────────────────────────
    private static final Color C_BG        = new Color(245, 246, 250);
    private static final Color C_HEADER    = new Color(24,  95, 165);
    private static final Color C_HEADER_FG = new Color(230, 241, 251);
    private static final Color C_FIELD_BG  = Color.WHITE;
    private static final Color C_BORDER    = new Color(181, 212, 244);
    private static final Color C_LABEL     = new Color(90,  100, 120);
    private static final Color C_BTN_ADD   = new Color(24,  95, 165);
    private static final Color C_BTN_UPD   = new Color(15, 110,  86);
    private static final Color C_BTN_DEL   = new Color(163,  45,  45);
    private static final Color C_BTN_FG    = new Color(230, 241, 251);
    private static final Color C_OK        = new Color(59, 109,  17);
    private static final Color C_ERR       = new Color(163,  45,  45);
    private static final Color C_ROW_SEL   = new Color(181, 212, 244);
    private static final Color C_ROW_ALT   = new Color(235, 241, 250);

    // ── Constructor ───────────────────────────────────────────────────────────
    public CustomerFrame() {
        setLayout(new BorderLayout(0, 0));
        setBackground(C_BG);

        add(buildHeader(),    BorderLayout.NORTH);
        add(buildCenter(),    BorderLayout.CENTER);
        add(buildButtonBar(), BorderLayout.SOUTH);

        wireListeners();
        refreshTable();
    }

    // =========================================================================
    // Header
    // =========================================================================
    private JPanel buildHeader() {
        JPanel h = new JPanel(new BorderLayout());
        h.setBackground(C_HEADER);
        h.setBorder(BorderFactory.createEmptyBorder(13, 20, 13, 20));

        JLabel title = new JLabel("Customer Management");
        title.setFont(new Font("Segoe UI", Font.BOLD, 17));
        title.setForeground(C_HEADER_FG);

        JLabel sub = new JLabel("Full CRUD  ·  models.Customer  ·  dao.CustomerDAO");
        sub.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        sub.setForeground(new Color(181, 212, 244));

        JPanel tb = new JPanel();
        tb.setOpaque(false);
        tb.setLayout(new BoxLayout(tb, BoxLayout.Y_AXIS));
        tb.add(title);
        tb.add(Box.createVerticalStrut(3));
        tb.add(sub);
        h.add(tb, BorderLayout.WEST);
        return h;
    }

    // =========================================================================
    // Center: form (left) + table (right)
    // =========================================================================
    private JSplitPane buildCenter() {
        JSplitPane split = new JSplitPane(
            JSplitPane.HORIZONTAL_SPLIT, buildForm(), buildTable());
        split.setDividerLocation(300);
        split.setDividerSize(4);
        split.setBorder(null);
        split.setResizeWeight(0.35);
        return split;
    }

    // ── Form ──────────────────────────────────────────────────────────────────
    private JPanel buildForm() {
        JPanel outer = new JPanel(new BorderLayout());
        outer.setBackground(C_BG);
        outer.setBorder(BorderFactory.createEmptyBorder(18, 20, 10, 14));

        JLabel formTitle = new JLabel("Customer Details");
        formTitle.setFont(new Font("Segoe UI", Font.BOLD, 13));
        formTitle.setForeground(C_HEADER);
        formTitle.setBorder(BorderFactory.createEmptyBorder(0, 0, 12, 0));

        JPanel grid = new JPanel(new GridBagLayout());
        grid.setBackground(C_BG);
        GridBagConstraints gc = new GridBagConstraints();
        gc.fill    = GridBagConstraints.HORIZONTAL;
        gc.weightx = 1;

        txtCustomerId = makeField(true);
        txtCustomerId.setText("(auto)");
        addRow(grid, gc, 0, "Customer ID", txtCustomerId);

        txtName    = makeField(false); addRow(grid, gc, 1, "Full Name *", txtName);
        txtPhone   = makeField(false); addRow(grid, gc, 2, "Phone",       txtPhone);
        txtEmail   = makeField(false); addRow(grid, gc, 3, "Email",       txtEmail);
        txtAddress = makeField(false); addRow(grid, gc, 4, "Address",     txtAddress);

        lblStatus = new JLabel(" ");
        lblStatus.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        gc.gridy = 5; gc.gridx = 0; gc.gridwidth = 2;
        gc.insets = new Insets(10, 0, 0, 0);
        grid.add(lblStatus, gc);

        outer.add(formTitle, BorderLayout.NORTH);
        outer.add(grid,      BorderLayout.CENTER);
        return outer;
    }

    private void addRow(JPanel grid, GridBagConstraints gc,
                        int row, String lbl, JTextField tf) {
        gc.gridy = row; gc.gridwidth = 1;

        gc.gridx = 0; gc.weightx = 0;
        gc.insets = new Insets(5, 0, 5, 10);
        JLabel label = new JLabel(lbl);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        label.setForeground(C_LABEL);
        label.setPreferredSize(new Dimension(100, 22));
        grid.add(label, gc);

        gc.gridx = 1; gc.weightx = 1;
        gc.insets = new Insets(5, 0, 5, 0);
        grid.add(tf, gc);
    }

    private JTextField makeField(boolean readOnly) {
        JTextField tf = new JTextField();
        tf.setFont(new Font("Segoe UI Mono", Font.PLAIN, 13));
        tf.setBackground(readOnly ? C_BG : C_FIELD_BG);
        tf.setForeground(readOnly ? C_LABEL : Color.BLACK);
        tf.setEditable(!readOnly);
        tf.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(C_BORDER, 1, true),
            BorderFactory.createEmptyBorder(5, 9, 5, 9)
        ));
        tf.setPreferredSize(new Dimension(0, 32));
        return tf;
    }

    // ── Table ─────────────────────────────────────────────────────────────────
    private JPanel buildTable() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(C_BG);
        panel.setBorder(BorderFactory.createEmptyBorder(18, 6, 10, 18));

        JLabel tblTitle = new JLabel("All Customers");
        tblTitle.setFont(new Font("Segoe UI", Font.BOLD, 13));
        tblTitle.setForeground(C_HEADER);
        tblTitle.setBorder(BorderFactory.createEmptyBorder(0, 0, 12, 0));

        String[] cols = {"ID", "Name", "Phone", "Email", "Address"};
        tableModel = new DefaultTableModel(cols, 0) {
            public boolean isCellEditable(int r, int c) { return false; }
        };

        table = new JTable(tableModel);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        table.setRowHeight(28);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setSelectionBackground(C_ROW_SEL);
        table.setSelectionForeground(Color.BLACK);
        table.setShowGrid(false);
        table.setIntercellSpacing(new Dimension(0, 0));
        table.setBorder(null);
        table.setFillsViewportHeight(true);

        // Alternating row renderer
        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable t, Object v,
                    boolean sel, boolean foc, int r, int c) {
                super.getTableCellRendererComponent(t, v, sel, foc, r, c);
                setBorder(BorderFactory.createEmptyBorder(0, 8, 0, 8));
                if (!sel) setBackground(r % 2 == 0 ? C_FIELD_BG : C_ROW_ALT);
                return this;
            }
        });

        // Header style
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Segoe UI", Font.BOLD, 12));
        header.setBackground(new Color(210, 225, 245));
        header.setForeground(new Color(30, 60, 100));
        header.setReorderingAllowed(false);
        header.setBorder(new MatteBorder(0, 0, 1, 0, C_BORDER));

        // Column widths
        int[] widths = {45, 130, 100, 160, 160};
        for (int i = 0; i < widths.length; i++)
            table.getColumnModel().getColumn(i).setPreferredWidth(widths[i]);

        JScrollPane scroll = new JScrollPane(table);
        scroll.setBorder(new LineBorder(C_BORDER, 1, true));
        scroll.getViewport().setBackground(C_FIELD_BG);

        panel.add(tblTitle, BorderLayout.NORTH);
        panel.add(scroll,   BorderLayout.CENTER);
        return panel;
    }

    // =========================================================================
    // Button bar
    // =========================================================================
    private JPanel buildButtonBar() {
        JPanel bar = new JPanel(new FlowLayout(FlowLayout.RIGHT, 8, 12));
        bar.setBackground(C_BG);
        bar.setBorder(new MatteBorder(1, 0, 0, 0, C_BORDER));

        btnRefresh = makeBtn("↻  Refresh", C_FIELD_BG, C_LABEL);
        btnClear   = makeBtn("Clear",      C_FIELD_BG, C_LABEL);
        btnDelete  = makeBtn("Delete",     C_BTN_DEL,  C_BTN_FG);
        btnUpdate  = makeBtn("Update",     C_BTN_UPD,  C_BTN_FG);
        btnAdd     = makeBtn("Add New",    C_BTN_ADD,  C_BTN_FG);
        btnAdd.setFont(new Font("Segoe UI", Font.BOLD, 13));

        bar.add(btnRefresh);
        bar.add(btnClear);
        bar.add(Box.createHorizontalStrut(10));
        bar.add(btnDelete);
        bar.add(btnUpdate);
        bar.add(btnAdd);
        return bar;
    }

    private JButton makeBtn(String text, Color bg, Color fg) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        btn.setBackground(bg);
        btn.setForeground(fg);
        btn.setFocusPainted(false);
        btn.setOpaque(true);
        btn.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(bg.equals(C_FIELD_BG) ? C_BORDER : bg.darker(), 1, true),
            BorderFactory.createEmptyBorder(7, 18, 7, 18)
        ));
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Color hover = bg.equals(C_FIELD_BG)
            ? new Color(225, 233, 245) : bg.darker();
        btn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) { btn.setBackground(hover); }
            public void mouseExited(MouseEvent e)  { btn.setBackground(bg);    }
        });
        return btn;
    }

    // =========================================================================
    // Listeners
    // =========================================================================
    private void wireListeners() {
        btnAdd.addActionListener(e     -> onAdd());
        btnUpdate.addActionListener(e  -> onUpdate());
        btnDelete.addActionListener(e  -> onDelete());
        btnClear.addActionListener(e   -> onClear());
        btnRefresh.addActionListener(e -> refreshTable());

        // Clicking a table row populates the form (READ)
        table.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) onRowSelected();
        });
    }

    // =========================================================================
    // CRUD Operations
    // =========================================================================

    /** CREATE */
    private void onAdd() {
        if (!validateName()) return;
        Customer c = buildCustomerFromForm();
        if (customerDAO.addCustomer(c)) {
            setStatus("Customer added successfully.", true);
            onClear();
            refreshTable();
        } else {
            setStatus("Failed to add customer.", false);
        }
    }

    /** READ — triggered by table row click */
    private void onRowSelected() {
        int row = table.getSelectedRow();
        if (row < 0) return;
        txtCustomerId.setText(tableModel.getValueAt(row, 0).toString());
        txtName.setText(safeCell(row, 1));
        txtPhone.setText(safeCell(row, 2));
        txtEmail.setText(safeCell(row, 3));
        txtAddress.setText(safeCell(row, 4));
        lblStatus.setText(" ");
    }

    /** UPDATE */
    private void onUpdate() {
        String idText = txtCustomerId.getText().trim();
        if (idText.isEmpty() || idText.equals("(auto)")) {
            setStatus("Select a customer from the table first.", false);
            return;
        }
        if (!validateName()) return;
        try {
            int id = Integer.parseInt(idText);
            Customer c = buildCustomerFromForm();
            c.setCustomerId(id);
            if (customerDAO.updateCustomer(c)) {
                setStatus("Customer updated (ID " + id + ").", true);
                refreshTable();
            } else {
                setStatus("Update failed — customer not found.", false);
            }
        } catch (NumberFormatException ex) {
            setStatus("Invalid customer ID.", false);
        }
    }

    /** DELETE */
    private void onDelete() {
        String idText = txtCustomerId.getText().trim();
        if (idText.isEmpty() || idText.equals("(auto)")) {
            setStatus("Select a customer from the table first.", false);
            return;
        }
        try {
            int id = Integer.parseInt(idText);
            int confirm = JOptionPane.showConfirmDialog(
                this,
                "Delete customer ID " + id + "?\nThis cannot be undone.",
                "Confirm Delete",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
            );
            if (confirm != JOptionPane.YES_OPTION) return;

            if (customerDAO.deleteCustomer(id)) {
                setStatus("Customer deleted (ID " + id + ").", true);
                onClear();
                refreshTable();
            } else {
                setStatus("Delete failed — customer not found.", false);
            }
        } catch (NumberFormatException ex) {
            setStatus("Invalid customer ID.", false);
        }
    }

    /** Clear form */
    private void onClear() {
        txtCustomerId.setText("(auto)");
        txtName.setText("");
        txtPhone.setText("");
        txtEmail.setText("");
        txtAddress.setText("");
        table.clearSelection();
        lblStatus.setText(" ");
    }

    /** Reload table from DB */
    private void refreshTable() {
        tableModel.setRowCount(0);
        try {
            List<Customer> list = customerDAO.getAllCustomers();
            for (Customer c : list) {
                tableModel.addRow(new Object[]{
                    c.getCustomerId(),
                    c.getName(),
                    c.getPhone(),
                    c.getEmail(),
                    c.getAddress()
                });
            }
        } catch (Exception ex) {
            setStatus("Could not load customers: " + ex.getMessage(), false);
        }
    }

    // =========================================================================
    // Helpers
    // =========================================================================
    private boolean validateName() {
        if (txtName.getText().trim().isEmpty()) {
            setStatus("Full Name is required.", false);
            txtName.requestFocus();
            return false;
        }
        return true;
    }

    private Customer buildCustomerFromForm() {
        return new Customer(
            txtName.getText().trim(),
            txtPhone.getText().trim(),
            txtEmail.getText().trim(),
            txtAddress.getText().trim()
        );
    }

    private String safeCell(int row, int col) {
        Object v = tableModel.getValueAt(row, col);
        return v != null ? v.toString() : "";
    }

    private void setStatus(String msg, boolean ok) {
        lblStatus.setText(msg);
        lblStatus.setForeground(ok ? C_OK : C_ERR);
    }

    // =========================================================================
    // Standalone test
    // =========================================================================
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Customer Management");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(new CustomerFrame());
            frame.setSize(900, 500);
            frame.setMinimumSize(new Dimension(700, 420));
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}