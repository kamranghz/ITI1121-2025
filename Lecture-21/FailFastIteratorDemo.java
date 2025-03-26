import java.util.LinkedList;
import java.util.ListIterator;

public class FailFastIteratorDemo {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        // Use ListIterator instead of Iterator
        ListIterator<String> it = list.listIterator();

        // Add elements using the ListIterator
        for (int c = 0; c < 5; c++) {
            it.add("element-" + c);
        }

        // Display elements using a new iterator
        System.out.println("List after adding 5 elements:");
        for (String value : list) {
            System.out.println(value);
        }

        // Remove the second element using the ListIterator
        it = list.listIterator();
        it.next(); // points to element-0
        it.next(); // points to element-1
        it.remove(); // removes element-1

        System.out.println("\nList after removing element-1:");
        for (String value : list) {
            System.out.println(value);
        }
    }
}
