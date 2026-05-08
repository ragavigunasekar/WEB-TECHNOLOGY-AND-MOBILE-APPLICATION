/**
 * ANDROID APPLICATIONS FOR EXPENSE TRACKER
 * Covers all requirements from syllabus points 7-9
 * 
 * Project Setup:
 * 1. Open Android Studio
 * 2. Create New Project: API 21+
 * 3. Add these activities to your project
 * 4. Update AndroidManifest.xml
 * 5. Build and Run
 */

// ============================================================
// 1. CALCULATOR ACTIVITY (Syllabus Point 7)
// ============================================================
// File: Calculator.java

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Calculator extends AppCompatActivity {
    
    private EditText inputField;
    private double firstNumber;
    private double secondNumber;
    private String operation = "";
    private boolean isNewNumber = true;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        
        inputField = findViewById(R.id.input_field);
    }
    
    // Number button click handlers
    public void onNumberClick(View view) {
        Button button = (Button) view;
        String number = button.getText().toString();
        
        if (isNewNumber) {
            inputField.setText(number);
            isNewNumber = false;
        } else {
            inputField.append(number);
        }
    }
    
    // Clear button
    public void onClearClick(View view) {
        inputField.setText("0");
        firstNumber = 0;
        secondNumber = 0;
        operation = "";
        isNewNumber = true;
        Toast.makeText(this, "Cleared", Toast.LENGTH_SHORT).show();
    }
    
    // Addition
    public void onAddClick(View view) {
        performOperation("+");
    }
    
    // Subtraction
    public void onSubtractClick(View view) {
        performOperation("-");
    }
    
    // Multiplication
    public void onMultiplyClick(View view) {
        performOperation("*");
    }
    
    // Division
    public void onDivideClick(View view) {
        performOperation("/");
    }
    
    // Equal button
    public void onEqualClick(View view) {
        if (!operation.isEmpty()) {
            secondNumber = Double.parseDouble(inputField.getText().toString());
            double result = calculate(firstNumber, secondNumber, operation);
            inputField.setText(String.valueOf(result));
            isNewNumber = true;
            operation = "";
            Toast.makeText(this, "Result: " + result, Toast.LENGTH_SHORT).show();
        }
    }
    
    // Decimal point
    public void onDecimalClick(View view) {
        String currentText = inputField.getText().toString();
        if (!currentText.contains(".")) {
            inputField.append(".");
        }
    }
    
    private void performOperation(String op) {
        firstNumber = Double.parseDouble(inputField.getText().toString());
        operation = op;
        isNewNumber = true;
        Toast.makeText(this, "Operation: " + op, Toast.LENGTH_SHORT).show();
    }
    
    private double calculate(double first, double second, String op) {
        switch (op) {
            case "+":
                return first + second;
            case "-":
                return first - second;
            case "*":
                return first * second;
            case "/":
                if (second == 0) {
                    Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                    return 0;
                }
                return first / second;
            default:
                return 0;
        }
    }
}

/* Layout file: res/layout/activity_calculator.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp"
    android:background="#f3f4f6">
    
    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Calculator"
        android:textSize="24sp"
        android:textStyle="bold"
        android:gravity="center"
        android:textColor="#6366f1"
        android:layout_marginBottom="16dp" />
    
    <EditText
        android:id="@+id/input_field"
        android:layout_width="match_parent"
        android:layout_height="80dp"
        android:text="0"
        android:textSize="36sp"
        android:gravity="right|center_vertical"
        android:inputType="number"
        android:background="@drawable/input_background"
        android:paddingRight="16dp"
        android:textColor="#1f2937" />
    
    <GridLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:columnCount="4"
        android:rowCount="5"
        android:padding="16dp">
        
        <!-- Row 1: C, /, *, - -->
        <Button
            android:layout_row="0"
            android:layout_column="0"
            android:text="C"
            android:onClick="onClearClick"
            android:background="@drawable/button_danger" />
        <Button
            android:layout_row="0"
            android:layout_column="1"
            android:text="/"
            android:onClick="onDivideClick"
            android:background="@drawable/button_operator" />
        <Button
            android:layout_row="0"
            android:layout_column="2"
            android:text="*"
            android:onClick="onMultiplyClick"
            android:background="@drawable/button_operator" />
        <Button
            android:layout_row="0"
            android:layout_column="3"
            android:text="-"
            android:onClick="onSubtractClick"
            android:background="@drawable/button_operator" />
        
        <!-- Row 2: 7, 8, 9, + -->
        <Button android:layout_row="1" android:layout_column="0" android:text="7" android:onClick="onNumberClick" />
        <Button android:layout_row="1" android:layout_column="1" android:text="8" android:onClick="onNumberClick" />
        <Button android:layout_row="1" android:layout_column="2" android:text="9" android:onClick="onNumberClick" />
        <Button android:layout_row="1" android:layout_column="3" android:text="+" android:onClick="onAddClick" />
        
        <!-- Row 3: 4, 5, 6, = -->
        <Button android:layout_row="2" android:layout_column="0" android:text="4" android:onClick="onNumberClick" />
        <Button android:layout_row="2" android:layout_column="1" android:text="5" android:onClick="onNumberClick" />
        <Button android:layout_row="2" android:layout_column="2" android:text="6" android:onClick="onNumberClick" />
        <Button android:layout_row="2" android:layout_column="3" android:text="=" android:onClick="onEqualClick" />
        
        <!-- Row 4: 1, 2, 3 -->
        <Button android:layout_row="3" android:layout_column="0" android:text="1" android:onClick="onNumberClick" />
        <Button android:layout_row="3" android:layout_column="1" android:text="2" android:onClick="onNumberClick" />
        <Button android:layout_row="3" android:layout_column="2" android:text="3" android:onClick="onNumberClick" />
        
        <!-- Row 5: 0, . -->
        <Button android:layout_row="4" android:layout_column="0" android:text="0" android:onClick="onNumberClick" />
        <Button android:layout_row="4" android:layout_column="1" android:text="." android:onClick="onDecimalClick" />
    </GridLayout>
    
</LinearLayout>
*/

