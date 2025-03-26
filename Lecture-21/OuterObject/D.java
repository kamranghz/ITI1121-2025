public class D {
    public static void main(String[] args) {
        A.B.C abc = new A().new B().new C();
        System.out.println("abc.getValue() -> " + abc.getValue());
    }
}