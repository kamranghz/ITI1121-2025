public class Dog extends Animal {
    private String breed; // Additional attribute specific to the Dog class

    // Constructor for the Dog class
    public Dog(String name, String breed) {
        super(name); // Calls the constructor of the superclass (Animal) to set the name
        this.breed = breed; // Initializes the breed specific to the Dog class
    }

    // Getter method to retrieve the breed of the dog
    public String getBreed() {
        return breed;
    }

    // Main method to create objects and test the behavior
    public static void main(String[] args) {
        Dog myDog = new Dog("Buddy", "Golden Retriever"); // Creating a Dog object
        System.out.println("Name: " + myDog.getName()); // Outputs the name of the dog using Animal's getName()
        System.out.println("Breed: " + myDog.getBreed()); // Outputs the breed of the dog
    }
}
