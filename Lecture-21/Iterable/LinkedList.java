/*
 * Summary: Custom LinkedList<E> Implementing Iterable<E>
 *
 * This code defines a generic singly linked list (`LinkedList<E>`) that supports iteration 
 * using both the traditional `Iterator` and Java’s enhanced for-loop (`for-each`), thanks 
 * to its implementation of the `Iterable` interface.
 *
 * Key Features:
 * ---------------------------------------
 * - `addLast(E value)`: Adds a new element to the end of the list.
 * - `Node<E>`: Inner static class representing each node with a value and a reference to the next node.
 * - `iterator()`: Returns a custom iterator (`ListIterator`) starting from the head of the list.
 * - `ListIterator`: Implements `Iterator<E>` and provides:
 *     - `hasNext()`: Checks if there are more elements to visit.
 *     - `next()`: Returns the current element and advances the iterator.
 *     - `remove()`: Not supported in this version (throws exception).
 *
 * Usage:
 * ---------------------------------------
 * - Enables both manual iteration via `Iterator` and simplified looping via `for-each`.
 * - Ensures compatibility with Java’s collection-handling idioms.
 *
 * Purpose:
 * ---------------------------------------
 * - Demonstrates how to implement `Iterable` for custom data structures.
 * - Reinforces understanding of Java's iteration mechanism.
 */


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
