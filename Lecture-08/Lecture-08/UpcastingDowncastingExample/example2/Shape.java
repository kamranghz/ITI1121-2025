// The base class "Shape" that defines the structure for all shapes
public class Shape {
    private double x;
    private double y;

    // Default constructor initializes the shape's location to (0, 0)
    public Shape() {
        x = 0;
        y = 0;
    }

    // Constructor to initialize shape at specific coordinates
    public Shape(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Getter for x-coordinate
    public double getX() {
        return x;
    }

    // Getter for y-coordinate
    public double getY() {
        return y;
    }

    // Move the shape to a new location
    public void moveTo(double newX, double newY) {
        x = newX;
        y = newY;
        System.out.println("Shape moved to (" + x + ", " + y + ")");
    }

    // Display the shape's location
    @Override
    public String toString() {
        return "Shape located at (" + x + ", " + y + ")";
    }
}
