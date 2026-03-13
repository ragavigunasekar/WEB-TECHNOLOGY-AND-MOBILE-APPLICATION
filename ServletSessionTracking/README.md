# Servlet Session Tracking Demo

## Experiment No: 6  
**Title:** Session Tracking using HttpSession in Java Servlet  

---

## Aim
To create a simple login system where the user's session is tracked using **HttpSession** in a Java Servlet.

---

## Description
This project demonstrates **session tracking in Java Servlets**.  

A login form collects **username and password** from the user.  
After successful login, a session is created, and the user is redirected to a **dashboard (protected page)**.  
The dashboard verifies the session before displaying content.  

A **logout** feature invalidates the session and redirects the user back to the login page.

---

## Technologies Used
- HTML  
- Java Servlet  
- Java  
- Apache Tomcat  

---

## Project Structure
session-tracking-servlet
│
├── login.html
├── LoginServlet.java
├── DashboardServlet.java
├── LogoutServlet.java
└── web.xml



---

## How It Works
1. User opens `login.html` in the browser.  
2. User enters **username** and **password**.  
3. Login form submits the request to `LoginServlet`.  
4. `LoginServlet` validates credentials:  
   - If valid → creates a session → redirects to `DashboardServlet`.  
   - If invalid → shows an error message.  
5. `DashboardServlet` checks the session:  
   - If session exists → shows dashboard content.  
   - If no session → redirects to login page.  
6. Logout invalidates the session using `session.invalidate()` and redirects back to login page.

---

## Session Management

### Session Creation
```java
HttpSession session = request.getSession();
session.setAttribute("user", username);
Session Validation
Java

HttpSession session = request.getSession(false);
if(session == null || session.getAttribute("user") == null) {
    response.sendRedirect("login.html");
}
Logout
Java

session.invalidate();
response.sendRedirect("login.html");
Result
A simple login system is created where the user's session is tracked using HttpSession, demonstrating session management and protected page access in Java Servlets.

