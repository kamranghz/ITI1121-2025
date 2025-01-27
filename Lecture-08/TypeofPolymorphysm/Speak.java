// Speak.java
// This class demonstrates Ad-hoc Polymorphism (Method Overloading).
// It provides multiple versions of the 'say' method with different parameters.

public class Speak {
    // First version: Simple message output
    public void say(String message) {
        System.out.println("Message: " + message);
    }

    // Second version: Outputs the message differently based on the isShouting flag
    public void say(String message, boolean isShouting) {
        if (isShouting) {
            System.out.println("SHOUTING: " + message.toUpperCase()); // Converts message to uppercase if shouting
        } else {
            System.out.println("Speaking: " + message); // Outputs the message normally if not shouting
        }
    }
}
