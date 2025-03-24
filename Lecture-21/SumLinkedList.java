/*
 * This Java program demonstrates how to use a LinkedList with an Iterator
 * to store and sum a sequence of integers.
 * 
 * Key Features:
 * - A `LinkedList<Integer>` is used to store a sequence of integers (0 to 4).
 * - An `Iterator` is used to traverse the list in a standard way.
 * - Each element in the list is accessed and summed up using the iterator.
 * 
 * Best Practices:
 * - Uses `Integer.valueOf(i)` instead of `new Integer(i)` to avoid deprecation warnings.
 * - Demonstrates how to iterate over a LinkedList with `Iterator` rather than a for-each loop,
 *   which can be useful in cases where element removal or fine-grained control is needed.
 * 
 * The final result is the total sum of all integers in the list, printed to the console.
 */



import java.util.LinkedList;
import java.util.Iterator;

public class SumLinkedList {
    public static void main(String[] args) {
        // Create a new LinkedList to store Integer objects
        LinkedList<Integer> list = new LinkedList<Integer>();

        // Add integers from 0 to 4 to the LinkedList using valueOf to avoid deprecation warning
        for (int i = 0; i < 5; i++) {
            list.add(Integer.valueOf(i));  // Use Integer.valueOf(i) instead of new Integer(i)
        }

        // Initialize a sum variable to accumulate the sum of elements in the list
        int sum = 0;

        // Create an iterator to go through each element in the linked list
        Iterator<Integer> iterator = list.iterator();

        // While there are more elements in the list, continue to iterate
        while (iterator.hasNext()) {
            // Get the next element from the list using the iterator
            Integer value = iterator.next();

            // Add the integer value of the current element to the sum
            sum += value.intValue();
        }

        // Print the total sum of all elements in the list
        System.out.println("sum = " + sum);
    }
}
