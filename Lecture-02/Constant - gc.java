// Class declaration: 'Constant' is a reference type. It acts as a blueprint for creating objects in memory.
public class Constant { 
    // Declares a private field 'name', which is a reference type (String).
    // It will store a memory address pointing to an object in the heap that holds a sequence of characters.
    private String name; 

    // Declares a private field 'value', which is a primitive type (double).
    // It directly holds the numeric value in memory, typically in the heap when part of an object.
    private double value; 

    // Constructor: Initializes an object of the 'Constant' class with the specified name and value.
    // The constructor parameters are stored on the stack temporarily during method execution.
    public Constant(String name, double value) { 
        // The 'this.name' refers to the instance variable of the object being initialized.
        // The provided 'name' parameter is assigned, and it points to a string object in the heap.
        this.name = name; 

        // Assigns the primitive value passed as a parameter to the instance variable 'value'.
        // Since 'value' is primitive, the data is stored directly in memory within the object in the heap.
        this.value = value; 
    }

    // Main method: The entry point of the Java program. It's executed first when the program runs.
    public static void main(String[] args) { 
        // Declares a reference variable 'c' of type 'Constant'.
        // At this stage, 'c' is uninitialized and does not point to any object.
        Constant c; 

        // Allocates memory for a new 'Constant' object in the heap using the 'new' keyword.
        // The reference 'c' points to this memory location. The string "golden ratio" is also stored in the heap.
        // The primitive double 1.62 is stored directly within the 'value' field of the object in the heap.
        c = new Constant("golden ratio", 1.62); 

        // Accesses the fields 'name' and 'value' of the 'Constant' object referenced by 'c'.
        // 'c.name' retrieves the string "golden ratio" from the heap.
        // 'c.value' retrieves the primitive double 1.62 from the object's memory in the heap.
        // Combines the values into a single string and prints it to the console.
        System.out.println(c.name + ": " + c.value); 
    }
}
