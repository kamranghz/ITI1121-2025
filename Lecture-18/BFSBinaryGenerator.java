import java.util.LinkedList;
import java.util.Queue;

public class BFSBinaryGenerator {
    public static void main(String[] args) {
        int n = 3; // Maximum binary string length
        generateBinaryStrings(n);
    }

    public static void generateBinaryStrings(int n) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(""); // Start with an empty string

        System.out.println("Breadth-First Search (BFS) Binary String Generation:\n");

        int level = 0; // Track levels (corresponding to slide steps)
        while (!queue.isEmpty()) {
            int size = queue.size(); // Elements at the current level
            System.out.println("Level " + level + ": " + queue); // Show current queue

            for (int i = 0; i < size; i++) {
                String s = queue.poll(); // Dequeue

                // Generate next-level binary strings
                if (s.length() < n) {
                    queue.offer(s + "0"); // Add "0" to the path
                    queue.offer(s + "1"); // Add "1" to the path
                }
            }
            level++; // Move to the next level
        }
    }
}
