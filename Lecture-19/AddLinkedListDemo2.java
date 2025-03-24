public class AddLinkedListDemo2<E> {
    private Node<E> head;  // Start of the list

    private static class Node<E> {
        E data;           // Data stored in the node
        Node<E> next;     // Reference to the next node

        Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    public void addElementAtEndUnsafe(E data) {
        Node<E> newNode = new Node<>(data, null);  // Create a new node, next is null because it will be the last node

        if (head == null) {
            // If the list is empty, the new node becomes the head
            head = newNode;
        } else {
            Node<E> current = head; // Start at the head of the list
            while (current.next != null) {  // Traverse the list until the last node is reached
                current.next = current;
            }
            // Attach the new node at the end of the list
            // Note: If we mistakenly modify current.next in the loop instead of current,
            // and set it to null (which we should not), it would lead to current being null here.
            // Attempting to access current.next would then throw a NullPointerException.
            current.next = newNode;  // Link the last node to the new node safely
        }
    }

    public void printList() {
        Node<E> current = head;
        System.out.print("List: ");
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        AddLinkedListDemo2<String> list = new AddLinkedListDemo2<>();
        list.addElementAtEndUnsafe("A");
        list.addElementAtEndUnsafe("B");
        list.addElementAtEndUnsafe("C");

        list.printList();  // Output will show the list: A -> B -> C -> null
    }
}
