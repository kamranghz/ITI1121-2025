public class TestAccessOuterObject {
    public static void main(String[] args) {
        Outer o = new Outer();
        System.out.println("o.getValue() -> " + o.getValue());

        Outer.Inner i = o.newInner();
        System.out.println("i.getValue() -> " + i.getValue());

        System.out.println("o.getValue() -> " + o.getValue());
    }
}
