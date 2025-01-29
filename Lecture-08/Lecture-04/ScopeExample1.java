class ScopeExample1 {
    public static void main(String[] args) {
        int x = 10; // Variable x is declared in the main method

        // x is accessible here
        System.out.println("x inside main: " + x);

        {
            // A new block
            int y = 20; // Variable y is declared inside this block
            System.out.println("x inside block: " + x); // x is still accessible
            System.out.println("y inside block: " + y); // y is accessible here
        }

        
       System.out.println(y); 
    }
}
