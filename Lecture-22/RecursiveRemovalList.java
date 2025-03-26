import java.util.NoSuchElementException;

/**
 * Demonstrates a recursive method to REMOVE the first occurrence of an element
 * from a singly linked list, following the "head + tail" strategy.
 * Emphasizes the importance of special case handling and structural modification.
 */
public class RecursiveRemovalList<E> {

    /**
     * Node class representing each element in the singly linked list.
     */
    private static class Node<E> {
        E value;
        Node<E> next;

        Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node<E> first; // Head of the list

    public RecursiveRemovalList() {
        first = null;
    }

    /**
     * Adds an element at the end of the list.
     */
    public void addLast(E value) {
        if (first == null) {
            first = new Node<>(value, null);
            return;
        }
        Node<E> current = first;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node<>(value, null);
    }

    /**
     * Public method to remove the first occurrence of the specified value.
     * Handles the special case where the value is at the head of the list.
     */
    public void remove(E o) {
        if (first == null) {
            throw new NoSuchElementException("List is empty.");
        }
        if (first.value.equals(o)) {
            first = first.next; // Special case: remove head
            return;
        }
        remove(first, o); // Recursive helper
    }

    /**
     * Private recursive method to remove the first occurrence of o starting from node p.
     * Always looks at p.next, because we cannot go backward in a singly linked list.
     */
    private void remove(Node<E> p, E o) {
        if (p.next == null) {
            throw new NoSuchElementException("Value not found: " + o);
        }

        if (p.next.value.equals(o)) {
            p.next = p.next.next; // Skip over the matching node
            return;
        }

        remove(p.next, o); // Continue search
    }

    /**
     * Prints the content of the list in a readable format.
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
     * Demonstrates the remove functionality.
     */
    public static void main(String[] args) {
        RecursiveRemovalList<String> list = new RecursiveRemovalList<>();

        list.addLast("A");
        list.addLast("B");
        list.addLast("C");
        list.addLast("B");
        list.addLast("D");

        System.out.println("Initial list:");
        list.printList();

        System.out.println("\nRemoving first 'B':");
        list.remove("B");
        list.printList();

        System.out.println("\nRemoving first 'A':");
        list.remove("A");
        list.printList();

        System.out.println("\nAttempting to remove 'Z' (not in list):");
        try {
            list.remove("Z");
        } catch (NoSuchElementException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        System.out.println("\nFinal list:");
        list.printList();
    }
}
