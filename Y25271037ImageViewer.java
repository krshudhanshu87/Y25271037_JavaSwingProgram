import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class Y25271037ImageViewer extends JFrame {
    private JLabel imageLabel;
    private JButton openButton, nextButton, prevButton;
    private JFileChooser fileChooser;
    private File[] imageFiles;
    private int currentIndex = -1;

    public Y25271037ImageViewer() {
        setTitle("Image Viewer");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        imageLabel = new JLabel("No Image Loaded", SwingConstants.CENTER);
        imageLabel.setFont(new Font("Arial", Font.BOLD, 20));

        openButton = new JButton("Open");
        nextButton = new JButton("Next");
        prevButton = new JButton("Previous");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(openButton);
        buttonPanel.add(prevButton);
        buttonPanel.add(nextButton);

        add(imageLabel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        fileChooser = new JFileChooser();
        fileChooser.setMultiSelectionEnabled(true);

        // Open images
        openButton.addActionListener(e -> {
            int option = fileChooser.showOpenDialog(this);
            if (option == JFileChooser.APPROVE_OPTION) {
                imageFiles = fileChooser.getSelectedFiles();
                if (imageFiles.length > 0) {
                    currentIndex = 0;
                    displayImage(imageFiles[currentIndex]);
                }
            }
        });

        // Next image
        nextButton.addActionListener(e -> {
            if (imageFiles != null && currentIndex < imageFiles.length - 1) {
                currentIndex++;
                displayImage(imageFiles[currentIndex]);
            }
        });

        // Previous image
        prevButton.addActionListener(e -> {
            if (imageFiles != null && currentIndex > 0) {
                currentIndex--;
                displayImage(imageFiles[currentIndex]);
            }
        });
    }

    private void displayImage(File file) {
        ImageIcon icon = new ImageIcon(file.getAbsolutePath());
        // Scale image to fit window
        Image scaled = icon.getImage().getScaledInstance(getWidth() - 50, getHeight() - 100, Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(scaled));
        imageLabel.setText(""); // remove placeholder text
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Y25271037ImageViewer().setVisible(true));
    }
}