/**
 * Recursively calculates the sum of all values in an integer array.
 * Demonstrates recursion: base case + smaller sub-problems.
 */

public class Sum {

    /**
     * Recursive helper method that starts from index k and sums to the end of array.
     *
     * @param t the input array
     * @param k the current index we are summing from
     * @return the sum from index k to the end
     */
    private static int sum(int[] t, int k) {
        // Base Case: If we are at the last element, return it directly
        if (k == t.length - 1) {
            // Trivial case: array has one element left → return it
            return t[k];
        }

        // Recursive Case: calculate the sum from the next index (k+1)
        int s = sum(t, k + 1);      // sum from t[k+1] to t[end]
        int result = t[k] + s;      // current element + sum of rest

        return result;              // return the result to the previous call
    }

    /**
     * Public method to start the recursive summing from the beginning of the array.
     *
     * @param t the input array
     * @return total sum of the array
     */
    public static int sum(int[] t) {
        // Handle edge case: empty array cannot be summed
        if (t.length == 0) {
            throw new IllegalArgumentException("Array is empty!");
        }

        // Start the recursion from the first element (index 0)
        return sum(t, 0);
    }

    /**
     * Main method to test the recursive sum implementation.
     */
    public static void main(String[] args) {
        // Sample array to sum
        int[] t = { 1, 2, 3, 4, 5 };

        // Output: 15 (1 + 2 + 3 + 4 + 5)
        System.out.println("Total sum: " + sum(t));
    }
}
