import java.util.LinkedList;
import java.util.NoSuchElementException;

public class RecursiveFilterLessThanDemo<E extends Comparable<E>> {

    // Node class for singly linked list
    private static class Node<E> {
        E value;
        Node<E> next;

        Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node<E> head; // first node of the list

    // Adds a new element at the end (for demo purposes)
    public void add(E value) {
        if (head == null) {
            head = new Node<>(value, null);
        } else {
            Node<E> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node<>(value, null);
        }
    }

    // Public method students will call
    public LinkedList<E> filterLessThan(E c) {
        return filterLessThan(head, c);
    }

    // Recursive helper that implements the "head + tail" strategy
    private LinkedList<E> filterLessThan(Node<E> node, E c) {
        LinkedList<E> result;

        if (node == null) {
            // Base Case: empty list
            result = new LinkedList<>();
        } else {
            // Recursive step: get result from the tail
            result = filterLessThan(node.next, c);

            // Post-processing: check current head
            if (node.value.compareTo(c) < 0) {
                result.addFirst(node.value); // Add to the front to maintain order
            }
        }
        return result;
    }

    // Main to demonstrate and print step-by-step
    public static void main(String[] args) {
        RecursiveFilterLessThanDemo<Integer> list = new RecursiveFilterLessThanDemo<>();

        // Add elements to the list
        list.add(7);
        list.add(3);
        list.add(10);
        list.add(2);
        list.add(5);

        System.out.println("Original List: [7, 3, 10, 2, 5]");

        // Call filterLessThan(6)
        LinkedList<Integer> filtered = list.filterLessThan(6);

        System.out.println("Filtered List (less than 6): " + filtered);  // Output: [3, 2, 5]
    }
}
