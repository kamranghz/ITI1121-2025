// This class demonstrates how to compare values stored in two objects.
public class CompareTwoObjects {
    public static void main(String[] args) {
        MyInteger objA = new MyInteger(5); // Object 'objA' initialized with the value 5.
        MyInteger objB = new MyInteger(10); // Object 'objB' initialized with the value 10.

        // Comparing the 'value' fields of two objects.
        if (objA.value < objB.value) {
            System.out.println("objA.value < objB.value"); // Output: objA.value < objB.value
        } else if (objA.value == objB.value) {
            System.out.println("objA.value == objB.value");
        } else {
            System.out.println("objA.value > objB.value");
        }
    }
}
