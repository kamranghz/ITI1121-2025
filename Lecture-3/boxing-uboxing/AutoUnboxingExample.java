public class AutoUnboxingExample {
    public static void main(String[] args) {
        // Auto-unboxing: Automatically converts a wrapper class object into its corresponding primitive value.
        Integer i = 100; 

        // During auto-unboxing, the primitive value `100` is extracted from the Integer object and used in the arithmetic operation.
        int autoUnboxedValue = i + 50; // Unboxing occurs here automatically.

        System.out.println("Auto-unboxing Example:");
        System.out.println(" Value is: " + i); // Displays the wrapped value (100).
        System.out.println("After auto-unboxing and adding 50: " + autoUnboxedValue); // Displays the result (150).
    }
}

