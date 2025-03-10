// Java program demonstrating the parseInt(String s) method

public class ParseIntExample {
    public static void main(String[] args) {
        // Example of a valid integer conversion
        String numStr = "100"; // A valid numeric string
        int num = Integer.parseInt(numStr);  // Converts "100" to integer 100
        System.out.println("Converted number: " + num); // Output: 100

        // Example of handling invalid input
        try {
            String invalidNumStr = "100A"; // Invalid numeric string
            int value = Integer.parseInt(invalidNumStr); // This will throw NumberFormatException
            System.out.println("Converted number: " + value);
        } catch (NumberFormatException e) {
            // Handling exception if the string is not a valid integer
            System.out.println("Invalid number format: " + e.getMessage());
        }
        
        // Example of valid and invalid inputs
        validateParsing("123");  // Valid
        validateParsing("-45");  // Valid
        validateParsing("0");    // Valid
        validateParsing("12.5"); // Invalid
        validateParsing("abc");  // Invalid
        validateParsing("");     // Invalid
    }

    // Method to demonstrate parsing and exception handling
    public static void validateParsing(String input) {
        try {
            int result = Integer.parseInt(input);
            System.out.println("Successfully converted: " + input + " -> " + result);
        } catch (NumberFormatException e) {
            System.out.println("Failed to convert: \"" + input + "\" -> " + e.getMessage());
        }
    }
}
