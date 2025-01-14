public class ReferenceTypes {

    public static void main(String[] args) {
        // Example 1: String (Reference Type)
        // A String is used to store text.
        String name = "John";
        System.out.println("This is an example of a String as a reference type."); 
        System.out.println("String name = \"John\";"); 
        System.out.println("Hello, " + name + "!"); 
        System.out.println("The length of the name is: " + name.length()); 

        // Example 2: Array (Reference Type)
        // An Array is used to store multiple values of the same type.
        int[] numbers = {5, 10, 15}; // Array of integers
        System.out.println("\nThis is an example of an Array as a reference type."); 
        System.out.println("Array elements: {5, 10, 15}"); 
        System.out.println("The first number in the array is: " + numbers[0]); 
        System.out.println("The second number in the array is: " + numbers[1]); 
        System.out.println("The third number in the array is: " + numbers[2]); 
    }
}
