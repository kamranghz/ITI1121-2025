public class AutoboxingExample {
    public static void main(String[] args) {
        // Autoboxing: Automatically converts a primitive value into its corresponding wrapper class object.
        Integer wrapperInt = 1; // The primitive value `1` is automatically converted into an Integer object.

        // Wrapper class methods: The `doubleValue()` method converts the value inside the Integer object to its double representation.
        System.out.println("Autoboxing Example:");
        System.out.println("The value of wrapperInt as a double: " + wrapperInt.doubleValue());
    }
}
