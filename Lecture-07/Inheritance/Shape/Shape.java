public class Shape {
    private double x;
    private double y;

    public Shape() {
        x = 0;
        y = 0;
    }

    public Shape(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void moveTo(double newX, double newY) {
        x = newX;
        y = newY;
        System.out.println("Shape moved to (" + newX + ", " + newY + ")");
    }

    public String toString() {
        return "Shape located at: (" + x + ", " + y + ")";
    }
}
