public class Testcounterinc {

    public static void main(String args[]) {

        // Creating an instance (object) of the Counter class
        Counter counter = new Counter();

        // Incrementing the counter's value twice using the increment method
        counter.increment(); // First increment
        counter.increment(); // Second increment

        // Printing the current value of the counter after two increments
        // Expected output: "Value of counter: 2"
        System.out.println("Value of counter: " + counter.getValue());
    }
}



