public class BinarySearchTreeTake2 {

    // Node class: represents each node in the tree
    private static class Node<E> {
        E value;
        Node<E> left, right;

        Node(E value) {
            this.value = value;
        }
    }

    // Root of the tree
    private Node<Integer> root;

    // Insert value into the BST
    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    private Node<Integer> insertRecursive(Node<Integer> node, int value) {
        if (node == null) return new Node<>(value);

        if (value < node.value) {
            node.left = insertRecursive(node.left, value);
        } else if (value > node.value) {
            node.right = insertRecursive(node.right, value);
        }
        return node;
    }

    // Iterative contains method (Take 2)
    public boolean contains2(int target) {
        Node<Integer> current = root;

        while (current != null) {
            if (target == current.value) {
                return true;
            } else if (target < current.value) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return false;
    }

    // In-order Traversal: Left → Root → Right
    public void inOrder() {
        System.out.print("In-order: ");
        inOrderTraversal(root);
        System.out.println();
    }

    private void inOrderTraversal(Node<Integer> node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.value + " ");
            inOrderTraversal(node.right);
        }
    }

    // Pre-order Traversal: Root → Left → Right
    public void preOrder() {
        System.out.print("Pre-order: ");
        preOrderTraversal(root);
        System.out.println();
    }

    private void preOrderTraversal(Node<Integer> node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    // Post-order Traversal: Left → Right → Root
    public void postOrder() {
        System.out.print("Post-order: ");
        postOrderTraversal(root);
        System.out.println();
    }

    private void postOrderTraversal(Node<Integer> node) {
        if (node != null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            System.out.print(node.value + " ");
        }
    }

    // Main method for demonstration
    public static void main(String[] args) {
        BinarySearchTreeTake2 bst = new BinarySearchTreeTake2();

        // Insert values into the tree
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(3);
        bst.insert(7);
        bst.insert(12);
        bst.insert(20);

        // Test contains2 method
        System.out.println("Searching in Tree:");
        System.out.println("Contains 7?  → " + bst.contains2(7));    // true
        System.out.println("Contains 13? → " + bst.contains2(13));   // false

        // Display tree traversals
        System.out.println("\nTree Traversals:");
        bst.inOrder();    // Output: 3 5 7 10 12 15 20
        bst.preOrder();   // Output: 10 5 3 7 15 12 20
        bst.postOrder();  // Output: 3 7 5 12 20 15 10
    }
}
