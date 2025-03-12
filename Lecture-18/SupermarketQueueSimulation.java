import java.util.LinkedList;
import java.util.Queue;

// Customer class representing a customer in the supermarket
class Customer {
    private String name;
    private int items;
    
    public Customer(String name, int items) {
        this.name = name;
        this.items = items;
    }
    
    public String getName() {
        return name;
    }
    
    public int getItems() {
        return items;
    }
}

// Supermarket Queue System
class Supermarket {
    private Queue<Customer> queue;
    
    public Supermarket() {
        this.queue = new LinkedList<>(); // Using LinkedList as a queue
    }
    
    // Customer enters the queue
    public void addCustomer(String name, int items) {
        Customer newCustomer = new Customer(name, items);
        queue.add(newCustomer); // Enqueue operation
        System.out.println(name + " joined the queue with " + items + " items.");
    }
    
    // Serving customers
    public void serveCustomer() {
        if (queue.isEmpty()) {
            System.out.println("No customers in the queue.");
            return;
        }
        
        Customer servedCustomer = queue.poll(); // Dequeue operation
        System.out.println("Serving " + servedCustomer.getName() + " with " + servedCustomer.getItems() + " items.");
    }
    
    // Display the queue
    public void displayQueue() {
        if (queue.isEmpty()) {
            System.out.println("The queue is empty.");
        } else {
            System.out.println("Customers in queue:");
            for (Customer c : queue) {
                System.out.println(c.getName() + " - " + c.getItems() + " items");
            }
        }
    }
}

// Main class to run the simulation
public class SupermarketQueueSimulation {
    public static void main(String[] args) {
        Supermarket supermarket = new Supermarket();
        
        // Adding customers to the queue
        supermarket.addCustomer("Alice", 5);
        supermarket.addCustomer("Bob", 3);
        supermarket.addCustomer("Charlie", 7);
        
        // Display the queue
        supermarket.displayQueue();
        
        // Serving customers
        supermarket.serveCustomer();
        supermarket.serveCustomer();
        supermarket.serveCustomer();
        supermarket.serveCustomer(); // No customers left
    }
}
