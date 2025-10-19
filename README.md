# 🧮 Dark Theme Calculator

A sleek, modern calculator application built with Java Swing, featuring a professional dark-themed interface and smooth user interactions. Perfect for performing basic arithmetic operations with style!

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Swing](https://img.shields.io/badge/Swing-GUI-blue?style=for-the-badge)

## ✨ Features

- **Modern Dark UI**: Eye-friendly dark theme with carefully chosen color palette
- **Real-time Display**: Dual display system showing both expression and result
- **Smooth Interactions**: Hover effects and visual feedback on all buttons
- **Complete Arithmetic**: Addition, subtraction, multiplication, and division
- **Decimal Support**: Handle floating-point calculations with ease
- **Error Handling**: Intelligent error messages for invalid operations
- **User-Friendly**: Intuitive layout matching standard calculator designs
- **Delete Function**: Remove last digit without clearing everything
- **Responsive Design**: Clean, organized button layout with proper spacing

## 🎨 Interface Preview

The calculator features:
- **Expression Field**: Shows the current mathematical operation
- **Result Field**: Displays the calculated result in large, bold text
- **Number Pad**: Standard 0-9 digit layout
- **Operators**: Color-coded orange buttons for +, -, ×, ÷
- **Function Buttons**: Clear (C), Delete (DEL), Decimal (.), Equals (=)

## 🚀 Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Java Runtime Environment (JRE)

### Installation

1. Clone the repository:
```bash
git clone https://github.com/yourusername/dark-calculator.git
cd dark-calculator
```

2. Compile the Java file:
```bash
javac DarkCalculator.java
```

3. Run the application:
```bash
java DarkCalculator
```

### Alternative: Running from IDE

1. Open the project in your favorite Java IDE (Eclipse, IntelliJ IDEA, NetBeans)
2. Locate `DarkCalculator.java`
3. Run the file (usually right-click → Run)

## 🎯 How to Use

1. **Basic Calculations**:
   - Click number buttons to input digits
   - Click an operator (+, -, ×, ÷)
   - Enter the second number
   - Press `=` to see the result

2. **Clear Operations**:
   - `C` button: Clears everything and resets calculator
   - `DEL` button: Deletes the last entered digit

3. **Decimal Numbers**:
   - Click `.` button to add decimal point
   - Calculator prevents multiple decimal points

4. **Continuous Calculations**:
   - After getting a result, you can immediately use it for the next operation
   - Chain multiple operations together

## 🔧 Technical Details

### Architecture

- **Language**: Java
- **GUI Framework**: Java Swing
- **Design Pattern**: Event-driven architecture with ActionListener interface
- **Layout**: Absolute positioning for precise control

### Key Components

```java
- JFrame: Main application window
- JTextField: Display fields for expression and result
- JButton: Interactive calculator buttons
- ActionListener: Event handling for button clicks
- MouseListener: Hover effects implementation
```

### Color Scheme

- Background: `RGB(30, 30, 30)` - Deep dark gray
- Buttons: `RGB(50, 50, 50)` - Medium dark gray
- Operators: `RGB(255, 159, 10)` - Vibrant orange
- Display: `RGB(40, 40, 40)` - Slightly lighter dark gray
- Text: `RGB(255, 255, 255)` - Pure white

## 📂 Project Structure

```
dark-calculator/
│
├── src/
│   └── DarkCalculator.java    # Main application file
│
├── screenshots/
│   └── demo.png                # Application screenshot
│
├── README.md                   # Project documentation
│
└── LICENSE                     # License file
```

## 🎓 Learning Outcomes

This project demonstrates:

- **GUI Design**: Creating visually appealing interfaces with Java Swing
- **Event Handling**: Implementing ActionListener and MouseListener
- **State Management**: Managing calculator state and operations
- **Error Handling**: Handling edge cases like division by zero
- **Code Organization**: Clean, maintainable code structure
- **User Experience**: Creating intuitive, responsive interfaces

## 🛠️ Customization

### Changing Colors

Modify the color constants in the `DarkCalculator` class:

```java
private final Color DARK_BG = new Color(30, 30, 30);
private final Color BUTTON_BG = new Color(50, 50, 50);
private final Color OPERATOR_BG = new Color(255, 159, 10);
// ... customize as needed
```

### Adjusting Window Size

Change dimensions in the `setupUI()` method:

```java
setSize(400, 600); // width, height
```

### Adding New Features

The code is structured to easily add:
- Scientific calculator functions
- Memory operations (M+, M-, MR, MC)
- History of calculations
- Keyboard input support

## 🤝 Contributing

Contributions are welcome! Here's how you can help:

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request


## 🙏 Acknowledgments

- Inspired by modern calculator designs
- Built with Java Swing framework
- Color palette inspired by popular dark themes

---

⭐ If you found this project helpful, please give it a star!

**Made with ❤️ and Java**
