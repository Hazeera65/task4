import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TemperatureConverterGUI extends JFrame implements ActionListener {
    private JTextField inputField;
    private JButton convertButton;
    private JLabel resultLabel;

    public TemperatureConverterGUI() {
        setTitle("Temperature Converter");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        inputField = new JTextField();
        panel.add(inputField);

        convertButton = new JButton("Convert");
        convertButton.addActionListener(this);
        panel.add(convertButton);

        resultLabel = new JLabel("Converted temperature will appear here");
        panel.add(resultLabel);

        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == convertButton) {
            try {
                double temperature = Double.parseDouble(inputField.getText());
                double convertedTemp;
                String inputText = inputField.getText();
                String resultText;

                if (inputText.endsWith("F") || inputText.endsWith("f")) {
                    convertedTemp = (temperature - 32) * 5 / 9;
                    resultText = String.format("%.2f Fahrenheit = %.2f Celsius", temperature, convertedTemp);
                } else if (inputText.endsWith("C") || inputText.endsWith("c")) {
                    convertedTemp = (temperature * 9 / 5) + 32;
                    resultText = String.format("%.2f Celsius = %.2f Fahrenheit", temperature, convertedTemp);
                } else {
                    resultText = "Invalid input. Please use 'F' or 'C' as suffix for Fahrenheit or Celsius respectively.";
                }

                resultLabel.setText(resultText);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Invalid input. Please enter a valid number.");
            }
        }
    }

    public static void main(String[] args) {
        new TemperatureConverterGUI();
    }
}

