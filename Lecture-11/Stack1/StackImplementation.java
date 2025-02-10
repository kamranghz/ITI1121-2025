public class StackImplementation implements Stack {
    private Object[] stackArray; // Array to hold stack elements
    private int top; // Index of the top element

    // Constructor to initialize the stack with a given capacity
    public StackImplementation(int capacity) {
        stackArray = new Object[capacity];
        top = -1; // Stack is initially empty
    }

    @Override
    public boolean isEmpty() {
        return top == -1; // True if no elements in the stack
    }

    @Override
    public void push(Object element) {
        if (top < stackArray.length - 1) { // Check if stack has space
            stackArray[++top] = element; // Add element to the stack
        } else {
            System.out.println("Stack is full. Cannot push element.");
        }
    }

    @Override
    public Object pop() {
        if (!isEmpty()) {
            return stackArray[top--]; // Remove and return the top element
        } else {
            System.out.println("Stack is empty. Cannot pop element.");
            return null;
        }
    }

    @Override
    public Object peek() {
        if (!isEmpty()) {
            return stackArray[top]; // Return the top element without removing it
        } else {
            System.out.println("Stack is empty. Nothing to peek.");
            return null;
        }
    }
}
