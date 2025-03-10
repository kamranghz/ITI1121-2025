// Queue implementation using an array (Dequeue operation)
public class QueueRemovalDemo {
    private Character[] queue; // Array to store queue elements
    private int rear;          // Index of the last element in the queue
    private int capacity;      // Maximum queue size

    // Constructor to initialize the queue
    public QueueRemovalDemo(int size) {
        queue = new Character[size]; // Array of Characters
        rear = -1; // Initially, queue is empty
        capacity = size;
    }

    // Method to insert (enqueue) an element
    public void enqueue(char item) {
        if (rear == capacity - 1) {
            System.out.println("Queue is FULL! Cannot enqueue " + item);
            return;
        }
        rear++;
        queue[rear] = item;
        displayQueue("After inserting '" + item + "'");
    }

    // Method to remove (dequeue) an element from the queue
    public Character dequeue() {
        if (rear == -1) {
            System.out.println("Queue is EMPTY! Cannot dequeue.");
            return null;
        }

        // Step 1: Save the front element
        Character removedItem = queue[0];

        // Step 2: Shift elements forward
        for (int i = 1; i <= rear; i++) {
            queue[i - 1] = queue[i];
        }

        // Step 3: Set the last occupied cell to null
        queue[rear] = null;

        // Step 4: Decrement rear
        rear--;

        // Step 5: Display queue state after removal
        displayQueue("After removing '" + removedItem + "'");

        return removedItem;
    }

    // Method to display the queue state
    private void displayQueue(String action) {
        System.out.println("\n" + action);
        System.out.print("Queue: ");
        for (int i = 0; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }
        if (rear == -1) {
            System.out.print("(empty)");
        }
        System.out.println("\nRear index is now at: " + rear);
    }

    // Main method to simulate insertion and removal
    public static void main(String[] args) {
        QueueRemovalDemo queue = new QueueRemovalDemo(10);

        // Insert elements
        queue.enqueue('a');
        queue.enqueue('b');
        queue.enqueue('c');
        queue.enqueue('d');
        queue.enqueue('e');

        // Remove elements 
        queue.dequeue(); // Removes 'a'
        queue.dequeue(); // Removes 'b'
    }
}
