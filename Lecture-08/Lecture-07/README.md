# ITI1121-2025 Lecture 7: Object-Oriented Programming Concepts

This repository contains the Java source code and project files for Lecture 7 of the ITI1121 course. The lecture focuses on **Object-Oriented Programming** concepts, including **Inheritance**, **Polymorphism**, **Abstract Classes**, and **Upcasting/Downcasting**.

## Folder Structure and Content

### **Lecture-07**
The main folder containing all project files and subfolders.

#### 1. **BankAccount**
   - **Purpose**: Demonstrates inheritance with bank account types and their behaviors.
   - **Files**:
     - `BankAccount.java`: The base class representing a generic bank account.
     - `CheckingAccount.java`: A subclass of `BankAccount` for checking accounts.
     - `SavingsAccount.java`: A subclass of `BankAccount` for savings accounts.
     - `CreditCard.java`: A subclass representing a credit card as an account.
     - `Customer.java`: Manages customer information.
     - `Main.java`: The entry point to demonstrate the functionality of different account types.

#### 2. **Inheritance**
   - **Purpose**: Focused on demonstrating the principles of inheritance in Java.
   - **Subfolders**:
     - **Animal**:
       - `Animal.java`: A base class for animals.
       - `Dog.java`: A subclass representing specific behavior for a dog.
     - **Modifier**:
       - `Shape.java`: Abstract base class representing shapes.
       - `Circle.java`: Subclass of `Shape` representing a circle.
       - `Rectangle.java`: Subclass of `Shape` representing a rectangle.
       - `TestShapes.java`: Contains examples to test shape functionalities and polymorphism.
     - **Shape**:
       - `Shape.java`: Base class for a general shape.
       - `Circle.java`: A subclass representing a circle.
       - `Main.java`: Main class to test shape-specific examples and polymorphism.

#### 3. **Account and Date**
   - **Purpose**: Supporting classes for additional exercises.
   - **Files**:
     - `Account.java`: A foundational class for account-related examples.
     - `Date.java`: Utility class for managing and testing date-related operations.

---

## How to Run the Code

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/kamranghz/ITI1121-2025.git
   cd ITI1121-2025/Lecture-07
