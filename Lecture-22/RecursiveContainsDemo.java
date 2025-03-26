/**
 * This class demonstrates a recursive contains(E o) method in a custom singly linked list.
 * 
 * Core Idea:
 * Use the "head + tail" recursion strategy:
 *  - Check if the current node (head) matches the value.
 *  - If not, recursively search in the rest of the list (tail).
 * 
 * Base Case:
 *  - If the current node is null, the list is empty or we've reached the end → return false.
 * 
 * Early Termination:
 *  - As soon as a match is found, return true and stop the recursion.
 */

public class RecursiveContainsDemo<E> {

    // Inner Node class to hold data and reference to the next node
    private static class Node<E> {
        E value;
        Node<E> next;

        Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    // Head pointer to the first element of the list
    private Node<E> first;

    // Constructor: start with an empty list
    public RecursiveContainsDemo() {
        first = null;
    }

    // Public method to add elements to the list (adds to the end)
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
     * Public method: initiates the recursive search.
     * 
     * @param target the object to find
     * @return true if the object exists in the list
     */
    public boolean contains(E target) {
        return contains(target, first);
    }

    /**
     * Private recursive method that searches the list.
     *
     * Base case:
     *  - If the list is empty or we reach the end (p == null), return false.
     *
     * Recursive case:
     *  - If the current node matches the target, return true.
     *  - Otherwise, search in the rest of the list (tail).
     */
    private boolean contains(E target, Node<E> p) {
        if (p == null) {
            // Base case: Reached end of list, not found
            return false;
        }

        if (p.value.equals(target)) {
            // Base case: Found the value
            return true;
        }

        // Recursive step: continue searching in the rest of the list
        return contains(target, p.next);
    }

    /**
     * Utility method to display the list contents
     */
    public void printList() {
        Node<E> current = first;
        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Main method to demonstrate and test the contains() function
    public static void main(String[] args) {
        RecursiveContainsDemo<String> list = new RecursiveContainsDemo<>();

        list.add("apple");
        list.add("banana");
        list.add("cherry");
        list.add("date");

        list.printList();  // Output: apple -> banana -> cherry -> date -> null

        // Test cases
        System.out.println("Contains 'banana'? " + list.contains("banana")); // true
        System.out.println("Contains 'fig'? " + list.contains("fig"));       // false
        System.out.println("Contains 'apple'? " + list.contains("apple"));   // true
        System.out.println("Contains 'date'? " + list.contains("date"));     // true
    }
}
