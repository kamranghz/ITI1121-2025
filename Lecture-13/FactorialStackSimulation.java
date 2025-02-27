/**
 * Example 2: Stack Frame Visualization for Factorial Calculation
 * This program simulates how recursion works in the JVM by printing each step of the call stack.
 * It helps students understand stack memory management.
 */
public class FactorialStackSimulation {

    /**
     * Recursive method to calculate factorial with stack visualization.
     *
     * @param n The number for which factorial is computed.
     * @param depth Depth of recursion (used for indentation)
     * @return Factorial of n.
     */
    public static int fact(int n, int depth) {
        int a, r;

        // Print stack frame information
        System.out.println("→ Entering fact(" + n + "), Stack Depth: " + depth);

        // Base case
        if (n == 0 || n == 1) {
            a = 1;
            System.out.println("   Base case reached: fact(" + n + ") = " + a);
        } else {
            // Recursive call
            r = fact(n - 1, depth + 1);
            a = n * r;
            System.out.println("   Returning: fact(" + n + ") = " + a);
        }
        
        // Print stack frame exit
        System.out.println("← Exiting fact(" + n + "), Stack Depth: " + depth);
        return a;
    }

    public static void main(String[] args) {
        int a, n;
        n = 3; // Define the input number
        System.out.println("Starting factorial computation for: " + n);
        
        a = fact(n, 1); // Initial call with depth = 1

        // Print final result
        System.out.println("\nFactorial of " + n + " is: " + a);
    }
}
