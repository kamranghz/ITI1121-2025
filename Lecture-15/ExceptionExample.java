// Java program demonstrating Checked and Unchecked Exceptions

public class ExceptionExample {
    public static void main(String[] args) {
        System.out.println("Program Started...\n");

        // Example of Checked Exception
        try {
            System.out.println("Trying to open a file...");
            readFile(); // This method will throw a Checked Exception
        } catch (Exception e) {
            System.out.println("Checked Exception Caught: " + e.getMessage());
        }

        System.out.println("\n-------------------------------\n");

        // Example of Unchecked Exception
        try {
            System.out.println("Trying to divide by zero...");
            divideByZero(); // This method will throw an Unchecked Exception
        } catch (ArithmeticException e) {
            System.out.println("Unchecked Exception Caught: " + e.getMessage());
        }

        System.out.println("\nProgram Ended Successfully!");
    }

    // This method demonstrates a CHECKED EXCEPTION (IOException)
    public static void readFile() throws Exception { 
        // Simulating a file reading error (Checked Exception)
        throw new Exception("File not found!");
    }

    // This method demonstrates an UNCHECKED EXCEPTION (ArithmeticException)
    public static void divideByZero() {
        int result = 10 / 0; // This will cause an ArithmeticException
        System.out.println("Result: " + result);
    }
}
