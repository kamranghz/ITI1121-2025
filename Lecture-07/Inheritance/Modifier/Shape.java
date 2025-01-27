// Shape.java
// Base class for all shapes
public class Shape {
    protected double x; // X coordinate, protected to allow subclass access
    protected double y; // Y coordinate, protected for the same reason

    // Default constructor for Shape
    public Shape() {
        this.x = 0;
        this.y = 0;
    }

    // Parameterized constructor for Shape
    public Shape(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Final method to prevent override, gets X coordinate
    public final double getX() {
        return x;
    }

    // Final method to prevent override, gets Y coordinate
    public final double getY() {
        return y;
    }

    // Final method to prevent override, moves the shape
    public final void moveTo(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Standard toString method
    public String toString() {
        return "Shape at (" + x + ", " + y + ")";
    }
}
