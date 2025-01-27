// Cat.java
// This class extends Animal and overrides the 'speak' method
// to provide behavior specific to cats.

public class Cat extends Animal {
    // Overridden method: Outputs the sound specific to a cat
    @Override
    public void speak() {
        System.out.println("Meow!"); // Cat's unique sound
    }
}
