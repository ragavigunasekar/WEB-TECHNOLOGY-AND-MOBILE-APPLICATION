# Student Expense Tracker - VS Code Setup Guide

## Quick Start (5 minutes)

### Step 1: Create Project Folder
```bash
mkdir expense-tracker
cd expense-tracker
```

### Step 2: Create Folder Structure
```
expense-tracker/
├── index.html
├── css/
│   ├── style.css
│   └── responsive.css
├── js/
│   ├── validation.js
│   ├── expense-tracker.js
│   └── utils.js
└── assets/
    └── images/
```

### Step 3: Download Files
1. Copy all provided files to your project folder
2. Create CSS and JS subfolders
3. Place files in respective directories

### Step 4: Install VS Code Extensions
- **Live Server** - For live preview
- **Code Formatter** - For code beautification
- **REST Client** - For testing Servlets

### Step 5: Run Live Server
1. Right-click on `index.html`
2. Select "Open with Live Server"
3. Browser opens at `http://localhost:5500`

## Detailed Setup Instructions

### Frontend Setup (HTML + CSS + JavaScript)

#### Prerequisites
- VS Code installed
- Live Server extension

#### Installation
```bash
# 1. Create project directory
mkdir student-expense-tracker
cd student-expense-tracker

# 2. Create subdirectories
mkdir css
mkdir js
mkdir assets
```

#### File Structure
```
student-expense-tracker/
├── index.html                 # Main page
├── css/
│   ├── style.css             # External CSS (all styles)
│   └── responsive.css        # Mobile responsive styles
├── js/
│   ├── validation.js         # Form validation (Syllabus #2)
│   ├── expense-tracker.js    # Main app logic
│   └── utils.js              # Utility functions
└── assets/
    ├── images/
    └── data/
```

#### Testing Validation (Covers Syllabus Point 2)

**First Name Validation:**
- ✓ Valid: "Alexander" (6+ alphabets)
- ✗ Invalid: "John" (less than 6 chars)
- ✗ Invalid: "John123" (contains numbers)

**Password Validation:**
- ✓ Valid: "password123" (6+ characters)
- ✗ Invalid: "pass" (less than 6 chars)

**Email Validation:**
- ✓ Valid: "student@example.com"
- ✗ Invalid: "student@example"
- ✗ Invalid: "student example.com"

**Mobile Number Validation:**
- ✓ Valid: "9876543210" (10 digits, starts with 6-9)
- ✗ Invalid: "12345" (less than 10)
- ✗ Invalid: "12345678901" (more than 10)

**Address Validation:**
- ✓ Valid: "123 Main Street, City" (10+ characters)
- ✗ Invalid: "123 Main" (less than 10)

---

## Backend Setup (Java Servlets)

### Prerequisites
- JDK 8+ installed
- Apache Tomcat 8.5+
- Java IDE (Eclipse or NetBeans)

### Tomcat Installation

#### Windows
```bash
# Download from: https://tomcat.apache.org/download-90.cgi
# Extract to: C:\Apache\tomcat

# Add to environment variables:
CATALINA_HOME=C:\Apache\tomcat

# Start server
cd C:\Apache\tomcat\bin
startup.bat
```

#### Linux/Mac
```bash
# Install via package manager
brew install tomcat  # Mac
sudo apt-get install tomcat9  # Linux

# Or download and extract
tar -xzf apache-tomcat-9.0.tar.gz
cd apache-tomcat-9.0/bin
./startup.sh
```

### Create Web Application

#### In Eclipse/NetBeans
```
1. File > New > Dynamic Web Project
2. Project Name: ExpenseTracker
3. Runtime: Apache Tomcat 8.5+
4. Next > Configure Web Module
5. Module Name: expensetracker
6. Content Directory: WebContent
```

#### Create Servlet Files
Place these Java files in: `src/` directory

