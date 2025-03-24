/*
 * Summary: Demonstration of Inner Class Accessing Outer Class Members
 *
 * This program defines a class `Outer` that contains:
 *  - An instance variable `value` initialized to 99.
 *  - A non-static inner class `Inner`, which also defines its own `value` variable.
 *
 * Key Concepts Demonstrated:
 * -----------------------------------------------------
 * - The inner class `Inner` can access the outer class's private members.
 * - Inside the `Inner` constructor, `this.value` (of Inner) is initialized as `Outer.this.value + 1`,
 *   meaning the inner class can disambiguate between its own `value` and the outer class's `value`.
 * - The method `getValue()` in `Inner` returns the inner `value` (which is 100).
 * - The method `getValue()` in `Outer` returns the outer `value` (which is 99).
 * - The `newInner()` method in `Outer` is used to instantiate the inner class.
 *
 * Purpose:
 * -----------------------------------------------------
 * - Demonstrates scope resolution and variable shadowing in nested classes.
 * - Explains how to access outer class members from an inner class using `Outer.this`.
 * - Useful for understanding Java’s object-oriented design and class nesting behavior.
 */




// Outer class definition
public class Outer {

    // Instance variable of the outer class
    private int value = 99;

    // Inner class definition
    public class Inner {
        // Inner class has its own variable named 'value'
        private int value;

        // Constructor of the inner class
        public Inner() {
            // Access outer class's 'value' using Outer.this.value
            this.value = Outer.this.value + 1;
        }

        // Method to return the inner class's value
        public int getValue() {
            return value;
        }
    }

    // Method to create a new instance of the inner class
    public Inner newInner() {
        return new Inner();
    }

    // Method to return the outer class's value
    public int getValue() {
        return value;
    }
}
