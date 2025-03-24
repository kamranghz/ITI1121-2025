// Separate class to run the test
public class D {
    public static void main(String[] args) {
        // Creating an object of class C through nested instantiation
        A.B.C abc = new A().new B().new C();

        // Calling getValue() to see the result
        System.out.println("abc.getValue() -> " + abc.getValue());
    }
}
