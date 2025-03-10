public class ExceptionHandlingDemo {

    // Method that intentionally throws an exception
    public static void riskyMethod() {
        System.out.println("Step 1: Entering riskyMethod.");
        
        // This line will cause an exception (division by zero)
        int result = 10 / 0; 

        // This statement will be skipped due to abrupt termination
        System.out.println("Step 2: This line will not be executed.");
    }

    public static void main(String[] args) {
        try {
            System.out.println("Step 3: Calling riskyMethod.");
            riskyMethod(); // Method call that leads to exception
            System.out.println("Step 4: This will not execute due to abrupt termination.");
        } catch (ArithmeticException e) {
            // Stack Unwinding stops here and execution resumes
            System.out.println("Step 5: Caught an exception: " + e);
        } finally {
            // Finally block executes regardless of exception
            System.out.println("Step 6: Finally block executed.");
        }
        
        System.out.println("Step 7: Program continues after exception handling.");
    }
}
