public class Main {
    public static void main(String[] args) {
        Shape shape = new Shape(10, 20);  // Shape object
        Circle circle = new Circle(15, 25, 5);  // Circle object

        // Print initial locations
        System.out.println(shape);
        System.out.println(circle);

        // Move the Shape
        shape.moveTo(30, 40);

        // Move the Circle
        circle.moveTo(35, 45);

        // Print updated locations
        System.out.println(shape);
        System.out.println(circle);
    }
}
