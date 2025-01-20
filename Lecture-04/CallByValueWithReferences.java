// Class to represent an integer with a value field
class MyInteger {
    int value; // Holds the integer value

    // Constructor to initialize the value
    MyInteger(int v) {
        value = v;
    }
}

class CallByValueWithReferences {
    // Method to increment the value of a MyInteger object
    public static void increment(MyInteger a) {
        // Increment the value field of the MyInteger object
        a.value++;
    }

    // Main method to CallByValueWithReferences the behavior of references and method calls
    public static void main(String[] args) {
        // Create a MyInteger object with an initial value of 5
        MyInteger a = new MyInteger(5);

        // Print the value before calling the increment method
        System.out.println("Before increment: " + a.value); // Output: Before increment: 5

        // Call the increment method and pass the object
        increment(a);

        // Print the value after calling the increment method
        System.out.println("After increment: " + a.value); // Output: After increment: 6
    }
}
