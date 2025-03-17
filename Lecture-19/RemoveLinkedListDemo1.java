import java.util.NoSuchElementException; // Import the NoSuchElementException class

public class RemoveLinkedListDemo1<E> {
    private Node<E> head;  // head of the list

    private static class Node<E> {
        E value;
        Node<E> next;

        Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    // Method to remove the first element from the list
    public E removeFirst() {
        if (head == null) {
            throw new NoSuchElementException("Cannot remove from an empty list");
        }
        E savedValue = head.value;
        Node<E> first = head;
        head = head.next; // Move head to next node
        first.next = null; // Help GC by unlinking the removed node
        first.value = null; // Clear the data of the removed node
        return savedValue; // Return the value of the removed node
    }

    // Method to remove the last element using two-pointer technique
    public E removeLast() {
        if (head == null) {
            throw new NoSuchElementException("Cannot remove from an empty list");
        }
        if (head.next == null) { // Special case: only one node in the list
            E savedValue = head.value;
            head = null; // Clear the list
            return savedValue;
        }
        Node<E> p = head;
        Node<E> q = null; // Second pointer to track the node before last

        // Traverse until p is the second last node
        while (p.next != null && p.next.next != null) {
            if (q == null) {
                q = head;  // Initialize q when p is two steps ahead
            } else {
                q = q.next;  // Move q forward
            }
            p = p.next; // Move p to the next node
        }

        // If q is still null, it means list has only two nodes
        if (q == null) {
            q = head;  // Set q to head
        }

        E savedValue = p.next.value; // Save the value of the last node
        p.next = null; // Remove the last node
        return savedValue; // Return the value of the removed node
    }

    // Optional: method to print the list values for verification
    public void printList() {
        Node<E> current = head;
        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        RemoveLinkedListDemo1<String> list = new RemoveLinkedListDemo1<>();
        list.head = new Node<>("A", new Node<>("B", new Node<>("C", new Node<>("D", null))));

        System.out.println("Original list:");
        list.printList();

        System.out.println("Removed first: " + list.removeFirst());
        list.printList();

        System.out.println("Removed last: " + list.removeLast());
        list.printList();
    }
}
