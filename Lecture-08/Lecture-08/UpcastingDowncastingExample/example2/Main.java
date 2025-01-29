// Main class to demonstrate polymorphic behavior, upcasting, and downcasting
public class Main {
    public static void main(String[] args) {
        // Upcasting: Circle and Rectangle objects are referenced as Shape
        Shape s1 = new Circle(0, 0, 1);  // Upcasting Circle to Shape
        Shape s2 = new Rectangle(10, 100, 10, 100);  // Upcasting Rectangle to Shape

        // Accessing properties/methods defined in Shape
        System.out.println("Shape s1: " + s1);
        System.out.println("Shape s2: " + s2);

        // Downcasting: Explicit casting back to the specific subclass
        Circle c = (Circle) s1;  // Downcasting s1 to Circle
        System.out.println("Circle radius: " + c.getRadius());

        // Attempting to access subclass-specific methods without downcasting will result in a compile-time error
        // For example: s1.getRadius(); // Error: Shape class does not have getRadius()

        // Polymorphism in action: methods work based on the actual type of the object
        s1.moveTo(5, 5);
        s2.moveTo(20, 120);

        // Display updated details
        System.out.println("Updated Shape s1: " + s1);
        System.out.println("Updated Shape s2: " + s2);
    }
}
