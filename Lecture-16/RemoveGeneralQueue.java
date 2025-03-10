public class RemoveGeneralQueue {
    private Node front; // Pointer to the front of the queue
    private Node rear;  // Pointer to the rear of the queue

    // Inner class to represent each element in the queue
    private static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    // Constructor to initialize an empty queue
    public RemoveGeneralQueue() {
        this.front = null;
        this.rear = null;
    }

    // Method to remove an element from the front of the queue
    public String dequeue() {
        if (front == null) {
            System.out.println("Queue is empty, no elements to remove.");
            return null;
        }

        // Save the data to return
        String removedData = front.data;

        // Move the front pointer to the next node
        front = front.next;

        // If the queue is now empty, adjust the rear pointer
        if (front == null) {
            rear = null;
        }

        System.out.println("Removed element: " + removedData);
        return removedData;
    }

    // Method to display the elements of the queue
    public void displayQueue() {
        if (front == null) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.print("Queue elements: ");
        Node current = front;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        RemoveGeneralQueue queue = new RemoveGeneralQueue();
        // Prepopulating the queue with some elements for demonstration
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        queue.enqueue("D");

        // Displaying initial queue state
        queue.displayQueue();

        // Removing elements
        queue.dequeue(); // Should remove 'A'
        queue.displayQueue(); // Should show B, C, D
        queue.dequeue(); // Should remove 'B'
        queue.displayQueue(); // Should show C, D
    }

    // For completeness, adding an enqueue method to add elements to the queue
    private void enqueue(String data) {
        Node newNode = new Node(data);
        if (rear == null) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }
}
