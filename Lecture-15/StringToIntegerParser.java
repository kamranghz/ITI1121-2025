public class StringToIntegerParser {
    public static void main(String[] args) {
        // Default fallback value in case of parsing failure
        int DEFAULT_VALUE = 1;
        int value;

        try {
            // Attempting to convert an invalid string into an integer
            value = Integer.parseInt("Team A");
        } catch (NumberFormatException e) {
            // Handling the exception by assigning a default value
            value = DEFAULT_VALUE;
        }

        // Displaying the final value after parsing
        System.out.println("value = " + value); // Output: value = 1
    }
}
