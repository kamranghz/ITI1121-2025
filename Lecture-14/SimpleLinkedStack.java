// SimpleLinkedStack.java: Demonstrates a simple linked stack handling Integer data

// Define the Stack interface
interface Stack {
    boolean isEmpty();
    void push(Integer element);
    Integer pop();
    Integer peek();
}

// Implement the SimpleLinkedStack class
public class SimpleLinkedStack implements Stack {
    // Inner class for stack elements
    private static class Elem {
        private Integer value; // Value stored in the element
        private Elem next; // Link to the next element

        // Constructor for creating a new element
        public Elem(Integer value, Elem next) {
            this.value = value;
            this.next = next;
        }
    }

    private Elem top; // Top element of the stack

    // Method to check if the stack is empty
    @Override
    public boolean isEmpty() {
        return top == null;
    }

    // Method to push a new element onto the stack
    @Override
    public void push(Integer element) {
        top = new Elem(element, top);
    }

    // Method to pop the top element from the stack
    @Override
    public Integer pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop.");
            return null;  // Return null if the stack is empty
        }
        Integer value = top.value;
        top = top.next;
        return value;
    }

    // Method to peek at the top element of the stack without removing it
    @Override
    public Integer peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Nothing to peek.");
            return null;  // Return null if the stack is empty
        }
        return top.value;
    }

    // Main method to demonstrate stack operations
    public static void main(String[] args) {
        SimpleLinkedStack stack = new SimpleLinkedStack();
        // Push elements onto the stack
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        // Peeking at the top element
        System.out.println("Peeking at top of stack: " + stack.peek()); // Expects 5
        System.out.println("Numbers popped from stack:");

        // Popping elements until the stack is empty
        while (!stack.isEmpty()) {
            System.out.println(stack.pop()); // Pops and prints numbers from 5 back to 1
        }

        // Attempting to pop from an empty stack
        stack.pop(); // Stack is empty, so it will print a message
    }
}
