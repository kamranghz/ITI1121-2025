// Demonstrates the use of Interfaces, Abstract Classes, and Polymorphism in Java

// 1. Defining an Interface Comparable
// An interface defines a contract that classes must follow.
interface Comparable {
    int compareTo(Object o); // Abstract method for comparison
}

// 2. Defining an Interface Displayable
// This interface ensures that any class implementing it has a display() method.
interface Displayable {
    void display(); // Abstract method to enforce display behavior
}

// 3. Abstract Class Shape implementing Comparable & Displayable
// This serves as a base class for all shapes.
abstract class Shape implements Comparable, Displayable {
    protected double x, y; // Coordinates of the shape

    // Constructor to initialize shape position
    public Shape(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Abstract method for calculating area (to be implemented by subclasses)
    public abstract double area();

    // Move the shape to a new position
    public void moveTo(double newX, double newY) {
        this.x = newX;
        this.y = newY;
    }

    // Implementing compareTo method for sorting shapes based on area
    @Override
    public int compareTo(Object o) {
        if (o instanceof Shape) {
            Shape other = (Shape) o;
            return Double.compare(this.area(), other.area());
        }
        return 0; // Default case
    }

    @Override
    public String toString() {
        return "Shape at (" + x + ", " + y + ")";
    }
}

// 4. Concrete class Rectangle extends Shape
class Rectangle extends Shape {
    private double width, height;

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

// 5. Concrete class Circle extends Shape
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

// 6. Button class implements Displayable (not a Shape, but still Displayable)
class Button implements Displayable {
    private String label;

    public Button(String label) {
        this.label = label;
    }

    @Override
    public void display() {
        System.out.println("Button: " + label);
    }
}

// 7. Utility Class for Displaying All Displayable Objects
class Graphics {
    public static void displayAll(Displayable[] items) {
        System.out.println("\n=== Displaying All Objects ===");
        for (Displayable item : items) {
            item.display(); // Calls display() based on the actual object's implementation
        }
    }
}

// 8. Demonstrating Multiple Interface Implementation
class MultipleInterfacesDemo implements Comparable, Displayable {
    private int value;

    public MultipleInterfacesDemo(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof MultipleInterfacesDemo) {
            MultipleInterfacesDemo other = (MultipleInterfacesDemo) o;
            return Integer.compare(this.value, other.value);
        }
        return 0;
    }

    @Override
    public void display() {
        System.out.println("MultipleInterfacesDemo object with value: " + value);
    }
}

// 9. Main Class to Test All Concepts
public class InterfaceAndAbstractDemo {
    public static void main(String[] args) {
        // Creating an array of Displayable objects (Shapes & Buttons)
        Displayable[] items = {
            new Rectangle(10, 20, 5, 8),
            new Circle(15, 25, 4),
            new Button("Submit"),
            new Button("Cancel")
        };

        // Displaying all objects using polymorphism
        Graphics.displayAll(items);

        // Demonstrating sorting of comparable shapes
        Shape[] shapes = { new Rectangle(0, 0, 3, 4), new Circle(0, 0, 2) };
        
        System.out.println("\n=== Comparing Shapes Based on Area ===");
        if (shapes[0].compareTo(shapes[1]) < 0) {
            System.out.println("Rectangle has a smaller area than Circle");
        } else if (shapes[0].compareTo(shapes[1]) > 0) {
            System.out.println("Rectangle has a larger area than Circle");
        } else {
            System.out.println("Rectangle and Circle have the same area");
        }

        // Demonstrating multiple interfaces implementation
        System.out.println("\n=== Demonstrating Multiple Interfaces ===");
        MultipleInterfacesDemo obj1 = new MultipleInterfacesDemo(5);
        MultipleInterfacesDemo obj2 = new MultipleInterfacesDemo(10);

        obj1.display();
        obj2.display();

        if (obj1.compareTo(obj2) < 0) {
            System.out.println("obj1 has a smaller value than obj2");
        } else if (obj1.compareTo(obj2) > 0) {
            System.out.println("obj1 has a larger value than obj2");
        } else {
            System.out.println("obj1 and obj2 have the same value");
        }
    }
}
