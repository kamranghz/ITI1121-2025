/**
 * Example 1: Recursive Factorial Calculation
 * This program demonstrates how recursion works in Java for computing factorials.
 * It also illustrates how JVM manages stack frames for each recursive call.
 */
public class RecursiveFactorial {

    /**
     * Recursive method to calculate the factorial of a number.
     * Each call creates a new stack frame until reaching the base case.
     *
     * @param n The number for which factorial is calculated.
     * @return The factorial of n.
     */
    public static int fact(int n) {
        int a, r; // Local variables in stack frame
        
        // Base case: Factorial of 0 or 1 is 1
        if (n == 0 || n == 1) {
            a = 1;
        } else {
            // Recursive case: n! = n * (n-1)!
            r = fact(n - 1); // Recursive call
            a = n * r;
        }
        return a; // Return the computed factorial value
    }

    public static void main(String[] args) {
        int a, n;
        n = 3; // Set the input value
        a = fact(n); // Call the recursive factorial function
        
        // Output the result with explanation
        System.out.println("Factorial of " + n + " is: " + a);
    }
}
