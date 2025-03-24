/*
 * Summary: ManyIteratorsDemo - Demonstrating Nested Iteration Over a LinkedList
 *
 * This program demonstrates how to use **two independent iterators** on the same `LinkedList<Double>`
 * to produce a **Cartesian product** of all element pairs in the list.
 *
 * Key Steps:
 * 1. Creates a `LinkedList<Double>` containing values from 0.0 to 4.0.
 * 2. Uses an **outer iterator (i)** to traverse each element once.
 * 3. For each element from the outer iterator, it creates a new **inner iterator (j)**
 *    that traverses the entire list again from the beginning.
 * 4. Prints all possible pairs (iVal, jVal), where iVal comes from outer iterator and jVal from inner.
 *
 * Output:
 * - Prints a total of 25 pairs (5 outer × 5 inner), representing all combinations.
 *
 * Purpose:
 * - Shows how multiple iterators can be used simultaneously on the same list.
 * - Demonstrates nested loops using iterators.
 * - Illustrates the Cartesian product pattern with linked lists.
 *
 * Note:
 * - Each call to `doubles.iterator()` returns a new independent iterator starting from the head.
 */



import java.util.LinkedList;
import java.util.Iterator;

public class ManyIteratorsDemo {
    public static void main(String[] args) {
        // Create a LinkedList of Doubles
        LinkedList<Double> doubles = new LinkedList<>();

        // Fill the list with values 0.0 to 4.0
        for (int c = 0; c < 5; c++) {
            doubles.add(Double.valueOf(c));  // Autoboxed from int to Double
        }

        // Outer iterator (i) traverses the entire list once
        Iterator<Double> i = doubles.iterator();

        while (i.hasNext()) {
            Double iVal = i.next();  // Get the next element from iterator i

            // Inner iterator (j) starts from the beginning for each iVal
            Iterator<Double> j = doubles.iterator();

            while (j.hasNext()) {
                Double jVal = j.next();  // Get the next element from iterator j

                // Print pair of (iVal, jVal) to represent Cartesian product
                System.out.println("(" + iVal + ", " + jVal + ")");
            }
        }
    }
}
