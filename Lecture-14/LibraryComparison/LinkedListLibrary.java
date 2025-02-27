// Linked list implementation of book storage and access
public class LinkedListLibrary {
    private static class Node {
        String book; // Book title stored in this node
        Node next;   // Reference to the next node (next book)

        public Node(String book) {
            this.book = book;
            this.next = null;
        }
    }

    private Node head;   // The first node (book) in the list
    private int size;    // Number of books in the library

    public LinkedListLibrary() {
        head = null; // Initially, no books in the library
        size = 0;
    }

    // Method to add a new book to the library
    public void addBook(String book) {
        Node newNode = new Node(book);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    // Method to search for a book by title (linked list-based)
    public boolean searchBook(String title) {
        Node current = head;
        while (current != null) {
            if (current.book.equals(title)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Method to access the book at a specific position (linked list-based)
    public String getBookAt(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid index.");
            return null;
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.book;
    }

    // Method to display all books in the library
    public void displayBooks() {
        Node current = head;
        System.out.println("Books in the library:");
        while (current != null) {
            System.out.println(current.book);
            current = current.next;
        }
    }
}
