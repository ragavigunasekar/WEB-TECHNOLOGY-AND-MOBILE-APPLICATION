# GET vs POST Servlet

## Title
HTTP GET and POST Method Demonstration using Java Servlet

## Description
This project demonstrates the difference between GET and POST methods in HTTP using an HTML form and a Java Servlet.

The user enters Name and Email, and the data is processed using:
- doGet() method for GET requests
- doPost() method for POST requests

## Technologies Used
- HTML
- Java Servlet
- Apache Tomcat
- Java (JDK)

## Files
- getpost.html
- GetPostServlet.java
- web.xml (optional)

## Functionality
- User enters Name and Email
- Chooses submission method (GET or POST)
- GET: Data is sent through URL
- POST: Data is sent through request body
- Servlet processes and displays the data

## Key Difference
GET:
- Data visible in URL
- Less secure
- Limited data size

POST:
- Data not visible in URL
- More secure
- No size limit

## How to Run
1. Deploy the project in Apache Tomcat
2. Start the server
3. Open browser
4. Run: http://localhost:8080/project-name/getpost.html
5. Test both GET and POST methods

## Output
- GET: Data visible in URL and displayed in browser
- POST: Data not visible in URL and displayed in browser

## Result
The program successfully demonstrates the difference between HTTP GET and POST methods using a Java Servlet.
