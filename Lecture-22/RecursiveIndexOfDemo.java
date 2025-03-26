/**
 * A generic singly linked list class that includes a recursive indexOf method.
 * This implementation demonstrates the "head + tail" recursive strategy.
 * 
 * Goal: Return the index of the first occurrence of a given element.
 * If not found, return -1.
 */

import java.util.NoSuchElementException;

public class RecursiveIndexOfDemo<E> {

    // Inner Node class to hold data and link to next node
    private static class Node<E> {
        E value;
        Node<E> next;

        Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    // Reference to the first node in the list
    private Node<E> first;

    // Constructor to initialize an empty list
    public RecursiveIndexOfDemo() {
        first = null;
    }

    /**
     * Adds a value to the end of the list.
     */
    public void add(E value) {
        if (first == null) {
            first = new Node<>(value, null);
        } else {
            Node<E> current = first;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node<>(value, null);
        }
    }

    /**
     * Public method to start recursive search from the head node.
     */
    public int indexOf(E target) {
        return indexOf(first, target);
    }

    /**
     * Private recursive method implementing the "head + tail" strategy.
     * - Base case 1: if node is null, target is not found → return -1.
     * - Base case 2: if node's value equals target, it's found → return 0.
     * - General case: recursively search in the tail, add 1 to result if found.
     */
    private int indexOf(Node<E> p, E target) {
        if (p == null) {
            // Base Case 1: We've reached the end of the list — value not found
            return -1;
        }

        if (p.value.equals(target)) {
            // Base Case 2: We found the value at this node
            return 0;
        }

        // Recursive Case: search the tail (rest of the list)
        int resultInTail = indexOf(p.next, target);

        if (resultInTail == -1) {
            // Target was not found in the tail either
            return -1;
        }

        // Target was found in the tail, so its position is 1 + resultInTail
        return resultInTail + 1;
    }

    /**
     * Print the contents of the list (for testing/debugging).
     */
    public void printList() {
        Node<E> current = first;
        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    /**
     * Main method to test recursive indexOf.
     */
    public static void main(String[] args) {
        RecursiveIndexOfDemo<String> list = new RecursiveIndexOfDemo<>();

        list.add("apple");
        list.add("banana");
        list.add("cherry");
        list.add("banana");
        list.add("date");

        list.printList();  // Output: apple -> banana -> cherry -> banana -> date -> null

        System.out.println("Index of 'banana': " + list.indexOf("banana")); // 1
        System.out.println("Index of 'cherry': " + list.indexOf("cherry")); // 2
        System.out.println("Index of 'date': " + list.indexOf("date"));     // 4
        System.out.println("Index of 'kiwi': " + list.indexOf("kiwi"));     // -1 (not found)
    }
}
