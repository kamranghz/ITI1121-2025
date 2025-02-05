import java.util.Stack;

/**
 * This class demonstrates basic stack operations using a sequence of characters.
 */
public class SimpleStackDemo {

    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>(); // Create a new stack of Character type

        // Push elements onto the stack
        pushElement(stack, 'a');
        pushElement(stack, 'b');
        pushElement(stack, 'c');
        pushElement(stack, 'd');
        pushElement(stack, 'e');

        // Pop one element from the stack
        popElement(stack);

        // Peek at the top element of the stack without removing
        peekElement(stack);

        // Continue to pop all elements to clear the stack
        while (!stack.isEmpty()) {
            popElement(stack);
        }
    }

    // Method to push an element onto the stack and display the stack content
    private static void pushElement(Stack<Character> stack, char element) {
        stack.push(element);
        System.out.println("Pushed " + element + ": " + stack);
    }

    // Method to pop an element from the stack and display the stack content
    private static void popElement(Stack<Character> stack) {
        char element = stack.pop();
        System.out.println("Popped " + element + ": " + stack);
    }

    // Method to peek at the top element of the stack and display the stack content
    private static void peekElement(Stack<Character> stack) {
        char element = stack.peek();
        System.out.println("Peeked at " + element + ": " + stack);
    }
}
