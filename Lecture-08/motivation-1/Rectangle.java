// Subclass representing a Rectangle
public class Rectangle extends Shape {
    private int width, height; // Additional properties for Rectangle

    // Constructor for Rectangle
    public Rectangle(int x, int width, int height) {
        super(x); // Call the parent constructor to set the x-coordinate
        this.width = width;
        this.height = height;
    }

    // Getter for width
    public int getWidth() {
        return width;
    }

    // Getter for height
    public int getHeight() {
        return height;
    }

    // Override to provide specific type description
    @Override
    public String getType() {
        return "Rectangle";
    }

    @Override
    public String toString() {
        return getType() + " with x=" + getX() + ", width=" + width + ", height=" + height;
    }
}
