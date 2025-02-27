// Array-based implementation of book storage and access
public class ArrayBasedLibrary {
    private String[] books;  // Array to store book titles
    private int size;        // Current number of books in the array
    private static final int MAX_CAPACITY = 10; // Maximum capacity of the library

    // Constructor to initialize the library with a given capacity
    public ArrayBasedLibrary() {
        books = new String[MAX_CAPACITY]; // Initialize array with capacity for 10 books
        size = 0; // Initially, the library is empty
    }

    // Method to add a new book to the library
    public void addBook(String book) {
        if (size < MAX_CAPACITY) {
            books[size] = book;  // Add book at the next available position
            size++;  // Increase the size of the library
        } else {
            System.out.println("Library is full! Cannot add more books.");
        }
    }

    // Method to search for a book by title (array-based)
    public boolean searchBook(String title) {
        for (int i = 0; i < size; i++) {
            if (books[i].equals(title)) {
                return true; // Book found
            }
        }
        return false; // Book not found
    }

    // Method to access the book at a specific index
    public String getBookAt(int index) {
        if (index >= 0 && index < size) {
            return books[index]; // Access book directly by index
        } else {
            System.out.println("Invalid index.");
            return null;
        }
    }

    // Method to display all books in the library
    public void displayBooks() {
        System.out.println("Books in the library:");
        for (int i = 0; i < size; i++) {
            System.out.println(books[i]);
        }
    }
}

