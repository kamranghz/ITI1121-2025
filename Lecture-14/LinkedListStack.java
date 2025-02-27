// Class representing a node in the stack
class StackNode {
    int value;
    StackNode next;

    public StackNode(int value) {
        this.value = value;
        this.next = null;
    }
}

// Stack implementation using a linked list
class LinkedListStack {
    private StackNode top; // Reference to the top of the stack

    public LinkedListStack() {
        this.top = null; // Initially, the stack is empty
    }

    // Push operation: Adds an element to the top of the stack
    public void push(int value) {
        StackNode newNode = new StackNode(value);
        newNode.next = top; // New node points to the previous top
        top = newNode; // Update top to the new node
    }

    // Pop operation: Removes and returns the top element of the stack
    public int pop() {
        if (isEmpty()) {
            return -1; // Return -1 if stack is empty (instead of throwing an exception)
        }
        int poppedValue = top.value;
        top = top.next; // Move top to the next node
        return poppedValue;
    }

    // Peek operation: Returns the top element without removing it
    public int peek() {
        if (isEmpty()) {
            return -1; // Return -1 if stack is empty (instead of throwing an exception)
        }
        return top.value;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Convert stack elements to a string for visualization
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        StackNode p = top;
        while (p != null) {
            sb.append(p.value);
            if (p.next != null) sb.append(", ");
            p = p.next;
        }
        sb.append("]");
        return sb.toString();
    }

    // Main method to test the stack
    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack();

        // Pushing elements onto the stack
        stack.push(6);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        // Display the stack
        System.out.println("Stack after push operations: " + stack);

        // Popping an element
        int poppedValue = stack.pop();
        if (poppedValue != -1) {
            System.out.println("Popped element: " + poppedValue);
        } else {
            System.out.println("Stack is empty, cannot pop.");
        }

        // Display stack after pop
        System.out.println("Stack after pop operation: " + stack);
    }
}
