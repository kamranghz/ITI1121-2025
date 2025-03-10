// Define a basic queue interface for enqueue operation only
interface Queue<T> {
    boolean isEmpty();  // Check if the queue is empty
    void enqueue(T item); // Add an element to the queue
}

// Linked-list-based queue implementation (Only for adding an element in the special case)
class SpecialCaseQueue<T> implements Queue<T> {

    // Node class representing an element in the queue
    private static class Node<E> {
        private E value;  // Stores the value of the node
        private Node<E> next; // Pointer to the next node

        // Constructor to initialize the node with a value
        private Node(E value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node<T> front; // Pointer to the front of the queue
    private Node<T> rear;  // Pointer to the rear of the queue

    // Constructor: Initializes an empty queue
    public SpecialCaseQueue() {
        front = rear = null;  // Both front and rear are initially null
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return front == null; // If front is null, the queue is empty
    }

    // Enqueue operation (Handling the special case of an empty queue)
    public void enqueue(T item) {
        System.out.println("\nAdding " + item + " to the queue...");

        // Step 1: Create a new node for the new element (Slide 2)
        Node<T> newElem = new Node<>(item);
        System.out.println("Step 1: Created a new node with value '" + item + "'");

        // Step 2: If queue is empty, set front and rear to newElem (Special Case)
        if (isEmpty()) {
            front = rear = newElem;  // Both front and rear point to the new node
            System.out.println("Step 2: Queue was empty. Front and rear now point to '" + item + "'");
            return;  // Exit function since the special case is handled
        }

        // Normally, enqueue would link rear.next to newElem, but this is not needed in the special case
        System.out.println("Queue is no longer empty and can now accept more elements.");
    }

    // Display the queue elements (For better visualization)
    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        System.out.print("Queue: ");
        Node<T> temp = front;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

// Main class to test special case enqueue
public class QueueSpecialCaseInsertion {
    public static void main(String[] args) {
        SpecialCaseQueue<String> queue = new SpecialCaseQueue<>();

        // Enqueue the first element (special case)
        queue.enqueue("A");
        queue.displayQueue();
    }
}
