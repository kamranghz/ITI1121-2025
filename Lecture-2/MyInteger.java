// This class defines a custom object 'MyInteger' that contains an integer value.
public class MyInteger { 
    int value; // An instance variable of type int (primitive), part of the object stored in the heap.

    // Constructor to initialize the object with a specific integer value.
    public MyInteger(int value) { 
        this.value = value; // Assigns the provided value to the instance variable 'value'.
    }

    // Main method: Entry point of the program.
    public static void main(String[] args) { 
        // Creates a new object of type MyInteger with the initial value 33.
        // The object is stored in the heap, and its reference is stored in the variable 'i' on the stack.
        MyInteger i = new MyInteger(33); 

        // Accesses the 'value' field of the object referenced by 'i' and increments it by 1.
        // The value changes from 33 to 34.
        i.value++; // 'i.value' is now 34 because primitives (like int) directly store the value in memory.

        // Prints the updated value of the 'value' field through the 'i' reference.
        // This directly accesses the 'value' field in the heap where the object is stored.
        System.out.println(i.value); // Output: 34

        // Creates a new reference 'j' and assigns it the reference stored in 'i'.
        // Both 'i' and 'j' now point to the same object in the heap.
        MyInteger j = i; 

        // Accesses the same 'value' field in the heap through the 'j' reference and increments it by 1.
        // Since both 'i' and 'j' refer to the same object, the modification is reflected for both.
        j.value++; // 'value' in the heap is now 35 because 'j' and 'i' share the same object reference.

        // Accesses the 'value' field again through the 'i' reference and prints its value.
        // The 'i.value' now reflects the increment made via 'j' because both references point to the same object.
        System.out.println(i.value); // Output: 35
    }
}
