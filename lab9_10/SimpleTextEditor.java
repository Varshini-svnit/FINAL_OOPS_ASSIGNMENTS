package gui;

        import javax.swing.*;
        import java.awt.*;
        import java.awt.event.*;
        import java.io.*;

        public class SimpleTextEditor extends JFrame {

            private JTextArea textArea;
            private JTextField statusBar;
            private String currentFile = null; // Track the current file for save and open

            public SimpleTextEditor() {
                // Set up the frame
                setTitle("Simple Text Editor");
                setSize(600, 400);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                // Create the text area with scroll pane
                textArea = new JTextArea();
                textArea.setFont(new Font("Arial", Font.PLAIN, 14));
                JScrollPane scrollPane = new JScrollPane(textArea);
                add(scrollPane, BorderLayout.CENTER);

                // Create the status bar
                statusBar = new JTextField("Character Count: 0 | Line Count: 0");
                statusBar.setEditable(false);
                add(statusBar, BorderLayout.SOUTH);

                // Create the menu bar
                JMenuBar menuBar = new JMenuBar();
                JMenu fileMenu = new JMenu("File");
                JMenuItem openItem = new JMenuItem("Open");
                JMenuItem saveItem = new JMenuItem("Save");
                JMenuItem saveAsItem = new JMenuItem("Save As");
                JMenuItem clearItem = new JMenuItem("Clear");
                JMenuItem exitItem = new JMenuItem("Exit");
                fileMenu.setSize(200,100);
                // Add menu items to the file menu
                fileMenu.add(openItem);
                fileMenu.add(saveItem);
                fileMenu.add(saveAsItem);
                fileMenu.add(clearItem);
                fileMenu.addSeparator();
                fileMenu.add(exitItem);
                menuBar.add(fileMenu);
                setJMenuBar(menuBar);

                // Set action listeners for menu items
                openItem.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        openFile();
                    }
                });

                saveItem.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        saveFile();
                    }
                });

                saveAsItem.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        saveFileAs();
                    }
                });

                clearItem.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        clearText();
                    }
                });

                exitItem.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        System.exit(0);
                    }
                });

                // Update the status bar when the text is changed
                textArea.addCaretListener(e -> updateStatusBar());

                // Make the frame visible
                setVisible(true);
            }

            // Method to open a file
            private void openFile() {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    currentFile = file.getAbsolutePath();
                    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                        textArea.read(reader, null);
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(this, "Error opening file.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }

            // Method to save a file
            private void saveFile() {
                if (currentFile == null) {
                    saveFileAs();  // If no file is selected, prompt for "Save As"
                } else {
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(currentFile))) {
                        textArea.write(writer);
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(this, "Error saving file.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }

            // Method to save a file with a "Save As" option
            private void saveFileAs() {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showSaveDialog(this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    currentFile = file.getAbsolutePath();
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                        textArea.write(writer);
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(this, "Error saving file.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }

            // Method to clear the text area
            private void clearText() {
                textArea.setText("");
                currentFile = null;
            }

            // Method to update the status bar
            private void updateStatusBar() {
                int charCount = textArea.getText().length();
                int lineCount = textArea.getLineCount();
                statusBar.setText("Character Count: " + charCount + " | Line Count: " + lineCount);
            }

            // Main method to launch the text editor
            public static void main(String[] args) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        new SimpleTextEditor();
                    }
                });
            }
        }
     
