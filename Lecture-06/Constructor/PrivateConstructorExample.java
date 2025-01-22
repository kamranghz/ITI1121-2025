// Utility class with a private constructor
class MathUtils {
    // Private constructor prevents instantiation
    private MathUtils() {
        // This class is not meant to be instantiated
    }

    // Static method for addition
    public static int add(int a, int b) {
        return a + b;
    }

    // Static method for multiplication
    public static int multiply(int a, int b) {
        return a * b;
    }
}

public class PrivateConstructorExample {
    public static void main(String[] args) {
        // Calling static methods directly without creating an object
        System.out.println("Addition: " + MathUtils.add(5, 10)); // Output: 15
        System.out.println("Multiplication: " + MathUtils.multiply(3, 4)); // Output: 12
    }
}
