public class SinglyLinkedList {
    // Node class to store data and reference to the next node
    private static class Node {
        String value;
        Node next;

        Node(String value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    // Head node of the list
    private Node head;

    // Constructor initializes the head to null
    public SinglyLinkedList() {
        head = null;
    }

    // Method to add elements to the front of the list
    public void addFirst(String value) {
        head = new Node(value, head);
    }

    // Method to traverse the list and print each element, including timing the traversal
    public void printList() {
        long startTime = System.nanoTime(); // Start timing
        Node current = head;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
        long endTime = System.nanoTime(); // End timing
        System.out.println("Time to traverse: " + (endTime - startTime) + " nanoseconds");
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addFirst("bleu");
        list.addFirst("blanc");
        list.addFirst("rouge");
        list.addFirst("jaune");
        list.addFirst("vert");
        list.addFirst("orange");
        list.printList();
    }
}
