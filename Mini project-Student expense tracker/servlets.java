/**
 * SERVLET PROGRAMS FOR STUDENT EXPENSE TRACKER
 * Covers all requirements from syllabus points 3-6
 * 
 * To compile and run:
 * 1. Set up Apache Tomcat
 * 2. Place .java files in WEB-INF/classes/
 * 3. Compile: javac -cp catalina.jar HelloWorld.java
 * 4. Access via: http://localhost:8080/expensetracker/hello
 */

// ============================================================
// 1. BASIC SERVLET - "Hello, World!" (Syllabus Point 3)
// ============================================================

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloWorld extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Set response content type
        response.setContentType("text/html");
        
        // Get output stream
        PrintWriter out = response.getWriter();
        
        // Send HTML response
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hello Servlet</title>");
        out.println("<style>");
        out.println("body { font-family: Arial; margin: 50px; }");
        out.println("h1 { color: #6366f1; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Hello, World!</h1>");
        out.println("<p>This is a basic Servlet response.</p>");
        out.println("<p>Timestamp: " + new java.util.Date() + "</p>");
        out.println("</body>");
        out.println("</html>");
        
        out.close();
    }
}

// ============================================================
// 2. FORM DATA PROCESSING SERVLET (Syllabus Point 4)
// ============================================================

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class FormDataServlet extends HttpServlet {
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Get form parameters
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        
        // Validate input
        if (name == null || name.isEmpty() || age == null || age.isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, 
                             "Name and Age are required!");
            return;
        }
        
        // Set response type
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        // Display the form data back
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Form Data Response</title>");
        out.println("<style>");
        out.println("body { font-family: Arial; margin: 50px; background: #f3f4f6; }");
        out.println(".container { background: white; padding: 30px; border-radius: 8px; max-width: 500px; }");
        out.println("h1 { color: #6366f1; }");
        out.println("p { font-size: 18px; margin: 10px 0; }");
        out.println(".label { font-weight: bold; color: #333; }");
        out.println(".value { color: #6366f1; font-weight: bold; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='container'>");
        out.println("<h1>Form Data Received</h1>");
        out.println("<p><span class='label'>Name:</span> <span class='value'>" + 
                   escapeHtml(name) + "</span></p>");
        out.println("<p><span class='label'>Age:</span> <span class='value'>" + 
                   escapeHtml(age) + "</span></p>");
        out.println("<p><span class='label'>Submission Time:</span> <span class='value'>" + 
                   new java.util.Date() + "</span></p>");
        out.println("<p><a href='javascript:history.back()'>Go Back</a></p>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
        
        out.close();
    }
    
    private String escapeHtml(String text) {
        return text.replace("&", "&amp;")
                   .replace("<", "&lt;")
                   .replace(">", "&gt;")
                   .replace("\"", "&quot;")
                   .replace("'", "&#39;");
    }
}

// ============================================================
// 3. GET vs POST SERVLET (Syllabus Point 5)
// ============================================================

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class GetPostServlet extends HttpServlet {
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String method = "GET";
        String data = request.getParameter("data");
        
        displayResponse(out, method, data);
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String method = "POST";
        String data = request.getParameter("data");
        
        displayResponse(out, method, data);
    }
    
    private void displayResponse(PrintWriter out, String method, String data) {
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>GET vs POST Demo</title>");
        out.println("<style>");
        out.println("body { font-family: Arial; margin: 50px; }");
        out.println(".container { max-width: 600px; }");
        out.println("h1 { color: #6366f1; }");
        out.println(".get { background: #dbeafe; padding: 20px; border-radius: 8px; margin: 20px 0; border-left: 4px solid #3b82f6; }");
        out.println(".post { background: #fce7f3; padding: 20px; border-radius: 8px; margin: 20px 0; border-left: 4px solid #ec4899; }");
        out.println("code { background: #f3f4f6; padding: 10px; border-radius: 4px; display: block; margin: 10px 0; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='container'>");
        out.println("<h1>HTTP GET vs POST Demonstration</h1>");
        
        if ("GET".equals(method)) {
            out.println("<div class='get'>");
            out.println("<h2>GET Request Received</h2>");
            out.println("<p><strong>Method:</strong> " + method + "</p>");
            out.println("<p><strong>Data Received:</strong> " + (data != null ? data : "None") + "</p>");
            out.println("<h3>Characteristics of GET:</h3>");
            out.println("<ul>");
            out.println("<li>Data is appended to URL as query string</li>");
            out.println("<li>Data is visible in browser address bar</li>");
            out.println("<li>Limited amount of data can be sent (URL length limit)</li>");
            out.println("<li>Data is cached by browser</li>");
            out.println("<li>Used for retrieving data (not sensitive)</li>");
            out.println("</ul>");
            out.println("<code>URL: http://localhost:8080/app/getpost?data=yourdata</code>");
            out.println("</div>");
        } else {
            out.println("<div class='post'>");
            out.println("<h2>POST Request Received</h2>");
            out.println("<p><strong>Method:</strong> " + method + "</p>");
            out.println("<p><strong>Data Received:</strong> " + (data != null ? data : "None") + "</p>");
            out.println("<h3>Characteristics of POST:</h3>");
            out.println("<ul>");
            out.println("<li>Data is sent in request body (not visible in URL)</li>");
            out.println("<li>Can send large amounts of data</li>");
            out.println("<li>Data is not cached</li>");
            out.println("<li>Used for sensitive data and file uploads</li>");
            out.println("<li>More secure than GET</li>");
            out.println("</ul>");
            out.println("<code>Data is sent in HTTP request body</code>");
            out.println("</div>");
        }
        
        out.println("<h3>Test Forms</h3>");
        out.println("<h4>Test GET Request:</h4>");
        out.println("<form action='getpost' method='GET'>");
        out.println("<input type='text' name='data' placeholder='Enter some data'>");
        out.println("<button type='submit'>Send via GET</button>");
        out.println("</form>");
        
        out.println("<h4>Test POST Request:</h4>");
        out.println("<form action='getpost' method='POST'>");
        out.println("<input type='text' name='data' placeholder='Enter some data'>");
        out.println("<button type='submit'>Send via POST</button>");
        out.println("</form>");
        
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}

