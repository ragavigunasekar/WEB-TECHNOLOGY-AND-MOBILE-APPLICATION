# Android Font & Color Change Application

## Experiment No: 8  
**Title:** Change Font and Color of Text and Display Toast Message  

---

## Aim
To develop an Android application that allows the user to **change the font and color of text** and display a **Toast message** when a button is pressed.

---

## Description
This project demonstrates dynamic UI updates in Android:  

- A **TextView** displays text on the screen.  
- A **Button** changes the font style and text color of the TextView when clicked.  
- A **Toast message** informs the user that the text style or color has changed.  
- Clicking the button again resets the style to default.

---

## Technologies Used
- Android Studio  
- Java  
- XML Layouts  
- Android SDK  

---

## Project Structure
Font_Change
│
├── app
│ ├── src
│ │ ├── main
│ │ │ ├── java/com/example/font_change/MainActivity.java
│ │ │ └── res/layout/activity_main.xml
│ │ │ └── res/font/roboto-regular.ttf
│ └── build.gradle (Module: app)
└── build.gradle (Project)



---

## How It Works
1. User opens the app on an Android device or emulator.  
2. The TextView initially displays default text in black.  
3. Clicking the **Change Font Style** button changes:  
   - The font to **Roboto-Regular** in **Bold Italic**  
   - The text color to **orange (#FF5722)**  
   - Shows a **Toast message**: "Style Changed!"  
4. Clicking the button again resets the TextView to **default font and black color** and shows **"Style Reset!"** toast.  

---

## Output
- Initial text is **black** with default font.  
- On button click, text becomes **orange** with **Bold Italic Roboto font**.  
- A **Toast message** confirms the action.  
- Clicking again resets the style.

---

## Result
A mobile application is successfully developed in Android Studio to **change the font and color of text** and display a **Toast message** when the user presses the button.

---
