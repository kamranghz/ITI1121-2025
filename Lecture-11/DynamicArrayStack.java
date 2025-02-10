// ***************************************************
//  Dynamic Array Stack Implementation in Java
//  - Uses an array that grows dynamically when full
//  - Demonstrates stack operations with letters (A, B, C, ...)
// ***************************************************

public class DynamicArrayStack {
    private char[] elems;  // Array to store stack elements
    private int top;       // Index of the next free position (top of stack)
    private int capacity;  // Maximum capacity of stack (grows dynamically)

    // ************************************
    // Constructor: Initializes an empty stack
    // ************************************
    public DynamicArrayStack(int capacity) {
        this.capacity = capacity;
        elems = new char[capacity];  // Initial array with given capacity
        top = 0;  // Stack is empty at the start
    }

    // ************************************
    // Method: Resizes the array when it becomes full
    // - Doubles the size to accommodate more elements
    // ************************************
    private void resize() {
        int newCapacity = capacity * 2; // Double the capacity
        char[] newElems = new char[newCapacity];

        // Copy old elements into new larger array
        System.arraycopy(elems, 0, newElems, 0, capacity);
        elems = newElems;
        capacity = newCapacity;

        // Notify about resizing
        System.out.println("⚠ Stack resized! New capacity: " + newCapacity);
    }

    // ************************************
    // Method: Push (Insert an element into the stack)
    // - Adds element at top, grows array if full
    // ************************************
    public void push(char element) {
        if (top == capacity) { // If full, resize
            resize();
        }
        elems[top++] = element; // Store element and move top pointer
        printStackState("push(" + element + ")");
    }

    // ************************************
    // Method: Pop (Remove the top element)
    // - Decrements top and returns the removed element
    // ************************************
    public char pop() {
        if (top == 0) {
            System.out.println("⚠ Stack is empty! Cannot pop.");
            return '\0';  // Return empty character if stack is empty
        }
        char removed = elems[--top]; // Get last element and move top down
        elems[top] = '\0'; // Optional: clear the popped element
        printStackState(removed + " <- pop()");
        return removed;
    }

    // ************************************
    // Method: Print current stack state
    // - Shows elements and top index for better understanding
    // ************************************
    private void printStackState(String operation) {
        System.out.print(operation + "  top = " + top + ", stack -> [");
        for (int i = 0; i < capacity; i++) {
            if (i < top) {
                System.out.print(elems[i]); // Print existing elements
            } else {
                System.out.print(" "); // Empty spaces in the stack
            }
            if (i < capacity - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    // ************************************
    // Main Method: Demonstrates Stack Operations
    // - Push and pop operations with characters A, B, C, D, etc.
    // ************************************
    public static void main(String[] args) {
        System.out.println("📌 Stack Demonstration: Dynamic Array Implementation");
        System.out.println("---------------------------------------------------");

        // Create stack with initial capacity of 5
        DynamicArrayStack stack = new DynamicArrayStack(5);

        // Push elements A, B, C, D, E
        stack.push('A');
        stack.push('B');
        stack.push('C');
        stack.push('D');
        stack.push('E');

        // Pop operations
        stack.pop(); // Removes 'E'
        stack.pop(); // Removes 'D'

        // More push operations (demonstrates dynamic resizing)
        stack.push('G');
        stack.push('H');
        stack.push('I');
        stack.push('J');
        stack.push('K'); // Should trigger resizing
    }
}