// ============================================================
// 2. TEXT STYLING & TOAST ACTIVITY (Syllabus Point 8)
// ============================================================
// File: TextStylingActivity.java

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class TextStylingActivity extends AppCompatActivity {
    
    private TextView displayText;
    private EditText textInput;
    private Spinner colorSpinner;
    private Spinner fontSizeSpinner;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_styling);
        
        displayText = findViewById(R.id.display_text);
        textInput = findViewById(R.id.text_input);
        colorSpinner = findViewById(R.id.color_spinner);
        fontSizeSpinner = findViewById(R.id.font_size_spinner);
    }
    
    // Update text
    public void onUpdateTextClick(View view) {
        String text = textInput.getText().toString();
        if (!text.isEmpty()) {
            displayText.setText(text);
            Toast.makeText(this, "Text updated!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Please enter some text", Toast.LENGTH_SHORT).show();
        }
    }
    
    // Change text color
    public void onChangeColorClick(View view) {
        String selectedColor = colorSpinner.getSelectedItem().toString();
        int color = getColorFromString(selectedColor);
        displayText.setTextColor(color);
        Toast.makeText(this, "Color changed to " + selectedColor, Toast.LENGTH_SHORT).show();
    }
    
    // Change font size
    public void onChangeFontSizeClick(View view) {
        String selectedSize = fontSizeSpinner.getSelectedItem().toString();
        float size = Float.parseFloat(selectedSize);
        displayText.setTextSize(size);
        Toast.makeText(this, "Font size changed to " + selectedSize, Toast.LENGTH_SHORT).show();
    }
    
    // Make text bold
    public void onMakeBoldClick(View view) {
        displayText.setTypeface(null, android.graphics.Typeface.BOLD);
        Toast.makeText(this, "Text is now BOLD", Toast.LENGTH_SHORT).show();
    }
    
    // Make text italic
    public void onMakeItalicClick(View view) {
        displayText.setTypeface(null, android.graphics.Typeface.ITALIC);
        Toast.makeText(this, "Text is now ITALIC", Toast.LENGTH_SHORT).show();
    }
    
    // Reset styling
    public void onResetClick(View view) {
        displayText.setText("Sample Text");
        displayText.setTextColor(Color.BLACK);
        displayText.setTextSize(20);
        displayText.setTypeface(null, android.graphics.Typeface.NORMAL);
        textInput.setText("");
        Toast.makeText(this, "Styling reset!", Toast.LENGTH_SHORT).show();
    }
    
    private int getColorFromString(String colorName) {
        switch (colorName) {
            case "Red": return Color.RED;
            case "Blue": return Color.BLUE;
            case "Green": return Color.GREEN;
            case "Black": return Color.BLACK;
            case "Purple": return Color.parseColor("#9c27b0");
            case "Orange": return Color.parseColor("#ff9800");
            default: return Color.BLACK;
        }
    }
}

