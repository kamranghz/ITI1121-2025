/*
 * Summary: RemoveWithIteratorDemo - Custom LinkedList Iterator with Remove and Add Support
 *
 * This program demonstrates how to use a custom `LinkedList` class and its inner `ListIterator`
 * to traverse, remove, and add elements to the list dynamically during iteration.
 *
 * Key Operations Demonstrated:
 * 1. **Creation of a LinkedList<Double>** with values: [2.718, 3.142, 7.389]
 * 2. **Removal of an element using the iterator**:
 *    - Moves the iterator to the second element (3.142) and removes it.
 * 3. **Removal of the first element (2.718)** by resetting the iterator.
 * 4. **Addition of a new element (9.806)** at the end of the list using the iterator.
 *
 * Iterator Behavior:
 * - `next()` advances the iterator to the next element.
 * - `remove()` removes the **last element returned by `next()`**.
 * - `add(E e)` inserts a new node **after the current position**.
 *
 * Final Output:
 * - After removing 3.142: [2.718, 7.389]
 * - After removing 2.718: [7.389]
 * - After adding 9.806 at the end: [7.389, 9.806]
 *
 * Purpose:
 * - Illustrates how a custom iterator supports **removal and insertion** in a linked list.
 * - Emphasizes careful iterator control when modifying the list during traversal.
 * - Useful for understanding the iterator state and structural changes during iteration.
 */




import java.util.Iterator;

public class RemoveWithIteratorDemo {

    public static void main(String[] args) {
        // Create a LinkedList of Doubles
        LinkedList<Double> doubles = new LinkedList<>();

        // Add some numbers to the list
        doubles.add(2.718);  // e
        doubles.add(3.142);  // pi
        doubles.add(7.389);  // e^2

        // Get an iterator for the list
        LinkedList<Double>.ListIterator i = doubles.iterator();

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
