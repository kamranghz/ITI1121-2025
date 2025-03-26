public class RecursiveLinkedList<E extends Comparable<E>> {

    // Node class for the linked list
    private static class Node<E> {
        private E value;
        private Node<E> next;

        Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node<E> first; // Head of the list

    public RecursiveLinkedList() {
        first = null;
    }

    // Public method to add an element at the end
    public void addLast(E o) {
        first = addLast(first, o);
    }

    // Recursive helper method to add element at the end
    private Node<E> addLast(Node<E> p, E o) {
        if (p == null) {
            return new Node<>(o, null);
        }
        p.next = addLast(p.next, o);
        return p;
    }

    // Public method to compare this list with another
    public boolean equalsList(RecursiveLinkedList<E> other) {
        return equalsList(this.first, other.first);
    }

    // Recursive helper method to compare two lists
    private boolean equalsList(Node<E> p1, Node<E> p2) {
        if (p1 == null && p2 == null) return true;
        if (p1 == null || p2 == null) return false;
        if (!p1.value.equals(p2.value)) return false;
        return equalsList(p1.next, p2.next);
    }

    // Print the list for verification
    public void printList() {
        Node<E> current = first;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Main method for demonstration
    public static void main(String[] args) {
        RecursiveLinkedList<Integer> list1 = new RecursiveLinkedList<>();
        list1.addLast(1);
        list1.addLast(2);
        list1.addLast(3);
        System.out.print("List1: ");
        list1.printList();

        RecursiveLinkedList<Integer> list2 = new RecursiveLinkedList<>();
        list2.addLast(1);
        list2.addLast(2);
        list2.addLast(3);
        System.out.println("List1 equals List2? " + list1.equalsList(list2));

        RecursiveLinkedList<Integer> list3 = new RecursiveLinkedList<>();
        list3.addLast(1);
        list3.addLast(4);
        System.out.println("List1 equals List3? " + list1.equalsList(list3));
    }
}
