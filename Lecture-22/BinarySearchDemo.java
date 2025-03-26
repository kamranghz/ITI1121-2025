/**
 * A complete Java class that demonstrates a recursive binary search.
 */
public class BinarySearchDemo {

    /**
     * Recursively searches for a value in a sorted array.
     * 
     * @param value the number we are searching for
     * @param array the sorted array to search within
     * @param lo    the start index of the current search range
     * @param hi    the end index of the current search range
     * @return the index where the value is found, or -1 if not found
     */
    private static int binSearch(int value, int[] array, int lo, int hi) {
        // Base Case 1: Search range is empty
        if (lo > hi) {
            return -1;
        }

        // Calculate the middle index
        int middle = (lo + hi) / 2;

        // Base Case 2: Found the value
        if (value == array[middle]) {
            return middle;
        }

        // General Case: Search left or right half
        if (value < array[middle]) {
            return binSearch(value, array, lo, middle - 1);  // Left half
        } else {
            return binSearch(value, array, middle + 1, hi);  // Right half
        }
    }

    /**
     * A wrapper method to start the recursive search from full array bounds.
     */
    public static int binarySearch(int value, int[] array) {
        return binSearch(value, array, 0, array.length - 1);
    }

    /**
     * Main method to test binary search functionality.
     */
    public static void main(String[] args) {
        int[] sortedArray = {2, 4, 6, 8, 10, 12, 14};

        int target = 10;
        int result = binarySearch(target, sortedArray);

        if (result != -1) {
            System.out.println("Found value " + target + " at index " + result);
        } else {
            System.out.println("Value " + target + " not found.");
        }
    }
}
