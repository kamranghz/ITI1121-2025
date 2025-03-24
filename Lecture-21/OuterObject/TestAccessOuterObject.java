// Class to test the behavior of outer and inner class access
public class TestAccessOuterObject {
    public static void main(String[] args) {
        // Create an instance of the outer class
        Outer o = new Outer();

        // Print value from the outer class
        System.out.println("o.getValue() -> " + o.getValue());  // Should print 99

        // Create an inner class object using the outer class instance
        Outer.Inner i = o.newInner();

        // Print value from the inner class
        System.out.println("i.getValue() -> " + i.getValue());  // Should print 100

        // Print value from the outer class again to show it’s unchanged
        System.out.println("o.getValue() -> " + o.getValue());  // Should still print 99
    }
}