**Files to create:**
- `HelloWorld.java` (Syllabus #3)
- `FormDataServlet.java` (Syllabus #4)
- `GetPostServlet.java` (Syllabus #5)
- `SessionTrackingServlet.java` (Syllabus #6)
- `AuthServlet.java` (Authentication)

#### Compile Servlets
```bash
# Navigate to project directory
cd ExpenseTracker

# Compile individual servlets
javac -cp "path/to/tomcat/lib/*" src/HelloWorld.java

# Or use Ant build script (included)
ant compile
```

#### Deploy to Tomcat
```bash
# Copy WAR file to Tomcat
cp ExpenseTracker.war /path/to/tomcat/webapps/

# Or use IDE deployment
# Right-click project > Run on Server > Apache Tomcat
```

### Test Servlets

#### Test 1: HelloWorld (Syllabus #3)
```
URL: http://localhost:8080/expensetracker/hello
Expected: "Hello, World!" message
```

#### Test 2: Form Data Processing (Syllabus #4)
```
URL: http://localhost:8080/expensetracker/formdata
Method: POST
Form Data: name=John&age=20
Expected: Form data echoed back
```

#### Test 3: GET vs POST (Syllabus #5)
```
GET: http://localhost:8080/expensetracker/getpost?data=test
POST: http://localhost:8080/expensetracker/getpost
Body: data=test
Expected: Different responses showing GET vs POST differences
```

#### Test 4: Session Tracking (Syllabus #6)
```
URL: http://localhost:8080/expensetracker/session
Steps:
1. Login with: admin / password
2. View session info
3. Logout to invalidate session
```

---

## Android Setup

### Prerequisites
- Android Studio 4.0+
- Android SDK (API 21+)
- Emulator or Physical Device

### Create Android Project

```
1. Android Studio > New > New Android Project
2. Name: ExpenseTracker
3. Package Name: com.example.expensetracker
4. Minimum API Level: 21 (Android 5.0)
5. Create Activity > Empty Activity
```

### Add Activities

#### Calculator Activity (Syllabus #7)
```
File > New > Activity > Empty Activity
Name: Calculator

Features:
- Button for numbers (0-9)
- Operation buttons (+, -, *, /)
- Clear button
- Decimal point support
- Toast messages
```

**Test Cases:**
- ✓ Addition: 5 + 3 = 8
- ✓ Subtraction: 10 - 4 = 6
- ✓ Multiplication: 6 * 7 = 42
- ✓ Division: 20 / 4 = 5
- ✓ Decimal: 5.5 + 2.5 = 8.0

#### Text Styling Activity (Syllabus #8)
```
Features:
- EditText for input
- Spinner for color selection
- Spinner for font size
- Bold button
- Italic button
- Toast messages on each action
```

**Test Cases:**
- ✓ Change text color to Red/Blue/Green
- ✓ Change font size (12-32 SP)
- ✓ Apply Bold formatting
- ✓ Apply Italic formatting
- ✓ Toast appears for each action

#### Email Sender Activity (Syllabus #9)
```
Features:
- EditText for recipient email
- EditText for subject
- EditText for email body
- Send button (opens mail client)
- Clear button
- Email validation
```

**Test Cases:**
- ✓ Valid email validation
- ✓ Opens Gmail/Email client
- ✓ Toast messages
- ✓ Clear all fields

### Add Permissions (AndroidManifest.xml)
```xml
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.SEND_SMS" />
```

### Run Application
```
1. Create Virtual Device (AVD)
   Tools > AVD Manager > Create Virtual Device
2. Select Pixel 4 with API 30
3. Click Run > Select Emulator
4. App runs in emulator
```

---

## Testing & Validation

### Frontend Testing Checklist

#### HTML & CSS (Syllabus #1)
- [ ] Embedded CSS (in `<style>` tags)
- [ ] External CSS (css/style.css)
- [ ] Inline CSS (in HTML attributes)
- [ ] Responsive design (test on mobile)
- [ ] Forms display correctly

#### JavaScript Validation (Syllabus #2)
- [ ] First Name: min 6 chars, alphabets only
- [ ] Last Name: non-empty
- [ ] Email: valid format
- [ ] Phone: 10 digits only
- [ ] Address: non-empty
- [ ] Password: min 6 chars
- [ ] Real-time error messages
- [ ] Form can't submit with invalid data

#### Form Tests
```javascript
// Open browser console (F12)
// Run validation tests:
runValidationTests();

// Manual tests:
// Test 1: Valid Registration
firstName: "Alexander"
lastName: "Johnson"
email: "alexander@example.com"
phone: "9876543210"
address: "123 Main Street, City"
password: "password123"
Result: ✓ Should submit

// Test 2: Invalid First Name
firstName: "John"
Result: ✗ Error: "must be at least 6 characters"

// Test 3: Invalid Email
email: "john@example"
Result: ✗ Error: "Invalid email format"
```

### Backend Testing Checklist

#### Servlet Tests
- [ ] HelloWorld prints "Hello, World!"
- [ ] Form data is processed correctly
- [ ] GET and POST produce different responses
- [ ] Session is created on login
- [ ] Session is destroyed on logout
- [ ] Session timeout works

### Android Testing Checklist

#### Calculator Tests
- [ ] All operations work correctly
- [ ] Clear button resets calculator
- [ ] Decimal support works
- [ ] Toast messages display
- [ ] No division by zero

#### Text Styling Tests
- [ ] Color spinner works
- [ ] Font size spinner works
- [ ] Bold button works
- [ ] Italic button works
- [ ] Toast messages appear
- [ ] Reset restores defaults

#### Email Sender Tests
- [ ] Email validation works
- [ ] Email client opens
- [ ] Toast messages display
- [ ] Clear button works

---

## Keyboard Shortcuts

### VS Code
- `Ctrl+S` - Save file
- `Ctrl+H` - Find and replace
- `Ctrl+Shift+F` - Format document
- `F5` - Start debugging

### Live Server
- `Ctrl+Shift+P` - Command palette
- Search "Live Server" for options

### Browser DevTools
- `F12` - Open developer tools
- `Ctrl+Shift+I` - Elements inspector
- `Console` tab - Run JavaScript

---

## Common Issues & Solutions

### Issue: "Script not found" error
**Solution:** Check file paths in HTML
```html
<!-- Correct -->
<script src="js/validation.js"></script>

<!-- Wrong -->
<script src="validation.js"></script>
```

### Issue: Validation not working
**Solution:** Check browser console for errors
```javascript
// In browser console:
// Check if validation.js loaded
typeof validateFirstName // Should be "function"

// Run tests
runValidationTests();
```

### Issue: Tomcat won't start
**Solution:** 
- Check port 8080 is not in use
- Check JAVA_HOME environment variable
- Check Tomcat logs: `tomcat/logs/catalina.out`

### Issue: Android emulator slow
**Solution:**
- Use Hardware Acceleration (KVM on Linux)
- Allocate more RAM to emulator
- Use latest API level (33+)

---

## Project Submission Checklist

### Frontend
- [x] index.html (with embedded CSS)
- [x] css/style.css (external CSS)
- [x] css/responsive.css (mobile responsive)
- [x] js/validation.js (all 6 validations)
- [x] js/expense-tracker.js (app logic)
- [x] All validations working
- [x] Responsive design tested
- [x] No console errors

### Backend
- [x] HelloWorld.java (Syllabus #3)
- [x] FormDataServlet.java (Syllabus #4)
- [x] GetPostServlet.java (Syllabus #5)
- [x] SessionTrackingServlet.java (Syllabus #6)
- [x] web.xml configuration
- [x] All Servlets compiled
- [x] All Servlets deployed to Tomcat
- [x] All URLs accessible
- [x] Session tracking working

### Android
- [x] Calculator Activity (Syllabus #7)
  - Addition, Subtraction, Multiplication, Division
  - Clear button, Decimal support
  - Toast messages
- [x] Text Styling Activity (Syllabus #8)
  - Font and color changes
  - Bold, Italic buttons
  - Toast messages
- [x] Email Sender Activity (Syllabus #9)
  - Email validation
  - Send email via client
  - Toast messages

---

## Documentation

### Code Comments
All code includes comments explaining:
- What each function does
- Parameter descriptions
- Return values
- Examples

### Validation Rules
Each validation includes:
- JavaScript implementation
- Java/Backend equivalent
- Test cases
- Error messages

### API Endpoints
Each Servlet documents:
- URL pattern
- HTTP method (GET/POST)
- Parameters
- Response format

---

## Additional Resources

### Learning Materials
- HTML/CSS: https://developer.mozilla.org/en-US/docs/Web/HTML
- JavaScript: https://developer.mozilla.org/en-US/docs/Web/JavaScript
- Java Servlets: https://docs.oracle.com/cd/E19798-01/servlet/
- Android: https://developer.android.com/docs

### Tools
- VS Code: https://code.visualstudio.com/
- Apache Tomcat: https://tomcat.apache.org/
- Android Studio: https://developer.android.com/studio

### References
- W3C Standards: https://www.w3.org/
- Oracle Java Docs: https://docs.oracle.com/javase/
- Android Developer Guide: https://developer.android.com/guide

---

## Support & Debugging

### Enable Debug Logging
```javascript
// In JavaScript
localStorage.setItem('debugMode', 'true');
// Now console.log statements will show
```

### View Network Requests
1. Open Developer Tools (F12)
2. Go to Network tab
3. Make requests
4. Check Request/Response

### Check Java Errors
```bash
# Tomcat logs
tail -f /path/to/tomcat/logs/catalina.out

# View recent errors
cat tomcat/logs/catalina.err
```

### Android Debugging
```bash
# Connect device
adb devices

# View logs
adb logcat

# Install app
adb install app.apk

# Run debugger
# Android Studio > Run > Debug App
```

---

## Tips for Success

1. **Start with Frontend** - Get HTML/CSS/JS working first
2. **Test Validation** - Thoroughly test all form validations
3. **Build Incrementally** - Add one Servlet at a time
4. **Test Each Feature** - Don't wait until the end
5. **Document as You Go** - Add comments while coding
6. **Use Version Control** - Git is your friend
7. **Read Error Messages** - They tell you what's wrong
8. **Test on Real Devices** - Emulator behavior may differ

---

Last Updated: 2024
For questions or issues, refer to official documentation or course materials.
