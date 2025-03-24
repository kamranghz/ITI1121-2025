/*
 * Summary: FailFastLinkedListDemo - Custom LinkedList with Add/Remove via Iterator
 *
 * This program demonstrates how to:
 * - Add and remove elements in a custom `LinkedList<String>` using a custom iterator.
 * - Safely modify the list (add/remove) during iteration without triggering fail-fast exceptions,
 *   assuming the custom list is designed to support such behavior (unlike Java’s built-in LinkedList).
 *
 * Key Operations:
 * 1. **Adding Elements:**
 *    - Uses an iterator (`it`) to add 5 elements: element-0 to element-4.
 *
 * 2. **Displaying the List:**
 *    - Creates a new iterator (`reader`) to traverse and print all elements.
 *
 * 3. **Removing an Element:**
 *    - Resets the iterator and moves to the second element (`element-1`).
 *    - Removes `element-1` using the iterator’s `remove()` method.
 *
 * 4. **Final Display:**
 *    - Prints the final list contents after the removal.
 *
 * Expected Output:
 * - After adding: [element-0, element-1, element-2, element-3, element-4]
 * - After removing: [element-0, element-2, element-3, element-4]
 *
 * Note:
 * - This assumes a custom `LinkedList` implementation that supports `add()` and `remove()` via the iterator.
 * - If using Java’s built-in `Iterator`, these methods wouldn’t be available unless using `ListIterator`.
 *
 *  Purpose:
 * - Shows how list mutation during iteration can be handled safely with a custom iterator.
 * - Reinforces correct iterator usage for adding and removing elements in a linked list.
 */


import java.util.Iterator;

public class FailFastLinkedListDemo {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        // Adding elements through iterator
        Iterator<String> it = list.iterator();
        for (int c = 0; c < 5; c++) {
            it.add("element-" + c);
        }

        // Display elements using a new iterator
        System.out.println("List after adding 5 elements:");
        Iterator<String> reader = list.iterator();
        while (reader.hasNext()) {
            System.out.println(reader.next());
        }

        // Remove the second element using iterator
        reader = list.iterator(); // reset
        reader.next(); // move to element-0
        reader.next(); // move to element-1
        reader.remove(); // remove element-1

        System.out.println("\nList after removing element-1:");
        reader = list.iterator();
        while (reader.hasNext()) {
            System.out.println(reader.next());
        }
    }
}
