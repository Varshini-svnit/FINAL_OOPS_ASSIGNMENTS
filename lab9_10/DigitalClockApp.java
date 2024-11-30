package gui;


import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;

public class DigitalClockApp extends JFrame {

    private JLabel timeLabel;
    private SimpleDateFormat timeFormat;
    private Timer timer;

    public DigitalClockApp() {
        // Set up the JFrame
        setTitle("Digital Clock");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create the JLabel for displaying the time
        timeLabel = new JLabel("00:00:00", JLabel.CENTER);
        timeLabel.setFont(new Font("Digital-7", Font.PLAIN, 48)); // Use a digital font
        add(timeLabel, BorderLayout.CENTER);

        // Set the time format for hours, minutes, and seconds
        timeFormat = new SimpleDateFormat("HH:mm:ss");

        // Initialize and start the timer to update the time every second
        timer = new Timer(1000, e -> updateTime());
        timer.start();
    }

    // Method to update the time displayed on the JLabel
    private void updateTime() {
        // Get the current time
        String currentTime = timeFormat.format(new Date());
        timeLabel.setText(currentTime); // Update the JLabel text with the new time
    }

    // Main method to run the application
    public static void main(String[] args) {
        // Run the clock on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            DigitalClockApp clock = new DigitalClockApp();
            clock.setVisible(true); // Make the frame visible
        });
    }
}
