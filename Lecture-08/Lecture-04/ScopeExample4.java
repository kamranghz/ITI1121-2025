public class ScopeExample4 {
    public static void display() {
        System.out.println("a = " + a);
		// Declare 'a' as a class-level variable to ensure it is accessible in both methods.
    //static int a;
    }

    public static void main(String[] args) {
        int i = 5, j = i + 5;
        int a;
        a = 9; // valid access, within the same block
        if (a < 10) {
            a = a + 1; // another valid access
        }
        display();
    }
}
