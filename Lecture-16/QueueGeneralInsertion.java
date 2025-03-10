// Define a generic Queue interface for enqueue operation only
interface Queue<T> {
    boolean isEmpty();  // Check if the queue is empty
    void enqueue(T item); // Add an item to the queue
}

// Linked-list-based implementation of a Queue (Only for adding elements)
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

    // Check if the queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Step-by-step enqueue operation (from 7 slides)
    public void enqueue(T item) {
        System.out.println("\nAdding " + item + " to the queue...");

        // Step 1: Create a new node for the new element (Slide 2)
        Node<T> newElem = new Node<>(item, null);
        System.out.println("Step 1: Created new node with value " + item);

        // Step 2: If queue is empty, set front and rear to newElem (Special Case)
        if (isEmpty()) {
            front = rear = newElem;
            System.out.println("Queue was empty. Front and rear now point to " + item);
            return;
        }

        // Step 3: Link the current rear's next to the new element (Slide 4)
        rear.next = newElem;
        System.out.println("Step 2: Linked the current rear node to newElem.");

        // Step 4: Move the rear pointer to the new node (Slide 5)
        rear = newElem;
        System.out.println("Step 3: Updated rear pointer to point to " + item);

        // Step 5: The queue is now updated (Slide 7)
        System.out.println("Queue updated! Rear is now " + item);
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

// Testing the enqueue operation only (No removal)
public class QueueGeneralInsertion {
    public static void main(String[] args) {
        LinkedQueue<String> queue = new LinkedQueue<>();

        // Enqueue elements based on 7 slides
        queue.enqueue("A");
        queue.displayQueue();
        queue.enqueue("B");
        queue.displayQueue();
        queue.enqueue("C");
        queue.displayQueue();
        queue.enqueue("D");
        queue.displayQueue();
    }
}
