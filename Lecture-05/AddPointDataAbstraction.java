class Point {
    int x, y, z;

    // Default constructor.
    Point() {}

    // Constructor for 3D points.
    Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // Method to add two points.
    Point add(Point other) {
        return new Point(this.x + other.x, this.y + other.y, this.z + other.z);
    }

    // Method to check equality between two points.
    boolean equals(Point other) {
        return this.x == other.x && this.y == other.y && this.z == other.z;
    }
}

public class AddPointDataAbstraction {
    public static void main(String[] args) {
        Point p1 = new Point(2, 3, 1);
        Point p2 = new Point(4, 5, 2);

        Point p3 = p1.add(p2); // Add the points.
        System.out.println("Result: (" + p3.x + ", " + p3.y + ", " + p3.z + ")");

        System.out.println("Are points equal? " + p1.equals(p2));
    }
}






