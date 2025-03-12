import java.util.Stack;

public class DepthFirstSearch {
    public static void main(String[] args) {
        int maxDepth = 4; // Limit depth to match slides
        dfsBinaryStrings(maxDepth);
    }

    // Depth-First Search using a Stack
    public static void dfsBinaryStrings(int maxDepth) {
        Stack<String> stack = new Stack<>();
        stack.push(""); // Start with an empty string

        System.out.println("Depth-First Search (DFS) Traversal:\n");

        while (!stack.isEmpty()) {
            String current = stack.pop(); // Get the last inserted string (LIFO)
            
            // Display the current DFS step
            System.out.println("Processing: " + current);

            // If max depth reached, continue
            if (current.length() >= maxDepth) {
                continue;
            }

            // Add new branches to stack (LIFO order)
            stack.push(current + "1"); // Explore "1" first (right side in slides)
            stack.push(current + "0"); // Explore "0" next (left side in slides)
        }
    }
}
