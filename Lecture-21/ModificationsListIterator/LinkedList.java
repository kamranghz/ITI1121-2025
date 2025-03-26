import java.util.Iterator;
import java.util.ConcurrentModificationException;

/**
 * Custom LinkedList<E> with Fail-Fast Iterator, Add, and Remove Support
 */
public class LinkedList<E> implements Iterable<E> {

    // Node class
    private static class Node<E> {
        E value;
        Node<E> next;

        Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node<E> head;
    private int modCount = 0;

    // Add element to the front
    public void addFirst(E value) {
        head = new Node<>(value, head);
        modCount++;
    }

    // Remove the first element
    public void deleteFirst() {
        if (head != null) {
            head = head.next;
            modCount++;
        }
    }

    // Return a new iterator
    @Override
    public Iterator<E> iterator() {
        return new ListIterator();
    }

    // Public ListIterator with fail-fast support
    public class ListIterator implements Iterator<E> {
        private Node<E> current = null;
        private Node<E> previous = null;
        private boolean canRemove = false;
        private int expectedModCount;

        public ListIterator() {
            expectedModCount = modCount;
        }

        private void isValid() {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException("Fail-fast: List modified externally.");
            }
        }

        @Override
        public boolean hasNext() {
            isValid();
            return (current == null && head != null) || (current != null && current.next != null);
        }

        @Override
        public E next() {
            isValid();
            if (!hasNext()) {
                throw new IllegalStateException("No next element.");
            }
            previous = current;
            current = (current == null) ? head : current.next;
            canRemove = true;
            return current.value;
        }

        public void remove() {
            isValid();
            if (!canRemove) {
                throw new IllegalStateException("Call next() before remove().");
            }

            if (current == head) {
                head = head.next;
            } else {
                Node<E> tmp = head;
                while (tmp.next != current) {
                    tmp = tmp.next;
                }
                tmp.next = current.next;
            }

            current = previous;
            modCount++;
            expectedModCount++;
            canRemove = false;
        }

        public void add(E value) {
            isValid();
            if (value == null) return;

            if (current == null) {
                head = new Node<>(value, head);
                current = head;
            } else {
                current.next = new Node<>(value, current.next);
                current = current.next;
            }

            modCount++;
            expectedModCount++;
            canRemove = false;
        }
    }
}
