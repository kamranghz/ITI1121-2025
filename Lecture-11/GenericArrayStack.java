import java.util.Arrays;

public class GenericArrayStack<E> {
    private E[] elems;  // Array to store stack elements
    private int top;    // Index representing the top of the stack

    // Constructor: Initializes an empty stack with a given capacity
    @SuppressWarnings("unchecked")
    public GenericArrayStack(int capacity) { // ✅ Fixed constructor name
        elems = (E[]) new Object[capacity]; // Generic array workaround
        top = 0; // Stack starts empty
    }

    // Push method: Adds an element to the stack
    public void push(E element) {
        if (top < elems.length) { // Ensure there is space before adding
            elems[top] = element;
            top++; // Move the top pointer up
        }
    }

    // Pop method: Removes and returns the top element
    public E pop() {
        if (!isEmpty()) { // Ensure the stack is not empty before popping
            top--; // Move top pointer down
            E saved = elems[top];
            elems[top] = null; // Remove reference (not required but good practice)
            return saved;
        }
        return null; // Return null if stack is empty (no exceptions)
    }

    // Peek method: Returns the top element without removing it
    public E peek() {
        if (!isEmpty()) {
            return elems[top - 1]; // Return the last inserted element
        }
        return null; // Return null if stack is empty
    }

    // Checks if the stack is empty
    public boolean isEmpty() {
        return top == 0;
    }

    // Returns the current number of elements in the stack
    public int size() {
        return top;
    }

    // Prints the stack elements (for visualization)
    public void printStack() {
        System.out.println("Stack elements: " + Arrays.toString(Arrays.copyOf(elems, top)));
    }

    // Main method to demonstrate stack functionality
    public static void main(String[] args) {
        GenericArrayStack<String> stack = new GenericArrayStack<>(8); // ✅ Fixed constructor name

        // Pushing elements onto the stack
        stack.push("23:00:00");
        stack.push("13:00:00");
        stack.push("14:30:00");

        // Display stack
        stack.printStack();

        // Popping elements and printing stack state
        System.out.println("Popped: " + stack.pop());
        stack.printStack();

        System.out.println("Popped: " + stack.pop());
        stack.printStack();

        System.out.println("Popped: " + stack.pop());
        stack.printStack();
    }
}
