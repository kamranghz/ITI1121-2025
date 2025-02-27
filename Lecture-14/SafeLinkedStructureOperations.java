public class SafeLinkedStructureOperations {

    static class Elem {
        Object value;  // The value stored in this element
        Elem next;     // Reference to the next element in the structure

        // Constructor initializes the element with a value and an optional next element
        Elem(Object value, Elem next) {
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        // Properly initializing the first element 'p' with value "A" and no next element
        Elem p = new Elem("A", null);

        // Attempting to create a second element 'q' and link it safely
        Elem q = null;

        // Safe linking: Check if 'q' is not null before accessing its 'next' attribute
        if (q != null) {
            q.next = p;  // This line would be safe, but 'q' is null, so it will not execute
        } else {
            System.out.println("'q' is null and has not been initialized. Initializing 'q' and linking to 'p'.");
            q = new Elem("B", p);  // Proper initialization and linking
        }

        // Printing out the values to show the linked structure
        if (q != null && q.next != null) {
            System.out.println("First element (q) value: " + q.value + " links to " + q.next.value);
        } else {
            System.out.println("There was an issue linking the elements.");
        }
    }
}
