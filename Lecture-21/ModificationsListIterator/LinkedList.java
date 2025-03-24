/*
 * Summary: Custom LinkedList<E> with Fail-Fast Iterator, Add, and Remove Support
 *
 * This class implements a generic singly linked list with custom iterator functionality
 * that supports:
 *  - Safe traversal using `hasNext()` and `next()`
 *  - Element removal with `remove()`
 *  - Element insertion with `add(E)`
 *  - **Fail-fast behavior** when the list is modified outside the iterator
 *
 * Key Components:
 * -----------------------------
 * 1. **Node<E>**: Static inner class to store data and reference to the next node.
 * 2. **LinkedList<E> Fields**:
 *    - `head`: Reference to the first node.
 *    - `modCount`: Tracks modifications to detect external changes during iteration.
 * 3. **Public Methods**:
 *    - `addFirst(E value)`: Inserts an element at the beginning and updates `modCount`.
 *    - `deleteFirst()`: Removes the first element (if any) and updates `modCount`.
 *    - `iterator()`: Returns a custom `ListIterator` instance.
 *
 * Iterator Functionality:
 * -----------------------------
 * - `ListIterator` is an inner class implementing `Iterator<E>`.
 * - It maintains its own `expectedModCount` to implement **fail-fast** detection.
 * - `isValid()` checks for external modifications and throws `ConcurrentModificationException` if detected.
 * - `next()`: Advances and returns the next element, ensuring validity.
 * - `remove()`: Removes the current element safely and adjusts links.
 * - `add(E value)`: Inserts a new node after the current position.
 *
 * Fail-Fast Behavior:
 * -----------------------------
 * - If the list is modified (via `addFirst`, `deleteFirst`, etc.) while iterating,
 *   the iterator detects this and throws a `ConcurrentModificationException`.
 *
 * Value:
 * -----------------------------
 * - Demonstrates the inner workings of a fail-fast iterator.
 * - Mimics Java’s built-in `Iterator` behavior with custom add/remove support.
 * - Helps understand how internal consistency and concurrent modification detection is implemented.
 */




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
