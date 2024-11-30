package lab1.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginRegisterApp extends JFrame {
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private JTextField usernameField, emailField;
    private JPasswordField passwordField, confirmPasswordField;
    private JButton loginButton, registerButton, submitRegisterButton, backToLoginButton;
    
    public LoginRegisterApp() {
        setTitle("Login and Registration");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Login Panel
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(3, 2));
        loginPanel.add(new JLabel("Username:"));
        usernameField = new JTextField();
        loginPanel.add(usernameField);
        loginPanel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        loginPanel.add(passwordField);
        loginButton = new JButton("Login");
        loginPanel.add(loginButton);
        
        registerButton = new JButton("Register");
        loginPanel.add(registerButton);
        
        // Registration Panel
        JPanel registerPanel = new JPanel();
        registerPanel.setLayout(new GridLayout(4, 2));
        registerPanel.add(new JLabel("Username:"));
        usernameField = new JTextField();
        registerPanel.add(usernameField);
        registerPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        registerPanel.add(emailField);
        registerPanel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        registerPanel.add(passwordField);
        registerPanel.add(new JLabel("Confirm Password:"));
        confirmPasswordField = new JPasswordField();
        registerPanel.add(confirmPasswordField);
        submitRegisterButton = new JButton("Register");
        registerPanel.add(submitRegisterButton);
        backToLoginButton = new JButton("Back to Login");
        registerPanel.add(backToLoginButton);

        cardPanel.add(loginPanel, "Login");
        cardPanel.add(registerPanel, "Register");
        add(cardPanel);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                
                if (DBHelper.authenticateUser(username, password)) {
                    JOptionPane.showMessageDialog(LoginRegisterApp.this, "Login successful!");
                } else {
                    JOptionPane.showMessageDialog(LoginRegisterApp.this, "Invalid credentials, try again.");
                }
            }
        });

        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Register");
            }
        });

        submitRegisterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());
                String confirmPassword = new String(confirmPasswordField.getPassword());
                
                if (DBHelper.isUserExists(username)) {
                    JOptionPane.showMessageDialog(LoginRegisterApp.this, "Username already exists.");
                } else if (!password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(LoginRegisterApp.this, "Passwords do not match.");
                } else if (DBHelper.registerUser(username, password, email)) {
                    JOptionPane.showMessageDialog(LoginRegisterApp.this, "Registration successful!");
                    cardLayout.show(cardPanel, "Login");
                } else {
                    JOptionPane.showMessageDialog(LoginRegisterApp.this, "Registration failed.");
                }
            }
        });

        backToLoginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Login");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LoginRegisterApp().setVisible(true);
        });
    }
}
