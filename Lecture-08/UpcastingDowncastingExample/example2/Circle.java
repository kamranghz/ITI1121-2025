// Circle is a subclass of Shape that adds a radius property
public class Circle extends Shape {
    private double radius;

    // Default constructor initializes the radius to 0
    public Circle() {
        super(); // Calls the default constructor of Shape
        radius = 0;
    }

    // Constructor initializes the circle's position and radius
    public Circle(double x, double y, double radius) {
        super(x, y); // Calls the Shape constructor to set the position
        this.radius = radius;
    }

    // Getter for the radius
    public double getRadius() {
        return radius;
    }

    // Override toString to include radius in the description
    @Override
    public String toString() {
        return "Circle located at (" + getX() + ", " + getY() + ") with radius " + radius;
    }
}
