import java.util.Stack;

public class ExpressionEvaluator {

    // Method to evaluate an arithmetic expression while considering operator precedence and parentheses
    public static int evaluate(String expression) {
        // Stacks to hold numbers and operators separately
        Stack<Integer> numbers = new Stack<>();
        Stack<Character> operators = new Stack<>();

        // Remove spaces to process the expression smoothly
        expression = expression.replaceAll("\\s", "");

        // Traverse each character in the expression
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            // Case 1: If current character is a number (digit)
            if (Character.isDigit(ch)) {
                int num = 0;
                // Handling multi-digit numbers
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    num = num * 10 + (expression.charAt(i) - '0');
                    i++;
                }
                i--; // Move back to process operators correctly
                numbers.push(num);
            }

            // Case 2: If current character is an opening parenthesis '('
            else if (ch == '(') {
                operators.push(ch);
            }

            // Case 3: If current character is a closing parenthesis ')'
            else if (ch == ')') {
                // Evaluate the expression inside the parentheses
                while (!operators.isEmpty() && operators.peek() != '(') {
                    numbers.push(applyOperation(operators.pop(), numbers.pop(), numbers.pop()));
                }
                operators.pop(); // Remove the '(' from the stack
            }

            // Case 4: If current character is an operator (+, -, *, /)
            else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                // Process previous higher precedence operators before pushing the current one
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(ch)) {
                    numbers.push(applyOperation(operators.pop(), numbers.pop(), numbers.pop()));
                }
                operators.push(ch);
            }
        }

        // Apply remaining operations in the stack
        while (!operators.isEmpty()) {
            numbers.push(applyOperation(operators.pop(), numbers.pop(), numbers.pop()));
        }

        return numbers.pop(); // Final result
    }

    // Method to return the precedence of operators
    private static int precedence(char op) {
        if (op == '+' || op == '-') return 1; // Lower precedence
        if (op == '*' || op == '/') return 2; // Higher precedence
        return 0; // Parentheses '(' will have the lowest precedence
    }

    // Method to apply an operation and return the result
    private static int applyOperation(char op, int b, int a) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return (b != 0) ? a / b : 0; // Handling division by zero
            default: return 0;
        }
    }

    // Main method to test the precedence and left-to-right evaluation
    public static void main(String[] args) {
        // Test expressions
        String[] expressions = {
            "7 - (3 - 2)",    // Parentheses first
            "7 - 3 * 2",      // Multiplication has higher priority
            "(7 - 3) * 2",    // Parentheses change order
            "7 - 3 + 2",      // Left to right for same precedence
            "7 + 3 * 2",      // Multiplication has higher priority
            "(7 + 3) * 2"     // Parentheses change precedence
        };

        // Display results with explanations
        for (String exp : expressions) {
            int result = evaluate(exp);
            System.out.println("\nExpression: " + exp);
            explainPrecedence(exp, result);
        }
    }

    // Method to explain operator precedence in the output
    private static void explainPrecedence(String expression, int result) {
        System.out.println("Evaluated Result: " + result);

        if (expression.contains("(")) {
            System.out.println("Priority: Parentheses '(' force higher precedence.");
        }
        if (expression.contains("*") || expression.contains("/")) {
            System.out.println("Priority: Multiplication '*' and Division '/' have higher precedence than Addition '+' and Subtraction '-'.");
        }
        System.out.println("Priority: Operators with the same precedence (like '+' and '-') are evaluated Left to Right.");
    }
}
