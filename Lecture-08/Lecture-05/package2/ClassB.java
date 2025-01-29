package package2;

public class ClassB {
    private String name;

    public ClassB(String name) {
        this.name = name;
    }

    public void displayInfo() {
        System.out.println("Hello from ClassB! My name is " + name);
    }

    public void useHelperB() {
        HelperB helper = new HelperB();
        helper.helperMethod();
    }
}
