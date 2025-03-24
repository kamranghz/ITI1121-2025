public class DoublyLinkedList<E> {
    private static class Node<T> {
        T value;
        Node<T> previous;
        Node<T> next;

        private Node(T value, Node<T> previous, Node<T> next) {
            this.value = value;
            this.previous = previous;
            this.next = next;
        }
    }

    private Node<E> head;
    private Node<E> tail;

    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    public void addFirst(E value) {
        Node<E> newNode = new Node<>(value, null, head);
        if (head != null) {
            head.previous = newNode;
        } else {
            tail = newNode; // If the list was empty, tail will also point to the new node
        }
        head = newNode;
    }

    public void addLast(E value) {
        if (tail == null) {
            addFirst(value); // If the list is empty, add first
        } else {
            Node<E> newNode = new Node<>(value, tail, null);
            tail.next = newNode;
            tail = newNode;
        }
    }

    public E removeLast() {
        if (tail == null) return null;
        E value = tail.value;
        tail = tail.previous;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null; // List becomes empty
        }
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
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        list.printList(); // Print the list before removal

        // Measuring the time taken to remove the last element in nanoseconds
        long startTime = System.nanoTime();
        int removedValue = list.removeLast();
        long endTime = System.nanoTime();

        System.out.println("Removed: " + removedValue);
        list.printList(); // Print the list after removal

        System.out.println("Time taken for removeLast: " + (endTime - startTime) + " ns");
    }
}
