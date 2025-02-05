/**
 * This interface defines the essential operations of a stack data structure using generics.
 * It is package-private to allow all classes in this file to interact without public exposure.
 * 
 * @param <E> The type of elements held in this stack. This allows the stack to be type-agnostic,
 *            meaning it can hold any type of objects as long as they are consistently the same.
 */
interface Stack<E> {
    boolean isEmpty(); // Checks if the stack is empty. Returns true if it is, otherwise false.
    void push(E elem); // Adds an element to the top of the stack.
    E pop();           // Removes and returns the top element of the stack. Returns null if empty.
    E peek();          // Returns the top element without removing it from the stack. Returns null if empty.
}

/**
 * Implements the Stack interface using an array to store the elements.
 * This class is generic and can be adapted to hold any type of object that is consistent throughout its instance.
 * It is not public to avoid the necessity of being in a separate file, keeping the demonstration concise.
 *
 * @param <T> The type of elements the stack will hold, extending the flexibility of the stack.
 */
class ArrayStack<T> implements Stack<T> {
    private T[] elems; // Array to store the elements of the stack
    private int top;   // Index tracking the top of the stack (first free cell), initially zero.

    /**
     * Constructs a new ArrayStack with a specified capacity.
     * 
     * @param capacity The maximum number of items the stack can hold, defining the size of the internal array.
     */
    public ArrayStack(int capacity) {
        // The array is cast to T[] from Object[] to comply with generic array creation rules.
        this.elems = (T[]) new Object[capacity];
        top = 0; // Stack is initially empty, so top is set to zero.
    }

    @Override
    public boolean isEmpty() {
        // Checks if the stack is empty by comparing the top index with zero.
        return top == 0;
    }

    @Override
    public void push(T elem) {
        // Adds an element to the position of 'top' and increments the index.
        // Assumes that the stack will not overflow since we do not handle stack overflow errors here.
        elems[top++] = elem;
    }

    @Override
    public T pop() {
        // Checks if the stack is empty to avoid underflow.
        // If not empty, decrements top and returns the element at the new top index.
        if (isEmpty()) {
            return null;
        }
        T elem = elems[--top];
        elems[top] = null; // Clears the reference to the popped element to aid garbage collection.
        return elem;
    }

    @Override
    public T peek() {
        // Returns the top element without modifying the stack.
        // Checks if the stack is empty to avoid accessing invalid index.
        if (isEmpty()) {
            return null;
        }
        return elems[top - 1];
    }
}

/**
 * This class contains the main method and serves as the entry point for the program.
 * It demonstrates the usage of the ArrayStack with strings.
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        Stack<String> myStack = new ArrayStack<>(100); // Instantiate a Stack with a capacity of 100.

        // Loop through command-line arguments and push each onto the stack.
        for (String arg : args) {
            myStack.push(arg);
            System.out.println("Pushed: " + arg); // Display each pushed element.
        }

        // Pop elements from the stack until it is empty, displaying each in LIFO order.
        System.out.println("Stack content in reverse order:");
        while (!myStack.isEmpty()) {
            System.out.print(myStack.pop() + " ");
        }
        System.out.println(); // Ensure a newline at the end of the output.
    }
}
