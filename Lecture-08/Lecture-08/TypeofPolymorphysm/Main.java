// Main.java
// This class demonstrates both Ad-hoc and Inclusion Polymorphism in action.

public class Main {
    public static void main(String[] args) {
        // Demonstrating Ad-hoc Polymorphism with the Speak class
        System.out.println("Ad-hoc Polymorphism Demonstration:");
        Speak speak = new Speak();
        speak.say("Hello"); // Outputs a simple message
        speak.say("Hello", true); // Outputs the message as shouting
        speak.say("Hello", false); // Outputs the message normally
        System.out.println();

        // Demonstrating Inclusion Polymorphism with the Animal class
        System.out.println("Inclusion Polymorphism Demonstration:");
        Animal dog = new Dog(); // Parent class reference pointing to a Dog object
        Animal cat = new Cat(); // Parent class reference pointing to a Cat object

        // Calls the overridden speak method in the Dog and Cat classes
        dog.speak(); // Output: Woof!
        cat.speak(); // Output: Meow!
    }
}
