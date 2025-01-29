public class Circle extends Shape {
    private double radius;

    public Circle() {
        radius = 0;
    }

    public Circle(double x, double y, double radius) {
        super(x, y);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void moveTo(double newX, double newY) {
        super.moveTo(newX, newY); // Update coordinates in Shape
        System.out.println("Circle moved to (" + newX + ", " + newY + ")");
    }

    public String toString() {
        return "Circle located at: (" + getX() + ", " + getY() + ") with radius " + radius;
    }
}
