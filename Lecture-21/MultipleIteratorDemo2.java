/*
 * Summary: MultipleIteratorDemo2 - Demonstrating Independent Iterators on Java's Built-in LinkedList
 *
 * This program uses Java's built-in `LinkedList` class to demonstrate how multiple iterators
 * can independently traverse different or the same lists without interfering with one another.
 *
 * Key Steps:
 * 1. Creates two LinkedLists:
 *    - `l1` stores Strings: ["A", "B", "C", "D"]
 *    - `l2` stores Integers: [1, 2, 3]
 * 2. Creates three iterators:
 *    - `i` and `j` iterate over `l1` independently.
 *    - `k` iterates over `l2`.
 * 3. Demonstrates that:
 *    - `i` and `j` can traverse the same list (`l1`) independently.
 *    - `k` traverses a different list (`l2`), also independently.
 *
 * Educational Purpose:
 * - Shows that multiple iterators created from Java’s standard library LinkedList
 *   do not share internal state, allowing simultaneous and independent traversal.
 *
  */



import java.util.LinkedList;
import java.util.Iterator;

public class MultipleIteratorDemo2 {

    public static void main(String[] args) {

        // Step 1: Create a LinkedList of Strings and add elements A, B, C, D
        LinkedList<String> l1 = new LinkedList<String>();
        l1.addLast("A");
        l1.addLast("B");
        l1.addLast("C");
        l1.addLast("D");

        // Step 2: Create a LinkedList of Integers and add elements 1, 2, 3
        LinkedList<Integer> l2 = new LinkedList<Integer>();
        l2.addLast(1); // can also use: new Integer(1)
        l2.addLast(2);
        l2.addLast(3);

        // Step 3: Declare three iterators
        Iterator<String> i, j;
        Iterator<Integer> k;

        // Step 4: Assign two independent iterators to the same string list l1
        i = l1.iterator();  // i starts at the beginning of l1
        j = l1.iterator();  // j also starts at the beginning of l1

        // Step 5: Assign another iterator to the integer list l2
        k = l2.iterator();  // k starts at the beginning of l2

        // Step 6: Use iterator 'j' to traverse l1
        System.out.println("Iterator j on l1:");
        while (j.hasNext()) {
            String value = j.next(); // advance j one step
            System.out.println("j --> " + value);
        }

        // Step 7: Now use iterator 'i' independently on the same list l1
        System.out.println("\nIterator i on l1 (independent of j):");
        while (i.hasNext()) {
            String value = i.next(); // advance i one step
            System.out.println("i --> " + value);
        }

        // Step 8: Use iterator 'k' to traverse l2
        System.out.println("\nIterator k on l2:");
        while (k.hasNext()) {
            Integer value = k.next(); // advance k one step
            System.out.println("k --> " + value);
        }
    }
}
