// Filename: Equal.java
// This program demonstrates how to override the equals() method in Java.

public class Equal {
    private int id;         // Unique identifier for the object
    private String name;    // Name associated with the object

    // Constructor to initialize object properties
    public Equal(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Overriding the equals() method to compare Equal objects
    @Override
    public boolean equals(Object o) {
        // Step 1: Check if the given object is null
        if (o == null) {
            return false;
        }
        // Step 2: Check if the object is of the same class
        if (this.getClass() != o.getClass()) {
            return false;
        }
        // Step 3: Cast the object to Equal type
        Equal other = (Equal) o;
        // Step 4: Compare ID and name fields for equality
        return this.id == other.id && 
               (this.name != null && this.name.equals(other.name));
    }

    // Overriding toString() for better object representation
    @Override
    public String toString() {
        return "Equal[ID=" + id + ", Name=" + name + "]";
    }

    // Main method to test the equals() method
    public static void main(String[] args) {
        Equal a = new Equal(1, "Jane Doe");
        Equal b = new Equal(1, "Jane Doe");
        Equal c = new Equal(2, "John Doe");

        // Comparing two objects with the same values
        System.out.println("Comparing 'a' and 'b': " + a==b); // Expected: true
        // Comparing two objects with different values
        System.out.println("Comparing 'a' and 'c': " + a.equals(c)); // Expected: false

        // Demonstrating toString() method
        System.out.println(a); // Output: Equal[ID=1, Name=Jane Doe]
        System.out.println(c); // Output: Equal[ID=2, Name=John Doe]
    }
}
