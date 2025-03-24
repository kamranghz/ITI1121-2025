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
