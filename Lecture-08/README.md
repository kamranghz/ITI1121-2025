=======
# ITI1121 - Lecture 08: Object-Oriented Programming Concepts

Welcome to **Lecture 08** of the **ITI1121-2025** course. This lecture focuses on fundamental Object-Oriented Programming (OOP) concepts, including **Abstraction, Polymorphism, and Upcasting/Downcasting**. The code examples provided in this repository will help reinforce these concepts through practical Java implementations.

## 📂 Folder Structure

### **1️⃣ AbstractClass**
- **Concept:** Demonstrates abstraction in Java using abstract classes.
- **File:** `ShapeTest.java`
- **Key Topics:**  
  - Abstract methods and classes
  - Implementing abstract methods in derived classes

### **2️⃣ BankAccount**
- **Concept:** Simulates a simple banking system with inheritance and method overriding.
- **Files:**  
  - `BankAccount.java` - Base class for all account types  
  - `SavingsAccount.java` - Derived class representing savings accounts  
  - `CheckingAccount.java` - Derived class for checking accounts  
  - `BankSystem.java` - Manages bank operations  
  - `BankDemo.java` - Main class demonstrating the banking system  
- **Key Topics:**  
  - Inheritance and method overriding  
  - Encapsulation and constructors  

### **3️⃣ motivation-1**
- **Concept:** Introduction to OOP principles using geometric shapes.
- **Files:**  
  - `Shape.java` - Base class  
  - `Circle.java` - Derived class implementing shape behavior  
  - `Rectangle.java` - Another derived class  
  - `Main.java` - Demonstration of class usage  
- **Key Topics:**  
  - Basics of OOP (Classes, Objects, Methods)
  - Inheritance in Java

### **4️⃣ TypeofPolymorphism**
- **Concept:** Demonstrates **polymorphism** using animals that make different sounds.
- **Files:**  
  - `Animal.java` - Parent class  
  - `Cat.java`, `Dog.java` - Subclasses demonstrating method overriding  
  - `Speak.java` - Interface for speaking behavior  
  - `Main.java` - Demonstration of polymorphism  
- **Key Topics:**  
  - Compile-time (Method Overloading) vs. Runtime (Method Overriding) Polymorphism  
  - Interfaces in Java  

### **5️⃣ UpcastingDowncastingExample**
- **Concept:** Explores typecasting in OOP with upcasting and downcasting examples.
- **Files:**  
  - `UpcastingDowncastingExample.java` - Demonstrates safe typecasting  
  - `example1/` & `example2/` - Additional examples with `Circle`, `Rectangle`, `Shape`, and `Main` classes  
- **Key Topics:**  
  - Upcasting (Implicit conversion of a subclass reference to a superclass)
  - Downcasting (Explicit casting from a superclass reference back to a subclass)

---

## 🚀 Getting Started

### ✅ **Prerequisites**
- **Java JDK** (Version 8+ recommended)
- **IDE** (IntelliJ, Eclipse, or VS Code)

### 🏃 **How to Run the Code**
1. Clone the repository:
   ```sh
   git clone https://github.com/kamranghz/ITI1121-2025.git
   ```
2. Navigate to the lecture directory:
   ```sh
   cd ITI1121-2025/Lecture-08
   ```
3. Compile and run any Java file using:
   ```sh
   javac <filename>.java
   java <classname>
   ```
   Example:
   ```sh
   javac BankAccount/BankDemo.java
   java BankDemo
   ```

---

## 📚 **Learning Outcomes**
By the end of this lecture, students should:
- Understand **abstraction** and when to use abstract classes.
- Implement **inheritance** and use **method overriding**.
- Differentiate between **compile-time and runtime polymorphism**.
- Use **upcasting and downcasting** effectively in Java.

---

## 🤝 Contributing
Feel free to fork this repository and improve upon the examples. Pull requests are welcome!

