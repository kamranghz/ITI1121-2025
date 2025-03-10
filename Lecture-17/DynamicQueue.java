public class DynamicQueue {
    private String[] queue;
    private int front;
    private int rear;
    private int capacity;

    // Constructor to initialize the queue with a given capacity
    public DynamicQueue(int size) {
        capacity = size;
        queue = new String[capacity];
        front = 0;  // Start with front at the beginning
        rear = -1;  // Start with rear before the first element
    }

    // Method to insert an element into the queue
    public void enqueue(String element) {
        // Check if the queue needs to be repositioned due to lack of space at the end
        if (rear == capacity - 1) {
            if (front > 0) {
                // Shift all elements to the front to utilize empty space
                shiftElementsToFront();
            } else {
                System.out.println("Queue is full. Cannot enqueue more elements.");
                return;
            }
        }
        // Add element at the next position in the queue
        queue[++rear] = element;
        System.out.println("Enqueued: " + element);
        displayQueue();
    }

    // Shift all elements to the front to utilize available space
    private void shiftElementsToFront() {
        int index = 0;
        for (int i = front; i <= rear; i++) {
            queue[index++] = queue[i];
            queue[i] = null; // Clear old position
        }
        front = 0;
        rear = index - 1;
        System.out.println("Shifted elements to the front to utilize space efficiently.");
    }

    // Method to remove an element from the queue
    public String dequeue() {
        if (front > rear) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return null;
        }
        String item = queue[front];
        queue[front++] = null; // Clear the front element and move the front pointer
        System.out.println("Dequeued: " + item);
        displayQueue();
        return item;
    }

    // Display the current state of the queue
    private void displayQueue() {
        System.out.print("Queue: ");
        for (int i = 0; i < capacity; i++) {
            if (queue[i] != null) {
                System.out.print(queue[i] + " ");
            } else {
                System.out.print("_ ");
            }
        }
        System.out.println("\nFront index: " + front + ", Rear index: " + rear);
    }

    public static void main(String[] args) {
        DynamicQueue queue = new DynamicQueue(10);
        for (char c = 'a'; c <= 'e'; c++) {
            queue.enqueue(String.valueOf(c));
        }

        // Demonstrate dequeue operations
        queue.dequeue();
        queue.dequeue();

        // Continue enqueue operations which may trigger shifting
        for (char c = 'f'; c <= 'j'; c++) {
            queue.enqueue(String.valueOf(c));
        }

        // Attempt to enqueue more elements to show shifting
        queue.enqueue("k");
        queue.enqueue("l");
    }
}
