// This class demonstrates comparing two objects using a custom equals method and prints their memory addresses.
public class CompareObjectsWithMemoryAddresses {
    public static void main(String[] args) {
        // Create two separate MyInteger objects with the same value.
        MyInteger a = new MyInteger(5); // Object 'a' with value 5.
        MyInteger b = new MyInteger(5); // Object 'b' with value 5.

        // Print the memory addresses of the objects using System.identityHashCode().
        System.out.println("Memory address of object 'a': " + System.identityHashCode(a));
        System.out.println("Memory address of object 'b': " + System.identityHashCode(b));

        // Compare the two objects using the '==' operator to check their references.
        if (a == b) {
            System.out.println("a and b refer to the same memory location (by reference)");
        } else {
            System.out.println("a and b do not refer to the same memory location (by reference)");
        }
    }
}
