public interface Stack {
    boolean isEmpty(); // Checks if the stack is empty
    void push(Object elem); // Adds an element to the stack
    Object pop(); // Removes and returns the top element
    Object peek(); // Returns the top element without removing it
}
