public class BinarySearchTreePostOrderDemo<E extends Comparable<E>> {

    // Node class representing a node in the binary tree
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

    // Manual method to create the exact tree structure
    public void buildCustomTree() {
        root = new Node<>(8);

        root.left = new Node<>(9);
        root.right = new Node<>(15);

        root.left.left = new Node<>(5);
        root.left.right = new Node<>(11);

        root.right.right = new Node<>(29);
    }

    // Public method to start post-order traversal
    public void postOrder() {
        System.out.print("Post-order traversal:");
        postOrder(root);
        System.out.println(); // newline after traversal
    }

    // Recursive post-order traversal: left → right → current
    private void postOrder(Node<E> current) {
        if (current != null) {
            postOrder(current.left);   // Traverse left subtree
            postOrder(current.right);  // Traverse right subtree
            visit(current);            // Visit current node
        }
    }

    // Print the node's value
    private void visit(Node<E> current) {
        System.out.print(" " + current.value);
    }

    // Main method to run the example
    public static void main(String[] args) {
        BinarySearchTreePostOrderDemo<Integer> tree = new BinarySearchTreePostOrderDemo<>();
        tree.buildCustomTree();

        tree.postOrder(); // Output: Post-order traversal: 5 11 9 29 15 8
    }
}
