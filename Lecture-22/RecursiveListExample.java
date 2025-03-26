/**
 * An example for recursive list size using the "head + tail" strategy.
 * Class name changed to avoid conflict with user's existing OrderedList class.
 */
public class RecursiveListExample<E> {

    /**
     * Inner static Node class representing each element in the linked list.
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
    private Node<E> head;

    // Constructor: starts with an empty list
    public RecursiveListExample() {
        head = null;
    }

    /**
     * Public method: initiates the recursive size computation.
     */
    public int size() {
        return size(head);
    }

    /**
     * Private recursive method: uses "head + tail" strategy to count nodes.
     *
     * Base case: if the list is empty, return 0.
     * General case: 1 + size of the tail.
     */
    private int size(Node<E> node) {
        if (node == null) {
            return 0; // Base case: empty list
        }
        return 1 + size(node.next); // Recursive case: head + size of tail
    }

    /**
     * Adds an element to the front of the list for demonstration.
     */
    public void addFirst(E value) {
        head = new Node<>(value, head);
    }

    /**
     * Main method for testing and demonstration.
     */
    public static void main(String[] args) {
        RecursiveListExample<Integer> list = new RecursiveListExample<>();

        // Add elements to the list: 5 → 4 → 3 → 2 → 1
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.addFirst(5);

        // Compute and display the size
        System.out.println("Size of the list: " + list.size()); // Output: 5
    }
}
