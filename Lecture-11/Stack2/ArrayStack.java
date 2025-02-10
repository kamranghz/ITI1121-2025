public class ArrayStack implements Stack {
    private Object[] stackArray;
    private int top;

    // Constructor with capacity
    public ArrayStack(int capacity) {
        stackArray = new Object[capacity];
        top = -1;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public void push(Object elem) {
        if (top < stackArray.length - 1) {
			// ++top is pre-increment, meaning the value of top is incremented before it is used in the expression.
            stackArray[++top] = elem;
        } else {
            System.out.println("Stack is full. Cannot push element.");
        }
    }

    @Override
    public Object pop() {
        if (!isEmpty()) {
			// top-- is post-decrement, meaning the value of top is used before it is decremented.
            return stackArray[top--];
        } else {
            System.out.println("Stack is empty. Cannot pop element.");
            return null;
        }
    }

    @Override
    public Object peek() {
        if (!isEmpty()) {
            return stackArray[top];
        } else {
            System.out.println("Stack is empty. Nothing to peek.");
            return null;
        }
    }
}
