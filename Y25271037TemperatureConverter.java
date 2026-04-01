import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Y25271037TemperatureConverter extends JFrame {
    private JTextField inputField;
    private JLabel resultLabel;
    private JButton toCelsiusButton, toFahrenheitButton, resetButton;

    public Y25271037TemperatureConverter() {
        setTitle("Temperature Converter");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1));

        inputField = new JTextField();
        resultLabel = new JLabel("Enter a temperature value", SwingConstants.CENTER);

        toCelsiusButton = new JButton("Convert to Celsius");
        toFahrenheitButton = new JButton("Convert to Fahrenheit");
        resetButton = new JButton("Reset");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(toCelsiusButton);
        buttonPanel.add(toFahrenheitButton);
        buttonPanel.add(resetButton);

        add(new JLabel("Temperature Converter (Celsius ↔ Fahrenheit)", SwingConstants.CENTER));
        add(inputField);
        add(resultLabel);
        add(buttonPanel);

        // Action: Convert to Celsius
        toCelsiusButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double fahrenheit = Double.parseDouble(inputField.getText());
                    double celsius = (fahrenheit - 32) * 5 / 9;
                    resultLabel.setText(fahrenheit + " °F = " + String.format("%.2f", celsius) + " °C");
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Please enter a valid number!");
                }
            }
        });

        // Action: Convert to Fahrenheit
        toFahrenheitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double celsius = Double.parseDouble(inputField.getText());
                    double fahrenheit = (celsius * 9 / 5) + 32;
                    resultLabel.setText(celsius + " °C = " + String.format("%.2f", fahrenheit) + " °F");
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Please enter a valid number!");
                }
            }
        });

        // Action: Reset
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                inputField.setText("");
                resultLabel.setText("Enter a temperature value");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Y25271037TemperatureConverter().setVisible(true));
    }
}