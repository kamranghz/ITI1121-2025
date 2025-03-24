public class SinglyLinkedList<E> {
    private static class Node<T> {
        T value;
        Node<T> next;

        Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node<E> head;
    private Node<E> tail;

    public SinglyLinkedList() {
        head = null;
        tail = null;
    }

    public void addLast(E value) {
        Node<E> newNode = new Node<>(value, null);
        if (tail != null) {
            tail.next = newNode;
        } else {
            head = newNode;
        }
        tail = newNode;
    }

    public E removeLast() {
        if (tail == null) {
            return null; // List is empty
        }

        if (head == tail) {
            // There is only one element
            E value = head.value;
            head = null;
            tail = null;
            return value;
        }

        // Find the second-to-last node
        Node<E> current = head;
        while (current.next != tail) {
            current = current.next;
        }

        E value = tail.value;
        tail = current;
        tail.next = null;
        return value;
    }

    public void printList() {
        Node<E> current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        System.out.println("Initial list:");
        list.printList(); // Expected: 1 2 3

        // Measure time to remove the last element
        long startTime = System.nanoTime();
        Integer removedValue = list.removeLast();
        long endTime = System.nanoTime();

        System.out.println("Removed element: " + removedValue); // Expected: 3
        System.out.println("List after removal:");
        list.printList(); // Expected: 1 2
        System.out.println("Time taken for removeLast: " + (endTime - startTime) + " ns");
    }
}
