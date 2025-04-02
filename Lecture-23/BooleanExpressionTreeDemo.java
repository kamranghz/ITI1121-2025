// A Binary Tree for evaluating Boolean expressions (e.g., true AND false)
public class BooleanExpressionTreeDemo {

    // Abstract base class for all expression nodes
    abstract static class Node {
        abstract boolean evaluate(); // Each node must implement this method
    }

    // Leaf node: stores a Boolean literal (true/false)
    static class LiteralNode extends Node {
        private final boolean value;

        LiteralNode(boolean value) {
            this.value = value;
        }

        @Override
        boolean evaluate() {
            return value;
        }
    }

    // Operator node: represents AND or OR
    static class OperatorNode extends Node {
        private final String operator; // "AND" or "OR"
        private final Node left, right;

        OperatorNode(String operator, Node left, Node right) {
            this.operator = operator;
            this.left = left;
            this.right = right;
        }

        @Override
        boolean evaluate() {
            boolean leftValue = left.evaluate();
            boolean rightValue = right.evaluate();
            if (operator.equals("AND")) {
                return leftValue && rightValue;
            } else if (operator.equals("OR")) {
                return leftValue || rightValue;
            } else {
                throw new IllegalArgumentException("Unsupported operator: " + operator);
            }
        }
    }

    public static void main(String[] args) {
        /*
           Expression Tree for: (true AND false) OR true

                     OR
                    /  \
                 AND   true
                /   \
            true   false
         */

        Node root = new OperatorNode("OR",
                        new OperatorNode("AND",
                            new LiteralNode(true),
                            new LiteralNode(false)
                        ),
                        new LiteralNode(true)
                    );

        // Evaluate the full expression
        System.out.println("Expression: (true AND false) OR true");
        System.out.println("Result: " + root.evaluate()); // true
    }
}
