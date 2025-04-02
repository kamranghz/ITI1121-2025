// A Binary Search Tree that stores Boolean values (true or false)
public class BooleanValueBSTDemo {

    public static void main(String[] args) {
        BinarySearchTree<Boolean> bst = new BinarySearchTree<>();

        // Insert Boolean values into the BST
        bst.insert(true);
        bst.insert(false);

        // Test contains method
        System.out.println("BST contains true?  → " + bst.contains(true));    // true
        System.out.println("BST contains false? → " + bst.contains(false));   // true
        System.out.println("BST contains null?  → throws exception");

        // Print in-order traversal
        System.out.print("In-order Traversal (should be: false true): ");
        bst.inOrderTraversal();  // Output: false true
    }
}

// Generic Binary Search Tree class for Comparable values
class BinarySearchTree<E extends Comparable<E>> {

    // Node class to represent each node in the tree
    private static class Node<E> {
        E value;
        Node<E> left, right;

        Node(E value) {
            this.value = value;
        }
    }

    private Node<E> root;

    // Inserts a new value into the BST
    public void insert(E value) {
        if (value == null) throw new IllegalArgumentException("Cannot insert null");
        root = insert(root, value);
    }

    private Node<E> insert(Node<E> current, E value) {
        if (current == null) return new Node<>(value);

        int cmp = value.compareTo(current.value);
        if (cmp < 0) {
            current.left = insert(current.left, value);
        } else if (cmp > 0) {
            current.right = insert(current.right, value);
        }
        return current;
    }

    // Searches for a value in the BST
    public boolean contains(E value) {
        if (value == null) throw new IllegalArgumentException("Cannot search for null");
        return contains(root, value);
    }

    private boolean contains(Node<E> node, E value) {
        if (node == null) return false;

        int cmp = value.compareTo(node.value);
        if (cmp == 0) return true;
        else if (cmp < 0) return contains(node.left, value);
        else return contains(node.right, value);
    }

    // In-order traversal to print sorted elements
    public void inOrderTraversal() {
        inOrderTraversal(root);
        System.out.println();
    }

    private void inOrderTraversal(Node<E> node) {
        if (node != null) {
            inOrderTraversal(node.left);
            System.out.print(node.value + " ");
            inOrderTraversal(node.right);
        }
    }
}
