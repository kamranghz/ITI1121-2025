// This class demonstrates aliasing and using the equals method to compare objects.
public class CompareAliasObjects {
    public static void main(String[] args) {
        // Create a MyInteger object with the value 5.
        MyInteger a = new MyInteger(5); // Object 'a' with value 5.

        // Assign the reference of 'a' to 'b' (aliasing).
        MyInteger b = a; // 'b' is now an alias for 'a'.

        // Print the values of 'a' and 'b'.
        System.out.println("Value of a: " + a.value);
        System.out.println("Value of b: " + b.value);

        // Print the memory addresses of 'a' and 'b'.
        System.out.println("Memory address of object 'a': " + System.identityHashCode(a));
        System.out.println("Memory address of object 'b': " + System.identityHashCode(b));

        // Compare the two references using the equals method.
        if (a.equals(b)) {
            System.out.println("a equals b");
        } else {
            System.out.println("a does not equal b");
        }
    }
}
