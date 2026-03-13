# Servlet GET vs POST Demo

## Experiment No: 5

**Title:** Demonstration of HTTP GET and POST Methods using Java Servlet

---

## Aim

To demonstrate the difference between the **HTTP GET and POST methods** by creating an HTML form and handling the requests using a Java Servlet.

---

## Description

This project demonstrates how **GET and POST HTTP methods** work in a Java Servlet application.

An HTML form collects **Name** and **Email** from the user.
The form can be submitted using either the **GET** method or the **POST** method.

The servlet processes the request and displays the submitted data back in the browser.

---

## Technologies Used

* HTML
* Java Servlet
* Java
* Apache Tomcat

---

## Project Structure

```
get-post-servlet-demo
│
├── index.html
├── MethodServlet.java
└── web.xml
```

---

## How It Works

1. The user opens the HTML form in the browser.
2. The user enters **Name** and **Email**.
3. The form is submitted using either **GET** or **POST**.
4. The servlet receives the request.
5. The servlet retrieves the data using `request.getParameter()`.
6. The servlet displays the received data in the browser.

---

## GET Method

* Data is sent through the **URL**.
* Parameters are visible in the address bar.

Example:

```
http://localhost:8080/MethodServlet?name=John&email=john@gmail.com
```

---

## POST Method

* Data is sent through the **HTTP request body**.
* Parameters are **not visible in the URL**.

Example:

```
http://localhost:8080/MethodServlet
```

---

## Result

The servlet successfully demonstrates the difference between **HTTP GET and POST methods** by handling form submissions accordingly.
