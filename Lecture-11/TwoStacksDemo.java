// Class to implement two stacks in one array
class TwoStacks {
    private int[] arr;  // Array to store both stacks
    private int size;   // Total size of the array
    private int top1, top2;  // Top pointers for both stacks

    // Constructor to initialize stack with given size
    public TwoStacks(int size) {
        this.size = size;
        arr = new int[size];
        top1 = -1;         // Stack 1 starts from index -1 (empty)
        top2 = size;       // Stack 2 starts from the end
    }

    // Push an element into Stack 1 (grows from left to right)
    public void push1(int value) {
        if (top1 < top2 - 1) {  // Check if there is space
            arr[++top1] = value;
        } else {
            System.out.println("Stack 1 Overflow! No space left.");
        }
    }

    // Push an element into Stack 2 (grows from right to left)
    public void push2(int value) {
        if (top1 < top2 - 1) {  // Check if there is space
            arr[--top2] = value;
        } else {
            System.out.println("Stack 2 Overflow! No space left.");
        }
    }

    // Pop an element from Stack 1
    public int pop1() {
        if (top1 >= 0) {
            return arr[top1--];
        } else {
            System.out.println("Stack 1 Underflow! No elements left.");
            return -1;
        }
    }

    // Pop an element from Stack 2
    public int pop2() {
        if (top2 < size) {
            return arr[top2++];
        } else {
            System.out.println("Stack 2 Underflow! No elements left.");
            return -1;
        }
    }

    // Print both stacks
    public void printStacks() {
        System.out.print("Stack 1: ");
        for (int i = 0; i <= top1; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        System.out.print("Stack 2: ");
        for (int i = size - 1; i >= top2; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

// Main class to test the implementation
public class TwoStacksDemo {
    public static void main(String[] args) {
        TwoStacks stacks = new TwoStacks(10); // Create an array of size 10

        // Push elements into Stack 1
        stacks.push1(1);
        stacks.push1(2);
        stacks.push1(3);

        // Push elements into Stack 2
        stacks.push2(9);
        stacks.push2(8);
        stacks.push2(7);

        // Print current state of both stacks
        stacks.printStacks();

        // Pop elements from both stacks
        System.out.println("Popped from Stack 1: " + stacks.pop1());
        System.out.println("Popped from Stack 2: " + stacks.pop2());

        // Print final state of both stacks
        stacks.printStacks();
    }
}
