import java.util.NoSuchElementException;

/**
 * A custom generic singly linked list that supports checking
 * whether the elements are in non-decreasing (increasing) order.
 */
public class IncreasingList<E extends Comparable<E>> {

    /**
     * A private static nested Node class used internally.
     */
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

    // Constructor creates an empty list
    public IncreasingList() {
        first = null;
    }

    /**
     * Adds a new element to the front of the list.
     * Used for testing.
     */
    public void addFirst(E value) {
        first = new Node<>(value, first);
    }

    /**
     * Public method to start the recursive isIncreasing check.
     * This method simply calls the private recursive method.
     */
    public boolean isIncreasing() {
        return isIncreasing(first);
    }

    /**
     * Private recursive method that checks if the list is increasing.
     *
     * Strategy:
     * - Base case: if list is empty or only one element → it’s increasing.
     * - Recursive case: 
     *      1. Compare current node with next.
     *      2. If current > next → return false.
     *      3. Otherwise, recursively check the rest of the list.
     */
    private boolean isIncreasing(Node<E> p) {
        // Base case: empty list or single-element list
        if (p == null || p.next == null) {
            return true;
        }

        // If current value is greater than the next one, list is not increasing
        if (p.value.compareTo(p.next.value) > 0) {
            return false;
        }

        // Recursive call: check the rest of the list
        return isIncreasing(p.next);
    }

    /**
     * Test the isIncreasing method.
     */
    public static void main(String[] args) {
        IncreasingList<Integer> list = new IncreasingList<>();

        // Example 1: [1, 2, 2, 3, 5] => increasing 
        list.addFirst(5);
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(2);
        list.addFirst(1);
        System.out.println("Is list [1,2,2,3,5] increasing? " + list.isIncreasing());  // Output: true

        // Example 2: [4, 3, 2] => not increasing 
        IncreasingList<Integer> list2 = new IncreasingList<>();
        list2.addFirst(2);
        list2.addFirst(3);
        list2.addFirst(4);
        System.out.println("Is list [4,3,2] increasing? " + list2.isIncreasing());  // Output: false
    }
}
