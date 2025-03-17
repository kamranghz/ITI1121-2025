import java.util.NoSuchElementException;

// A generic singly linked list implementation with get and remove methods
public class RemoveLinkedListDemo3<E> {
    private Node<E> head; // Head of the linked list
    
    // Inner class for Node representation
    private static class Node<E> {
        E value;
        Node<E> next;

        Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    // Method to retrieve the value at a given position
    public E get(int pos) {
        // Handle invalid positions
        if (pos < 0 || head == null) {
            throw new IndexOutOfBoundsException("Invalid position");
        }

        Node<E> p = head;
        int index = 0;
        
        // Traverse to the required position
        while (p != null && index < pos) {
            p = p.next;
            index++;
        }

        if (p == null) {
            throw new IndexOutOfBoundsException("Position exceeds list size");
        }
        
        return p.value; // Return the value at the position
    }

    // Method to remove an element at a given position
    public boolean remove(int pos) {
        // Handle invalid position or empty list case
        if (head == null || pos < 0) {
            return false;
        }

        // Special case: removing the head node
        if (pos == 0) {
            head = head.next;
            return true;
        }

        Node<E> p = head;
        int index = 0;

        // Traverse to the node before the one to remove
        while (p.next != null && index < pos - 1) {
            p = p.next;
            index++;
        }

        // If we reached the end or position exceeds size
        if (p.next == null) {
            return false;
        }

        Node<E> toDelete = p.next;
        p.next = toDelete.next; // Bypass the deleted node
        toDelete.value = null;  // Help garbage collector
        toDelete.next = null;

        return true;
    }

    // Method to add elements to the list (for testing)
    public void add(E value) {
        if (head == null) {
            head = new Node<>(value, null);
        } else {
            Node<E> p = head;
            while (p.next != null) {
                p = p.next;
            }
            p.next = new Node<>(value, null);
        }
    }

    // Method to print the linked list
    public void printList() {
        Node<E> p = head;
        while (p != null) {
            System.out.print(p.value + " -> ");
            p = p.next;
        }
        System.out.println("null");
    }

    // Main method to test the implementation
    public static void main(String[] args) {
        RemoveLinkedListDemo3<String> list = new RemoveLinkedListDemo3<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        
        System.out.println("Original list:");
        list.printList();

        // Testing get method
        try {
            System.out.println("Element at position 2: " + list.get(2));
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        // Testing remove method
        System.out.println("Removing element at position 2...");
        if (list.remove(2)) {
            System.out.println("Removal successful");
        } else {
            System.out.println("Removal failed");
        }
        list.printList();

        // Edge cases
        System.out.println("Removing element at position 0 (head)...");
        list.remove(0);
        list.printList();
    }
}
