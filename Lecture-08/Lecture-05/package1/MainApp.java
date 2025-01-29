package package1;

// Importing ClassB from package2
import package2.ClassB;

public class MainApp {
    public static void main(String[] args) {
        // Using ClassA and HelperA from package1
        ClassA classA = new ClassA("Hello from package1!");
        classA.showMessage();
        classA.useHelperA();

        // Using ClassB and HelperB from package2
        ClassB classB = new ClassB("ClassB from package2");
        classB.displayInfo();
        classB.useHelperB();
    }
}
