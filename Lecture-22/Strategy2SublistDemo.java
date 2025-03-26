/**
 * Strategy2SublistDemo.java
 * --------------------------------------------
 * This program demonstrates Strategy 2 for creating a sublist from a singly linked list
 * using recursion: The result list is created first and filled as we traverse the original list.
 *
 * Key Concepts:
 * - Recursive traversal with a separate result list.
 * - Base and general case logic for filling the list.
 * - Demonstrates the "head + tail" pattern.
 */

import java.util.NoSuchElementException;

public class Strategy2SublistDemo<E> {

    private static class Node<E> {
        E value;
        Node<E> next;
        Node(E value) {
            this.value = value;
        }
    }

    private Node<E> first; // Head of the list

    public void addLast(E value) {
        if (first == null) {
            first = new Node<>(value);
        } else {
            Node<E> current = first;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node<>(value);
        }
    }

    /**
     * Public method that returns a sublist between fromIndex and toIndex (inclusive).
     */
    public Strategy2SublistDemo<E> subList(int fromIndex, int toIndex) {
        Strategy2SublistDemo<E> result = new Strategy2SublistDemo<>();
        subList(first, result, fromIndex, toIndex, 0);
        return result;
    }

    /**
     * Recursive helper method to populate the result list.
     * @param p       current node
     * @param result  list to store the sublist
     * @param from    fromIndex
     * @param to      toIndex
     * @param index   current position in the list
     */
    private void subList(Node<E> p, Strategy2SublistDemo<E> result, int from, int to, int index) {
        if (p == null) {
            throw new IndexOutOfBoundsException("Reached end before toIndex");
        }
        
        if (index == to) {
            // Base case: last element to include
            result.addLast(p.value);
        } else {
            if (index >= from) {
                // Only add if we're within the range
                result.addLast(p.value);
            }
            subList(p.next, result, from, to, index + 1);
        }
    }

    /**
     * Display the elements of the list
     */
    public void printList() {
        Node<E> current = first;
        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Demonstration for beginner students
    public static void main(String[] args) {
        Strategy2SublistDemo<Integer> originalList = new Strategy2SublistDemo<>();
        originalList.addLast(10);
        originalList.addLast(20);
        originalList.addLast(30);
        originalList.addLast(40);
        originalList.addLast(50);

        System.out.println("Original List:");
        originalList.printList();

        System.out.println("\nSublist from index 1 to 3:");
        Strategy2SublistDemo<Integer> sublist = originalList.subList(1, 3);
        sublist.printList();
    }
}
