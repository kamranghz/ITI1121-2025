// Array-based stack implementation for managing a collection of books
public class ArrayBasedStack {
    private String[] elems;  // Array to store stack elements (books)
    private int size;        // Current number of elements in the stack
    private static final int CAPACITY = 10;  // Capacity of the stack (max number of books)

    // Constructor initializes the stack with a predefined capacity
    public ArrayBasedStack() {
        elems = new String[CAPACITY];  // Allocate space for books
        size = 0;  // The stack is initially empty
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return size == 0;  // If there are no books, the stack is empty
    }

    // Method to push a new book onto the stack
    public void push(String book) {
        if (size >= CAPACITY) {  // If the stack is full, we cannot add more books
            System.out.println("Stack is full. Cannot add more books.");
            return;  // Exit the method without adding the book
        }
        elems[size] = book;  // Add the new book at the top of the stack
        size++;  // Increase the size of the stack
    }

    // Method to pop a book from the stack
    public String pop() {
        if (isEmpty()) {  // If the stack is empty, we cannot remove any book
            System.out.println("Stack is empty. No books to remove.");
            return null;  // Return null as there is no book to pop
        }
        String topBook = elems[size - 1];  // Get the book at the top of the stack
        elems[size - 1] = null;  // Set the now-removed book to null (it is no longer part of the stack)
        size--;  // Decrease the size of the stack
        return topBook;  // Return the removed book
    }

    // Method to peek at the top book without removing it
    public String peek() {
        if (isEmpty()) {  // If the stack is empty, there's no book to peek at
            System.out.println("Stack is empty. No book to peek.");
            return null;  // Return null as there is no book to peek at
        }
        return elems[size - 1];  // Return the top book without removing it
    }

    // Method to represent the current stack as a string (for easy printing)
    public String toString() {
        StringBuilder res = new StringBuilder("[");
        if (size > 0) {  // If the stack is not empty, append the books
            int p = 0;  // Initialize the index for the first book
            res.append(elems[p]);  // Append the first book to the result string
            p++;  // Move to the next book
            while (p < size) {  // Continue until all books are processed
                res.append(", ").append(elems[p]);  // Append the next book with a comma
                p++;  // Move to the next book
            }
        }
        res.append("]");  // Close the string representation of the stack
        return res.toString();  // Return the string representation of the stack
    }

    // Main method to demonstrate stack operations
    public static void main(String[] args) {
        // Create a new stack of books
        ArrayBasedStack bookStack = new ArrayBasedStack();

        // Push books onto the stack
        bookStack.push("The Catcher in the Rye");
        bookStack.push("To Kill a Mockingbird");
        bookStack.push("1984");
        bookStack.push("The Great Gatsby");

        // Display the stack content
        System.out.println("Stack after pushing books: " + bookStack); 

        // Peek at the top book
        System.out.println("Top book (peek): " + bookStack.peek()); 

        // Pop a book from the stack and display it
        System.out.println("Popped book: " + bookStack.pop()); 

        // Display the stack content after popping
        System.out.println("Stack after popping a book: " + bookStack);
    }
}
