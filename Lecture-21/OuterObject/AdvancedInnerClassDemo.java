// Outer class A
public class A {
    // Private variable in class A
    private int value = 99;

    // Inner class B inside A
    public class B {
        // Variable specific to B
        private int value;

        // Constructor for B
        public B() {
            // Accessing A's value using A.this.value
            this.value = A.this.value + 1;
        }

        // Inner class C inside B (nested more deeply)
        public class C {
            // Variable specific to C
            private int value;

            // Constructor for C
            public C() {
                // Accessing B's value using B.this.value
                this.value = B.this.value + 1;
            }

            // Method to print and return C's value
            public int getValue() {
                // Printing all the enclosing class values
                System.out.println("A.this.value = " + A.this.value);   // 99
                System.out.println("B.this.value = " + B.this.value);   // 100
                System.out.println("this.value = " + this.value);       // 101
                return value;
            }
        }
    }
}
