// A detailed implementation of removing the first element in a Singly Linked List


class NineStepsLinkedList<E> {

    // Node class to represent each element in the linked list
    private static class Node<E> {
        E value;       // The data stored in the node
        Node<E> next;  // Pointer to the next node

        Node(E value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node<E> head; // The head of the linked list

    // Constructor to initialize an empty list
    public NineStepsLinkedList() {
        this.head = null;
    }

    // STEP 1: Identify Inputs/Outputs
    // - Input: The method is applied to a Singly Linked List instance.
    // - Output: The removed element (E) is returned.

    // STEP 2: BEFORE/AFTER memory diagrams (described in comments)
    // - BEFORE: head -> [value, next] -> [value, next] -> null
    // - AFTER:  head -> [value, next] -> null (first node is removed)

    // STEP 3: Generalization
    // - Replacing constant values with variables and removing elements not involved.

    // STEP 4: Find all specific cases
    // - Empty list (Illegal case)
    // - Singleton list (Special case)

    public E removeFirst() {
        // STEP 5: Handling Special Cases
        // - If list is empty, throw an exception (Illegal case)
        if (head == null) {
            throw new IllegalStateException("Cannot remove from an empty list.");
        }

        // Declare the variable for return value
        E result;

        // STEP 6: Writing test cases
        // - If there is only one node (Special case)
        if (head.next == null) {
            Node<E> nodeToDelete = head;  // Identify the node to delete
            result = nodeToDelete.value;  // Store its value
            head = null;                  // Remove the node (list becomes empty)
            nodeToDelete.value = null;     // Clear memory reference
            nodeToDelete.next = null;
        } 
        // General case: More than one node
        else {
            Node<E> nodeToDelete = head;  // Identify the first node to remove
            result = nodeToDelete.value;  // Store its value
            head = head.next;             // Move head to the next node
            nodeToDelete.value = null;    // Clear memory reference
            nodeToDelete.next = null;
        }

        return result; // Return the removed value
    }

    // STEP 7: Writing blocks of code
    // Adding helper functions to insert and display the list for testing

    // Add an element at the end of the list
    public void addLast(E value) {
        Node<E> newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
        } else {
            Node<E> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Display the list elements
    public void printList() {
        Node<E> temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Main function to demonstrate all steps
    public static void main(String[] args) {
        NineStepsLinkedList<String> list = new NineStepsLinkedList<>();

        // Adding elements
        list.addLast("10:10:00");
        list.addLast("11:00:00");
        list.addLast("12:12:00");
        list.addLast("9:59:45");

        System.out.println("Before removing first element:");
        list.printList();

        // Removing the first element
        System.out.println("\nRemoving first element: " + list.removeFirst());

        System.out.println("\nAfter removing first element:");
        list.printList();

        // Special Case: Removing until the list is empty
        System.out.println("\nRemoving all elements:");
        while (true) {
            try {
                System.out.println("Removed: " + list.removeFirst());
                list.printList();
            } catch (IllegalStateException e) {
                System.out.println("Error: " + e.getMessage());
                break;
            }
        }
    }
}


/*

----Step 1: Identify Inputs/Outputs
Input: The method removeFirst() operates on a SinglyLinkedList.
Output: Returns the removed element.


----Step 2: BEFORE/AFTER Memory Diagrams
BEFORE: head -> [value, next] -> [value, next] -> null
AFTER: head -> [value, next] -> null (first node is removed)


----Step 3: Generalization
Replaced constants with variables.


----Step 4: Specific Cases
Empty List (Illegal case): Throws an exception.
Singleton List (Special case): Adjusts head correctly.


----Step 5: Handling Special Cases
The method properly handles removing from an empty list and a single-node list.


----Step 6: Writing Test Cases
The main function demonstrates different test cases.


----Step 7: Writing Blocks of Code
Implemented addLast() and printList() methods for testing.


----Step 8: Writing the Method (Unoptimized)
The method is structured to follow the 9 steps approach.


----Step 9: Optimization
Removed redundant variables and improved efficiency.


  */