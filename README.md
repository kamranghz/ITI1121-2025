<div align="center">

# ITI1121-D · Introduction to Computing II

### Winter 2025 — University of Ottawa

**Instructor:** Kamran Gholizadeh HamlAbadi, Ph.D. Candidate

[![Java](https://img.shields.io/badge/Java-JDK%2011%2B-ED8B00?logo=openjdk&logoColor=white)](https://openjdk.org/)
[![University of Ottawa](https://img.shields.io/badge/University%20of%20Ottawa-EECS-8F001A)](https://www.uottawa.ca/)
[![Lectures](https://img.shields.io/badge/Lectures-23-4CAF50)]()
[![License: Academic](https://img.shields.io/badge/License-Academic%20Use-blue)]()

*Object-oriented design · Abstract data types · Recursion · Linked structures · Trees*

[Course Overview](#course-overview) · [Syllabus](#weekly-syllabus) · [Repository Structure](#repository-structure) · [Getting Started](#getting-started) · [Academic Integrity](#academic-integrity)

</div>

---

## Course Overview

This repository contains the complete set of weekly Java source files, in-class demonstrations, and lab exercises for **ITI1121 D — Introduction to Computing II**, delivered in the **Winter 2025** term at the **University of Ottawa, School of Electrical Engineering and Computer Science (EECS)**.

The course builds on the foundations of ITI1120 (Introduction to Computing I) and develops students' ability to design, implement, and analyse object-oriented programs in Java. The central themes are:

- **Object-oriented programming** — encapsulation, inheritance, and polymorphism
- **Abstract data types (ADTs)** — specification, implementation, and comparison
- **Linear data structures** — stacks, queues, and linked lists
- **Recursion** — recursive reasoning, stack frames, and recursive list processing
- **Non-linear structures** — binary search trees

All source code is organised lecture-by-lecture and is intended to be used alongside the official course slides, assignments, and lab sessions on Brightspace.

---

## Weekly Syllabus

| Lecture | Topic | Key Concepts |
|:---:|---|---|
| 01 | Introduction | Course overview, Java environment setup |
| 02 | Primitive and Reference Data Types | `int`, `double`, `char`, heap vs. stack memory |
| 03 | Wrappers | `Integer`, `Double`, autoboxing, unboxing |
| 04 | Call-by-Value, Scope, and Memory Management | Parameter passing, variable lifetimes, GC |
| 05 | Object-Oriented Programming and Packages | Classes, objects, packages, access modifiers |
| 06 | Classes and Objects | Constructors, `this`, instance variables, methods |
| 07 | Class Variables, Methods, and Inheritance | `static`, `super`, method overriding |
| 08 | Polymorphism and Abstract Classes | Dynamic dispatch, `abstract` keyword |
| 09 | Interfaces, ADTs, and Equality | `interface`, `equals()`, contract-based design |
| 10 | Generics and Stacks | Type parameters, `Stack<T>` ADT |
| 11 | ArrayStack and Dynamic Arrays | Array-backed stack, capacity doubling |
| 12 | Arithmetic Expressions and Postfix Notation | Shunting-yard algorithm, RPN evaluation |
| 13 | Method Calls, Stack Frames, and Recursion | Call stack, base cases, recursive design |
| 14 | Linked Structures and Stack Implementation | Singly linked list, `LinkedStack<T>` |
| 15 | Error Handling and Exceptions | `try/catch/finally`, checked vs. unchecked |
| 16 | Queues and LinkedQueue | FIFO ADT, `Queue<T>` interface |
| 17 | Array-Based and Circular Queues | Ring buffer, wrap-around indexing |
| 18 | Queue-Based Algorithms and State-Space Search | BFS, asynchronous processes, simulation |
| 19 | ADTs and Lists | `List<T>` ADT, singly vs. doubly linked |
| 20 | Tail Pointer, Doubly Linked Lists, Dummy Node | Sentinel nodes, bidirectional traversal |
| 21 | Iterators in Java | `Iterator<T>`, `Iterable<T>`, `for-each` loop |
| 22 | Recursive List Processing | Structural recursion on linked lists |
| 23 | Binary Search Tree (BST) | BST invariant, insert, search, traversals |

---

## Repository Structure

```text
ITI1121-2025/
│
├── Lecture-01/                  # Introduction
├── Lecture-02/                  # Primitive and Reference Data Types
├── Lecture-03/                  # Wrappers
├── Lecture-04/                  # Call-by-Value, Scope, Memory
├── Lecture-05/                  # OOP and Packages
├── Lecture-06/                  # Classes and Objects
├── Lecture-07/                  # Class Variables, Methods, Inheritance
├── Lecture-08/                  # Polymorphism and Abstract Classes
├── Lecture-09/                  # Interfaces, ADTs, Equality
├── Lecture-10/                  # Generics and Stacks
├── Lecture-11/                  # ArrayStack and Dynamic Arrays
├── Lecture-12/                  # Arithmetic Expressions and Postfix
├── Lecture-13/                  # Recursion and Stack Frames
├── Lecture-14/                  # Linked Structures and LinkedStack
├── Lecture-15/                  # Exceptions and Error Handling
├── Lecture-16/                  # Queues and LinkedQueue
├── Lecture-17/                  # Array-Based and Circular Queues
├── Lecture-18/                  # Queue Algorithms and State-Space Search
├── Lecture-19/                  # ADTs and Lists
├── Lecture-20/                  # Doubly Linked Lists and Dummy Nodes
├── Lecture-21/                  # Iterators
├── Lecture-22/                  # Recursive List Processing
├── Lecture-23/                  # Binary Search Trees
│
└── README.md
```

Each `Lecture-XX/` folder contains `.java` source files corresponding to the examples, live demos, and exercises presented during that lecture.

---

## Getting Started

### Prerequisites

- **JDK 11 or later** — [Download OpenJDK](https://openjdk.org/)
- Any Java-capable editor or IDE:
  - [IntelliJ IDEA](https://www.jetbrains.com/idea/) *(recommended)*
  - [Eclipse](https://www.eclipse.org/)
  - [VS Code](https://code.visualstudio.com/) with the Java Extension Pack
  - Terminal with `javac` and `java`

### Clone the repository

```bash
git clone https://github.com/kamranghz/ITI1121-2025.git
cd ITI1121-2025
```

### Compile and run a single lecture example

```bash
cd Lecture-14
javac SinglyLinkedList.java
java SinglyLinkedList
```

### Compile an entire lecture folder

```bash
cd Lecture-10
javac *.java
```

### Recommended study workflow

1. Review the lecture slides on Brightspace before opening the source files.
2. Read through each `.java` file and trace the logic manually before running it.
3. Modify and experiment — change values, break invariants, and observe the output.
4. Attempt the corresponding lab exercises on your own before consulting solutions.

---

## How to Use This Repository

| Goal | Suggested approach |
|---|---|
| Reinforce a lecture concept | Open `Lecture-XX/`, read the source, run the demo |
| Prepare for a quiz or midterm | Re-implement each ADT from scratch, then compare |
| Complete a lab | Use lecture code as a reference — do not copy directly |
| Study for the final exam | Focus on Lectures 10–23 (ADTs, recursion, trees) |

---

## Academic Integrity

This repository is provided **for educational reference only**.

- Source code shared here is the **instructor's demonstration material**, not a solution bank for assignments or labs.
- Students must complete all graded work independently in accordance with the [University of Ottawa Academic Integrity Policy](https://www.uottawa.ca/university-secretariat/academic-integrity).
- Submitting any portion of this code as your own original work for a graded deliverable constitutes academic fraud.

When in doubt, consult the instructor or a teaching assistant before referencing any code in a graded context.

---

## Course Information

| Field | Detail |
|---|---|
| **Course code** | ITI1121 D |
| **Title** | Introduction to Computing II |
| **Term** | Winter 2025 |
| **Institution** | University of Ottawa |
| **Department** | School of Electrical Engineering and Computer Science (EECS) |
| **Language** | Java (JDK 11+) |
| **Course portal** | Brightspace (uOttawa) |

---

## Instructor

<table>
<tr>
<td>

**Kamran Gholizadeh HamlAbadi**
Ph.D. Candidate · School of EECS
University of Ottawa · MCRLab

Research interests: multimodal AI, digital twins, human–computer interaction, real-time computer vision.

🔗 [GitHub](https://github.com/kamranghz) · [LinkedIn](https://linkedin.com/in/kamranghz)

</td>
</tr>
</table>

For course-related questions, please use the discussion board on **Brightspace** or contact the instructor via the university email system.

---

<div align="center">

*© 2025 Kamran Gholizadeh HamlAbadi · University of Ottawa*
*Course material is shared for academic reference. All rights reserved.*

</div>
