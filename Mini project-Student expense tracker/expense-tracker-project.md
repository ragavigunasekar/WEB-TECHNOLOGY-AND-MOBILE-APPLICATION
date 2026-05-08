# Student Expense Tracker - Complete Project Guide

## Project Overview
This is a full-stack Student Expense Tracker application that covers multiple topics from your Web Technology and Mobile Application syllabus.

## Syllabus Coverage

### 1. HTML & CSS ✓
- **Embedded, External, and Inline CSS** - index.html uses all three
- **Responsive Web Design** - Mobile-first approach
- **HTML Forms** - Registration and expense forms

### 2. JavaScript Validation ✓
- First Name validation (alphabets only, min 6 chars)
- Password validation (min 6 chars)
- Email validation (standard pattern)
- Mobile number validation (10 digits)
- Address validation (non-empty)
- Real-time form validation

### 3. Servlet Programs (Backend)
- Basic Servlet setup
- Form data processing
- Session tracking and authentication

### 4. Android Application
- Calculator app with basic operations
- Text styling and toast messages
- Email sending functionality

## Project Structure

```
expense-tracker/
├── frontend/
│   ├── index.html                 # Main dashboard
│   ├── register.html              # Registration page
│   ├── login.html                 # Login page
│   ├── css/
│   │   ├── style.css              # Main styles
│   │   ├── register.css           # Registration styles
│   │   └── responsive.css         # Mobile responsive styles
│   ├── js/
│   │   ├── validation.js          # Form validation functions
│   │   ├── expense-tracker.js     # Main app logic
│   │   └── utils.js               # Utility functions
│   └── assets/
│       ├── charts.js              # Chart library
│       └── fonts/                 # Custom fonts
│
├── backend/
│   ├── servlets/
│   │   ├── HelloWorld.java        # Basic Servlet
│   │   ├── ExpenseServlet.java    # Expense processing
│   │   ├── AuthServlet.java       # Authentication
│   │   ├── SessionServlet.java    # Session tracking
│   │   └── GetPostServlet.java    # GET/POST demo
│   │
│   ├── web.xml                    # Web app configuration
│   └── build.xml                  # Ant build file
│
├── android/
│   ├── ExpenseTrackerApp/         # Android Studio Project
│   ├── Calculator.java            # Calculator activity
│   ├── TextStyling.java           # Text styling activity
│   └── EmailSender.java           # Email sending activity
│
└── README.md                       # Project documentation
```

## Quick Start

### Frontend Only (HTML + CSS + JavaScript)
1. Open `index.html` in VS Code
2. Use Live Server extension to run locally
3. Test all form validations
4. Track expenses locally (stored in browser localStorage)

### With Backend (Add Servlets)
1. Set up Apache Tomcat
2. Deploy Java Servlets
3. Connect frontend to backend APIs

### Android Integration
1. Open Android Studio
2. Import the Android project
3. Build and run on emulator/device

## Key Features

✓ User Registration with validation
✓ Secure Login with session management
✓ Add/Edit/Delete expenses
✓ Categorize expenses (Food, Travel, Entertainment, etc.)
✓ View expense charts and statistics
✓ Export expense reports
✓ Mobile-responsive design
✓ Dark/Light theme toggle
✓ Local storage persistence

## Technologies Used

- **Frontend**: HTML5, CSS3, Vanilla JavaScript
- **Backend**: Java Servlets, Apache Tomcat
- **Mobile**: Android (Java)
- **Database**: SQLite (Android) / MySQL (Web)
- **Charting**: Chart.js

## How to Use This Guide

1. Start with the **Frontend Section** - build and test the web interface
2. Move to **JavaScript Validation** - implement all form validations
3. Create **Servlet Programs** - backend processing
4. Extend to **Android** - mobile application
5. Integrate **Session Management** - user authentication

Each section has complete, working code with explanations.
