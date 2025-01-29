public class CalledByValue1 {

    // A static method to compare two points for equality using Call-by-Value.
    public static boolean equal(int x1, int y1, int x2, int y2) {
        // Compare x-coordinates and y-coordinates of the two points.
        return (x1 == x2 && y1 == y2);
    }

    public static void main(String[] args) {
        // Declare coordinates for the first point.
        int x1 = 0; // x-coordinate of point 1
        int y1 = 0; // y-coordinate of point 1

        // Declare coordinates for the second point.
        int x2 = 1; // x-coordinate of point 2
        int y2 = 1; // y-coordinate of point 2

        // Call the 'equal' method with coordinates of two points.
        // Values of x1, y1, x2, y2 are passed as copies to the method.
    //  System.out.println("Are the points equal? " + equal(x1, y1, x2, y2)); // Expected: false

        // Example of incorrect parameter passing:
        // The order of coordinates is incorrect here.
     System.out.println(equal(x1, x2, y1, y2)); // Uncomment to see the effect
    }
}
