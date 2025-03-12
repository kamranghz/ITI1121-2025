public class MazeSolver {

    // Maze representation: '#' = Wall, '.' = Open path, 'E' = Exit
    private static final char WALL = '#';
    private static final char PATH = '.';
    private static final char EXIT = 'E';
    
    private static final int MAX_ROW = 5;
    private static final int MAX_COL = 7;

    // Example Maze Grid
    private static final char[][] grid = {
        {'#', '+', '#', '#', '#', '#', '#'},
        {'#', '#', ' ', ' ', '#', ' ', '#'},
        {'#', '+', '+', ' ', '#', ' ', '#'},
        {'#', '#', '#', ' ', ' ', ' ', '#'},
        {'#', '#', '#', '#', '#', 'E', '#'} // 'E' represents the Exit
    };

    // Method to check if a given path is valid
    private static boolean checkPath(String path) {
        boolean[][] visited = new boolean[MAX_ROW][MAX_COL]; // Track visited positions

        int row = 0, col = 1; // Assume start position is (0,1)
        int pos = 0;
        boolean valid = true;

        while (valid && pos < path.length()) {
            char direction = path.charAt(pos++); // Read next move

            // Update position based on move direction
            switch (direction) {
                case 'L': col--; break;  // Move Left
                case 'R': col++; break;  // Move Right
                case 'U': row--; break;  // Move Up
                case 'D': row++; break;  // Move Down
                default: valid = false;  // Invalid move
            }

            // Check if new position is out of bounds or hitting a wall
            if (row < 0 || row >= MAX_ROW || col < 0 || col >= MAX_COL || grid[row][col] == WALL || visited[row][col]) {
                valid = false;
            } else {
                visited[row][col] = true; // Mark as visited
            }
        }

        return valid; // Return whether path is valid
    }

    // Method to check if the path reaches the exit
    private static boolean reachesGoal(String path) {
        int row = 0, col = 1; // Start position

        for (int pos = 0; pos < path.length(); pos++) {
            char direction = path.charAt(pos);

            // Move based on direction
            switch (direction) {
                case 'L': col--; break;
                case 'R': col++; break;
                case 'U': row--; break;
                case 'D': row++; break;
            }

            // Check if the exit is reached
            if (grid[row][col] == EXIT) {
                return true;
            }
        }
        return false;
    }

    // Main method to test functionality
    public static void main(String[] args) {
        // Test paths
        String path1 = "RRDD"; // Moves right twice, then down twice
        String path2 = "RRRDDRR"; // Moves towards an invalid area

        // Output results
        System.out.println("Path: " + path1 + " is " + (checkPath(path1) ? "Valid" : "Invalid"));
        System.out.println("Does Path 1 reach the exit? " + (reachesGoal(path1) ? "Yes" : "No"));

        System.out.println("\nPath: " + path2 + " is " + (checkPath(path2) ? "Valid" : "Invalid"));
        System.out.println("Does Path 2 reach the exit? " + (reachesGoal(path2) ? "Yes" : "No"));
    }
}
