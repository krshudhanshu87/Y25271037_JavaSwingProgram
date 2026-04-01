import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class Y25271037AddressBook extends JFrame {
    private JTable contactTable;
    private DefaultTableModel tableModel;
    private JTextField nameField, phoneField, emailField;
    private JButton addButton, editButton, deleteButton, resetButton;

    public Y25271037AddressBook() {
        setTitle("Contact / Address Book");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Table model with columns
        tableModel = new DefaultTableModel(new String[]{"Name", "Phone", "Email"}, 0);
        contactTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(contactTable);

        // Input fields
        nameField = new JTextField(10);
        phoneField = new JTextField(10);
        emailField = new JTextField(15);

        JPanel inputPanel = new JPanel(new FlowLayout());
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Phone:"));
        inputPanel.add(phoneField);
        inputPanel.add(new JLabel("Email:"));
        inputPanel.add(emailField);

        // Buttons
        addButton = new JButton("Add");
        editButton = new JButton("Edit");
        deleteButton = new JButton("Delete");
        resetButton = new JButton("Reset");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(resetButton);

        add(new JLabel("Contact / Address Book", SwingConstants.CENTER), BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);
        add(buttonPanel, BorderLayout.PAGE_END);

        // Add contact
        addButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            String phone = phoneField.getText().trim();
            String email = emailField.getText().trim();

            if (!name.isEmpty() && !phone.isEmpty() && !email.isEmpty()) {
                tableModel.addRow(new Object[]{name, phone, email});
                clearFields();
            } else {
                JOptionPane.showMessageDialog(this, "All fields are required!", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        });

        // Edit contact
        editButton.addActionListener(e -> {
            int selectedRow = contactTable.getSelectedRow();
            if (selectedRow != -1) {
                tableModel.setValueAt(nameField.getText().trim(), selectedRow, 0);
                tableModel.setValueAt(phoneField.getText().trim(), selectedRow, 1);
                tableModel.setValueAt(emailField.getText().trim(), selectedRow, 2);
                clearFields();
            } else {
                JOptionPane.showMessageDialog(this, "Select a contact to edit!", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        });

        // Delete contact
        deleteButton.addActionListener(e -> {
            int selectedRow = contactTable.getSelectedRow();
            if (selectedRow != -1) {
                tableModel.removeRow(selectedRow);
            } else {
                JOptionPane.showMessageDialog(this, "Select a contact to delete!", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        });

        // Reset fields
        resetButton.addActionListener(e -> clearFields());

        // Fill fields when selecting a row
        contactTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int selectedRow = contactTable.getSelectedRow();
                if (selectedRow != -1) {
                    nameField.setText(tableModel.getValueAt(selectedRow, 0).toString());
                    phoneField.setText(tableModel.getValueAt(selectedRow, 1).toString());
                    emailField.setText(tableModel.getValueAt(selectedRow, 2).toString());
                }
            }
        });
    }

    private void clearFields() {
        nameField.setText("");
        phoneField.setText("");
        emailField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Y25271037AddressBook().setVisible(true));
    }
}