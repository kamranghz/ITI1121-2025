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
