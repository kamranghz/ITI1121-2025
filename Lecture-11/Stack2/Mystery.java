public class Mystery {
    public static void main(String[] args) {
        Stack myStack = new StackImplementation(100); // Create stack with capacity 100

        // Push command-line arguments onto the stack
        for (int i = 0; i < args.length; i++) {
            myStack.push(args[i]);
        }

        // Pop and print elements in reverse order
        while (!myStack.isEmpty()) {
            System.out.print(myStack.pop() + " ");
        }

        System.out.println(); // Print newline at the end
    }
}
