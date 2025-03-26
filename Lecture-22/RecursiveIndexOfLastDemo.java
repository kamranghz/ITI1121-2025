/**
 * A generic singly linked list class demonstrating how to recursively find
 * the index of the last occurrence of a value using the "head + tail" strategy.
 *
 * The method traverses the entire list before making decisions, because we need
 * the rightmost (last) match — not the first!
 */

public class RecursiveIndexOfLastDemo<E> {

    // Node class to store elements and link to the next node
    private static class Node<E> {
        E value;
        Node<E> next;

        Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    // Head pointer to the first node in the list
    private Node<E> first;

    // Constructor: start with an empty list
    public RecursiveIndexOfLastDemo() {
        first = null;
    }

    /**
     * Adds an element to the end of the list.
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
     * Public method: starts the recursive search from the first node.
     */
    public int indexOfLast(E target) {
        return indexOfLast(first, target);
    }

    /**
     * Recursive method to find the index of the **last occurrence** of a value.
     * 
     * Explanation of logic:
     * - We always let the recursion go to the end of the list, because we want the **last** match.
     * - We cannot return early when we find a match (unlike indexOf).
     * - As recursion unwinds, we check if a match was already found in the tail.
     * - If yes: return that index + 1 (because we're moving back to the left).
     * - If not: check if the current node is a match → return 0 (current position).
     * - If no match anywhere: return -1.
     */
    private int indexOfLast(Node<E> p, E target) {
        if (p == null) {
            // Base Case: End of list — nothing was found
            return -1;
        }

        // Recursive call on the tail (rest of the list)
        int result = indexOfLast(p.next, target);

        if (result > -1) {
            // Match found in the tail — adjust the index as we return back
            return result + 1;
        } else if (target.equals(p.value)) {
            // No match in tail, but match found at current node
            return 0;
        } else {
            // No match in tail or current node
            return -1;
        }
    }

    /**
     * Utility method to print the list contents.
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
     * Main method to demonstrate how indexOfLast works.
     */
    public static void main(String[] args) {
        RecursiveIndexOfLastDemo<String> list = new RecursiveIndexOfLastDemo<>();

        list.add("apple");
        list.add("banana");
        list.add("cherry");
        list.add("banana");
        list.add("date");

        list.printList(); // apple -> banana -> cherry -> banana -> date -> null

        System.out.println("Last index of 'banana': " + list.indexOfLast("banana")); // Output: 3
        System.out.println("Last index of 'apple': " + list.indexOfLast("apple"));   // Output: 0
        System.out.println("Last index of 'date': " + list.indexOfLast("date"));     // Output: 4
        System.out.println("Last index of 'kiwi': " + list.indexOfLast("kiwi"));     // Output: -1
    }
}
