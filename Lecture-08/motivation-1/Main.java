// Main class to demonstrate polymorphism and the isLeftOf method
public class Main {
    public static void main(String[] args) {
        // Create shapes
        Circle circle1 = new Circle(10, 5); // Circle at x=10 with radius=5
        Circle circle2 = new Circle(20, 8); // Circle at x=20 with radius=8
        Rectangle rect1 = new Rectangle(5, 10, 15); // Rectangle at x=5
        Rectangle rect2 = new Rectangle(15, 20, 25); // Rectangle at x=15

        // Compare shapes using isLeftOf
        System.out.println(circle1 + " is left of " + circle2 + ": " + circle1.isLeftOf(circle2));
        System.out.println(rect1 + " is left of " + rect2 + ": " + rect1.isLeftOf(rect2));
        System.out.println(circle1 + " is left of " + rect1 + ": " + circle1.isLeftOf(rect1));
        System.out.println(rect2 + " is left of " + circle2 + ": " + rect2.isLeftOf(circle2));

        // Demonstrate type flexibility
        Shape shape1 = circle1; // Circle treated as a Shape
        Shape shape2 = rect1;   // Rectangle treated as a Shape
        System.out.println(shape1 + " is left of " + shape2 + ": " + shape1.isLeftOf(shape2));
    }
}
