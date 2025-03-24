import java.util.Iterator;
import java.util.ConcurrentModificationException;

public class LinkedList<E> {

    // Inner static node class
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

    public void addFirst(E value) {
        head = new Node<>(value, head);
        modCount++;
    }

    public void deleteFirst() {
        if (head != null) {
            head = head.next;
            modCount++;
        }
    }

    public Iterator<E> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<E> {
        private Node<E> current = null;        // current node
        private Node<E> previous = null;       // one behind current
        private boolean canRemove = false;     // track if remove() is valid
        private int expectedModCount;

        public ListIterator() {
            expectedModCount = modCount;
        }

        private void isValid() {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException("Fail-fast: List modified externally.");
            }
        }

        public boolean hasNext() {
            isValid();
            return (current == null && head != null) || (current != null && current.next != null);
        }

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
