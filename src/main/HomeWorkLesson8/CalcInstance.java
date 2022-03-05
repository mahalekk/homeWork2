package main.HomeWorkLesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CalcInstance extends JFrame {

    private static final JTextField inputField = new JTextField();
    public static ArrayList<Integer> arrayOfDigits = new ArrayList<>(2);
    public static String[] arrayOfSign = new String[1];
    public CalcInstance(){
        setTitle("CalcInstance");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 200, 250);
        setJMenuBar(createTopMenu());
        setLayout(new BorderLayout());
        add(createTextEditor(),BorderLayout.NORTH);
        add(createBottom(), BorderLayout.SOUTH);

        setVisible(true);
    }

    private JMenuBar createTopMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        menuBar.add(menu);
        JMenuItem exit = menu.add(new JMenuItem("Exit"));
        exit.addActionListener(new ExitListener());

        return menuBar;
    }

    private JPanel createTextEditor() {
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        inputField.setEditable(false);
        inputField.setBackground(Color.LIGHT_GRAY);
        topPanel.add(inputField);
        return topPanel;
    }
    
   private JPanel createBottom() {
       ActionListener buttonListener = new ButtonListener(inputField);
       JPanel bottomPanel = new JPanel();
       JPanel digitsPanel = new JPanel();
       JPanel actionsPanel = new JPanel();
       JPanel extraDigitsPanel = new JPanel();

       bottomPanel.setLayout(new BorderLayout());

       bottomPanel.add(digitsPanel,BorderLayout.CENTER);
       bottomPanel.add(actionsPanel, BorderLayout.WEST);
       bottomPanel.add(extraDigitsPanel, BorderLayout.SOUTH);


       digitsPanel.setLayout(new GridLayout(4,3));
//       for (int i = 1; i <= 12; i++) {
//           String btnTitle = switch (i) {
//               case 10 -> "0";
//               case 11 -> ".";
//               case 12 -> "=";
//               default -> String.valueOf(i);
//           };
//           JButton button = new JButton(btnTitle);
//            button.addActionListener(buttonListener);
//            digitsPanel.add(button);
//       }


       actionsPanel.setLayout(new GridLayout(5,1));
       JButton minusButton = new JButton("-");
       minusButton.addActionListener(buttonListener);
       actionsPanel.add(minusButton);

       JButton plusButton = new JButton("+");
       plusButton.addActionListener(buttonListener);
       actionsPanel.add(plusButton);

       JButton multiplyButton = new JButton("*");
       multiplyButton.addActionListener(buttonListener
       );
       actionsPanel.add(multiplyButton);

       JButton divideButton = new JButton("/");
       divideButton.addActionListener(buttonListener);
       actionsPanel.add(divideButton);

       JButton clearButton = new JButton("C");
       clearButton.addActionListener(buttonListener);
       actionsPanel.add(clearButton);

       return bottomPanel;
        
    }

//    public static int evalResult( ArrayList<Integer> arrayOfDigits, String evalSign) {
//        return switch (evalSign) {
//            case "+" -> arrayOfDigits.get(0) + arrayOfDigits.get(1);
//            case "-" -> arrayOfDigits.get(0) - arrayOfDigits.get(1);
//            case "*" -> arrayOfDigits.get(0) * arrayOfDigits.get(1);
//            case "/" -> (int) arrayOfDigits.get(0) / arrayOfDigits.get(1);
//            default -> 0;
//        };
//    }
}

