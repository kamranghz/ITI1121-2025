// Class to represent a Person
class Person {
    String name;
    int age;

    // Default constructor (automatically called when an object is created)
    Person() {
        name = "Unknown"; // Setting default name
        age = 0;          // Setting default age
    }

    // Method to display details of the person
    void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

public class DefaultConstructorExample {
    public static void main(String[] args) {
        // Creating an object of Person using the default constructor
        Person person1 = new Person();
        
        // Displaying the details
        person1.display(); // Output: Name: Unknown, Age: 0
    }
}
