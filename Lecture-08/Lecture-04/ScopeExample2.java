class ScopeExample2 {
    public static void main(String[] args) {
        int a = 5; // Local variable a
        if (a > 0) {
            int b = a + 10; // b is declared inside the if block
            System.out.println("a: " + a); // a is accessible here
            System.out.println("b: " + b); // b is accessible here
        }

        // b is not accessible here
        // System.out.println(b); // This will cause an error if uncommented
    }
}
