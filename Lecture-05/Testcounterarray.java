public class Testcounterarray {

    public static void main(String args[]) {

        // Create an array to hold 3 Counter objects
        Counter[] myArray = new Counter[3];

        // Initialize each element of the array with a new Counter object
        myArray[0] = new Counter();
        myArray[1] = new Counter(); // if comment this bring java.lang.NullPointerException error in Run time
        myArray[2] = new Counter();

        // Increment the value of the counter at index 0 once
        myArray[0].increment();

        // Increment the value of the counter at index 1 twice
        myArray[1].increment();
        myArray[1].increment();

        // Increment the value of the counter at index 2 three times
        myArray[2].increment();
        myArray[2].increment();
        myArray[2].increment();

        // Print the values of each counter in the array
        System.out.println("Value of element 0: " + myArray[0].getValue());
        System.out.println("Value of element 1: " + myArray[1].getValue());
        System.out.println("Value of element 2: " + myArray[2].getValue());
    }
}