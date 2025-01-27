// TestShapes.java
// Test class to demonstrate functionality
public class TestShapes {
    public static void main(String[] args) {
        Shape shape1 = new Shape(3, 5);
        Circle circle1 = new Circle(5, 6, 7);
        Rectangle rectangle1 = new Rectangle(10, 20, 30, 40);

        System.out.println(shape1); // Utilizes Shape's toString
        System.out.println(circle1); // Utilizes Circle's overridden toString
        System.out.println(rectangle1); // Utilizes Rectangle's overridden toString

        rectangle1.flip(); // Demonstrates behavior change
        System.out.println(rectangle1); // Output after flip
    }
}
