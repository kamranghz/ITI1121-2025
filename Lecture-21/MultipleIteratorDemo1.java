/*
 * This Java program demonstrates how to implement a custom singly linked list
 * with the ability to create **multiple independent iterators** using a generic class.
 * 
 * Key Components:
 * - `MultipleIteratorDemo1<E>`: A generic outer class representing a singly linked list.
 * - `Node<E>`: A private static inner class representing each node in the list.
 * - `LinkedListIterator<E>`: A static nested class that implements the `Iterator` interface.
 *   Each iterator instance maintains its own position and traverses the list independently.
 * 
 * Functionality:
 * - Elements are added to the front of the list using `addFirst()`.
 * - The `iterator()` method returns a new independent iterator every time it's called.
 * - In `main()`, two iterators are created and used one after the other to demonstrate that
 *   each one traverses the entire list independently and maintains its own state.
 * 
 * ================================================================
 /*
 * Summary: Key Differences Between MultipleIteratorDemo and MultipleIteratorDemo1
 *
 * 1. Code Structure:
 *    - MultipleIteratorDemo: Uses multiple top-level classes (Node, LinkedList, LinkedListIterator).
 *    - MultipleIteratorDemo1: All logic is encapsulated within a single class using inner static classes.
 *
 * 2. Generics:
 *    - MultipleIteratorDemo: LinkedList and Iterator are generic, but the main class is not.
 *    - MultipleIteratorDemo1: The entire class is generic (MultipleIteratorDemo1<E>), making it more reusable.
 *
 * 3. Modularity:
 *    - MultipleIteratorDemo: Emphasizes modular design; good for learning separation of concerns.
 *    - MultipleIteratorDemo1: More self-contained and compact; easier to reuse and distribute.
 *
 * 4. Encapsulation:
 *    - MultipleIteratorDemo: Node and LinkedListIterator are top-level classes.
 *    - MultipleIteratorDemo1: Node and LinkedListIterator are private static inner classes, better encapsulated.
 *
 * 5. Iterator Design:
 *    - MultipleIteratorDemo: Iterator is tied to a separate LinkedList class.
 *    - MultipleIteratorDemo1: Iterator references the outer class directly for simplicity.
 *
 * 6. Main Method Behavior:
 *    - MultipleIteratorDemo: Demonstrates interleaved iterator calls (i.next(), j.next(), i.next(), ...).
 *    - MultipleIteratorDemo1: Demonstrates full iteration of each iterator independently.
 */


import java.util.Iterator;
import java.util.NoSuchElementException;

// This class demonstrates how multiple iterators can work independently on a linked list.
public class MultipleIteratorDemo1<E> {

    // Node class to represent each element in the linked list
    private static class Node<E> {
        E value;
        Node<E> next;

        Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    // Pointer to the beginning of the list
    private Node<E> head;

    // Adds a new element at the beginning of the list
    public void addFirst(E value) {
        head = new Node<>(value, head);
    }

    // Returns a new iterator for this list
    public Iterator<E> iterator() {
        return new LinkedListIterator<>(this);
    }

    // Static nested class: each iterator gets its own state
    private static class LinkedListIterator<E> implements Iterator<E> {
        private Node<E> current;
        private MultipleIteratorDemo1<E> myList;

        // Constructor links this iterator to the outer list
        public LinkedListIterator(MultipleIteratorDemo1<E> list) {
            this.myList = list;
            this.current = null;
        }

        // Checks if there is a next element to visit
        public boolean hasNext() {
            return (current == null && myList.head != null) ||
                   (current != null && current.next != null);
        }

        // Moves to the next element and returns its value
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements.");
            }

            if (current == null) {
                current = myList.head; // Start from the beginning
            } else {
                current = current.next;
            }

            return current.value;
        }
    }

    // Main method to demonstrate multiple independent iterators
    public static void main(String[] args) {
        MultipleIteratorDemo1<String> list = new MultipleIteratorDemo1<>();

        // Add elements to the list: A -> B -> C -> D
        list.addFirst("D");
        list.addFirst("C");
        list.addFirst("B");
        list.addFirst("A");

        // Create two separate iterators
        Iterator<String> i = list.iterator();
        Iterator<String> j = list.iterator();

        System.out.println("Iterator i:");
        while (i.hasNext()) {
            System.out.println("i --> " + i.next());
        }

        System.out.println("\nIterator j:");
        while (j.hasNext()) {
            System.out.println("j --> " + j.next());
        }
    }
}
