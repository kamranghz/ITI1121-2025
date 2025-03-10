// Demonstrates handling NumberFormatException using try-catch
public class NumberParser {
    public static void main(String[] args) {
        int DEFAULT_VALUE = 1; // Default value in case of an error
        int value; // Variable to store parsed value

        try {
            // Trying to parse an integer from a string
            value = Integer.parseInt("100"); // Valid case
        } catch (NumberFormatException e) {
            // Handling incorrect input conversion
            System.out.println(" Invalid number format! Using default value.");
            value = DEFAULT_VALUE;
        }

        // Printing the final result
        System.out.println(" Parsed value: " + value);
    }
}
