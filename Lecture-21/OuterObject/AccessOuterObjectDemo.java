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
