// This is a class definition for a Counter, demonstrating key OOP concepts like encapsulation and state management.
public class Counter {

    // This private variable stores the current state of the counter.
    // Encapsulation ensures that the state is not directly accessible from outside the class.
    private int value = 0; // state

    // This method returns the current value of the counter.
    // It demonstrates the concept of a getter method, providing controlled access to the private state.
    public int getValue() {
        return value;
    }

    // This method increments the counter value by 1.
    // It encapsulates the logic for modifying the state, ensuring the counter behaves as intended.
    public void increment() {
        this.value++; // Using 'this' keyword to refer to the instance variable
    }

    // This method resets the counter value to 0.
    // It provides a way to reinitialize the state, useful for reuse.
    public void reset() {
        value = 0;
    }
}
