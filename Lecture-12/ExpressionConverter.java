import java.util.Stack;

public class ExpressionConverter {

    // Method to convert infix to postfix (Reverse Polish Notation - RPN)
    public static String infixToPostfix(String infix) {
        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();

        for (char ch : infix.toCharArray()) {
            if (Character.isDigit(ch)) {
                postfix.append(ch).append(" ");  // Append numbers directly
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop()).append(" ");
                }
                stack.pop(); // Remove '('
            } else if (isOperator(ch)) {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(ch)) {
                    postfix.append(stack.pop()).append(" ");
                }
                stack.push(ch);
            }
        }

        // Pop remaining operators
        while (!stack.isEmpty()) {
            postfix.append(stack.pop()).append(" ");
        }

        return postfix.toString().trim();
    }

    // Method to convert infix to prefix notation
    public static String infixToPrefix(String infix) {
        String reversedInfix = new StringBuilder(infix).reverse().toString();
        String modifiedInfix = reversedInfix.replace('(', '#').replace(')', '(').replace('#', ')');
        String reversedPostfix = infixToPostfix(modifiedInfix);
        return new StringBuilder(reversedPostfix).reverse().toString();
    }

    // Method to check if a character is an operator
    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    // Method to return operator precedence
    private static int precedence(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return 0; // Parentheses '(' have lowest precedence
    }

    // Main method to demonstrate all three notations
    public static void main(String[] args) {
        // Example expressions
        String expression1 = "7 - (3 - 2)"; 
        String expression2 = "(7 - 3) - 2"; 
        String expression3 = "7 - 3 * 2"; 

        // Print results
        System.out.println("\nExpression: " + expression1);
        explainNotation(expression1);

        System.out.println("\nExpression: " + expression2);
        explainNotation(expression2);

        System.out.println("\nExpression: " + expression3);
        explainNotation(expression3);
    }

    // Method to explain infix, postfix, and prefix notations
    private static void explainNotation(String expression) {
        System.out.println("Infix Notation:   " + expression);
        System.out.println("Postfix (RPN):    " + infixToPostfix(expression));
        System.out.println("Prefix Notation:  " + infixToPrefix(expression));
    }
}



