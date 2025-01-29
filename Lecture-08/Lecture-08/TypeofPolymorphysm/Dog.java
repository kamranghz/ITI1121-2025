// Dog.java
// This class extends Animal and overrides the 'speak' method
// to provide behavior specific to dogs.

public class Dog extends Animal {
    // Overridden method: Outputs the sound specific to a dog
    @Override
    public void speak() {
        System.out.println("Woof!"); // Dog's unique sound
    }
}
