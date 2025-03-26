import java.util.NoSuchElementException;

/**
 * Conceptual class to demonstrate recursion: finding the max in a generic linked list.
 * The class name is chosen to avoid conflict with other user-defined classes.
 */
public class RecursiveMaxList<E extends Comparable<E>> {

    /**
     * Inner class for the linked list node.
     * Holds a value and a reference to the next node.
     */
    private static class Node<E> {
        private E value;
        private Node<E> next;

        Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    // Head of the list
    private Node<E> first;

    // Constructor: create an empty list
    public RecursiveMaxList() {
        first = null;
    }

    /**
     * Adds an element to the front of the list (used for setup in demo)
     */
    public void addFirst(E value) {
        first = new Node<>(value, first);
    }

    /**
     * Public method: called by users to find the maximum.
     * Checks for empty list and throws exception if needed.
     * Starts recursion from the first node.
     */
    public E findMax() {
        if (first == null) {
            throw new NoSuchElementException("List is empty!");
        }
        return findMax(first);
    }

    /**
     * Private recursive method using the "head + tail" strategy.
     *
     * @param p current node we're looking at
     * @return the maximum value in the list starting from node p
     */
    private E findMax(Node<E> p) {
        // 🟢 BASE CASE: only one node left → return its value
        if (p.next == null) {
            return p.value;
        }

        // 🔁 GENERAL CASE: find the max of the tail (rest of the list)
        E result = findMax(p.next); // Recursive call on smaller list

        // 🧠 POST-PROCESSING: compare current node's value with result from tail
        if (result.compareTo(p.value) > 0) {
            return result; // Max is in the tail
        } else {
            return p.value; // Max is in the current node
        }
    }

    /**
     * Test the recursive findMax() method
     */
    public static void main(String[] args) {
        RecursiveMaxList<Integer> list = new RecursiveMaxList<>();

        // Create a list: 3 → 7 → 2 → 9 → 5
        list.addFirst(5);
        list.addFirst(9);
        list.addFirst(2);
        list.addFirst(7);
        list.addFirst(3);

        System.out.println("List created: 3 → 7 → 2 → 9 → 5");

        // Find and print the max
        System.out.println("Maximum value in the list: " + list.findMax()); // Expected: 9
    }
}
