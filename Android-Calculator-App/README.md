# Android Calculator Application

## Experiment No: 7  
**Title:** Android Calculator Application using Android Studio  

---

## Aim
To develop an Android application that implements a basic calculator using Android controls such as **Button**, **TextView**, and **EditText**.  
The calculator supports basic arithmetic operations: **Addition, Subtraction, Multiplication, and Division**.

---

## Description
This project demonstrates how to create a **simple calculator app** in Android Studio.  

- The user inputs two numbers using **EditText** fields.  
- Buttons perform the respective operations (**Add, Subtract, Multiply, Divide**).  
- The result is displayed in a **TextView**.  
- Input validation is included to handle empty fields, non-numeric input, and division by zero.

---

## Technologies Used
- Android Studio  
- Java  
- XML Layouts  
- Android SDK  

---

## Project Structure
CalculatorApp
│
├── app
│ ├── src
│ │ ├── main
│ │ │ ├── java/com/example/calculatorapp/MainActivity.java
│ │ │ └── res/layout/activity_main.xml
│ └── build.gradle (Module: app)
└── build.gradle (Project)



---

## How It Works
1. User opens the app on an Android device or emulator.  
2. User enters two numbers in the **EditText** fields.  
3. User clicks a button corresponding to the desired operation.  
4. The app performs the calculation and displays the result in **TextView**.  
5. Clicking **Clear** resets the input fields and the result display.  
6. Input validation ensures the app handles:
   - Empty input fields  
   - Non-numeric input  
   - Division by zero  

---

## Key Features
- Addition, Subtraction, Multiplication, Division  
- Input validation  
- Clear/reset button  
- Responsive UI using **ConstraintLayout**  

---

## Example Code Snippet (MainActivity.java)
```java
double num1 = Double.parseDouble(editTextNumber1.getText().toString());
double num2 = Double.parseDouble(editTextNumber2.getText().toString());
double result;

switch(operator) {
    case '+': result = num1 + num2; break;
    case '-': result = num1 - num2; break;
    case '*': result = num1 * num2; break;
    case '/': 
        if(num2 == 0) {
            textViewResult.setText("Cannot divide by zero");
            return;
        }
        result = num1 / num2;
        break;
}

textViewResult.setText("Result: " + result);
Output
The calculator app displays the result of the arithmetic operation in the TextView.
It handles invalid inputs and prevents division by zero.

Result
A functional Android calculator application is successfully developed using Android Studio with controls like Button, TextView, and EditText, performing Addition, Subtraction, Multiplication, and Division.