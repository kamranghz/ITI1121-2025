// Queue interface with essential methods
interface Queue<T> {
    boolean isEmpty();  // Checks if the queue is empty
    void enqueue(T item); // Adds an item to the queue
    T dequeue();  // Removes and returns the front item
}

// Linked-list-based implementation of a Queue
class LinkedQueue<T> implements Queue<T> {

    // Node class to represent elements in the queue
    private static class Node<E> {
        private E value;  // Holds the value of the node
        private Node<E> next; // Points to the next node

        // Constructor to initialize a node
        private Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node<T> front; // Points to the front of the queue
    private Node<T> rear;  // Points to the rear of the queue

    // Constructor: Initializes an empty queue
    public LinkedQueue() {
        front = rear = null;
    }

    // Checks if the queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Adds an item to the queue (enqueue)
    public void enqueue(T item) {
        Node<T> newNode = new Node<>(item, null); // Create a new node
        if (rear != null) {
            rear.next = newNode; // Link the new node after the rear
        }
        rear = newNode; // Update rear pointer
        if (front == null) { // If queue was empty, update front
            front = rear;
        }
    }

    // Removes and returns the front item from the queue (dequeue)
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        }
        T value = front.value; // Get value from the front node
        front = front.next; // Move front to the next node
        if (front == null) { // If queue becomes empty, update rear
            rear = null;
        }
        return value;
    }
}

// Testing the queue implementation
public class QueueExample {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedQueue<>();

        // Enqueue elements
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        // Dequeue and print elements
        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
    }
}
