// This class demonstrates how to compare a primitive value with the value inside an object.
public class ComparePrimitiveWithObject {
    public static void main(String[] args) {
        int a = 5; // Primitive integer 'a'.
        MyInteger objB = new MyInteger(10); // Object 'objB' initialized with the value 10.

        // Comparing the primitive value with the value inside the object.
        if (a < objB.value) {
            System.out.println("a < objB.value"); // Output: a < objB.value
        } else if (a == objB.value) {
            System.out.println("a == objB.value");
        } else {
            System.out.println("a > objB.value");
        }
    }
}
