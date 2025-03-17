public class SinglyLinkedList<E> {
    private Node<E> head;  // Pointer to the first node of the list

    // Node inner class for singly linked list
    private static class Node<E> {
        E data;            // Data held by the node
        Node<E> next;      // Pointer to the next node in the list

        // Node constructor links the node to a next node and stores data
        Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    // Constructor initializes an empty list
    public SinglyLinkedList() {
        head = null;  // At the start, head is null indicating an empty list
    }

    // Method to add an element at the beginning of the list
    public void addFirst(E data) {
        Node<E> newNode = new Node<>(data, head);  // Create a new node with next as the current head
        head = newNode;  // Update head to point to the new node, making it the first node
        System.out.println("Added " + data + " to the front of the list.");
        displayList();
    }

    // Helper method to display the current state of the list
    public void displayList() {
        Node<E> current = head;  // Start from the head
        System.out.print("List: ");
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.addFirst("A");  // First element, making the list: A -> null
        list.addFirst("newNode");  // Adding a new node to the front, making the list: newNode -> A -> null
    }
}
