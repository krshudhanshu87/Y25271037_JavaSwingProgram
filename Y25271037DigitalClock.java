import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;

public class Y25271037DigitalClock extends JFrame {
    private JLabel clockLabel;
    private JLabel dateLabel;
    private Timer timer;

    public Y25271037DigitalClock() {
        setTitle("Digital Clock");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 1));

        clockLabel = new JLabel("", SwingConstants.CENTER);
        clockLabel.setFont(new Font("Arial", Font.BOLD, 40));

        dateLabel = new JLabel("", SwingConstants.CENTER);
        dateLabel.setFont(new Font("Arial", Font.PLAIN, 20));

        add(clockLabel);
        add(dateLabel);

        // Timer updates every second
        timer = new Timer(1000, e -> updateClock());
        timer.start();

        updateClock(); // initial update
    }

    private void updateClock() {
        Date now = new Date();
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, dd MMMM yyyy");

        clockLabel.setText(timeFormat.format(now));
        dateLabel.setText(dateFormat.format(now));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Y25271037DigitalClock().setVisible(true));
    }
}