/* Layout file: res/layout/activity_text_styling.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">
    
    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Text Styling Demo"
        android:textSize="24sp"
        android:textStyle="bold"
        android:textColor="#6366f1"
        android:gravity="center"
        android:layout_marginBottom="20dp" />
    
    <EditText
        android:id="@+id/text_input"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Enter text to display"
        android:inputType="text"
        android:layout_marginBottom="10dp" />
    
    <TextView
        android:id="@+id/display_text"
        android:layout_width="match_parent"
        android:layout_height="100dp"
        android:text="Sample Text"
        android:textSize="20sp"
        android:textColor="#000000"
        android:gravity="center"
        android:background="#f0f0f0"
        android:layout_marginBottom="20dp" />
    
    <Spinner
        android:id="@+id/color_spinner"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:entries="@array/colors"
        android:layout_marginBottom="10dp" />
    
    <Button
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Change Color"
        android:onClick="onChangeColorClick"
        android:layout_marginBottom="10dp" />
    
    <Spinner
        android:id="@+id/font_size_spinner"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:entries="@array/font_sizes"
        android:layout_marginBottom="10dp" />
    
    <Button
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Change Font Size"
        android:onClick="onChangeFontSizeClick"
        android:layout_marginBottom="10dp" />
    
    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        android:layout_marginBottom="10dp">
        
        <Button
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="Bold"
            android:onClick="onMakeBoldClick"
            android:layout_marginRight="5dp" />
        
        <Button
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="Italic"
            android:onClick="onMakeItalicClick"
            android:layout_marginLeft="5dp" />
    </LinearLayout>
    
    <Button
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Update Text"
        android:onClick="onUpdateTextClick"
        android:layout_marginBottom="10dp" />
    
    <Button
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Reset"
        android:onClick="onResetClick" />
    
</LinearLayout>
*/

// ============================================================
// 3. EMAIL SENDING ACTIVITY (Syllabus Point 9)
// ============================================================
// File: EmailSenderActivity.java

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class EmailSenderActivity extends AppCompatActivity {
    
    private EditText recipientEmail;
    private EditText emailSubject;
    private EditText emailBody;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_sender);
        
        recipientEmail = findViewById(R.id.recipient_email);
        emailSubject = findViewById(R.id.email_subject);
        emailBody = findViewById(R.id.email_body);
    }
    
    // Send email
    public void onSendEmailClick(View view) {
        String recipient = recipientEmail.getText().toString().trim();
        String subject = emailSubject.getText().toString().trim();
        String body = emailBody.getText().toString().trim();
        
        if (recipient.isEmpty() || subject.isEmpty() || body.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }
        
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(recipient).matches()) {
            Toast.makeText(this, "Invalid email address", Toast.LENGTH_SHORT).show();
            return;
        }
        
        sendEmail(recipient, subject, body);
    }
    
    private void sendEmail(String recipient, String subject, String body) {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setType("message/rfc822");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{recipient});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        emailIntent.putExtra(Intent.EXTRA_TEXT, body);
        
        try {
            startActivity(Intent.createChooser(emailIntent, "Send email..."));
            Toast.makeText(this, "Sending email...", Toast.LENGTH_SHORT).show();
        } catch (android.content.ActivityNotFoundException e) {
            Toast.makeText(this, "No email client installed", Toast.LENGTH_SHORT).show();
        }
    }
    
    // Clear fields
    public void onClearClick(View view) {
        recipientEmail.setText("");
        emailSubject.setText("");
        emailBody.setText("");
        Toast.makeText(this, "Fields cleared", Toast.LENGTH_SHORT).show();
    }
}

/* Layout file: res/layout/activity_email_sender.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">
    
    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Send Email"
        android:textSize="24sp"
        android:textStyle="bold"
        android:textColor="#6366f1"
        android:gravity="center"
        android:layout_marginBottom="20dp" />
    
    <EditText
        android:id="@+id/recipient_email"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Recipient Email"
        android:inputType="textEmailAddress"
        android:layout_marginBottom="10dp" />
    
    <EditText
        android:id="@+id/email_subject"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Email Subject"
        android:inputType="text"
        android:layout_marginBottom="10dp" />
    
    <EditText
        android:id="@+id/email_body"
        android:layout_width="match_parent"
        android:layout_height="200dp"
        android:hint="Email Body"
        android:gravity="top"
        android:inputType="textMultiLine"
        android:layout_marginBottom="20dp" />
    
    <Button
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Send Email"
        android:onClick="onSendEmailClick"
        android:layout_marginBottom="10dp" />
    
    <Button
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Clear"
        android:onClick="onClearClick" />
    
</LinearLayout>
*/

// ============================================================
// AndroidManifest.xml
// ============================================================
/*
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android">
    
    <uses-permission android:name="android.permission.INTERNET" />
    
    <application>
        
        <activity android:name=".Calculator" />
        <activity android:name=".TextStylingActivity" />
        <activity android:name=".EmailSenderActivity" />
        
    </application>
    
</manifest>
*/

// ============================================================
// res/values/arrays.xml (String arrays for spinners)
// ============================================================
/*
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <string-array name="colors">
        <item>Red</item>
        <item>Blue</item>
        <item>Green</item>
        <item>Black</item>
        <item>Purple</item>
        <item>Orange</item>
    </string-array>
    
    <string-array name="font_sizes">
        <item>12</item>
        <item>16</item>
        <item>20</item>
        <item>24</item>
        <item>28</item>
        <item>32</item>
    </string-array>
</resources>
*/
