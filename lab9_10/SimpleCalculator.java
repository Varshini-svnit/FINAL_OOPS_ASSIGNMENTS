package lab1.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleCalculator extends JFrame {
    
    // Declare components
    private JTextField display;
    private String currentText = "";
    
    public SimpleCalculator() {
        // Set up the frame
        setTitle("Simple Calculator");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window
        
        // Initialize the display field
        display = new JTextField();
        display.setFont(new Font("Arial", Font.PLAIN, 24));
        display.setEditable(false);
        
        // Create a panel for buttons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4, 10, 10)); // 5 rows and 4 columns
        
        // Button labels
        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
        };
        
        // Add buttons to the panel
        for (String label : buttons) {
            JButton button = new JButton(label);
            panel.add(button);
            button.addActionListener(new ButtonActionListener());
        }
        
        // Add a FocusListener to the display field
        display.addFocusListener(new DisplayFocusListener());
        
        // Add a KeyListener to the frame for keyboard input
        this.addKeyListener(new CalculatorKeyListener());
        this.setFocusable(true);
        
        // Set layout and add components to the frame
        this.setLayout(new BorderLayout());
        this.add(display, BorderLayout.NORTH);
        this.add(panel, BorderLayout.CENTER);
    }
    
    // ActionListener for button clicks
    private class ButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            
            if (command.equals("=")) {
                try {
                    currentText = evaluateExpression(currentText);
                } catch (Exception ex) {
                    currentText = "Error";
                }
            } else {
                currentText += command;
            }
            display.setText(currentText);
        }
    }
    
    // Evaluate the arithmetic expression
    private String evaluateExpression(String expression) {
        try {
            return String.valueOf(new ScriptEngineManager().getEngineByName("JavaScript").eval(expression));
        } catch (Exception e) {
            return "Error";
        }
    }
    
    // FocusListener to clear the display if it loses focus
    private class DisplayFocusListener implements FocusListener {
        @Override
        public void focusGained(FocusEvent e) {
            // Do nothing on gaining focus
        }

        @Override
        public void focusLost(FocusEvent e) {
            // Optionally, clear the display if it loses focus
            currentText = "";
            display.setText(currentText);
        }
    }
    
    // KeyListener for keyboard input
    private class CalculatorKeyListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {
            char c = e.getKeyChar();
            if (Character.isDigit(c) || c == '+' || c == '-' || c == '*' || c == '/' || c == '.') {
                currentText += c;
                display.setText(currentText);
            }
            if (c == '\n') { // Enter key
                try {
                    currentText = evaluateExpression(currentText);
                } catch (Exception ex) {
                    currentText = "Error";
                }
                display.setText(currentText);
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {
            // Optional: handle key pressed events if needed
        }

        @Override
        public void keyReleased(KeyEvent e) {
            // Optional: handle key released events if needed
        }
    }

    // Main method to run the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SimpleCalculator().setVisible(true);
        });
    }
}
