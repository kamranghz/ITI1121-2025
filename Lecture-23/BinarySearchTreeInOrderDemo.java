public class BinarySearchTreeInOrderDemo<E extends Comparable<E>> {

    // Node class representing a node in the binary search tree
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

    // Recursive helper method for insertion
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

    // Public method to start in-order traversal
    public void inOrder() {
        System.out.print("In-order traversal:");
        inOrder(root);
        System.out.println(); // new line after traversal
    }

    // Recursive in-order traversal: left → current → right
    private void inOrder(Node<E> current) {
        if (current != null) {
            inOrder(current.left);   // Traverse left subtree
            visit(current);          // Visit current node
            inOrder(current.right);  // Traverse right subtree
        }
    }

    // Helper method to print a node's value
    private void visit(Node<E> current) {
        System.out.print(" " + current.value);
    }

    // Main method to demonstrate in-order traversal
    public static void main(String[] args) {
        BinarySearchTreeInOrderDemo<Integer> bst = new BinarySearchTreeInOrderDemo<>();

        // Insert nodes to form the exact tree
        bst.insert(11);
        bst.insert(8);
        bst.insert(15);
        bst.insert(5);
        bst.insert(9);
        bst.insert(29);

        // Perform in-order traversal
        bst.inOrder();  // Output: In-order traversal: 5 8 9 11 15 29
    }
}
