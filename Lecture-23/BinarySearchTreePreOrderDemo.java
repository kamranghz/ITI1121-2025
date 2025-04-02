// BinarySearchTreePreOrderDemo.java

public class BinarySearchTreePreOrderDemo<E extends Comparable<E>> {

    // Node class represents each node in the tree
    private static class Node<E> {
        private E value;
        private Node<E> left;
        private Node<E> right;

        public Node(E value) {
            this.value = value;
        }
    }

    // Root of the tree
    private Node<E> root;

    // Public method to insert a value into the tree
    public void insert(E value) {
        root = insertRecursive(root, value);
    }

    // Recursive helper for insertion
    private Node<E> insertRecursive(Node<E> current, E value) {
        if (current == null) {
            return new Node<>(value);
        }

        if (value.compareTo(current.value) < 0) {
            current.left = insertRecursive(current.left, value);
        } else if (value.compareTo(current.value) > 0) {
            current.right = insertRecursive(current.right, value);
        }

        return current;
    }

    // Public method to start pre-order traversal
    public void preOrder() {
        System.out.print("Pre-order traversal:");
        preOrder(root);
        System.out.println(); // new line after traversal
    }

    // Recursive pre-order traversal: current → left → right
    private void preOrder(Node<E> current) {
        if (current != null) {
            visit(current);             // Visit current node
            preOrder(current.left);     // Traverse left subtree
            preOrder(current.right);    // Traverse right subtree
        }
    }

    // Helper method to print the value of a node
    private void visit(Node<E> current) {
        System.out.print(" " + current.value);
    }

    // Main method for demonstration
    public static void main(String[] args) {
        BinarySearchTreePreOrderDemo<Integer> bst = new BinarySearchTreePreOrderDemo<>();
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        bst.preOrder();  // Output: Pre-order traversal: 50 30 20 40 70 60 80
    }
}
