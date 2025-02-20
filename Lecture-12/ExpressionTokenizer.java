// This program tokenizes a mathematical expression into numbers and symbols.
public class ExpressionTokenizer {

    // Method to process and extract tokens from an expression
    public static void scanExpression(String expression) {
        // Splitting the input string based on spaces to get individual tokens
        String[] tokens = expression.trim().split("\\s+");

        // Loop through each token and classify it as INTEGER or SYMBOL
        for (String token : tokens) {
            // Check if the token is a number using a simple condition
            if (token.matches("\\d+")) {  // Matches one or more digits (0-9)
                System.out.println("INTEGER: " + token);
            } else {
                System.out.println("SYMBOL: " + token);
            }
        }
    }

    // Main method to execute the program
    public static void main(String[] args) {
        // Example arithmetic expression
        String expression = " 3   + 4 * 567 ";

        // Display the input expression
        System.out.println("Input Expression: \"" + expression + "\"");
        System.out.println("Tokenized Output:");

        // Call method to tokenize and classify the expression
        scanExpression(expression);
    }
}
