public class DoublyLinkedList2<E> {
    private static class Node<E> {
        E element;
        Node<E> next;
        Node<E> prev;

        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    public DoublyLinkedList2() {
        head = null;
        tail = null;
    }

    public void add(int pos, E element) {
        if (pos < 0 || pos > size) {
            throw new IndexOutOfBoundsException("Position " + pos + " out of bounds for list of size " + size);
        }

        Node<E> newNode = new Node<>(element, null, null);
        if (pos == 0) {
            if (head == null) {
                head = tail = newNode;
            } else {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
        } else if (pos == size) {
            if (tail == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
        } else {
            Node<E> current = head;
            for (int i = 0; i < pos; i++) {
                current = current.next;
            }
            newNode.next = current;
            newNode.prev = current.prev;
            current.prev.next = newNode;
            current.prev = newNode;
        }
        size++;
    }

    public static void main(String[] args) {
        DoublyLinkedList2<Integer> dll = new DoublyLinkedList2<>();
        try {
            dll.add(0, 10); // Adding first element
            dll.add(1, 20); // Adding second element at the end
            dll.add(1, 15); // Adding element at position 1
            dll.add(0, 5);  // Adding new head
            dll.add(dll.size, 25); // Correctly adding at the end

            // Attempting to add at an invalid position
            dll.add(10, 30); // This should throw an exception
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }
}
