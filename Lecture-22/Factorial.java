/**
 * A simple recursive method to compute the factorial of a number.
 * 
 * factorial(n) = n * factorial(n-1)
 * Base case: factorial(1) = 1
 */
public class Factorial {

    /**
     * Recursive method to calculate factorial of a number n.
     * 
     * @param n the number to calculate factorial of
     * @return the factorial of n
     */
    public static int factorial(int n) {
        int s, result;

        if (n <= 1) {
            // Base case: factorial of 0 or 1 is 1
            result = 1;
        } else {
            // General case:
            // Step 1: calculate factorial of (n - 1)
            int n1 = n - 1;
            s = factorial(n1);

            // Step 2: multiply n by factorial of (n - 1)
            result = n * s;
        }

        return result;
    }

    public static void main(String[] args) {
        int number = 5;
        int output = factorial(number);
        System.out.println("Factorial of " + number + " is: " + output);
        // Output: Factorial of 5 is: 120
    }
}
