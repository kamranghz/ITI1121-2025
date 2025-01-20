// Abstract class representing a Shape
abstract class Shape {
    abstract void draw(); // Abstract method to be implemented by subclasses
}

// Circle class extending Shape
class Circle extends Shape {
    void draw() {
        System.out.println("Drawing a Circle");
    }
}

// Square class extending Shape
class Square extends Shape {
    void draw() {
        System.out.println("Drawing a Square");
    }
}

public class ShapeWithDataAbstraction {
    public static void main(String[] args) {
        // Create shapes
        Shape circle = new Circle();
        Shape square = new Square();

        // Draw shapes
        circle.draw();
        square.draw();
    }
}
