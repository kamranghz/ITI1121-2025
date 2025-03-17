public class AddLinkedListDemo1 {

    // Node inner class for LinkedList
    private static class Node<E> {
        E data;
        Node<E> next;

        // Node constructor initializes the node's data and its next node reference
        Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<String> head; // head of the list

    // Constructor initializes an empty LinkedList
    public AddLinkedListDemo1() {
        head = null;
    }

    // Adds a node with the specified data at the beginning of the list
    public void addFirst(String data) {
        // Creating a new node. The new node's next reference points to the current head
        Node<String> newNode = new Node<>(data, head);
        // The new node becomes the head of the list
        head = newNode;
        System.out.println("Added '" + data + "' at the beginning.");
        displayList();
    }

    // Adds a node with the specified data at the end of the list
    public void addLast(String data) {
        Node<String> newNode = new Node<>(data, null); // Create a new node pointing to null
        if (head == null) {
            // If the list is empty, the new node becomes the head
            head = newNode;
            System.out.println("Added '" + data + "' at the end (was the first element).");
        } else {
            // Find the last node of the list
            Node<String> current = head;
            while (current.next != null) {
                current = current.next;
            }
            // Make the new node the last node
            current.next = newNode;
            System.out.println("Added '" + data + "' at the end.");
        }
        displayList();
    }

    // Displays the current elements in the list
    public void displayList() {
        Node<String> current = head;
        System.out.print("Current List: ");
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        AddLinkedListDemo1 list = new AddLinkedListDemo1();
        list.addFirst("C");
        list.addFirst("B");
        list.addFirst("A"); // List is now A -> B -> C -> null

        list.addLast("D"); // List is A -> B -> C -> D -> null
        list.addLast("E"); // Continues to add elements at the end
    }
}
