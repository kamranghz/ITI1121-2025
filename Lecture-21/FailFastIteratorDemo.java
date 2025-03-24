/*
 * Summary: FailFastIteratorDemo - Demonstrating Fail-Fast Behavior in Java Iterators
 *
 * This program illustrates how Java's built-in `LinkedList` iterators are **fail-fast**, 
 * meaning they detect concurrent modifications and throw an exception if the list is 
 * structurally modified outside the iterator that is being used.
 *
 * Key Concepts Demonstrated:
 *
 * 1. **Initial Setup:**
 *    - A LinkedList<Double> is created and populated with values: [3.0, 2.0, 6.0].
 *
 * 2. **Safe Iteration:**
 *    - A single iterator (`i`) is used to traverse the list safely with `next()` and `hasNext()`.
 *
 * 3. **Fail-Fast Behavior:**
 *    - Two iterators (`it1` and `it2`) are created from the same list.
 *    - `it2` removes an element (modifying the list structure and incrementing `modCount`).
 *    - When `it1` (now outdated) is used afterward, it throws a `ConcurrentModificationException`.
 *
 * 4. **Exception Handling:**
 *    - The code demonstrates how Java detects and throws an exception to prevent undefined behavior 
 *      due to concurrent modifications (structural changes outside the active iterator).
 *
 * Final Output:
 * - Safely prints all original list elements.
 * - Catches and prints the exception from the outdated iterator.
 * - Prints the final list after removal: [2.0, 6.0]
 *
 * Purpose:
 * - Shows how Java’s fail-fast iterators ensure safe traversal.
 * - Encourages developers to use a single iterator for both read and write operations.
 * - Explains why modifying a collection while iterating with a separate iterator is unsafe.
 */



import java.util.Iterator;
import java.util.LinkedList;

public class FailFastIteratorDemo {
    public static void main(String[] args) {
        // Step 1: Create a LinkedList and add initial values
        LinkedList<Double> list = new LinkedList<>();
        list.add(6.0);       // modCount becomes 1
        list.addFirst(2.0);  // modCount becomes 2
        list.addFirst(3.0);  // modCount becomes 3

        System.out.println("Original List: " + list); // [3.0, 2.0, 6.0]

        // Step 2: Create an iterator
        Iterator<Double> i = list.iterator();

        // Step 3: Iterate safely using one iterator
        System.out.println("\nIterating through list:");
        while (i.hasNext()) {
            Double val = i.next();
            System.out.println("Value: " + val);
        }

        // Step 4: Create two iterators to show fail-fast behavior
        Iterator<Double> it1 = list.iterator();
        Iterator<Double> it2 = list.iterator();

        // Step 5: Modify the list through one iterator
        if (it2.hasNext()) {
            it2.next();     // move to first element
            it2.remove();   // remove 3.0 (modCount is now changed)
        }

        // Step 6: Now try using the first iterator (it1) - this will fail
        System.out.println("\nTrying to use an outdated iterator (should throw exception):");
        try {
            if (it1.hasNext()) {
                Double val = it1.next(); // will throw ConcurrentModificationException
                System.out.println("Unexpected Value: " + val);
            }
        } catch (Exception e) {
            System.out.println("Exception caught: " + e);
        }

        // Final List state
        System.out.println("\nFinal List after removal: " + list); // [2.0, 6.0]
    }
}
