import java.util.Iterator;

// Custom LinkedList that supports Iterable
public class IterableLinkedListDemo {
    public static void main(String[] args) {
        // Create our custom LinkedList
        LinkedList<Integer> list = new LinkedList<>();

        // Add elements
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        // ✅ Traditional Iterator usage
        int sum1 = 0;
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            int value = it.next();
            sum1 += value;
        }
        System.out.println("Sum using Iterator: " + sum1); // Output: 15

        // ✅ Enhanced For-Loop (for-each) usage
        int sum2 = 0;
        for (int num : list) {
            sum2 += num;
        }
        System.out.println("Sum using enhanced for-loop: " + sum2); // Output: 15
    }
}
