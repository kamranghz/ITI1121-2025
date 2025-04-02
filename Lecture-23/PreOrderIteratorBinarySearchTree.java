import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class PreOrderIteratorBinarySearchTree<E extends Comparable<E>> {
    private Node<E> root;

    // Node class definition to encapsulate the properties of a binary search tree node
    private static class Node<E> {
        E value; // The value or data held by the node
        Node<E> left, right; // References to the left and right child nodes

        // Node constructor initializes the node with a value and null children
        Node(E value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    /**
     * Provides a pre-order iterator for the binary search tree.
     * Pre-order traversal visits nodes in the order: root, left subtree, right subtree.
     * @return An iterator that traverses the tree in pre-order.
     */
    public Iterator<E> preOrderIterator() {
        return new PreOrderIterator();
    }

    /**
     * Inner class implementing the Iterator interface to enable pre-order traversal of the tree.
     */
    private class PreOrderIterator implements Iterator<E> {
        private Stack<Node<E>> trail; // Stack to hold the nodes for traversal

        /**
         * Constructor initializes the stack and pushes the root node if present.
         * This setup starts the traversal from the root as required by pre-order traversal.
         */
        private PreOrderIterator() {
            trail = new Stack<>();
            if (root != null) {
                trail.push(root); // Start with the root node
            }
        }

        /**
         * Checks if there are more nodes to visit in the traversal.
         * @return true if there are more nodes to visit, false otherwise.
         */
        @Override
        public boolean hasNext() {
            return !trail.isEmpty();
        }

        /**
         * Moves to the next node in the pre-order traversal sequence.
         * @return The next node's value in the traversal.
         * @throws NoSuchElementException if there are no more elements.
         */
        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements in the tree");
            }
            Node<E> current = trail.pop(); // Retrieve and remove the top of the stack
            // Push right then left child to the stack to ensure that left child is processed first
            if (current.right != null) {
                trail.push(current.right);
            }
            if (current.left != null) {
                trail.push(current.left);
            }
            return current.value; // Return the value of the current node
        }
    }

    /**
     * Main method to demonstrate the usage of the pre-order iterator in a binary search tree.
     */
    public static void main(String[] args) {
        PreOrderIteratorBinarySearchTree<Integer> bst = new PreOrderIteratorBinarySearchTree<>();
        bst.root = new Node<>(10); // Setup a simple tree
        bst.root.left = new Node<>(5);
        bst.root.right = new Node<>(15);
        bst.root.left.left = new Node<>(3);
        bst.root.left.right = new Node<>(7);
        bst.root.right.left = new Node<>(12);

        Iterator<Integer> it = bst.preOrderIterator();
        System.out.println("BST Pre-Order Traversal:");
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
