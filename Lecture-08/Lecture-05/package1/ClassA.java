package package1;

public class ClassA {
    private String message;

    public ClassA(String message) {
        this.message = message;
    }

    public void showMessage() {
        System.out.println("Message from ClassA: " + message);
    }

    public void useHelperA() {
        HelperA helper = new HelperA();
        helper.helperMethod();
    }
}
