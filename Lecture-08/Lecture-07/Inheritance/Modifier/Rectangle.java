// Rectangle.java
// Subclass of Shape for rectangles
public class Rectangle extends Shape {
    private double width;
    private double height;

    // Constructor for Rectangle
    public Rectangle(double x, double y, double width, double height) {
        super(x, y); // Calls superclass constructor to set coordinates
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

    // Method to swap the dimensions of the rectangle
    public void flip() {
        double temp = width;
        width = height;
        height = temp;
    }

    // Overridden toString method for Rectangle
    @Override
    public String toString() {
        return "Rectangle at (" + x + ", " + y + ") with width " + width + " and height " + height;
    }
}
