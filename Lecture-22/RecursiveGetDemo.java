/**
 * A generic singly linked list with a recursive get(int index) method.
 * Demonstrates the "head + tail" strategy for recursive list access.
 */
import java.util.NoSuchElementException;

public class RecursiveGetDemo<E> {

    // Inner class to represent each node in the list
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

    // Constructor - creates an empty list
    public RecursiveGetDemo() {
        first = null;
    }

    /**
     * Adds a new element at the end of the list.
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
     * Public method to get the value at the specified index.
     * Starts the recursion with the first node.
     */
    public E get(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Negative index not allowed.");
        }
        return get(first, index);
    }

    /**
     * Private recursive method that uses "head + tail" strategy to find value at index.
     * @param p current node being inspected
     * @param index position to find relative to this node
     * @return value at given index
     */
    private E get(Node<E> p, int index) {
        // Case 1: Index too large - we reached end of list
        if (p == null) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }

        // Base Case: We found the node at index 0
        if (index == 0) {
            return p.value;
        }

        // Recursive Case: Go to the next node, with index decreased
        return get(p.next, index - 1);
    }

    /**
     * Prints the entire list (for testing/debugging).
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
     * Main method to demonstrate recursive get method.
     */
    public static void main(String[] args) {
        RecursiveGetDemo<String> list = new RecursiveGetDemo<>();

        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.printList();  // Output: A -> B -> C -> D -> null

        // Try getting elements at various indexes
        System.out.println("Element at index 0: " + list.get(0));  // A
        System.out.println("Element at index 2: " + list.get(2));  // C
        System.out.println("Element at index 3: " + list.get(3));  // D

        // Uncomment to test error:
        // System.out.println("Element at index 4: " + list.get(4)); // Should throw exception
    }
}
