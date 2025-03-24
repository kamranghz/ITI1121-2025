import java.util.Iterator;
import java.util.NoSuchElementException;

// This class demonstrates how multiple iterators can work independently on a linked list.
public class MultipleIteratorDemo1<E> {

    // Node class to represent each element in the linked list
    private static class Node<E> {
        E value;
        Node<E> next;

        Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    // Pointer to the beginning of the list
    private Node<E> head;

    // Adds a new element at the beginning of the list
    public void addFirst(E value) {
        head = new Node<>(value, head);
    }

    // Returns a new iterator for this list
    public Iterator<E> iterator() {
        return new LinkedListIterator<>(this);
    }

    // Static nested class: each iterator gets its own state
    private static class LinkedListIterator<E> implements Iterator<E> {
        private Node<E> current;
        private MultipleIteratorDemo1<E> myList;

        // Constructor links this iterator to the outer list
        public LinkedListIterator(MultipleIteratorDemo1<E> list) {
            this.myList = list;
            this.current = null;
        }

        // Checks if there is a next element to visit
        public boolean hasNext() {
            return (current == null && myList.head != null) ||
                   (current != null && current.next != null);
        }

        // Moves to the next element and returns its value
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements.");
            }

            if (current == null) {
                current = myList.head; // Start from the beginning
            } else {
                current = current.next;
            }

            return current.value;
        }
    }

    // Main method to demonstrate multiple independent iterators
    public static void main(String[] args) {
        MultipleIteratorDemo1<String> list = new MultipleIteratorDemo1<>();

        // Add elements to the list: A -> B -> C -> D
        list.addFirst("D");
        list.addFirst("C");
        list.addFirst("B");
        list.addFirst("A");

        // Create two separate iterators
        Iterator<String> i = list.iterator();
        Iterator<String> j = list.iterator();

        System.out.println("Iterator i:");
        while (i.hasNext()) {
            System.out.println("i --> " + i.next());
        }

        System.out.println("\nIterator j:");
        while (j.hasNext()) {
            System.out.println("j --> " + j.next());
        }
    }
}
