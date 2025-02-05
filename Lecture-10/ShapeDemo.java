// Define a base class called Shape
class Shape {
    public void display() {
        System.out.println("This is a generic shape.");
    }
}

// Define a subclass of Shape called Circle
class Circle extends Shape {
    private double radius;

    public Circle(double r) {
        this.radius = r;
    }

    // Method specific to the Circle class
    public double getRadius() {
        return radius;
    }
    
    @Override
    public void display() {
        System.out.println("This is a circle.");
    }
}

// Main class to run the code
public class ShapeDemo {
    public static void main(String[] args) {
        Shape shape = new Shape();
        Shape circle = new Circle(5.0);

        if (shape instanceof Circle) {
            System.out.println("shape is not a Circle");
        }

        if (circle instanceof Circle) {
            double radius = ((Circle) circle).getRadius();
            System.out.println("Radius of the circle: " + radius);
        }

        shape.display();
        circle.display();
    }
}
