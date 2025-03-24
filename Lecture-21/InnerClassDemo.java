/*
 * This Java program demonstrates the concept of nested classes, 
 * including both non-static inner classes and static nested classes.
 * 
 * Key Concepts:
 * - The `InnerClassDemo` is the outer class containing:
 *   1. A non-static inner class (`Inner`) that can access instance members of the outer class.
 *   2. A static nested class (`StaticNested`) that cannot directly access instance members.
 * 
 * The `main` method shows how to:
 * - Instantiate only the outer class.
 * - Instantiate the inner class using an outer class instance.
 * - Instantiate the static nested class directly without an outer instance.
 * 
 * This helps in understanding the differences between inner and static nested classes 
 * and their access to outer class members.
 */




// Outer class definition
public class InnerClassDemo {

    // Instance variable of Outer class
    private String message = "Hello from Outer class";

    // 1. Inner Class (non-static nested class)
    public class Inner {
        public Inner() {
            System.out.println("* Inner class constructor *");
            System.out.println("Accessing outer class variable: " + message);
        }
    }

    // 2. Static Nested Class
    public static class StaticNested {
        public StaticNested() {
            System.out.println("* Static nested class constructor *");

            // Cannot directly access instance variables like 'message'
            // So we simulate with static message (example purpose)
            System.out.println("Cannot access outer instance variable directly");
        }
    }

    // Constructor of Outer class
    public InnerClassDemo() {
        System.out.println("* Outer class constructor *");
    }

    // Main method to test both inner and static nested classes
    public static void main(String[] args) {

        // -------------------------------------
        // Test 1: Create only Outer object
        // -------------------------------------
        System.out.println("== Test 1: Outer instance only ==");
        InnerClassDemo outerOnly = new InnerClassDemo();

        // NOTE: Inner class is NOT created automatically
        System.out.println("No inner class created automatically.\n");

        // -------------------------------------
        // Test 2: Create Inner class (needs Outer)
        // -------------------------------------
        System.out.println("== Test 2: Create Inner class using Outer instance ==");
        InnerClassDemo outer = new InnerClassDemo();
        InnerClassDemo.Inner inner = outer.new Inner(); // Requires outer instance
        System.out.println();

        // -------------------------------------
        // Test 3: Create Static Nested class (does NOT need Outer)
        // -------------------------------------
        System.out.println("== Test 3: Create Static Nested class ==");
        InnerClassDemo.StaticNested staticNested = new InnerClassDemo.StaticNested();
    }
}
