// Class to represent a Car
class Car {
    String brand;
    String model;
    int year;

    // Parameterized constructor
    Car(String brand, String model, int year) {
        this.brand = brand; // Initializing the brand of the car
        this.model = model; // Initializing the model of the car
        this.year = year;   // Initializing the year of the car
    }

    // Method to display car details
    void display() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
    }
}

public class ParameterizedConstructorExample {
    public static void main(String[] args) {
        // Creating an object of Car with specific values
        Car car1 = new Car("Toyota", "Corolla", 2021);
        Car car2 = new Car("Honda", "Civic", 2020);
        
        // Displaying the details
        car1.display();
        car2.display();
    }
}
