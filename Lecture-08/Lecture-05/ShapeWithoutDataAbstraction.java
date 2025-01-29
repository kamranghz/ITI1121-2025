public class ShapeWithoutDataAbstraction {
    public static void main(String[] args) {
        String shape = "Circle";

        if (shape.equals("Circle")) {
            System.out.println("Drawing a Circle");
        } else if (shape.equals("Square")) {
            System.out.println("Drawing a Square");
        } else {
            System.out.println("Unknown Shape");
        }
    }
}

