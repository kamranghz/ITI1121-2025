import java.util.LinkedList;
import java.util.List;

public class ListTraversal {
    public static void main(String[] args) {
        List<String> colors = new LinkedList<>();
        colors.add("bleu");
        colors.add("blanc");
        colors.add("rouge");
        colors.add("jaune");
        colors.add("vert");
        colors.add("orange");

        long startTime = System.nanoTime(); // Start timing
        for (int i = 0; i < colors.size(); i++) {
            System.out.println(colors.get(i));
        }
        long endTime = System.nanoTime(); // End timing
        System.out.println("Time to traverse: " + (endTime - startTime) + " nanoseconds");
    }
}
