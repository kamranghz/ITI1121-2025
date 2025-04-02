public class AlternativeRemoveBinarySearchTree<E extends Comparable<E>> {
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
     * Removes a node with the specified value from the tree by replacing it in its parent's reference.
     * @param obj The value of the node to be removed.
     */
    public void remove(E obj) {
        Node<E> parent = null, current = root;
        boolean done = false;

        while (current != null && !done) {
            int test = obj.compareTo(current.value);
            if (test == 0) {
                // Node found; perform removal
                Node<E> newTop = removeTopMost(current);
                if (current == root) {
                    root = newTop; // Update root if current is root
                } else if (current == parent.left) {
                    parent.left = newTop; // Replace the left child of parent
                } else {
                    parent.right = newTop; // Replace the right child of parent
                }
                done = true; // Mark the removal as done
            } else {
                // Move deeper into the tree
                parent = current;
                current = test < 0 ? current.left : current.right;
            }
        }
    }

    /**
     * Handles the removal of a node by determining the new root of the subtree
     * after the node is removed, especially handling the case when the node has two children.
     * @param node The node to remove from the subtree.
     * @return The new subtree root.
     */
    private Node<E> removeTopMost(Node<E> node) {
        if (node.left == null) {
            return node.right; // Return the right subtree if no left child
        } else if (node.right == null) {
            return node.left; // Return the left subtree if no right child
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
        AlternativeRemoveBinarySearchTree<Integer> bst = new AlternativeRemoveBinarySearchTree<>();
        bst.root = new Node<>(10);
        bst.root.left = new Node<>(5);
        bst.root.right = new Node<>(15);
        bst.root.left.left = new Node<>(2);
        bst.root.left.right = new Node<>(7);
        bst.root.right.right = new Node<>(20);

        bst.remove(10);
        System.out.println("10 removed, new root: " + (bst.root != null ? bst.root.value : "null"));
        bst.remove(7);
        System.out.println("7 removed, root left right child: " + (bst.root.left.right != null ? bst.root.left.right.value : "null"));
    }
}
