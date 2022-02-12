package main.HomeWorkApp8;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import static main.HomeWorkApp8.CalcInstance.arrayOfDigits;
import static main.HomeWorkApp8.CalcInstance.arrayOfSign;

public class ButtonListener implements ActionListener {
    private final JTextField inputField;
    public ButtonListener(JTextField inputField) {
        this.inputField = inputField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();

        switch (btn.getText()) {
            case "=" -> {
                inputField.setText(String.valueOf(evalResult(arrayOfDigits, arrayOfSign[0])));
                arrayOfDigits.clear();
            }
            case "C" -> {
                inputField.setText("");
                arrayOfDigits.clear();
            }
            case "+", "-", "*", "/" -> {
                arrayOfSign[0] = btn.getText();
                inputField.setText("");
            }
            default -> {
                arrayOfDigits.add(Integer.parseInt(inputField.getText() + btn.getText()));
                inputField.setText(inputField.getText() + btn.getText());

            }
        }
    }
    private int evalResult( ArrayList<Integer> arrayOfDigits, String evalSign) {
        return switch (evalSign) {
            case "+" -> arrayOfDigits.get(0) + arrayOfDigits.get(1);
            case "-" -> arrayOfDigits.get(0) - arrayOfDigits.get(1);
            case "*" -> arrayOfDigits.get(0) * arrayOfDigits.get(1);
            case "/" -> (int) arrayOfDigits.get(0) / arrayOfDigits.get(1);
            default -> 0;
        };
    }
}
