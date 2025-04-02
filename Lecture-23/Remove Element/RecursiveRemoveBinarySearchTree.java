public class RecursiveRemoveBinarySearchTree<E extends Comparable<E>> {
    private Node<E> root;

    private static class Node<E> {
        E value;
        Node<E> left, right;

        Node(E value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    /**
     * Public method to remove a node with the specified value from the tree.
     * This uses a recursive helper method to find and remove the node.
     * @param obj The value of the node to be removed.
     */
    public void remove(E obj) {
        // Precondition: check if the value to remove is null
        if (obj == null) {
            throw new IllegalArgumentException("Cannot remove null");
        }

        // Start the recursive removal from the root
        root = remove(root, obj);
    }

    /**
     * Recursive method to remove a node with the specified value from the tree.
     * @param current The current node in the recursion.
     * @param obj The value of the node to be removed.
     * @return The new root of the subtree after the removal.
     */
    private Node<E> remove(Node<E> current, E obj) {
        if (current == null) {
            return null; // Base case: node not found
        }

        int test = obj.compareTo(current.value);
        if (test == 0) {
            // Node to remove found
            if (current.left == null) {
                return current.right;
            } else if (current.right == null) {
                return current.left;
            } else {
                // Node has two children: replace its value with the leftmost node in the right subtree
                current.value = getLeftMost(current.right);
                // Remove the leftmost node in the right subtree
                current.right = remove(current.right, current.value);
            }
        } else if (test < 0) {
            // Continue searching in the left subtree
            current.left = remove(current.left, obj);
        } else {
            // Continue searching in the right subtree
            current.right = remove(current.right, obj);
        }
        return current;
    }

    /**
     * Helper method to find the smallest value (leftmost node) in a subtree.
     * @param node The root of the subtree.
     * @return The value of the leftmost node.
     */
    private E getLeftMost(Node<E> node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.value;
    }

    public static void main(String[] args) {
        RecursiveRemoveBinarySearchTree<Integer> bst = new RecursiveRemoveBinarySearchTree<>();
        bst.root = new Node<>(10);
        bst.root.left = new Node<>(5);
        bst.root.right = new Node<>(20);
        bst.root.left.left = new Node<>(1);
        bst.root.left.right = new Node<>(8);
        bst.root.right.left = new Node<>(15);
        bst.root.right.right = new Node<>(25);

        // Remove elements
        bst.remove(10); // Root with two children
        System.out.println("10 removed, new root: " + (bst.root != null ? bst.root.value : "null"));
        bst.remove(1);  // Leaf
        System.out.println("1 removed, left child of 5: " + (bst.root.left.left != null ? bst.root.left.left.value : "null"));
        bst.remove(20); // Node with two children
        System.out.println("20 removed, right child of root: " + (bst.root.right != null ? bst.root.right.value : "null"));
    }
}
