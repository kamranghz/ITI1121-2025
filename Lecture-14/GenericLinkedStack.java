// GenericLinkedStack.java: Implementation of a generic linked stack handling Integer, String, Character, and Double data types.

// Define the Stack interface
interface Stack<T> {
    boolean isEmpty();  // Check if the stack is empty.
    void push(T element);  // Push an element onto the stack.
    T pop();  // Remove and return the top element of the stack.
    T peek();  // Return the top element without removing it.
}

// Implementation of a generic linked stack.
class GenericLinkedStack<T> implements Stack<T> {
    // Inner class for stack elements.
    private static class Elem<E> {
        private E value;  // The value stored in the element.
        private Elem<E> next;  // Link to the next element in the stack.

        // Constructor for stack element.
        public Elem(E value, Elem<E> next) {
            this.value = value;  // Set the value of the element.
            this.next = next;  // Set the next element in the stack.
        }
    }

    private Elem<T> top;  // The top element of the stack.

    // Check if the stack is empty.
    @Override
    public boolean isEmpty() {
        return top == null;  // Returns true if the top is null.
    }

    // Push a new element onto the stack.
    @Override
    public void push(T element) {
        top = new Elem<T>(element, top);  // Create a new element at the top.
    }

    // Pop the top element from the stack
    @Override
    public T pop() {
        if (isEmpty()) {  // Check if the stack is empty
            System.out.println("Stack is empty. Cannot pop.");
            return null;  // Return null if the stack is empty
        }
        T value = top.value;  // Get the top element's value
        top = top.next;  // Remove the top element
        return value;  // Return the popped value
    }

    // Peek at the top element of the stack
    @Override
    public T peek() {
        if (isEmpty()) {  // Check if the stack is empty
            System.out.println("Stack is empty. Nothing to peek.");
            return null;  // Return null if the stack is empty
        }
        return top.value;  // Return the value of the top element
    }

    // Main method to demonstrate usage of GenericLinkedStack with various data types
    public static void main(String[] args) {
        // Create GenericLinkedStack instances for different data types
        GenericLinkedStack<Integer> integerStack = new GenericLinkedStack<>();
        GenericLinkedStack<String> stringStack = new GenericLinkedStack<>();
        GenericLinkedStack<Character> charStack = new GenericLinkedStack<>();
        GenericLinkedStack<Double> doubleStack = new GenericLinkedStack<>();

        // Push elements onto the stacks
        integerStack.push(42);  // Integer stack
        stringStack.push("Hello, world!");  // String stack
        charStack.push('A');  // Character stack
        doubleStack.push(3.14159);  // Double stack

        // Peek at the top elements
        System.out.println("Integer Stack Top: " + integerStack.peek());  
        System.out.println("String Stack Top: " + stringStack.peek());  
        System.out.println("Character Stack Top: " + charStack.peek());  
        System.out.println("Double Stack Top: " + doubleStack.peek());  

        // Pop elements and display them
        System.out.println("Popped from Integer Stack: " + integerStack.pop()); 
        System.out.println("Popped from String Stack: " + stringStack.pop());  
        System.out.println("Popped from Character Stack: " + charStack.pop());  
        System.out.println("Popped from Double Stack: " + doubleStack.pop());  
    }
}
