// This class demonstrates aliasing by assigning two references to the same object.
public class AliasExample {
    public static void main(String[] args) {
        // Create a MyInteger object with the value 5.
        MyInteger a = new MyInteger(5); // Object 'a' with value 5.

        // Assign the reference of 'a' to 'b'.
        MyInteger b = a; // 'b' is now an alias for 'a'.

        // Print the memory addresses of 'a' and 'b'.
        System.out.println("Memory address of object 'a': " + System.identityHashCode(a));
        System.out.println("Memory address of object 'b': " + System.identityHashCode(b));

        // Compare the two references using the '==' operator.
        if (a == b) {
            System.out.println("a == b (both reference the same object)");
        } else {
            System.out.println("a != b (references point to different objects)");
        }
    }
}
