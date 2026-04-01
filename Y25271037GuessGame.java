import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Y25271037GuessGame extends JFrame {
    private JTextField inputField;
    private JLabel hintLabel, attemptsLabel;
    private JButton guessButton, resetButton;
    private int targetNumber, attempts;

    public Y25271037GuessGame() {
        setTitle("Number Guessing Game (1–100)");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1));

        inputField = new JTextField();
        hintLabel = new JLabel("Enter a number between 1 and 100", SwingConstants.CENTER);
        attemptsLabel = new JLabel("Attempts: 0", SwingConstants.CENTER);

        guessButton = new JButton("Guess");
        resetButton = new JButton("Reset");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(guessButton);
        buttonPanel.add(resetButton);

        add(hintLabel);
        add(inputField);
        add(attemptsLabel);
        add(buttonPanel);

        startNewGame();

        guessButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int guess = Integer.parseInt(inputField.getText());
                    attempts++;
                    if (guess == targetNumber) {
                        hintLabel.setText("Correct! The number was " + targetNumber);
                        guessButton.setEnabled(false);
                    } else if (guess < targetNumber) {
                        hintLabel.setText("Too low! Try again.");
                    } else {
                        hintLabel.setText("Too high! Try again.");
                    }
                    attemptsLabel.setText("Attempts: " + attempts);
                } catch (NumberFormatException ex) {
                    hintLabel.setText("Please enter a valid number!");
                }
            }
        });

        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startNewGame();
            }
        });
    }

    private void startNewGame() {
        Random rand = new Random();
        targetNumber = rand.nextInt(100) + 1;
        attempts = 0;
        hintLabel.setText("Enter a number between 1 and 100");
        attemptsLabel.setText("Attempts: 0");
        inputField.setText("");
        guessButton.setEnabled(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Y25271037GuessGame().setVisible(true));
    }
}