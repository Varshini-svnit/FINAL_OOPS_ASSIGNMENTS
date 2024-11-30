package gui;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DigitalCalculator extends JFrame {
    private JTextField display;
    private String currentInput = "";  // Store the current input (expression)
    private double result = 0;         // Store the result of calculations
    private String lastOperation = "="; // Store the last operation (used for calculation)

    public DigitalCalculator() {
        // Set up the frame
        setTitle("Digital Calculator");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create the display area (JTextField) with a digital look
        display = new JTextField();
        display.setFont(new Font("Digital-7", Font.PLAIN, 48));  // Use a digital-style font
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        display.setBackground(Color.BLACK);
        display.setForeground(Color.GREEN);  // Green text for a digital look
        add(display, BorderLayout.NORTH);

        // Create the panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 10, 10));  // 5 rows, 4 columns

        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "C", "0", "=", "+",
            "(", ")", "", ""
        };

        // Create buttons and add ActionListeners
        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.PLAIN, 24));
            button.setBackground(Color.BLACK);
            button.setForeground(Color.WHITE);  // White text on black buttons
            button.addActionListener(new ButtonClickListener());
            button.addKeyListener(new CalculatorKeyListener());
            button.addFocusListener(new ButtonFocusListener());
            buttonPanel.add(button);
        }

        // Add the button panel to the frame
        add(buttonPanel, BorderLayout.CENTER);

        // Add keyboard listener to the frame
        addKeyListener(new CalculatorKeyListener());
        setFocusable(true); // Makes sure the frame can listen for key events
    }

    // Handle the button click event
    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command.equals("C")) {
                // Clear the display
                currentInput = "";
                result = 0;
                lastOperation = "=";
            } else if (command.equals("=")) {
                // Perform the calculation when "=" is pressed
                calculate();
            } else {
                // For number and operator buttons, append to the current input
                currentInput += command;
            }
            display.setText(currentInput);
        }
    }

    // KeyListener for keyboard input
    private class CalculatorKeyListener extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            char key = e.getKeyChar();
            if (Character.isDigit(key) || key == '+' || key == '-' || key == '*' || key == '/') {
                currentInput += key;
            } else if (key == '=' || key == '\n') {
                calculate();
            } else if (key == 'c' || key == 'C') {
                currentInput = "";
                result = 0;
                lastOperation = "=";
            }
            display.setText(currentInput);
        }
    }

    // FocusListener to highlight the display when focused
    private class ButtonFocusListener implements FocusListener {
        public void focusGained(FocusEvent e) {
            JButton source = (JButton) e.getSource();
            source.setBackground(Color.CYAN); // Change color when focused
        }

        public void focusLost(FocusEvent e) {
            JButton source = (JButton) e.getSource();
            source.setBackground(Color.BLACK); // Reset color when focus is lost
        }
    }

    // Perform the calculation based on the current input and last operation
    private void calculate() {
        try {
            if (lastOperation.equals("=")) {
                result = Double.parseDouble(currentInput);
            } else if (lastOperation.equals("+")) {
                result += Double.parseDouble(currentInput);
            } else if (lastOperation.equals("-")) {
                result -= Double.parseDouble(currentInput);
            } else if (lastOperation.equals("*")) {
                result *= Double.parseDouble(currentInput);
            } else if (lastOperation.equals("/")) {
                if (Double.parseDouble(currentInput) != 0) {
                    result /= Double.parseDouble(currentInput);
                } else {
                    display.setText("Error");
                    return;
                }
            }

            // Update the current input with the result
            currentInput = String.valueOf(result);
            display.setText(currentInput);
            lastOperation = "="; // Reset the last operation
        } catch (Exception e) {
            display.setText("Error");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new DigitalCalculator().setVisible(true);
            }
        });
    }
}
