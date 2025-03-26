/**
 * A generic, ordered singly linked list.
 * This list stores elements in sorted order based on their natural comparison.
 *
 * @param <E> the type of elements stored, must be Comparable
 */
public class OrderedList<E extends Comparable<E>> {

    /**
     * Internal Node class representing each element in the list.
     * Each node stores a value and a reference to the next node.
     */
    private static class Node<E> {
        private E value;       // The value stored in this node
        private Node<E> next;  // Pointer to the next node

        // Constructor to create a new node
        Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    // Reference to the first node in the list (null if list is empty)
    private Node<E> first;

    /**
     * Constructor: creates an empty OrderedList.
     */
    public OrderedList() {
        first = null;
    }

    /**
     * Inserts a new value into the list in its correct position.
     * Maintains sorted order (ascending).
     */
    public void insert(E value) {
        // Special case: empty list or should be inserted at the beginning
        if (first == null || value.compareTo(first.value) < 0) {
            first = new Node<>(value, first);
        } else {
            // Otherwise, find the correct position recursively
            insertRecursive(first, value);
        }
    }

    // Helper method to recursively insert a node in the right place
    private void insertRecursive(Node<E> current, E value) {
        // If we reached the end or found the right spot
        if (current.next == null || value.compareTo(current.next.value) < 0) {
            current.next = new Node<>(value, current.next);
        } else {
            // Keep going to the next node
            insertRecursive(current.next, value);
        }
    }

    /**
     * Returns the number of elements in the list using recursion.
     */
    public int size() {
        return sizeRecursive(first);
    }

    // Recursive size method
    private int sizeRecursive(Node<E> node) {
        if (node == null) {
            return 0; // base case: end of list
        }
        return 1 + sizeRecursive(node.next); // head + tail size
    }

    /**
     * Returns a string representation of the list.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> current = first;
        while (current != null) {
            sb.append(current.value).append(" → ");
            current = current.next;
        }
        sb.append("null");
        return sb.toString();
    }

    // Main method to test our OrderedList
    public static void main(String[] args) {
        OrderedList<Integer> list = new OrderedList<>();
        list.insert(5);
        list.insert(2);
        list.insert(8);
        list.insert(3);

        System.out.println("List contents:");
        System.out.println(list); // Should print in sorted order: 2 → 3 → 5 → 8 → null

        System.out.println("Size of the list: " + list.size()); // Should print 4
    }
}
