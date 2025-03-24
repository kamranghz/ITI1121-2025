/*
 * Summary: IterableLinkedListDemo - Custom LinkedList with Iterable Support
 *
 * This program demonstrates how to use a **custom LinkedList** that implements `Iterable`,
 * allowing iteration through both:
 *  - Traditional `Iterator` usage
 *  - Java's enhanced for-loop (`for-each`)
 *
 * Key Features:
 * ----------------------------------
 * - A custom `LinkedList<Integer>` is created.
 * - Elements 1 through 5 are added using `addLast()`.
 * - The list is traversed twice to compute the sum:
 *    1. Using a traditional `Iterator`
 *    2. Using an enhanced for-loop (which implicitly uses the iterator)
 * - Both methods compute and print the sum of all elements (output: 15).
 *
 * Purpose:
 * ----------------------------------
 * - Shows how implementing the `Iterable` interface in a custom data structure
 *   enables usage of Java’s enhanced for-loop syntax.
 * - Reinforces understanding of how enhanced for-loops internally rely on iterators.
 *
 * Prerequisite:
 * ----------------------------------
 * - The `LinkedList` class used must implement `Iterable<E>` and provide a valid `iterator()` method.
 */



import java.util.Iterator;

// Custom LinkedList that supports Iterable
public class IterableLinkedListDemo {
    public static void main(String[] args) {
        // Create our custom LinkedList
        LinkedList<Integer> list = new LinkedList<>();

        // Add elements
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        // ✅ Traditional Iterator usage
        int sum1 = 0;
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            int value = it.next();
            sum1 += value;
        }
        System.out.println("Sum using Iterator: " + sum1); // Output: 15

        // ✅ Enhanced For-Loop (for-each) usage
        int sum2 = 0;
        for (int num : list) {
            sum2 += num;
        }
        System.out.println("Sum using enhanced for-loop: " + sum2); // Output: 15
    }
}
