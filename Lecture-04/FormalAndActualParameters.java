public class FormalAndActualParameters {

    // Function that uses formal parameters "a" and "b"
    public static int addNumbers(int a, int b) {
        // "a" and "b" are placeholders (formal parameters) that will receive values during the function call
        System.out.println("Inside addNumbers method:");
        System.out.println("Formal parameter a: " + a); // Print the value of the first formal parameter
        System.out.println("Formal parameter b: " + b); // Print the value of the second formal parameter

        // Return the sum of the two formal parameters
        return a + b;
    }

    public static void main(String[] args) {
        // Actual parameters are defined here with specific values
        int num1 = 10; // First actual parameter
        int num2 = 20; // Second actual parameter

        // Display the actual parameters before calling the function
        System.out.println("In main method:");
        System.out.println("Actual parameter num1: " + num1);
        System.out.println("Actual parameter num2: " + num2);

        // Call the function "addNumbers" and pass the actual parameters
        int result = addNumbers(num1, num2);

        // Display the result returned by the function
        System.out.println("\nResult of addition: " + result);
    }
}
