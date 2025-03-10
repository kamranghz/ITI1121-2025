import java.io.*; // Importing necessary classes for Input/Output operations

// Class to handle keyboard input
public class Keyboard {
    
    // Method to read an integer from user input
    public static int getInt() throws IOException { // Declares that it may throw IOException
        byte[] buffer = new byte[256]; // Buffer to store user input
        
        System.in.read(buffer); // Reads user input and throws IOException if an error occurs
        
        String s = new String(buffer); // Converts byte array to String
        int num = Integer.parseInt(s.trim()); // Converts trimmed String to an integer
        return num; // Returns the integer value
    }

    // Main method to execute the program
    public static void main(String[] args) {
        System.out.print("Please enter a number: ");
        
        try {
            int n = Keyboard.getInt(); // Calls getInt(), which may throw IOException
            System.out.println("You’ve entered the number: " + n);
        } catch (IOException e) { // Handles the exception
            System.out.println("An input error occurred: " + e.getMessage());
        } catch (NumberFormatException e) { // Handles invalid integer input
            System.out.println("Invalid number format. Please enter a valid integer.");
        }
    }
}
