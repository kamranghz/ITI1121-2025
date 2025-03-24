// Custom implementation of a generic LinkedList with an inner ListIterator
public class AddElementsWithIteratorDemo {

    public static void main(String[] args) {
        // Create a LinkedList of Strings
        LinkedList<String> list = new LinkedList<>();

        // Create an iterator for the list
        LinkedList<String>.ListIterator iterator = list.iterator();

        // Add elements using the iterator
        for (int c = 0; c < 5; c++) {
            iterator.add("element-" + c); // inserts element before 'next()' position
        }

        // Reset the iterator to the beginning
        iterator = list.iterator();

        // Traverse and print all elements in the list
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

// Generic LinkedList class
class LinkedList<E> {

    // Node definition for singly linked list
    private static class Node<E> {
        E value;
        Node<E> next;

        Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    // Head of the list
    private Node<E> first;

    // Inner class: custom iterator
    public class ListIterator {
        private Node<E> current;

        // Start before the first element
        public ListIterator() {
            current = null;
        }

        // Check if there's a next node
        public boolean hasNext() {
            if (current == null)
                return first != null;
            else
                return current.next != null;
        }

        // Get the next element and move forward
        public E next() {
            if (current == null) {
                current = first;
            } else {
                current = current.next;
            }
            return current.value;
        }

        // Add element before the next() value
        public boolean add(E o) {
            if (o == null) return false;

            if (current == null) {
                // Insert at beginning
                first = new Node<>(o, first);
                current = first;
            } else {
                // Insert after current
                current.next = new Node<>(o, current.next);
                current = current.next;
            }
            return true;
        }
    }

    // Factory method to return a new iterator
    public ListIterator iterator() {
        return new ListIterator();
    }
}
