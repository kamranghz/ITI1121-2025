// A Java program demonstrating the concept of data abstraction
// by encapsulating the logic for comparing two points in a reusable method.

public class DataAbstraction {

    /**
     * A method to check if two points in a 2D space are equal.
     * This method abstracts the comparison logic, making it reusable
     * and hiding the implementation details from the user.
     * 
     * @param x1 The x-coordinate of the first point.
     * @param y1 The y-coordinate of the first point.
     * @param x2 The x-coordinate of the second point.
     * @param y2 The y-coordinate of the second point.
     * @return true if the points (x1, y1) and (x2, y2) are identical, otherwise false.
     */
    public static boolean equal(int x1, int y1, int x2, int y2) {
        // Compares the x and y coordinates of two points and returns the result.
        return (x1 == x2 && y1 == y2);
    }

    public static void main(String[] args) {
        // Define the coordinates for the first point.
        int x1 = 0; // x-coordinate of the first point.
        int y1 = 0; // y-coordinate of the first point.

        // Define the coordinates for the second point.
        int x2 = 1; // x-coordinate of the second point.
        int y2 = 1; // y-coordinate of the second point.

        // Call the equal() method to determine if the points are equal
        // and directly print the result with a descriptive message.
        System.out.println("Are the two points equal? " + equal(x1, y1, x2, y2));
    }
}
