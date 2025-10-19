import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class calculator extends JFrame implements ActionListener {
    
    // UI Components
    private JTextField expressionField;
    private JTextField resultField;
    private JButton[] numberButtons;
    private JButton[] operatorButtons;
    private JButton addButton, subButton, mulButton, divButton;
    private JButton decButton, equButton, delButton, clrButton;
    
    // Calculator state
    private String currentExpression = "";
    private double result = 0;
    private String operator = "";
    private boolean startNewNumber = true;
    
    // Color scheme
    private final Color DARK_BG = new Color(30, 30, 30);
    private final Color BUTTON_BG = new Color(50, 50, 50);
    private final Color BUTTON_HOVER = new Color(70, 70, 70);
    private final Color OPERATOR_BG = new Color(255, 159, 10);
    private final Color OPERATOR_HOVER = new Color(255, 179, 50);
    private final Color TEXT_COLOR = new Color(255, 255, 255);
    private final Color DISPLAY_BG = new Color(40, 40, 40);
    
    public calculator() {
        setupUI();
        initializeComponents();
        layoutComponents();
        setVisible(true);
    }
    
    private void setupUI() {
        setTitle("Dark Calculator");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(DARK_BG);
        setLayout(null);
    }
    
    private void initializeComponents() {
        // Expression display
        expressionField = new JTextField();
        expressionField.setBounds(20, 20, 360, 50);
        expressionField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        expressionField.setEditable(false);
        expressionField.setBackground(DISPLAY_BG);
        expressionField.setForeground(new Color(150, 150, 150));
        expressionField.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        expressionField.setHorizontalAlignment(JTextField.RIGHT);
        
        // Result display
        resultField = new JTextField("0");
        resultField.setBounds(20, 80, 360, 80);
        resultField.setFont(new Font("Segoe UI", Font.BOLD, 36));
        resultField.setEditable(false);
        resultField.setBackground(DISPLAY_BG);
        resultField.setForeground(TEXT_COLOR);
        resultField.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
        resultField.setHorizontalAlignment(JTextField.RIGHT);
        
        // Number buttons
        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = createStyledButton(String.valueOf(i), BUTTON_BG, BUTTON_HOVER);
            numberButtons[i].addActionListener(this);
        }
        
        // Operator buttons
        addButton = createStyledButton("+", OPERATOR_BG, OPERATOR_HOVER);
        subButton = createStyledButton("-", OPERATOR_BG, OPERATOR_HOVER);
        mulButton = createStyledButton("×", OPERATOR_BG, OPERATOR_HOVER);
        divButton = createStyledButton("÷", OPERATOR_BG, OPERATOR_HOVER);
        decButton = createStyledButton(".", BUTTON_BG, BUTTON_HOVER);
        equButton = createStyledButton("=", OPERATOR_BG, OPERATOR_HOVER);
        delButton = createStyledButton("DEL", new Color(220, 53, 69), new Color(240, 73, 89));
        clrButton = createStyledButton("C", new Color(108, 117, 125), new Color(128, 137, 145));
        
        addButton.addActionListener(this);
        subButton.addActionListener(this);
        mulButton.addActionListener(this);
        divButton.addActionListener(this);
        decButton.addActionListener(this);
        equButton.addActionListener(this);
        delButton.addActionListener(this);
        clrButton.addActionListener(this);
    }
    
    private JButton createStyledButton(String text, Color bgColor, Color hoverColor) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.BOLD, 20));
        button.setBackground(bgColor);
        button.setForeground(TEXT_COLOR);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        // Hover effect
        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                button.setBackground(hoverColor);
            }
            public void mouseExited(MouseEvent e) {
                button.setBackground(bgColor);
            }
        });
        
        return button;
    }
    
    private void layoutComponents() {
        add(expressionField);
        add(resultField);
        
        int buttonWidth = 80;
        int buttonHeight = 70;
        int gap = 10;
        int startX = 20;
        int startY = 180;
        
        // First row: C, DEL, ÷
        clrButton.setBounds(startX, startY, buttonWidth, buttonHeight);
        delButton.setBounds(startX + buttonWidth + gap, startY, buttonWidth, buttonHeight);
        divButton.setBounds(startX + 2 * (buttonWidth + gap), startY, buttonWidth, buttonHeight);
        mulButton.setBounds(startX + 3 * (buttonWidth + gap), startY, buttonWidth, buttonHeight);
        
        add(clrButton);
        add(delButton);
        add(divButton);
        add(mulButton);
        
        // Number pad layout
        int row = startY + buttonHeight + gap;
        
        // Second row: 7, 8, 9, -
        numberButtons[7].setBounds(startX, row, buttonWidth, buttonHeight);
        numberButtons[8].setBounds(startX + buttonWidth + gap, row, buttonWidth, buttonHeight);
        numberButtons[9].setBounds(startX + 2 * (buttonWidth + gap), row, buttonWidth, buttonHeight);
        subButton.setBounds(startX + 3 * (buttonWidth + gap), row, buttonWidth, buttonHeight);
        
        add(numberButtons[7]);
        add(numberButtons[8]);
        add(numberButtons[9]);
        add(subButton);
        
        // Third row: 4, 5, 6, +
        row += buttonHeight + gap;
        numberButtons[4].setBounds(startX, row, buttonWidth, buttonHeight);
        numberButtons[5].setBounds(startX + buttonWidth + gap, row, buttonWidth, buttonHeight);
        numberButtons[6].setBounds(startX + 2 * (buttonWidth + gap), row, buttonWidth, buttonHeight);
        addButton.setBounds(startX + 3 * (buttonWidth + gap), row, buttonWidth, buttonHeight);
        
        add(numberButtons[4]);
        add(numberButtons[5]);
        add(numberButtons[6]);
        add(addButton);
        
        // Fourth row: 1, 2, 3, =
        row += buttonHeight + gap;
        numberButtons[1].setBounds(startX, row, buttonWidth, buttonHeight);
        numberButtons[2].setBounds(startX + buttonWidth + gap, row, buttonWidth, buttonHeight);
        numberButtons[3].setBounds(startX + 2 * (buttonWidth + gap), row, buttonWidth, buttonHeight);
        equButton.setBounds(startX + 3 * (buttonWidth + gap), row, buttonWidth, buttonHeight * 2 + gap);
        
        add(numberButtons[1]);
        add(numberButtons[2]);
        add(numberButtons[3]);
        add(equButton);
        
        // Fifth row: 0, .
        row += buttonHeight + gap;
        numberButtons[0].setBounds(startX, row, buttonWidth * 2 + gap, buttonHeight);
        decButton.setBounds(startX + 2 * (buttonWidth + gap), row, buttonWidth, buttonHeight);
        
        add(numberButtons[0]);
        add(decButton);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        
        // Number buttons
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                handleNumberInput(String.valueOf(i));
                return;
            }
        }
        
        // Decimal point
        if (e.getSource() == decButton) {
            handleDecimalInput();
            return;
        }
        
        // Operators
        if (e.getSource() == addButton || e.getSource() == subButton || 
            e.getSource() == mulButton || e.getSource() == divButton) {
            handleOperatorInput(command);
            return;
        }
        
        // Equals
        if (e.getSource() == equButton) {
            handleEqualsInput();
            return;
        }
        
        // Clear
        if (e.getSource() == clrButton) {
            handleClearInput();
            return;
        }
        
        // Delete
        if (e.getSource() == delButton) {
            handleDeleteInput();
            return;
        }
    }
    
    private void handleNumberInput(String num) {
        if (startNewNumber) {
            resultField.setText(num);
            startNewNumber = false;
        } else {
            String current = resultField.getText();
            if (current.equals("0")) {
                resultField.setText(num);
            } else {
                resultField.setText(current + num);
            }
        }
    }
    
    private void handleDecimalInput() {
        String current = resultField.getText();
        if (startNewNumber) {
            resultField.setText("0.");
            startNewNumber = false;
        } else if (!current.contains(".")) {
            resultField.setText(current + ".");
        }
    }
    
    private void handleOperatorInput(String op) {
        if (!operator.isEmpty() && !startNewNumber) {
            handleEqualsInput();
        }
        
        result = Double.parseDouble(resultField.getText());
        operator = op;
        currentExpression = formatNumber(result) + " " + operator;
        expressionField.setText(currentExpression);
        startNewNumber = true;
    }
    
    private void handleEqualsInput() {
        if (operator.isEmpty()) return;
        
        double secondNumber = Double.parseDouble(resultField.getText());
        double calculatedResult = 0;
        
        switch (operator) {
            case "+":
                calculatedResult = result + secondNumber;
                break;
            case "-":
                calculatedResult = result - secondNumber;
                break;
            case "×":
                calculatedResult = result * secondNumber;
                break;
            case "÷":
                if (secondNumber != 0) {
                    calculatedResult = result / secondNumber;
                } else {
                    resultField.setText("Error");
                    expressionField.setText("Cannot divide by zero");
                    operator = "";
                    startNewNumber = true;
                    return;
                }
                break;
        }
        
        currentExpression = formatNumber(result) + " " + operator + " " + formatNumber(secondNumber);
        expressionField.setText(currentExpression);
        resultField.setText(formatNumber(calculatedResult));
        result = calculatedResult;
        operator = "";
        startNewNumber = true;
    }
    
    private void handleClearInput() {
        resultField.setText("0");
        expressionField.setText("");
        result = 0;
        operator = "";
        currentExpression = "";
        startNewNumber = true;
    }
    
    private void handleDeleteInput() {
        String current = resultField.getText();
        if (current.length() > 1 && !startNewNumber) {
            resultField.setText(current.substring(0, current.length() - 1));
        } else {
            resultField.setText("0");
            startNewNumber = true;
        }
    }
    
    private String formatNumber(double num) {
        if (num == (long) num) {
            return String.format("%d", (long) num);
        } else {
            return String.format("%.8g", num);
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            new calculator();
        });
    }
}