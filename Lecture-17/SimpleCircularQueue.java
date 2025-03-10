import java.util.ArrayList;
import java.util.List;

/**
 * SimpleCircularQueue demonstrates a circular queue using an ArrayList.
 * This class provides a clear example of managing enqueue and dequeue operations
 * in a circular fashion to help students understand the concept effectively.
 */
public class SimpleCircularQueue<E> {
    private static final int MAX_QUEUE_SIZE = 5;  // Reduced size for simplicity
    private List<E> q;                            // List to store queue elements
    private int front;                            // Index of the front element
    private int rear;                             // Index of the rear element
    private int size;                             // Current number of elements in the queue

    /**
     * Constructor initializes the queue.
     */
    public SimpleCircularQueue() {
        this.q = new ArrayList<>(MAX_QUEUE_SIZE);
        for (int i = 0; i < MAX_QUEUE_SIZE; i++) {
            q.add(null);  // Pre-fill with null to manage fixed capacity
        }
        this.front = 0;
        this.rear = -1;  // Rear at -1 signifies an empty queue
        this.size = 0;
    }

    /**
     * Enqueues an element at the rear of the queue.
     * Demonstrates wrapping around when reaching the array end.
     * @param element the element to be added
     */
    public void enqueue(E element) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue element: " + element);
            return;
        }
        rear = (rear + 1) % MAX_QUEUE_SIZE;
        q.set(rear, element);
        size++;
        System.out.println("Enqueued: " + element);
        displayQueue();
    }

    /**
     * Dequeues and returns the element at the front of the queue.
     * Demonstrates circular index increment.
     * @return the element at the front of the queue, or null if the queue is empty
     */
    public E dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Nothing to dequeue.");
            return null;
        }
        E element = q.get(front);
        q.set(front, null);
        front = (front + 1) % MAX_QUEUE_SIZE;
        size--;
        System.out.println("Dequeued: " + element);
        displayQueue();
        return element;
    }

    /**
     * Checks if the queue is empty.
     * @return true if the queue is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks if the queue is full.
     * @return true if the queue is full, false otherwise
     */
    public boolean isFull() {
        return size == MAX_QUEUE_SIZE;
    }

    /**
     * Displays the current state of the queue for educational purposes.
     */
    private void displayQueue() {
        System.out.print("Queue state: ");
        for (E item : q) {
            System.out.print(item + " ");
        }
        System.out.println(" | Front index: " + front + ", Rear index: " + rear);
    }

    /**
     * Main method to demonstrate queue operations in an easily understandable manner.
     */
    public static void main(String[] args) {
        SimpleCircularQueue<String> queue = new SimpleCircularQueue<>();
        queue.enqueue("Apple");
        queue.enqueue("Banana");
        queue.enqueue("Cherry");
        queue.enqueue("Date");
        queue.enqueue("Elderberry");  // Fills the queue

        queue.dequeue();  // Start dequeuing, should wrap around
        queue.dequeue();

        queue.enqueue("Fig");  // Tests wrap around after dequeues
        queue.enqueue("Grape");
    }
}
