class ScopeExample3 {
    public static void display() {
         System.out.println("a = " + a); // Error: a is not accessible here
    }

    public static void main(String[] args) {
        int a = 10; // Local variable a
        System.out.println("a inside main: " + a);
        display(); // This will cause an error because a is not in the scope of display
    }
}
