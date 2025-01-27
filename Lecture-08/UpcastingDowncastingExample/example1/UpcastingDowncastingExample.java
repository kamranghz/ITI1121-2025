// Parent class (Base class)
class Animal {
    public void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

// Child class (Derived class)
class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Dog barks");
    }

    // Specific method for Dog class
    public void fetch() {
        System.out.println("Dog is fetching the ball");
    }
}

public class UpcastingDowncastingExample {
    public static void main(String[] args) {
        // Upcasting: Assigning a Dog object to an Animal reference
        Animal animal = new Dog(); // Upcasting happens here
        animal.makeSound(); // Calls the overridden method in Dog class

        // Downcasting: Casting an Animal reference back to Dog
        if (animal instanceof Dog) { // Safe check before downcasting
            Dog dog = (Dog) animal; // Downcasting happens here
            dog.makeSound(); // Calls the overridden method in Dog class
            dog.fetch(); // Calls the method specific to Dog class
        } else {
            System.out.println("Downcasting not possible");
        }
    }
}
