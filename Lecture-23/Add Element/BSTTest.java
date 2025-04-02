public class BSTTest {
    public static void main(String[] args) {
        BinarySearchTree<String> bst = new BinarySearchTree<>();

        // Adding elements to the BST
        bst.add("Lion");
        bst.add("Fox");
        bst.add("Rat");
        bst.add("Cat");
        bst.add("Pig");
        bst.add("Dog");
        bst.add("Tiger");

        // Output the result of each add operation, demonstrating the tree's behavior
        System.out.println(bst.add("Lion"));  // false, as it is a duplicate
    }
}
