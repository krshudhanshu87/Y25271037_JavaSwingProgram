import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class y25271037_Calculator extends JFrame implements ActionListener {
    JTextField display;
    String operator = "";
    double num1 = 0, num2 = 0;

    public y25271037_Calculator() {
        setTitle("By SHUDHANSHU");
        setLayout(new BorderLayout());

        // Display field
        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 20));
        add(display, BorderLayout.NORTH);

        // Panel for buttons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,4,5,5));

        // Buttons
        String[] buttons = {
            "7","8","9","/",
            "4","5","6","*",
            "1","2","3","-",
            "0","C","=","+"
        };

        for(String text: buttons) {
            JButton btn = new JButton(text);
            btn.setFont(new Font("Arial", Font.BOLD, 18));
            btn.addActionListener(this);
            panel.add(btn);
        }

        add(panel, BorderLayout.CENTER);

        setSize(300,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if(cmd.matches("[0-9]")) { // number pressed
            display.setText(display.getText()+cmd);
        }
        else if(cmd.matches("[+\\-*/]")) { // operator pressed
            num1 = Double.parseDouble(display.getText());
            operator = cmd;
            display.setText("");
        }
        else if(cmd.equals("=")) { // calculate
            num2 = Double.parseDouble(display.getText());
            double result = 0;
            switch(operator) {
                case "+": result = num1+num2; break;
                case "-": result = num1-num2; break;
                case "*": result = num1*num2; break;
                case "/": result = num1/num2; break;
            }
            display.setText(""+result);
        }
        else if(cmd.equals("C")) { // clear
            display.setText("");
            num1 = num2 = 0;
            operator = "";
        }
    }

    public static void main(String[] args) {
        new y25271037_Calculator();
    }
}