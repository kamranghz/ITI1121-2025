import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Strategy1SublistDemo
 * ---------------------
 * Demonstrates the recursive construction of a sublist from a singly linked list
 * using the "Head + Tail" pattern (Strategy 1).
 * 
 * In this strategy, the method recursively reaches the desired end index (toIndex)
 * and builds the list backwards by adding values only if they are within the range.
 *
 * This class is intended for educational purposes to help students learn
 * recursive list processing with conceptual clarity.
 */
public class Strategy1SublistDemo<E> {

    // Node class for the singly linked list
    private static class Node<E> {
        E value;
        Node<E> next;

        Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    // First node in the list
    private Node<E> first = null;

    /**
     * Adds an element to the end of the list (for testing purposes).
     */
    public void addLast(E value) {
        if (first == null) {
            first = new Node<>(value, null);
        } else {
            Node<E> temp = first;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node<>(value, null);
        }
    }

    /**
     * Public method to return a sublist between fromIndex and toIndex (inclusive).
     * This is the method students will use.
     */
    public LinkedList<E> subList(int fromIndex, int toIndex) {
        if (fromIndex > toIndex || fromIndex < 0) {
            throw new IllegalArgumentException("Invalid index range.");
        }
        return subList(first, fromIndex, toIndex, 0);
    }

    /**
     * Private recursive method implementing Strategy 1: "head + tail".
     * Recursively reaches toIndex, then builds the result list backwards.
     */
    private LinkedList<E> subList(Node<E> p, int fromIndex, int toIndex, int index) {
        LinkedList<E> result;

        // Base Case: Reached toIndex, start building result list
        if (index == toIndex) {
            result = new LinkedList<>();
            result.addFirst(p.value);
        } else {
            // Recursive Call: Move to the next node and increase the index
            result = subList(p.next, fromIndex, toIndex, index + 1);

            // Post-processing: Add the current value if it's within the range
            if (index >= fromIndex) {
                result.addFirst(p.value);
            }
        }

        return result;
    }

    /**
     * Utility method to print the full original list.
     */
    public void printOriginalList() {
        Node<E> temp = first;
        System.out.print("Original list: ");
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /**
     * Main method for demonstration and testing
     */
    public static void main(String[] args) {
        Strategy1SublistDemo<Integer> list = new Strategy1SublistDemo<>();

        // Adding sample values
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);

        // Display full list
        list.printOriginalList();

        // Create and display sublist from index 1 to 3
        LinkedList<Integer> sublist = list.subList(1, 3);
        System.out.println("Sublist from index 1 to 3: " + sublist);
    }
}
