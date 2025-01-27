// Rectangle is another subclass of Shape with additional width and height properties
public class Rectangle extends Shape {
    private double width;
    private double height;

    // Constructor initializes the rectangle's position, width, and height
    public Rectangle(double x, double y, double width, double height) {
        super(x, y); // Calls the Shape constructor to set the position
        this.width = width;
        this.height = height;
    }

    // Getter for width
    public double getWidth() {
        return width;
    }

    // Getter for height
    public double getHeight() {
        return height;
    }

    // Override toString to include width and height in the description
    @Override
    public String toString() {
        return "Rectangle located at (" + getX() + ", " + getY() + ") with width " + width + " and height " + height;
    }
}
