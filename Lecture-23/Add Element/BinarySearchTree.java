public class BinarySearchTree<E extends Comparable<E>> {
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

    public boolean add(E obj) {
        if (root == null) {
            root = new Node<>(obj);
            return true;
        }

        Node<E> current = root;
        while (true) {
            int test = obj.compareTo(current.value);
            if (test == 0) {
                // Element already exists, no duplicates allowed
                return false;
            } else if (test < 0) {
                if (current.left == null) {
                    current.left = new Node<>(obj);
                    return true;
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    current.right = new Node<>(obj);
                    return true;
                }
                current = current.right;
            }
        }
    }
}
