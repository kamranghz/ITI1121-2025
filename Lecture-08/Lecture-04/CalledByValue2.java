// Import the Point class to represent 2D coordinates.
class Point {
    int x; // X-coordinate of the point
    int y; // Y-coordinate of the point
}

public class CalledByValue2 {

    // A static method to compare two points for equality.
    public static boolean equal(Point p1, Point p2) {
        // Compare the x and y coordinates of two points.
        // If both x-coordinates and y-coordinates are equal, return true. Otherwise, return false.
        return (p1.x == p2.x && p1.y == p2.y);
    }

    // A static method to add two points and return a new point.
    public static Point add(Point p1, Point p2) {
        // Create a new Point object to store the sum of the two points.
        Point result = new Point();
        // Add the x-coordinates and y-coordinates of the two points.
        result.x = p1.x + p2.x;
        result.y = p1.y + p2.y;
        // Return the new point object.
        return result;
    }

    // A static method to print the coordinates of a point.
    public static void printPoint(Point p) {
        // Print the x and y coordinates of the point in the format "x, y".
        System.out.println("Point coordinates: " + p.x + ", " + p.y);
    }

    public static void main(String[] args) {
        // Step 1: Create the first point (p1) with coordinates (0, 3).
        Point p1 = new Point();
        p1.x = 0; // Set the x-coordinate of p1
        p1.y = 3; // Set the y-coordinate of p1

        // Step 2: Create the second point (p2) with coordinates (1, 1).
        Point p2 = new Point();
        p2.x = 1; // Set the x-coordinate of p2
        p2.y = 1; // Set the y-coordinate of p2

        // Step 3: Check if the two points are equal and print the result.
        // Output will be false because (0, 3) != (1, 1).
        System.out.println("Are the points equal? " + equal(p1, p2));

        // Step 4: Add the two points and store the result in a new Point object (p3).
        Point p3 = add(p1, p2);

        // Step 5: Print the coordinates of the resulting point (p3).
        // Output will be "1, 4" because (0 + 1, 3 + 1) = (1, 4).
        printPoint(p3);
    }
}



  