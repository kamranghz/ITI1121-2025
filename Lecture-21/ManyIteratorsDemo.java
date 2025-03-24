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
