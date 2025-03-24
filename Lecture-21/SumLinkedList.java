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
