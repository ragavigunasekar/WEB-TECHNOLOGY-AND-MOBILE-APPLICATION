# User Form Servlet

## Experiment No: 4

**Title:** Web Form Processing using Java Servlet

---

## Aim

To create a simple web application that accepts a user's **name** and **age** through an HTML form and processes the data using a Java Servlet. The servlet retrieves the input values and displays them back on the browser.

---

## Description

This project demonstrates basic **form handling using Java Servlets**.
A web form is created using HTML where the user enters their name and age.
When the form is submitted, a servlet processes the request, retrieves the submitted values, and generates a response displaying the user's information.

---

## Technologies Used

* HTML
* Java Servlet
* Apache Tomcat
* Java

---

## Project Structure

```
user-form-servlet
│
├── index.html
├── UserServlet.java
└── web.xml
```

---

## How It Works

1. The user opens the HTML form in the browser.
2. The user enters their **name** and **age**.
3. The form sends the data to the servlet using the **POST** method.
4. The servlet retrieves the values using `request.getParameter()`.
5. The servlet generates a response displaying the user's name and age.

---

## Example Output

```
Hello, John!
You are 20 years old.
```

---

## Result

The servlet successfully processes the HTML form data and displays the user's name and age in the browser.

---
