/**
 * Class representing a simple singly linked list with an equals method.
 * This method checks if two lists contain equivalent elements in the same order.
 */
public class LinkedListEquals<E> {
    private Node<E> head; // Head node of the list

    /**
     * Inner static class representing a Node in the linked list.
     */
    private static class Node<E> {
        E value;  // Value stored in the node
        Node<E> next;  // Reference to the next node

        Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    /**
     * Method to add a new element at the end of the list.
     */
    public void add(E value) {
        if (head == null) {
            head = new Node<>(value, null);
            return;
        }
        Node<E> current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node<>(value, null);
    }

    /**
     * Method to compare this list with another linked list for equality.
     * Returns true if both lists contain the same elements in the same order.
     */
    public boolean equals(LinkedListEquals<E> otherList) {
        Node<E> p = this.head; // Pointer for the first list
        Node<E> q = otherList.head; // Pointer for the second list

        // Traverse both lists and compare elements one by one
        while (p != null && q != null) {
            if (!p.value.equals(q.value)) {
                return false; // Found a mismatch
            }
            p = p.next;
            q = q.next;
        }

        // If both lists have reached the end, they are equal
        return p == null && q == null;
    }

    /**
     * Helper method to print the list elements.
     */
    public void printList() {
        Node<E> current = head;
        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Creating first linked list
        LinkedListEquals<String> s = new LinkedListEquals<>();
        s.add("11:30:00");
        s.add("12:50:00");
        s.add("13:00:00");
        s.add("14:20:00");

        // Creating second linked list (same as s)
        LinkedListEquals<String> t = new LinkedListEquals<>();
        t.add("11:30:00");
        t.add("12:50:00");
        t.add("13:00:00");
        t.add("14:20:00");

        // Creating third linked list (different from s)
        LinkedListEquals<String> u = new LinkedListEquals<>();
        u.add("11:30:00");
        u.add("12:50:00");
        u.add("13:00:00");

        // Printing all lists
        System.out.println("List s:");
        s.printList();
        System.out.println("List t:");
        t.printList();
        System.out.println("List u:");
        u.printList();

        // Checking equality
        System.out.println("s.equals(t): " + s.equals(t)); 
        System.out.println("s.equals(u): " + s.equals(u)); 
    }
}
