public class SpecialCaseQueue {
    // Node inner class for queue
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node front;
    Node rear;

    // Constructor to initialize the queue
    public SpecialCaseQueue() {
        this.front = null;
        this.rear = null;
    }

    // Method to remove an element from the queue in special case
    public void dequeue() {
        // Check if the queue is empty
        if (front == null) {
            System.out.println("Queue is empty, nothing to remove.");
            return;
        }

        // Special case: Only one element in the queue
        if (front == rear) {
            System.out.println("Removing the only element in the queue: " + front.data);
            // Set both front and rear to null as the queue will be empty after this operation
            front = null;
            rear = null;
        } else {
            // Normally we would handle more cases here, but this is focused on the special case
            System.out.println("There are more than one element, special case not applicable.");
        }
    }

    // Helper method to display the queue
    public void displayQueue() {
        if (front == null) {
            System.out.println("Queue is empty.");
        } else {
            Node temp = front;
            System.out.print("Queue contents: ");
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        SpecialCaseQueue queue = new SpecialCaseQueue();

        // Add elements to the queue
        queue.front = new Node(10); // Only one element in the queue
        queue.rear = queue.front;  // Front and rear are the same

        // Display initial queue state
        queue.displayQueue();

        // Perform the dequeue operation which is a special case
        queue.dequeue();

        // Display queue state post-dequeue operation
        queue.displayQueue();
    }
}