// ============================================================
// 4. SESSION TRACKING SERVLET (Syllabus Point 6)
// ============================================================

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SessionTrackingServlet extends HttpServlet {
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Get session object (create new if doesn't exist)
        HttpSession session = request.getSession(true);
        
        String action = request.getParameter("action");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        if ("login".equals(action)) {
            // Simple authentication (in real app, check database)
            if ("admin".equals(username) && "password".equals(password)) {
                // Set session attributes
                session.setAttribute("username", username);
                session.setAttribute("loginTime", new java.util.Date());
                session.setMaxInactiveInterval(30 * 60); // 30 minutes timeout
                
                displayLoginSuccess(out, session);
            } else {
                out.println("<h1>Login Failed</h1>");
                out.println("<p>Invalid credentials. Try: admin / password</p>");
                out.println("<a href='javascript:history.back()'>Go Back</a>");
            }
        } 
        else if ("logout".equals(action)) {
            // Invalidate session
            session.invalidate();
            out.println("<h1>Logged Out Successfully</h1>");
            out.println("<p>Your session has been terminated.</p>");
            out.println("<a href='javascript:history.back()'>Go Back</a>");
        }
        else {
            displayLoginForm(out, session);
        }
        
        out.close();
    }
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        HttpSession session = request.getSession(false);
        
        if (session != null && session.getAttribute("username") != null) {
            String username = (String) session.getAttribute("username");
            java.util.Date loginTime = (java.util.Date) session.getAttribute("loginTime");
            String sessionId = session.getId();
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head><title>Session Info</title>");
            out.println("<style>");
            out.println("body { font-family: Arial; margin: 50px; }");
            out.println(".session-info { background: #dbeafe; padding: 20px; border-radius: 8px; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Session Information</h1>");
            out.println("<div class='session-info'>");
            out.println("<p><strong>Logged In User:</strong> " + username + "</p>");
            out.println("<p><strong>Login Time:</strong> " + loginTime + "</p>");
            out.println("<p><strong>Session ID:</strong> " + sessionId + "</p>");
            out.println("<p><strong>Session Timeout:</strong> " + session.getMaxInactiveInterval() + " seconds</p>");
            out.println("<form action='session' method='POST'>");
            out.println("<input type='hidden' name='action' value='logout'>");
            out.println("<button type='submit'>Logout</button>");
            out.println("</form>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        } else {
            out.println("<h1>No Active Session</h1>");
            out.println("<p>Please login first.</p>");
            out.println("<a href='session'>Go to Login</a>");
        }
        
        out.close();
    }
    
    private void displayLoginForm(PrintWriter out, HttpSession session) {
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>Login</title>");
        out.println("<style>");
        out.println("body { font-family: Arial; margin: 50px; }");
        out.println(".form-container { background: white; padding: 30px; border-radius: 8px; max-width: 400px; box-shadow: 0 4px 6px rgba(0,0,0,0.1); }");
        out.println("input { width: 100%; padding: 10px; margin: 10px 0; border: 1px solid #ccc; border-radius: 4px; }");
        out.println("button { background: #6366f1; color: white; padding: 10px 20px; border: none; border-radius: 4px; cursor: pointer; width: 100%; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='form-container'>");
        out.println("<h1>Simple Login System with Session Tracking</h1>");
        out.println("<p>Try: username=<strong>admin</strong>, password=<strong>password</strong></p>");
        out.println("<form action='session' method='POST'>");
        out.println("<input type='hidden' name='action' value='login'>");
        out.println("<input type='text' name='username' placeholder='Username' required>");
        out.println("<input type='password' name='password' placeholder='Password' required>");
        out.println("<button type='submit'>Login</button>");
        out.println("</form>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
    
    private void displayLoginSuccess(PrintWriter out, HttpSession session) {
        String username = (String) session.getAttribute("username");
        
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>Login Success</title>");
        out.println("<style>");
        out.println("body { font-family: Arial; margin: 50px; }");
        out.println(".success { background: #ecfdf5; padding: 20px; border-radius: 8px; border-left: 4px solid #10b981; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='success'>");
        out.println("<h1>Login Successful!</h1>");
        out.println("<p>Welcome, " + username + "!</p>");
        out.println("<p>Your session has been created and is being tracked.</p>");
        out.println("<p><a href='session'>View Session Info</a></p>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}

// ============================================================
// 5. AUTHENTICATION SERVLET (Form Processing)
// ============================================================

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.HashMap;
import java.util.Map;

public class AuthServlet extends HttpServlet {
    
    // Simple in-memory user database (In production, use database)
    private static Map<String, String> users = new HashMap<>();
    
    static {
        users.put("student1@email.com", "hashedPassword123");
        users.put("student2@email.com", "hashedPassword456");
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        
        if ("register".equals(action)) {
            handleRegister(request, response);
        } else if ("login".equals(action)) {
            handleLogin(request, response);
        }
    }
    
    private void handleRegister(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String password = request.getParameter("password");
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        // Validation (same as JavaScript)
        if (!isValidFirstName(firstName)) {
            out.println("Invalid First Name");
            return;
        }
        if (!isValidEmail(email)) {
            out.println("Invalid Email");
            return;
        }
        if (!isValidPhone(phone)) {
            out.println("Invalid Phone");
            return;
        }
        if (!isValidPassword(password)) {
            out.println("Invalid Password");
            return;
        }
        
        // Store user (in real app, save to database)
        users.put(email, password);
        
        out.println("Registration successful!");
    }
    
    private void handleLogin(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        if (users.containsKey(email) && users.get(email).equals(password)) {
            HttpSession session = request.getSession(true);
            session.setAttribute("userEmail", email);
            out.println("Login successful!");
        } else {
            out.println("Invalid email or password!");
        }
    }
    
    // Validation methods matching JavaScript
    private boolean isValidFirstName(String firstName) {
        if (firstName == null || firstName.length() < 6) return false;
        return firstName.matches("[a-zA-Z\\s]+");
    }
    
    private boolean isValidEmail(String email) {
        if (email == null) return false;
        return email.matches("[^\\s@]+@[^\\s@]+\\.[^\\s@]+");
    }
    
    private boolean isValidPhone(String phone) {
        String cleaned = phone.replaceAll("[\\s\\-()]", "");
        return cleaned.matches("[6-9]\\d{9}");
    }
    
    private boolean isValidPassword(String password) {
        return password != null && password.length() >= 6;
    }
}

// ============================================================
// WEB.XML CONFIGURATION
// ============================================================
/*
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://java.sun.com/xml/ns/javaee"
   xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
   xsi:schemaLocation="http://java.sun.com/xml/ns/javaee 
   http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd"
   version="3.0">
    
    <servlet>
        <servlet-name>HelloWorld</servlet-name>
        <servlet-class>HelloWorld</servlet-class>
    </servlet>
    
    <servlet-mapping>
        <servlet-name>HelloWorld</servlet-name>
        <url-pattern>/hello</url-pattern>
    </servlet-mapping>
    
    <servlet>
        <servlet-name>FormData</servlet-name>
        <servlet-class>FormDataServlet</servlet-class>
    </servlet>
    
    <servlet-mapping>
        <servlet-name>FormData</servlet-name>
        <url-pattern>/formdata</url-pattern>
    </servlet-mapping>
    
    <servlet>
        <servlet-name>GetPost</servlet-name>
        <servlet-class>GetPostServlet</servlet-class>
    </servlet>
    
    <servlet-mapping>
        <servlet-name>GetPost</servlet-name>
        <url-pattern>/getpost</url-pattern>
    </servlet-mapping>
    
    <servlet>
        <servlet-name>SessionTracking</servlet-name>
        <servlet-class>SessionTrackingServlet</servlet-class>
    </servlet>
    
    <servlet-mapping>
        <servlet-name>SessionTracking</servlet-name>
        <url-pattern>/session</url-pattern>
    </servlet-mapping>
    
    <servlet>
        <servlet-name>Auth</servlet-name>
        <servlet-class>AuthServlet</servlet-class>
    </servlet>
    
    <servlet-mapping>
        <servlet-name>Auth</servlet-name>
        <url-pattern>/auth</url-pattern>
    </servlet-mapping>
    
</web-app>
*/
