/*
 * Summary: Deeply Nested Inner Classes and Variable Shadowing in Java
 *
 * This program demonstrates a three-level nested class structure:
 * - Class `A` is the outer class with a private variable `value = 99`.
 * - Class `B` is a non-static inner class within `A`, with its own `value`.
 * - Class `C` is an inner class within `B`, also with its own `value`.
 *
 * Key Concepts Illustrated:
 * ------------------------------------------------------------
 * 1. **Nested Inner Class Access**:
 *    - Class `C` can access variables from both its enclosing class `B` and the outer class `A`.
 *    - This is done using `B.this.value` and `A.this.value`.
 *
 * 2. **Variable Shadowing and Scope Resolution**:
 *    - Each class (`A`, `B`, and `C`) defines a variable named `value`, demonstrating **shadowing**.
 *    - `C`'s constructor sets its `value` to `B.this.value + 1` (which is 101).
 *    - `B`'s constructor sets its `value` to `A.this.value + 1` (which is 100).
 *
 * 3. **Output via `getValue()`**:
 *    - The method `getValue()` in class `C` prints all the shadowed values using explicit scoping:
 *      - `A.this.value = 99`
 *      - `B.this.value = 100`
 *      - `this.value    = 101`
 *
 * Purpose:
 * ------------------------------------------------------------
 * - Shows how inner classes can access members of their enclosing classes.
 * - Demonstrates the use of qualified `this` references (`A.this`, `B.this`) for disambiguation.
 * - Useful for teaching advanced Java concepts such as nested scopes, object relationships,
 *   variable shadowing, and inner class mechanics.
 */



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
