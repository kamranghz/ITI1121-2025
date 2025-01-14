// This class demonstrates initializing and using objects in Java.
public class ObjectInitialization {
    public static void main(String[] args) {
        MyInteger objA = new MyInteger(5); // Object 'objA' initialized with the value 5.
        MyInteger objB = new MyInteger(10); // Object 'objB' initialized with the value 10.

        // Accessing the 'value' field of objects.
        System.out.println("objA.value = " + objA.value); // Output: objA.value = 5
        System.out.println("objB.value = " + objB.value); // Output: objB.value = 10
    }
}
