// A simple and conceptual Binary Search Tree (BST) implementation
public class SimpleBinarySearchTreeDemo {

    public static void main(String[] args) {
        // Create a new BST of Integers
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();

        // Insert some values into the tree
        tree.insert(8);
        tree.insert(5);
        tree.insert(15);
        tree.insert(2);
        tree.insert(7);
        tree.insert(12);
        tree.insert(20);

        // Display the tree contents using in-order traversal
        System.out.println("In-Order Traversal (should be sorted):");
        tree.inOrderTraversal(); // Output: 2 5 7 8 12 15 20
    }
}

// ===============================
// Generic Binary Search Tree Class
// ===============================
class BinarySearchTree<E extends Comparable<E>> {

    // Nested static class representing a Node in the tree
    private static class Node<E> {
        E value;
        Node<E> left;
        Node<E> right;

        Node(E value) {
            this.value = value;
        }
    }

    private Node<E> root; // Root of the tree

    // Public method to insert a value into the tree
    public void insert(E value) {
        root = insertRecursive(root, value);
    }

    // Recursive helper method for insertion
    private Node<E> insertRecursive(Node<E> current, E value) {
        if (current == null) {
            return new Node<>(value); // Create new node if we hit a null spot
        }

        if (value.compareTo(current.value) < 0) {
            current.left = insertRecursive(current.left, value);
        } else if (value.compareTo(current.value) > 0) {
            current.right = insertRecursive(current.right, value);
        }
        // If value is equal, do nothing (or handle duplicates if needed)
        return current;
    }

    // Public method for in-order traversal (left-root-right)
    public void inOrderTraversal() {
        inOrderRecursive(root);
        System.out.println(); // New line after traversal
    }

    // Recursive in-order traversal
    private void inOrderRecursive(Node<E> node) {
        if (node != null) {
            inOrderRecursive(node.left);
            System.out.print(node.value + " ");
            inOrderRecursive(node.right);
        }
    }
}
