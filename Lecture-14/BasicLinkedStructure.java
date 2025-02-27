public class BasicLinkedStructure {

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
        // Initializing the first element 'p' with value "A" and no next element
        Elem p = new Elem("A", null);

        // Attempting to link a new element 'q' to 'p' without initializing 'q'
        Elem q = null;
        // This line will cause a NullPointerException because 'q' is not an object yet
        // q.next = p;  // Uncommenting this line will cause an error

        // Proper way to create and link 'q' to 'p'
        q = new Elem("B", p);  // 'q' now points to 'p'

        // Printing out the values to show the linked structure
        System.out.println("First element (q) value: " + q.value + " links to " + q.next.value);
    }
}
