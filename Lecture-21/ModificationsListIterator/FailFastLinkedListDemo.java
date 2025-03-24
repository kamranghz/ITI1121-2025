import java.util.Iterator;

public class FailFastLinkedListDemo {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();

        // Adding elements through iterator
        Iterator<String> it = list.iterator();
        for (int c = 0; c < 5; c++) {
            it.add("element-" + c);
        }

        // Display elements using a new iterator
        System.out.println("List after adding 5 elements:");
        Iterator<String> reader = list.iterator();
        while (reader.hasNext()) {
            System.out.println(reader.next());
        }

        // Remove the second element using iterator
        reader = list.iterator(); // reset
        reader.next(); // move to element-0
        reader.next(); // move to element-1
        reader.remove(); // remove element-1

        System.out.println("\nList after removing element-1:");
        reader = list.iterator();
        while (reader.hasNext()) {
            System.out.println(reader.next());
        }
    }
}
