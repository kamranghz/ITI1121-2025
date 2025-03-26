/**
 * Demonstration of adding and removing elements using a custom LinkedList iterator
 * with fail-fast behavior and support for add/remove during iteration.
 */
public class FailFastLinkedListDemo {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        // Use the custom ListIterator to add elements
        LinkedList<String>.ListIterator it = list.new ListIterator();
        for (int c = 0; c < 5; c++) {
            it.add("element-" + c);
        }

        // Display list contents
        System.out.println("List after adding 5 elements:");
        for (String value : list) {
            System.out.println(value);
        }

        // Remove the second element using iterator
        LinkedList<String>.ListIterator reader = list.new ListIterator();
        reader.next(); // element-0
        reader.next(); // element-1
        reader.remove(); // remove element-1

        // Final display after removal
        System.out.println("\nList after removing element-1:");
        for (String value : list) {
            System.out.println(value);
        }
    }
}
