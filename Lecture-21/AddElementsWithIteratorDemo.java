/*
 * Summary: AddElementsWithIteratorDemo - Custom LinkedList with Add-While-Iterating Support
 *
 * This program demonstrates how to:
 * - Create a **custom generic singly linked list** (`LinkedList<E>`)
 * - Implement an **inner iterator class** (`ListIterator`) that can both **traverse** and **add elements**
 * - Add elements to the list during iteration, then reset the iterator to print all inserted elements
 *
 * Key Components:
 * 1. `LinkedList<E>`:
 *    - Custom singly linked list with a `first` node reference
 *    - Inner static class `Node<E>` to hold value and next pointer
 *
 * 2. `ListIterator`:
 *    - Maintains a reference to the `current` node
 *    - `hasNext()` checks if the next node exists
 *    - `next()` moves the iterator forward and returns the current value
 *    - `add(E o)` inserts a new node **after** the current one and updates the iterator position
 *      - If called before any `next()`, it inserts at the beginning
 *
 * 3. Demo in `main()`:
 *    - Creates an empty list and an iterator
 *    - Adds 5 elements (`element-0` to `element-4`) using the iterator
 *    - Resets the iterator and prints the entire list
 *
 * Output:
 * - A list of strings from `element-0` to `element-4`, printed line by line
 *
 * Purpose:
 * - Demonstrates how to manually control insertion using an iterator pattern
 * - Shows how an iterator can maintain state and modify a list during traversal
 * - Useful for understanding how linked list insertions work at an abstract level
 */



public class AddElementsWithIteratorDemo {

    public static void main(String[] args) {
        // Create a LinkedList of Strings
        LinkedList<String> list = new LinkedList<>();

        // Create an iterator for the list
        LinkedList<String>.ListIterator iterator = list.iterator();

        // Add elements using the iterator
        for (int c = 0; c < 5; c++) {
            iterator.add("element-" + c); // inserts element before 'next()' position
        }

        // Reset the iterator to the beginning
        iterator = list.iterator();

        // Traverse and print all elements in the list
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

// Generic LinkedList class
class LinkedList<E> {

    // Node definition for singly linked list
    private static class Node<E> {
        E value;
        Node<E> next;

        Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    // Head of the list
    private Node<E> first;

    // Inner class: custom iterator
    public class ListIterator {
        private Node<E> current;

        // Start before the first element
        public ListIterator() {
            current = null;
        }

        // Check if there's a next node
        public boolean hasNext() {
            if (current == null)
                return first != null;
            else
                return current.next != null;
        }

        // Get the next element and move forward
        public E next() {
            if (current == null) {
                current = first;
            } else {
                current = current.next;
            }
            return current.value;
        }

        // Add element before the next() value
        public boolean add(E o) {
            if (o == null) return false;

            if (current == null) {
                // Insert at beginning
                first = new Node<>(o, first);
                current = first;
            } else {
                // Insert after current
                current.next = new Node<>(o, current.next);
                current = current.next;
            }
            return true;
        }
    }

    // Factory method to return a new iterator
    public ListIterator iterator() {
        return new ListIterator();
    }
}
