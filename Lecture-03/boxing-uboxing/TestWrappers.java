public class TestWrappers {
    public static void main(String[] args) {

        // ----------------- Section 1: Autoboxing and Wrapper Class Methods -----------------

        // Autoboxing: Automatically converts a primitive value into its corresponding wrapper class object.
        Integer wrapperInt = 1; // The primitive value `1` is automatically converted into an Integer object.

        // Wrapper class methods: The `doubleValue()` method converts the value inside the Integer object to its double representation.
        System.out.println("Autoboxing Example:");
        System.out.println("The value of wrapperInt as a double: " + wrapperInt.doubleValue());
        // Output: The value of wrapperInt as a double: 1.0
        System.out.println("----------------------");

        // ----------------- Section 2: Auto-unboxing -----------------

        // Auto-unboxing: Automatically converts a wrapper class object into its corresponding primitive value.
        Integer autoBoxedInt = 100; // Autoboxing: The primitive value `100` is stored in an Integer object.

        // During auto-unboxing, the primitive value `100` is extracted from the Integer object and used in the arithmetic operation.
        int autoUnboxedValue = autoBoxedInt + 50; // Unboxing occurs here automatically.

        System.out.println("Auto-unboxing Example:");
        System.out.println("Auto-boxed Integer value: " + autoBoxedInt); // Displays the wrapped value (100).
        System.out.println("After auto-unboxing and adding 50: " + autoUnboxedValue); // Displays the result (150).
        // Output:
        // Auto-boxed Integer value: 100
        // After auto-unboxing and adding 50: 150
        System.out.println("----------------------");

        // ----------------- Section 3: Boxing and Unboxing of Primitive Values -----------------

        // Boxing: Wrapping a primitive value into its corresponding wrapper class.
        int primitiveValue = 42; // Primitive type `int` directly stores the value in memory.
        Integer boxedValue = primitiveValue; // Boxing: Wraps `primitiveValue` into an Integer object.

        // Unboxing: Extracting the primitive value from the wrapper object.
        int unboxedValue = boxedValue; // Unboxing: Retrieves the primitive value from `boxedValue`.

        System.out.println("Boxing and Unboxing Example:");
        System.out.println("Primitive value: " + primitiveValue); // Output: 42
        System.out.println("Boxed value (Integer object): " + boxedValue); // Output: 42
        System.out.println("Unboxed value (primitive): " + unboxedValue); // Output: 42
        System.out.println("----------------------");

        // ----------------- Section 4: Wrapper Object Immutability and Object References -----------------

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
