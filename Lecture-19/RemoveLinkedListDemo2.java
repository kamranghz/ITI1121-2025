import java.util.NoSuchElementException;

public class RemoveLinkedListDemo2<E> {
    private Node<E> head;  // Head of the list

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
        head = head.next; // Move head to the next node
        first.next = null; // Help GC by unlinking the removed node
        first.value = null; // Clear the data of the removed node
        return savedValue; // Return the value of the removed node
    }

    // Method to remove the last element using a two-pointer technique
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
        while (p.next.next != null) {
            p = p.next; // Stop at the second last node
        }
        E savedValue = p.next.value; // Save the value of the last node
        p.next = null; // Remove the last node
        return savedValue; // Return the value of the removed node
    }

    // Method to remove an element by value
    public boolean remove(E o) {
        if (head == null) return false; // If list is empty

        // Special case: removing head
        if (head.value.equals(o)) {
            head = head.next;
            return true;
        }

        Node<E> p = head;
        while (p.next != null && !p.next.value.equals(o)) {
            p = p.next;
        }
        if (p.next == null) return false; // Element not found

        Node<E> toDelete = p.next;
        p.next = toDelete.next; // Remove the node
        toDelete.value = null;
        toDelete.next = null;
        return true;
    }

    // Method to print the list values for verification
    public void printList() {
        Node<E> current = head;
        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        RemoveLinkedListDemo2<String> list = new RemoveLinkedListDemo2<>();
        list.head = new Node<>("A", new Node<>("B", new Node<>("C", new Node<>("D", null))));

        System.out.println("Original list:");
        list.printList();

        System.out.println("Removed first: " + list.removeFirst());
        list.printList();

        System.out.println("Removed last: " + list.removeLast());
        list.printList();

        System.out.println("Removing 'B': " + list.remove("B"));
        list.printList();

        System.out.println("Trying to remove 'X' (not in list): " + list.remove("X"));
        list.printList();
    }
}
