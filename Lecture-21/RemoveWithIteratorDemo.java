import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * Summary: RemoveWithIteratorDemo - Custom LinkedList Iterator with Remove and Add Support
 *
 * This program demonstrates how to use a custom `MyLinkedList` class and its inner `ListIterator`
 * to traverse, remove, and add elements to the list dynamically during iteration.
 */

public class RemoveWithIteratorDemo {
    public static void main(String[] args) {
        // Create a MyLinkedList of Doubles
        MyLinkedList<Double> doubles = new MyLinkedList<>();

        // Add some numbers to the list
        doubles.add(2.718);  // e
        doubles.add(3.142);  // pi
        doubles.add(7.389);  // e^2

        // Get an iterator for the list
        MyLinkedList<Double>.ListIterator i = doubles.iterator();

        // Move to second element (3.142)
        i.next();  // points to 2.718
        i.next();  // points to 3.142

        // Remove the element 3.142
        i.remove();  // removes 3.142

        System.out.println("List after removing 3.142:");
        for (Double value : doubles) {
            System.out.println(value);
        }

        // Try removing first element
        i = doubles.iterator();
        i.next(); // points to 2.718
        i.remove(); // removes 2.718

        System.out.println("\nList after removing 2.718:");
        for (Double value : doubles) {
            System.out.println(value);
        }

        // Add a new element at the end
        i = doubles.iterator();
        while (i.hasNext()) {
            i.next(); // move to end
        }
        i.add(9.806);  // gravitational acceleration

        System.out.println("\nList after adding 9.806 at the end:");
        for (Double value : doubles) {
            System.out.println(value);
        }
    }
}

// Custom generic singly linked list class
class MyLinkedList<E> implements Iterable<E> {

    // Node class for internal use
    private static class Node<E> {
        E value;
        Node<E> next;

        Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node<E> head = null;

    // Adds element to the front (default behavior)
    public void add(E value) {
        head = new Node<>(value, head);
    }

    // Iterator factory method
    public ListIterator iterator() {
        return new ListIterator();
    }

    // Custom ListIterator inner class
    public class ListIterator implements Iterator<E> {
        private Node<E> current = null;
        private Node<E> previous = null;
        private Node<E> beforePrevious = null;
        private boolean canRemove = false;

        @Override
        public boolean hasNext() {
            if (current == null) {
                return head != null;
            } else {
                return current.next != null;
            }
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            beforePrevious = previous;
            previous = current;
            current = (current == null) ? head : current.next;
            canRemove = true;
            return current.value;
        }

        // Adds a new node after the current one
        public void add(E value) {
            Node<E> newNode = new Node<>(value, null);
            if (current == null) {
                // Add at the beginning
                newNode.next = head;
                head = newNode;
                current = newNode;
            } else {
                newNode.next = current.next;
                current.next = newNode;
                current = newNode;
            }
            canRemove = false;
        }

        // Removes the last returned element
        @Override
        public void remove() {
            if (!canRemove) {
                throw new IllegalStateException("Call next() before remove()");
            }

            if (current == head) {
                head = head.next;
                current = null;
            } else if (previous != null) {
                previous.next = current.next;
                current = previous;
            }
            canRemove = false;
        }
    }
}
