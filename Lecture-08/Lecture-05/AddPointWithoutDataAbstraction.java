public class AddPointWithoutDataAbstraction {
    public static void main(String[] args) {
        // Define coordinates of the first point (Point 1).
        int x1 = 2, y1 = 3, z1 = 1;

        // Define coordinates of the second point (Point 2).
        int x2 = 4, y2 = 5, z2 = 2;

        // Add corresponding coordinates manually to create the resulting point (Point 3).
        int x3 = x1 + x2; // x-coordinate of Point 3.
        int y3 = y1 + y2; // y-coordinate of Point 3.
        int z3 = z1 + z2; // z-coordinate of Point 3.

        // Print the resulting point.
        System.out.println("Result: (" + x3 + ", " + y3 + ", " + z3 + ")");

        // Check if Point 1 and Point 2 are equal.
        boolean arePointsEqual = (x1 == x2) && (y1 == y2) && (z1 == z2);
        System.out.println("Are points equal? " + arePointsEqual);
    }
}
