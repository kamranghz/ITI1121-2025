import java.util.Iterator;
import java.util.NoSuchElementException;

// Custom LinkedList class that implements Iterable
class LinkedList<E> implements Iterable<E> {

    // Inner class for Node
    private static class Node<E> {
        E value;
        Node<E> next;

        Node(E value) {
            this.value = value;
        }
    }

    private Node<E> head = null;
    private Node<E> tail = null;

    // Add to the end of the list
    public void addLast(E value) {
        Node<E> newNode = new Node<>(value);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    // Implement the Iterable interface method
    @Override
    public Iterator<E> iterator() {
        return new ListIterator();
    }

    // Internal iterator class
    private class ListIterator implements Iterator<E> {
        private Node<E> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (!hasNext()) throw new NoSuchElementException();
            E value = current.value;
            current = current.next;
            return value;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Remove not supported in this simple version.");
        }
    }
}
