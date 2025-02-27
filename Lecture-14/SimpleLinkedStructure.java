public class SimpleLinkedStructure {
    // Elem class to hold data and a reference to the next element
    static class Elem {
        Object value;
        Elem next;

        // Constructor initializes the element with a value and null next reference
        Elem(Object value) {
            this.value = value;
            this.next = null;
        }
    }

    // Head of the linked structure
    Elem head;

    // Method to add elements to the end of the structure
    public void add(Object value) {
        Elem newElem = new Elem(value);
        if (head == null) {
            head = newElem;
        } else {
            Elem last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newElem;
        }
    }

    // Method to print the linked structure
    public void printStructure() {
        Elem current = head;
        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        SimpleLinkedStructure linkedStructure = new SimpleLinkedStructure();

        // Adding elements to the linked structure
        linkedStructure.add("Monday");
        linkedStructure.add("Wednesday");
        linkedStructure.add("Friday");

        // Display the linked structure
        System.out.println("Linked Structure:");
        linkedStructure.printStructure();
    }
}
