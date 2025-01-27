// Subclass representing a Circle
public class Circle extends Shape {
    private int radius; // Additional property for Circle

    // Constructor for Circle
    public Circle(int x, int radius) {
        super(x); // Call the parent constructor to set the x-coordinate
        this.radius = radius;
    }

    // Getter for radius
    public int getRadius() {
        return radius;
    }

    // Override to provide specific type description
    @Override
    public String getType() {
        return "Circle";
    }

    @Override
    public String toString() {
        return getType() + " with x=" + getX() + ", radius=" + radius;
    }
}
