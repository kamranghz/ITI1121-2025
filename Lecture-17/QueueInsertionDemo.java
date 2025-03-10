// Queue implementation using an array (Insertion only)
public class QueueInsertionDemo {
    private char[] queue; // Array to store queue elements
    private int rear;     // Index of the last element in the queue
    private int capacity; // Maximum capacity of the queue

    // Constructor to initialize queue with a fixed size
    public QueueInsertionDemo(int size) {
        queue = new char[size]; // Create an empty queue array
        rear = -1;              // Initially, queue is empty
        capacity = size;
    }

    // Method to insert (enqueue) an element into the queue
    public void enqueue(char item) {
        if (rear == capacity - 1) { // Check if queue is full
            System.out.println("Queue is FULL! Cannot enqueue " + item);
            return;
        }

        rear++;          // Step 1: Move rear to the next empty position
        queue[rear] = item; // Step 2: Insert the new element at rear

        // Display queue state after insertion
        displayQueue(item);
    }

    // Method to display the current queue state after insertion
    private void displayQueue(char insertedItem) {
        System.out.println("\nAfter inserting '" + insertedItem + "':");
        System.out.print("Queue: ");
        for (int i = 0; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println("\nRear index is now at: " + rear);
    }

    // Main method to simulate insertion steps
    public static void main(String[] args) {
        QueueInsertionDemo queue = new QueueInsertionDemo(10); // Create queue of size 10

        // Simulating the insertion steps from the slide
        queue.enqueue('a'); // Insert 'a'
        queue.enqueue('b'); // Insert 'b'
        queue.enqueue('c'); // Insert 'c'
        queue.enqueue('d'); // Insert 'd'
        queue.enqueue('e'); // Insert 'e'
        queue.enqueue('f'); // Insert 'f' 
    }
}
