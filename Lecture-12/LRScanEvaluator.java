// Java program to evaluate an arithmetic expression using Left-to-Right (LR) Scan
public class LRScanEvaluator {

    // Method to evaluate an expression using LR scan
    public static int evaluateExpression(String expression) {
        // Split the expression into tokens (numbers and operators)
        String[] tokens = expression.split("\\s+"); // Splitting based on spaces

        // Declare L (Left operand), R (Right operand), and OP (Operator)
        int L = Integer.parseInt(tokens[0]); // First number is stored in L

        // Process expression from left to right
        for (int i = 1; i < tokens.length; i += 2) {
            String OP = tokens[i];  // Read operator
            int R = Integer.parseInt(tokens[i + 1]);  // Read next number
            
            // Evaluate L OP R and store the result in L
            L = applyOperator(L, OP, R);
        }

        // Final value of L is the result
        return L;
    }

    // Method to apply arithmetic operations based on the operator
    private static int applyOperator(int L, String OP, int R) {
        switch (OP) {
            case "+": return L + R;
            case "-": return L - R;
            case "*": return L * R;
            case "/": return R != 0 ? L / R : 0; // Handling division by zero
            default:
                System.err.println("Error: Invalid operator '" + OP + "'");
                return 0;
        }
    }

    // Main method to test the LR Scan Evaluator
    public static void main(String[] args) {
        // Example arithmetic expression (space-separated)
        String expression = "3 + 4 * 2"; // LR Scan will evaluate it as (3+4) * 2 instead of 3 + (4*2)

        // Display input
        System.out.println("Input Expression: " + expression);

        // Evaluate and print the result
        int result = evaluateExpression(expression);
        System.out.println("Evaluated Result: " + result);
    }
}
