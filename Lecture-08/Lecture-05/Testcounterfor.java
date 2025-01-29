public class Testcounterfor {
    public static void main(String args[]) {
        Counter counter = new Counter(); // Creates an object of the Counter class.
        counter.increment(); // Increments the counter.
        counter.increment(); // Increments again.

        System.out.println("Value of counter: " + counter.getValue()); // Accesses the counter's value.
        
        for (int i = 0; i < 5; i++) { // Uses a loop to increment the counter multiple times.
            counter.increment();
        }

        System.out.println("Value of counter: " + counter.getValue()); // Prints the final counter value.
    }
}
