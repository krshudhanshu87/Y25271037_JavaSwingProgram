import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Y25271037Stopwatch extends JFrame {
    private JLabel timeLabel;
    private JButton startButton, stopButton, resetButton, lapButton;
    private JTextArea lapArea;
    private Timer timer;
    private int elapsedTime = 0; // in milliseconds
    private int lapCount = 0;

    public Y25271037Stopwatch() {
        setTitle("Stopwatch Application");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        timeLabel = new JLabel("00:00:00", SwingConstants.CENTER);
        timeLabel.setFont(new Font("Arial", Font.BOLD, 40));

        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        resetButton = new JButton("Reset");
        lapButton = new JButton("Lap");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);
        buttonPanel.add(resetButton);
        buttonPanel.add(lapButton);

        lapArea = new JTextArea();
        lapArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(lapArea);

        add(timeLabel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        // Timer updates every 1 second
        timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                elapsedTime += 1000;
                updateTimeLabel();
            }
        });

        // Start
        startButton.addActionListener(e -> timer.start());

        // Stop
        stopButton.addActionListener(e -> timer.stop());

        // Reset
        resetButton.addActionListener(e -> {
            timer.stop();
            elapsedTime = 0;
            lapCount = 0;
            updateTimeLabel();
            lapArea.setText("");
        });

        // Lap
        lapButton.addActionListener(e -> {
            lapCount++;
            lapArea.append("Lap " + lapCount + ": " + formatTime(elapsedTime) + "\n");
        });
    }

    private void updateTimeLabel() {
        timeLabel.setText(formatTime(elapsedTime));
    }

    private String formatTime(int millis) {
        int seconds = millis / 1000;
        int minutes = seconds / 60;
        int hours = minutes / 60;
        seconds %= 60;
        minutes %= 60;
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Y25271037Stopwatch().setVisible(true));
    }
}