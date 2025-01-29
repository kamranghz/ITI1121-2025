// Abstract class Displayable ensures that all subclasses implement the display() method
abstract class Displayable {
    public abstract void display();
}

// The Shape class extends Displayable and serves as a base class for different shapes
abstract class Shape extends Displayable {
    protected double x = 0;
    protected double y = 0;

    // Constructor to set position
    public Shape(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Abstract method for area calculation
    public abstract double area();

    // Move shape to a new position
    public void moveTo(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Shape at (" + x + ", " + y + ")";
    }
}

// Rectangle class extends Shape and provides its own implementation of display() and area()
class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(double x, double y, double width, double height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public void display() {
        System.out.println("Rectangle at (" + x + ", " + y + ") with width " + width + " and height " + height);
    }
}

// Circle class extends Shape and provides its own implementation of display() and area()
class Circle extends Shape {
    private double radius;

    public Circle(double x, double y, double radius) {
        super(x, y);
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public void display() {
        System.out.println("Circle at (" + x + ", " + y + ") with radius " + radius);
    }
}

// Button class extends Displayable and provides its own display method
class Button extends Displayable {
    private String label;

    public Button(String label) {
        this.label = label;
    }

    @Override
    public void display() {
        System.out.println("Button: " + label);
    }
}

// Graphics class that contains a polymorphic method to display all Displayable objects
class Graphics {
    public static void displayAll(Displayable[] myArray) {
        for (int i = 0; i < myArray.length; i++) {
            myArray[i].display();
        }
    }
}

// Main class to test the implementation
public class DisplayableObjectsDemo {
    public static void main(String[] args) {
        // Creating an array of Displayable objects
        Displayable[] items = {
            new Rectangle(10, 20, 5, 8),
            new Circle(15, 25, 4),
            new Button("Submit"),
            new Button("Cancel")
        };

        // Calling the displayAll() method to show all objects
        System.out.println("=== Displaying All Objects ===");
        Graphics.displayAll(items);
    }
}
