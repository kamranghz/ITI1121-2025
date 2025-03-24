/*
 * This Java program demonstrates the implementation of a simple singly linked list 
 * along with a custom iterator that allows independent traversal over the list.
 * 
 * Key Components:
 * - `Node<E>`: Represents a single node in the linked list, holding a value and a reference to the next node.
 * - `LinkedList<E>`: A basic singly linked list implementation with a method to add elements at the front (`addFirst`)
 *   and a method to generate a new iterator (`iterator()`).
 * - `LinkedListIterator<E>`: A custom iterator class implementing the `Iterator` interface, enabling traversal
 *   through the linked list without modifying it. It maintains its own state (`current`) and works independently.
 * 
 * Demonstration:
 * - In `main`, a list is created and populated with elements "A" to "D".
 * - Two separate iterators (`i` and `j`) are created from the same list.
 * - The iterators are moved independently to show that each iterator maintains its own state,
 *   proving that multiple iterators on the same list do not interfere with each other.
 * 
 * This example is useful to understand how iterators work, how to build them for custom data structures,
 * and how multiple iterators can coexist and function independently.
 */



import java.util.Iterator;
import java.util.NoSuchElementException;

// Node class representing each element in the linked list
class Node<E> {
    E value;
    Node<E> next;

    public Node(E value, Node<E> next) {
        this.value = value;
        this.next = next;
    }
}

// Singly linked list implementation
class LinkedList<E> {
    Node<E> head;

    public void addFirst(E value) {
        head = new Node<>(value, head);
    }

    // This method returns a new iterator each time it’s called
    public Iterator<E> iterator() {
        return new LinkedListIterator<>(this);
    }
}

// Custom iterator for the LinkedList
class LinkedListIterator<E> implements Iterator<E> {
    private Node<E> current;        // Tracks the current node of this iterator
    private LinkedList<E> myList;   // Reference to the LinkedList being iterated over

    public LinkedListIterator(LinkedList<E> myList) {
        this.myList = myList;
        this.current = null; // Initially, the iterator is before the first element
    }

    public boolean hasNext() {
        return (current == null && myList.head != null) ||
               (current != null && current.next != null);
    }

    public E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        // If this is the first call to next(), start at the head
        if (current == null) {
            current = myList.head;
        } else {
            current = current.next;
        }
        return current.value;
    }
}

// Demonstration class
public class MultipleIteratorDemo {
    public static void main(String[] args) {
        // Create and populate a linked list: D → C → B → A
        LinkedList<String> list = new LinkedList<>();
        list.addFirst("D");
        list.addFirst("C");
        list.addFirst("B");
        list.addFirst("A");

        // Create two independent iterators on the same list
        Iterator<String> i = list.iterator();
        Iterator<String> j = list.iterator();

        // Advance iterator i one step
        System.out.println("Iterator i calls next(): " + i.next()); // Output: A

        // Advance iterator j two steps
        System.out.println("Iterator j calls next(): " + j.next()); // Output: A
        System.out.println("Iterator j calls next(): " + j.next()); // Output: B

        // Continue with iterator i
        System.out.println("Iterator i calls next(): " + i.next()); // Output: B

        // Now both iterators are independent and do not affect each other
        System.out.println("Iterator j calls next(): " + j.next()); // Output: C
        System.out.println("Iterator i calls next(): " + i.next()); // Output: C
    }
}
