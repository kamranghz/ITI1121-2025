# ITI1121-2025: Lecture 21

Welcome to the **Lecture 21** repository for **ITI1121 (Introduction to Computing II, 2025)**. This lecture focuses on iterators, inner classes, fail-fast behavior, and working with iterable data structures in Java.

## 📂 Repository Structure

### Root Directory Java Files

| File Name                       | Description |
|--------------------------------|-------------|
| `AddElementsWithIteratorDemo.java` | Demonstrates adding elements using an iterator. |
| `FailFastIteratorDemo.java`        | Shows how fail-fast behavior works with iterators. |
| `InnerClassDemo.java`              | Introduces basic inner class structure. |
| `IteratorSumDemo.java`            | Sums values in a collection using an iterator. |
| `ListTraversal.java`              | Demonstrates basic list traversal with iterators. |
| `ManyIteratorsDemo.java`          | Shows multiple iterators used on a list. |
| `MultipleIteratorDemo.java`       | Demo using multiple iterators. |
| `MultipleIteratorDemo1.java` to `MultipleIteratorDemo3.java` | Variants demonstrating different multiple iterator use cases. |
| `RemoveWithIteratorDemo.java`     | Safely removes elements while iterating. |
| `SinglyLinkedList.java`           | A basic singly linked list implementation. |
| `SumLinkedList.java`              | Demonstrates summing elements of a linked list. |

### `Iterable/` Subfolder

| File Name                       | Description |
|--------------------------------|-------------|
| `IterableLinkedListDemo.java`  | Demonstrates usage of `Iterable` interface with a linked list. |
| `LinkedList.java`              | A linked list implementing the `Iterable` interface. |

### `ModificationsListIterator/` Subfolder

| File Name                       | Description |
|--------------------------------|-------------|
| `FailFastLinkedListDemo.java`  | Illustrates fail-fast iterator behavior. |
| `LinkedList.java`              | Custom linked list with fail-fast behavior. |

### `OuterObject/` Subfolder

| File Name                       | Description |
|--------------------------------|-------------|
| `AccessOuterObjectDemo.java`   | Accessing members of outer classes from inner classes. |
| `AdvancedInnerClassDemo.java`  | Advanced usage of inner classes. |
| `D.java`                        | Class used in inner/outer class demo. |
| `TestAccessOuterObject.java`   | Tests accessing outer class members. |

## 🚀 Getting Started

### Prerequisites
- Java Development Kit (JDK) 11 or later
- A Java IDE (e.g., IntelliJ IDEA, Eclipse, VS Code) or terminal with `javac` and `java`

### Compilation & Execution

1. Clone the repository:
   ```sh
   git clone https://github.com/kamranghz/ITI1121-2025.git
   cd ITI1121-2025/Lecture-21
   ```

2. Compile the Java files:
   ```sh
   javac *.java Iterable/*.java ModificationsListIterator/*.java OuterObject/*.java
   ```

3. Run a main demo class:
   ```sh
   java AddElementsWithIteratorDemo  # or any other main class
   ```

## 📖 Concepts Covered
- **Iterators**: Standard iteration over collections
- **Fail-Fast Behavior**: Modifications during iteration and concurrent modification exceptions
- **Inner Classes**: Accessing outer class members
- **Custom Iterable Structures**: Making custom linked lists iterable

## 🔧 Contribution
Feel free to fork the repository and contribute improvements via pull requests.

## 📜 License
This project is for educational purposes under the **MIT License**.
