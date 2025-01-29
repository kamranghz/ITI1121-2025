// Abstract class Shape that serves as a blueprint for different geometric shapes
abstract class Shape {
    // Abstract method area(), which must be implemented by subclasses
    public abstract double area();
}

// Triangle class that extends Shape and implements the area() method
class Triangle extends Shape {
    private double base;
    private double height;

    // Constructor to initialize base and height
    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    // Implementing the area() method
    @Override
    public double area() {
        return 0.5 * base * height;
    }
}

// Main class to test the functionality
public class ShapeTest {
    public static void main(String[] args) {
        // Reference variable of type Shape assigned to an instance of Triangle
        Shape shape = new Triangle(5, 10);
        System.out.println("Area: " + shape.area()); // Calls Triangle's area() method
    }
}
