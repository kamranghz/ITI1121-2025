// Parent class for all shapes
public class Shape {
    private int x; // X-coordinate common to all shapes

    // Constructor to initialize the x-coordinate
    public Shape(int x) {
        this.x = x;
    }

    // Getter for x-coordinate
    public int getX() {
        return x;
    }

    // Method to determine if this shape is to the left of another shape
    public boolean isLeftOf(Shape s) {
        return this.getX() < s.getX();
    }

    // Default description of a shape
    public String getType() {
        return "Generic Shape";
    }
}
