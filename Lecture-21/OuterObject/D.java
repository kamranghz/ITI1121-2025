/*
 * Summary: Class D - Testing Deeply Nested Inner Classes (A → B → C)
 *
 * This class serves as a test driver to instantiate and use the deeply nested inner class `C`,
 * which is defined inside class `B`, which itself is defined inside class `A`.
 *
 * Key Actions:
 * -------------------------------------------------
 * - Creates an instance of `A.B.C` using **nested instantiation syntax**:
 *     A.B.C abc = new A().new B().new C();
 * - Calls `abc.getValue()`, which:
 *     - Prints the values from all three levels:
 *         A.this.value = 99  
 *         B.this.value = 100  
 *         this.value   = 101
 *     - Returns the innermost value (101), which is printed by the main method.
 *
 * Purpose:
 * -------------------------------------------------
 * - Demonstrates how to instantiate and use **deeply nested inner classes** in Java.
 * - Reinforces the concept of scope resolution (`A.this`, `B.this`, etc.).
 * - Useful for understanding how inner class instances are tied to their enclosing instances.
 */



// Separate class to run the test
public class D {
    public static void main(String[] args) {
        // Creating an object of class C through nested instantiation
        A.B.C abc = new A().new B().new C();

        // Calling getValue() to see the result
        System.out.println("abc.getValue() -> " + abc.getValue());
    }
}
