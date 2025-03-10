// Custom exception class extending Exception (Checked Exception)
class MyException extends Exception {
    public MyException() {
        super("Custom exception occurred");
    }

    public MyException(String message) {
        super(message);
    }
}

// Remove `public` from ExceptionDemo class
class ExceptionDemo {
    public static void throwCheckedException() throws MyException {
        throw new MyException("This is a checked exception");
    }

    public static void throwUncheckedException() {
        throw new ArithmeticException("This is an unchecked exception");
    }

    public static void main(String[] args) {
        try {
            throwCheckedException();
        } catch (MyException e) {
            System.out.println("Caught a checked exception: " + e.getMessage());
        }

        try {
            throwUncheckedException();
        } catch (ArithmeticException e) {
            System.out.println("Caught an unchecked exception: " + e.getMessage());
        }

        System.out.println("Program continues execution after exception handling.");
    }
}
