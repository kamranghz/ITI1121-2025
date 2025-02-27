public class LibraryTest {
    public static void main(String[] args) {
        // Test with Array-based Implementation
        ArrayBasedLibrary arrayLibrary = new ArrayBasedLibrary();
        arrayLibrary.addBook("Harry Potter");
        arrayLibrary.addBook("The Hobbit");
        arrayLibrary.addBook("1984");

        System.out.println("Array-based library:");
        arrayLibrary.displayBooks();
        System.out.println("Is 'The Hobbit' in the library? " + arrayLibrary.searchBook("The Hobbit"));
        System.out.println("Book at index 2: " + arrayLibrary.getBookAt(2));

        // Test with Linked List Implementation
        LinkedListLibrary linkedLibrary = new LinkedListLibrary();
        linkedLibrary.addBook("Harry Potter");
        linkedLibrary.addBook("The Hobbit");
        linkedLibrary.addBook("1984");

        System.out.println("\nLinked-list-based library:");
        linkedLibrary.displayBooks();
        System.out.println("Is 'The Hobbit' in the library? " + linkedLibrary.searchBook("The Hobbit"));
        System.out.println("Book at position 2: " + linkedLibrary.getBookAt(2));
    }
}
