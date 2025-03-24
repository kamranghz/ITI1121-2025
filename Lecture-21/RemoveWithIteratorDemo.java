import java.util.Iterator;

public class RemoveWithIteratorDemo {

    public static void main(String[] args) {
        // Create a LinkedList of Doubles
        LinkedList<Double> doubles = new LinkedList<>();

        // Add some numbers to the list
        doubles.add(2.718);  // e
        doubles.add(3.142);  // pi
        doubles.add(7.389);  // e^2

        // Get an iterator for the list
        LinkedList<Double>.ListIterator i = doubles.iterator();

        // Move to second element (3.142)
        i.next();  // points to 2.718
        i.next();  // points to 3.142

        // Remove the element 3.142
        i.remove();  // removes 3.142

        System.out.println("List after removing 3.142:");
        for (Double value : doubles) {
            System.out.println(value);
        }

        // Try removing first element
        i = doubles.iterator();
        i.next(); // points to 2.718
        i.remove(); // removes 2.718

        System.out.println("\nList after removing 2.718:");
        for (Double value : doubles) {
            System.out.println(value);
        }

        // Add a new element at the end
        i = doubles.iterator();
        while (i.hasNext()) {
            i.next(); // move to end
        }
        i.add(9.806);  // gravitational acceleration

        System.out.println("\nList after adding 9.806 at the end:");
        for (Double value : doubles) {
            System.out.println(value);
        }
    }
}
