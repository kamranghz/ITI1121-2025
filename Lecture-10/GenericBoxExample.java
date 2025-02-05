// Generic Box class that can hold any type of item
class Box<T> { 
    private T item; // The item contained in the box

    // Constructor to initialize the box with an item
    public Box(T item) {
        this.item = item;
    }

    // Method to get the item from the box
    public T getItem() {
        return item;
    }

    // Method to set the item in the box
    public void setItem(T item) {
        this.item = item;
    }
}

// Main class to demonstrate the use of the Box class with generics
public class GenericBoxExample {
    public static void main(String[] args) {
        // Create a Box for holding an Integer
        Box<Integer> integerBox = new Box<>(123);
        System.out.println("Integer Box contains: " + integerBox.getItem());

        // Create a Box for holding a String
        Box<String> stringBox = new Box<>("Hello Generics");
        System.out.println("String Box contains: " + stringBox.getItem());
    }
}
