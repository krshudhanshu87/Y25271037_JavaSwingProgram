import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

public class Y25271037CurrencyConverter extends JFrame {
    private JComboBox<String> fromCurrency, toCurrency;
    private JTextField amountField;
    private JLabel resultLabel;
    private JButton convertButton, resetButton;

    // Fixed exchange rates (example values)
    private HashMap<String, Double> rates = new HashMap<>();

    public Y25271037CurrencyConverter() {
        setTitle("Currency Converter");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 1));

        // Initialize rates (base: USD)
        rates.put("USD", 1.0);
        rates.put("EUR", 0.92);
        rates.put("INR", 83.0);
        rates.put("GBP", 0.78);
        rates.put("JPY", 150.0);

        String[] currencies = {"USD", "EUR", "INR", "GBP", "JPY"};

        fromCurrency = new JComboBox<>(currencies);
        toCurrency = new JComboBox<>(currencies);
        amountField = new JTextField();
        resultLabel = new JLabel("Enter amount and select currencies", SwingConstants.CENTER);

        convertButton = new JButton("Convert");
        resetButton = new JButton("Reset");

        JPanel selectionPanel = new JPanel();
        selectionPanel.add(new JLabel("From:"));
        selectionPanel.add(fromCurrency);
        selectionPanel.add(new JLabel("To:"));
        selectionPanel.add(toCurrency);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(convertButton);
        buttonPanel.add(resetButton);

        add(new JLabel("Currency Converter", SwingConstants.CENTER));
        add(amountField);
        add(selectionPanel);
        add(resultLabel);
        add(buttonPanel);

        // Convert action
        convertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(amountField.getText());
                    String from = (String) fromCurrency.getSelectedItem();
                    String to = (String) toCurrency.getSelectedItem();

                    double usdAmount = amount / rates.get(from); // convert to USD
                    double converted = usdAmount * rates.get(to); // convert to target

                    resultLabel.setText(amount + " " + from + " = " +
                            String.format("%.2f", converted) + " " + to);
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Please enter a valid number!");
                }
            }
        });

        // Reset action
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                amountField.setText("");
                resultLabel.setText("Enter amount and select currencies");
                fromCurrency.setSelectedIndex(0);
                toCurrency.setSelectedIndex(0);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Y25271037CurrencyConverter().setVisible(true));
    }
}