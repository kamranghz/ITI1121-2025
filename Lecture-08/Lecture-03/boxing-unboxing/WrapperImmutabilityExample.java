public class WrapperImmutabilityExample {
    public static void main(String[] args) {
        // Creating a wrapper object and assigning it to a reference variable.
        Integer original = 10; // `original` points to an Integer object with value 10.

        // Create another reference pointing to the same object.
        Integer alias = original; // `alias` points to the same object as `original`.

        // Modify `original` by performing an arithmetic operation.
        original = original + 5; // Creates a NEW Integer object with value 15.
        // `alias` still points to the old object (value 10) because wrapper objects are immutable.

        // Comparing references.
        System.out.println("Wrapper Object Immutability Example:");
        if (original == alias) {
            System.out.println("original and alias are pointing to the same object.");
        } else {
            System.out.println("original and alias are NOT pointing to the same object.");
        }
        // Output: original and alias are NOT pointing to the same object.

        // Printing the actual values of `original` and `alias`.
        System.out.println("Value of original: " + original); // Output: 15
        System.out.println("Value of alias: " + alias);       // Output: 10
        System.out.println("----------------------");
    }
}
