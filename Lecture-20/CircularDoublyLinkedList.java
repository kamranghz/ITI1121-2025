public class CircularDoublyLinkedList<E> {
    private Node<E> head; // Dummy node

    private static class Node<E> {
        E value;
        Node<E> next;
        Node<E> prev;

        Node(E value, Node<E> prev, Node<E> next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    public CircularDoublyLinkedList() {
        head = new Node<>(null, null, null);
        head.next = head; // Point to itself, circular nature
        head.prev = head; // Point to itself, circular nature
    }

    public void add(E element) {
        Node<E> newNode = new Node<>(element, head, head.next);
        head.next.prev = newNode;
        head.next = newNode;
    }

    // Method to display the list
    public void display() {
        Node<E> current = head.next; // Start after dummy
        while (current != head) { // Stop when circled back to dummy
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularDoublyLinkedList<Integer> list = new CircularDoublyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.display(); // Should display 1 2 3
    }
}
