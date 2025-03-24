/*
 * Summary: IteratorSumDemo - Measuring Performance of Iterator-Based Summation in LinkedList
 *
 * This program evaluates the performance of iterating over a Java `LinkedList<Double>` 
 * using an `Iterator` to compute the sum of all elements. It tests this across varying list sizes.
 *
 * Key Steps:
 * 1. For each list size (e.g., 10,000 to 160,000), it:
 *    - Creates a new `LinkedList<Double>`.
 *    - Fills the list with dummy double values (e.g., 5.0, 6.0, ..., 14.0 repeating).
 *    - Measures the time taken to sum all elements using an iterator.
 *
 * 2. The sum is calculated by:
 *    - Creating an `Iterator<Double>` for the list.
 *    - Iterating through each element and adding its value to a `sum` variable.
 *
 * 3. The program prints:
 *    - The size of the list,
 *    - The resulting sum,
 *    - The total time taken (in milliseconds).
 *
 * Purpose:
 * - Demonstrates the use of `Iterator` for linked list traversal.
 * - Useful for comparing performance and understanding the cost of traversing large `LinkedList`s.
 *
 */



import java.util.LinkedList;
import java.util.Iterator;

public class IteratorSumDemo {
    public static void main(String[] args) {

        // Try different sizes to compare performance
        int[] sizes = {10000, 20000, 40000, 80000, 160000};

        for (int size : sizes) {
            // Step 1: Create a linked list of Doubles
            LinkedList<Double> doubles = new LinkedList<>();

            // Step 2: Fill the list with dummy data
            for (int i = 0; i < size; i++) {
                doubles.add(5.0 + i % 10);  // Arbitrary double values
            }

            // Step 3: Start timing
            long startTime = System.currentTimeMillis();

            // Step 4: Use iterator to traverse and compute sum
            double sum = 0.0;
            Iterator<Double> it = doubles.iterator();
            while (it.hasNext()) {
                Double val = it.next();
                sum += val.doubleValue(); // Access the primitive double
            }

            // Step 5: Stop timing
            long endTime = System.currentTimeMillis();

            // Step 6: Print results
            System.out.println("Size: " + size + " | Sum: " + sum + " | Time: " + (endTime - startTime) + " ms");
        }
    }
}
