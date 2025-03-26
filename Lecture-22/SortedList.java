/**
 * This class demonstrates how to:
 * - Insert an element while maintaining sorted order.
 * - Delete the last element.
 * - Delete the last occurrence of a specific element.
 * - Delete all occurrences of a specific element.
 * - Delete an element at a given index.
 *
 */

import java.util.NoSuchElementException;

public class SortedList<E extends Comparable<E>> {

    // Internal Node class to hold data and reference to next node
    private static class Node<E> {
        E value;
        Node<E> next;
        Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node<E> head;

    /**
     * Inserts the element in sorted order (ascending).
     */
    public void insertSorted(E element) {
        head = insertSortedRecursive(head, element);
    }

    private Node<E> insertSortedRecursive(Node<E> node, E element) {
        if (node == null || element.compareTo(node.value) <= 0) {
            return new Node<>(element, node);
        }
        node.next = insertSortedRecursive(node.next, element);
        return node;
    }

    /**
     * Deletes the last node in the list.
     */
    public void deleteLast() {
        if (head == null) throw new NoSuchElementException("List is empty.");
        head = deleteLastRecursive(head);
    }

    private Node<E> deleteLastRecursive(Node<E> node) {
        if (node.next == null) return null; // base case: only one element
        node.next = deleteLastRecursive(node.next); // move forward
        return node;
    }

    /**
     * Deletes the last occurrence of the given element.
     */
    public void deleteLastOccurrence(E target) {
        head = deleteLastOccurrenceRecursive(head, target);
    }

    private Node<E> deleteLastOccurrenceRecursive(Node<E> node, E target) {
        if (node == null) return null;
        node.next = deleteLastOccurrenceRecursive(node.next, target);
        if (node.value.equals(target) && (node.next == null || !containsValue(node.next, target))) {
            return node.next; // remove this node
        }
        return node;
    }

    private boolean containsValue(Node<E> node, E value) {
        if (node == null) return false;
        return node.value.equals(value) || containsValue(node.next, value);
    }

    /**
     * Deletes all occurrences of the given element.
     */
    public void deleteAllOccurrences(E target) {
        head = deleteAllOccurrencesRecursive(head, target);
    }

    private Node<E> deleteAllOccurrencesRecursive(Node<E> node, E target) {
        if (node == null) return null;
        if (node.value.equals(target)) {
            return deleteAllOccurrencesRecursive(node.next, target);
        }
        node.next = deleteAllOccurrencesRecursive(node.next, target);
        return node;
    }

    /**
     * Deletes the element at the specified index (0-based).
     */
    public void deleteAtIndex(int index) {
        if (index < 0) throw new IndexOutOfBoundsException();
        head = deleteAtIndexRecursive(head, index);
    }

    private Node<E> deleteAtIndexRecursive(Node<E> node, int index) {
        if (node == null) throw new IndexOutOfBoundsException();
        if (index == 0) return node.next;
        node.next = deleteAtIndexRecursive(node.next, index - 1);
        return node;
    }

    /**
     * Prints all elements in the list.
     */
    public void printList() {
        printRecursive(head);
        System.out.println();
    }

    private void printRecursive(Node<E> node) {
        if (node != null) {
            System.out.print(node.value + " ");
            printRecursive(node.next);
        }
    }

    // Main method for demonstration
    public static void main(String[] args) {
        SortedList<Integer> list = new SortedList<>();

        // Insert values in sorted order
        list.insertSorted(3);
        list.insertSorted(1);
        list.insertSorted(2);
        list.insertSorted(2);
        list.insertSorted(5);
        list.insertSorted(4);
        System.out.print("Original list: ");
        list.printList();

        // Remove last value
        list.deleteLast();
        System.out.print("After deleteLast(): ");
        list.printList();

        // Remove last occurrence of 2
        list.deleteLastOccurrence(2);
        System.out.print("After deleteLastOccurrence(2): ");
        list.printList();

        // Remove all occurrences of 2
        list.deleteAllOccurrences(2);
        System.out.print("After deleteAllOccurrences(2): ");
        list.printList();

        // Remove item at index 1
        list.deleteAtIndex(1);
        System.out.print("After deleteAtIndex(1): ");
        list.printList();
    }
}
