// Circle.java
// Subclass of Shape for circles
public class Circle extends Shape {
    private double radius; // Specific attribute for Circle

    // Constructor for Circle
    public Circle(double x, double y, double radius) {
        super(x, y); // Calls superclass constructor to set coordinates
        this.radius = radius;
    }

    // Getter for radius
    public double getRadius() {
        return radius;
    }

    // Overridden toString method for Circle
    @Override
    public String toString() {
        return "Circle at (" + x + ", " + y + ") with radius " + radius;
    }
}
