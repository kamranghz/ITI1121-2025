public class Test {
    public static void main(String[] args) {
        // Create a new stack with a capacity of 100
        Stack myStack = new ArrayStack(100);

        // Push each command-line argument onto the stack as an Integer
        for (int i = 0; i < args.length; i++) {
            myStack.push(Integer.valueOf(args[i])); // Convert argument to Integer and push
        }

        // Pop and print all elements from the stack until it is empty
        while (!myStack.isEmpty()) {
            System.out.print(myStack.pop() + " "); // Pop and print the top element
        }

        // Print a new line after all elements are printed
        System.out.println();
    }
}
