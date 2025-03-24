public class DoublyLinkedList1<E> {
    private Node<E> head;
    private Node<E> tail;

    private static class Node<E> {
        E element;
        Node<E> next;
        Node<E> prev;

        Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }

    public void addFirst(E element) {
        Node<E> newNode = new Node<>(element, null, head);
        if (head == null) {
            tail = newNode;  // If the list was empty, newNode is now the tail as well.
        } else {
            head.prev = newNode;
        }
        head = newNode;
    }

    public void addLast(E element) {
        Node<E> newNode = new Node<>(element, tail, null);
        if (tail == null) {
            head = newNode;  // If the list was empty, newNode is now the head as well.
        } else {
            tail.next = newNode;
        }
        tail = newNode;
    }

    public void printList() {
        Node<E> current = head;
        while (current != null) {
            System.out.print(current.element + " <-> ");
            current = current.next;
        }
        System.out.println("END");
    }

    public static void main(String[] args) {
        DoublyLinkedList1<Integer> list = new DoublyLinkedList1<>();
        list.addFirst(10);
        list.addFirst(20);
        list.addLast(5);
        list.addLast(1);

        list.printList();  // Output should show the doubly linked list contents.
    }
}
