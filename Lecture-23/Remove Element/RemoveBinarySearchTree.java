import java.util.NoSuchElementException;  // Import statement for NoSuchElementException

public class RemoveBinarySearchTree<E extends Comparable<E>> {
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
     * Removes a node with the specified value from the tree.
     * @param obj The value of the node to be removed.
     * @return The removed node, or null if no node was found.
     */
    public Node<E> remove(E obj) {
        // Check for invalid input
        if (obj == null) {
            throw new IllegalArgumentException("Cannot remove null");
        }

        // Check if the tree is empty
        if (root == null) {
            throw new NoSuchElementException("Tree is empty");
        }

        // Special case: removing the root
        if (obj.compareTo(root.value) == 0) {
            return removeTopMost(root);
        } else {
            // Initialize pointers to traverse the tree
            Node<E> current, parent = root;
            current = obj.compareTo(root.value) < 0 ? root.left : root.right;

            // Traverse the tree and find the node to remove
            while (current != null) {
                int test = obj.compareTo(current.value);
                if (test == 0) {
                    // Node found; perform removal
                    if (current == parent.left) {
                        parent.left = removeTopMost(current);
                    } else {
                        parent.right = removeTopMost(current);
                    }
                    return current; // Return the removed node
                } else {
                    // Move deeper into the tree
                    parent = current;
                    current = test < 0 ? current.left : current.right;
                }
            }
        }
        return null; // No node found with the given value
    }

    /**
     * Removes the top-most node from a subtree and restructures it.
     * @param node The subtree root to remove from.
     * @return The new subtree root.
     */
    private Node<E> removeTopMost(Node<E> node) {
        if (node.left == null) {
            return node.right; // Return the right subtree
        } else if (node.right == null) {
            return node.left; // Return the left subtree
        } else {
            Node<E> parent = node;
            Node<E> successor = node.right;
            
            // Find leftmost node in the right subtree
            while (successor.left != null) {
                parent = successor;
                successor = successor.left;
            }
            
            // Replace node value with successor value
            node.value = successor.value;

            // Remove successor node
            if (parent == node) {
                parent.right = successor.right;
            } else {
                parent.left = successor.right;
            }

            return node;
        }
    }

    public static void main(String[] args) {
        RemoveBinarySearchTree<Integer> bst = new RemoveBinarySearchTree<>();
        bst.root = new Node<>(10);
        bst.root.left = new Node<>(5);
        bst.root.right = new Node<>(15);
        bst.root.left.left = new Node<>(2);
        bst.root.left.right = new Node<>(7);
        bst.root.right.right = new Node<>(20);

        System.out.println("Removing 15: " + (bst.remove(15) != null));
        System.out.println("Removing 10: " + (bst.remove(10) != null));
        System.out.println("Removing 25: " + (bst.remove(25) != null)); // not found
    }
}
