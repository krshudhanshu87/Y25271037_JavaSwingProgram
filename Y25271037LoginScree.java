import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Y25271037LoginScree extends JFrame implements ActionListener {

    // Components
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public Y25271037LoginScree() {
        // Frame settings
        setTitle("Hi, Login Here");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window

        // Panel for form
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));

        // Username
        panel.add(new JLabel("Username:"));
        usernameField = new JTextField();
        panel.add(usernameField);

        // Password
        panel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        panel.add(passwordField);

        // Empty cell
        panel.add(new JLabel(""));

        // Login button
        loginButton = new JButton("Login");
        loginButton.addActionListener(this);
        panel.add(loginButton);

        // Add panel to frame
        add(panel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (username.equals("admin") && password.equals("1234")) {
            JOptionPane.showMessageDialog(this, "Login Successful!");
        } else {
            JOptionPane.showMessageDialog(this, "Invalid Username or Password!");
        }
    }

    public static void main(String[] args) {
        new Y25271037LoginScree();
    }
}