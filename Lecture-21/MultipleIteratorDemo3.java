/*
 * Summary: MultipleIteratorDemo3 - Custom Linked List with Add-Last and Independent Iterators
 *
 * This Java program demonstrates how to implement a simple generic singly linked list
 * with support for adding elements to the **end of the list** and creating **multiple independent iterators**.
 *
 * Key Features:
 * - `MultipleIteratorDemo3<E>`: A generic class that defines a custom singly linked list.
 * - `addLast(E value)`: Adds elements to the **end** of the list (unlike addFirst in previous demos).
 * - `ListIterator`: An inner class implementing the `Iterator<E>` interface, maintaining its own traversal state.
 * - Each call to `iterator()` returns a **new, independent iterator**, which starts from the beginning of the list.
 *
 * Main Behavior:
 * - Creates a list with elements ["A", "B", "C", "D"] using `addLast`.
 * - Demonstrates that two iterators (`i` and `j`) can **traverse the same list independently**.
 *
 */



import java.util.Iterator;
import java.util.NoSuchElementException;

//  Our own simple linked list class (generic)
public class MultipleIteratorDemo3<E> {

    // Node class to hold data and a reference to the next node
    private static class Node<E> {
        E value;
        Node<E> next;

        Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    // Head of the list
    private Node<E> head;

    // Add an element at the end of the list
    public void addLast(E value) {
        if (head == null) {
            head = new Node<>(value, null);
        } else {
            Node<E> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node<>(value, null);
        }
    }

    // Create a new iterator instance
    public Iterator<E> iterator() {
        return new ListIterator();
    }

    // Inner class implementing Iterator — each iterator has its own "current" node
    private class ListIterator implements Iterator<E> {
        private Node<E> current;

        public ListIterator() {
            current = null; // Before the first node
        }

        public boolean hasNext() {
            if (current == null) {
                return head != null;
            } else {
                return current.next != null;
            }
        }

        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements.");
            }

            if (current == null) {
                current = head;
            } else {
                current = current.next;
            }

            return current.value;
        }
    }

    // Main method to test multiple iterators
    public static void main(String[] args) {
        // Step 1: Create list and add elements
        MultipleIteratorDemo3<String> list = new MultipleIteratorDemo3<>();
        list.addLast("A");
        list.addLast("B");
        list.addLast("C");
        list.addLast("D");

        // Step 2: Create two independent iterators
        Iterator<String> i = list.iterator();
        Iterator<String> j = list.iterator();

        // Step 3: Use 'i' to traverse the list
        System.out.println("Iterator i:");
        while (i.hasNext()) {
            System.out.println("i --> " + i.next());
        }

        // Step 4: Use 'j' to traverse the list (again from beginning)
        System.out.println("\nIterator j:");
        while (j.hasNext()) {
            System.out.println("j --> " + j.next());
        }
    }
}
