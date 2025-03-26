import java.util.LinkedList;

// A generic predicate interface to decide whether a value matches a condition
interface Predicate<E> {
    boolean evaluate(E arg);
}

// Our singly linked list class with recursive filter logic
public class RecursiveFilterGenericDemo<E> {

    // Static inner node class for list elements
    private static class Node<E> {
        E value;
        Node<E> next;

        Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node<E> head;

    // Method to add an element at the end of the list
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

    /**
     * Public filter method that initiates recursive filtering.
     * Accepts any predicate to evaluate elements.
     */
    public LinkedList<E> filter(Predicate<E> f) {
        return filter(head, f);
    }

    /**
     * Recursive filtering method using "head + tail" strategy.
     * If the node is null (base case), return an empty list.
     * Otherwise, get the filtered tail and add current value if it satisfies the condition.
     */
    private LinkedList<E> filter(Node<E> p, Predicate<E> f) {
        LinkedList<E> result;

        if (p == null) {
            result = new LinkedList<>();
        } else {
            result = filter(p.next, f); // Recursive step: process the tail

            // Post-processing: check if current node should be included
            if (f.evaluate(p.value)) {
                result.addFirst(p.value); // add to front to preserve order
            }
        }
        return result;
    }

    // Utility method to print the list
    public void print() {
        Node<E> temp = head;
        System.out.print("List: [");
        while (temp != null) {
            System.out.print(temp.value);
            if (temp.next != null) System.out.print(", ");
            temp = temp.next;
        }
        System.out.println("]");
    }

    // Main method to demonstrate filter usage
    public static void main(String[] args) {
        RecursiveFilterGenericDemo<Integer> list = new RecursiveFilterGenericDemo<>();

        // Populate list
        list.add(3);
        list.add(-2);
        list.add(0);
        list.add(7);
        list.add(-5);

        list.print();  // Output: List: [3, -2, 0, 7, -5]

        // Example 1: Filter all negatives using a named class
        LinkedList<Integer> negatives = list.filter(new IsNegative());
        System.out.println("Negatives: " + negatives);  // Output: [-2, -5]

        // Example 2: Filter all positives using an anonymous class
        LinkedList<Integer> positives = list.filter(new Predicate<Integer>() {
            public boolean evaluate(Integer arg) {
                return arg > 0;
            }
        });
        System.out.println("Positives: " + positives);  // Output: [3, 7]
    }
}

// Predicate implementation that checks if a number is negative
class IsNegative implements Predicate<Integer> {
    public boolean evaluate(Integer arg) {
        return arg < 0;
    }
}
