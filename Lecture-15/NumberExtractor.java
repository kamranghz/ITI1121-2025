// Java program to parse command-line arguments and find the first valid integer

public class NumberExtractor {
    public static void main(String[] args) {

        boolean valid = false; // Flag to track if a valid number is found
        int value = -1; // Default value if no valid number is found

        // Loop through command-line arguments until a valid number is found
        for (int i = 0; i < args.length && !valid; i++) {
            try {
                // Attempt to convert the argument to an integer
                value = Integer.parseInt(args[i]);
                valid = true; // If successful, mark as valid
            } catch (NumberFormatException e) {
                // Catch invalid number format and print an error message
                System.out.println("not a valid number: " + args[i]);
            }
        }

        // Check if a valid integer was found and display the result
        if (valid) {
            System.out.println("value = " + value);
        } else {
            System.out.println("No valid number was found");
        }
    }
}
// java NumberExtractor a 1.1 "" 2 3