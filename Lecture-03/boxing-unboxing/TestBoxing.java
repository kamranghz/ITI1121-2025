public class TestBoxing {
    public static void main(String[] args) {
        // Variables to store the start and stop times for performance measurement.
        long start, stop;

        // ------------------- Part 1: Testing with Primitive Type `long` -------------------
        System.out.println("Testing performance with primitive type 'long'...");

        long s1 = 0; // Initialize a primitive variable of type `long` to 0.

        start = System.currentTimeMillis(); // Record the start time of the loop.
        for (int j = 0; j < 10_000_000; j++) { // Loop runs 10 million times.
            s1 = s1 + 1; // Directly increment the primitive variable by 1.
        }
        stop = System.currentTimeMillis(); // Record the end time of the loop.

        // Print the elapsed time for operations with the primitive type.
        System.out.println("Elapsed time for primitive type 'long': " + (stop - start) + " ms");
        System.out.println("----------------------");

        // Explanation:
        // - `long` is a primitive type, so it directly manipulates values in memory.
        // - There are no additional overheads such as boxing or unboxing.
        // - This makes operations with `long` significantly faster.

        // ------------------- Part 2: Testing with Wrapper Class `Long` -------------------
        System.out.println("Testing performance with wrapper class 'Long'...");

        Long s2 = 0L; // Initialize a variable of type `Long` (wrapper class) to 0.

        start = System.currentTimeMillis(); // Record the start time of the loop.
        for (int j = 0; j < 10_000_000; j++) { // Loop runs 10 million times.
            s2 = s2 + 1L; // Increment the wrapper variable by 1.
            // Note: This involves:
            // 1. Unboxing: Extracting the primitive value from the `Long` object.
            // 2. Performing the addition.
            // 3. Boxing: Wrapping the result back into a `Long` object.
        }
        stop = System.currentTimeMillis(); // Record the end time of the loop.

        // Print the elapsed time for operations with the wrapper class.
        System.out.println("Elapsed time for wrapper class 'Long': " + (stop - start) + " ms");
        System.out.println("----------------------");

        // Explanation:
        // - `Long` is a wrapper class for the primitive type `long`.
        // - Operations with `Long` involve extra steps:
        //   - **Boxing**: Converting a primitive `long` into a `Long` object.
        //   - **Unboxing**: Extracting the `long` value from a `Long` object.
        // - These additional steps introduce overhead, making `Long` slower compared to `long`.

        // ------------------- Conclusion -------------------
        System.out.println("Conclusion:");
        System.out.println("Operations with primitive types are significantly faster than wrapper classes.");
        System.out.println("Use wrapper classes only when necessary, such as when working with collections or methods requiring objects.");
    }
}
