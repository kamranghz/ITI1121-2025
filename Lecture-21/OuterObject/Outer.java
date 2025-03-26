public class Outer {
    private int value = 99;

    public class Inner {
        private int value;

        public Inner() {
            this.value = Outer.this.value + 1;
        }

        public int getValue() {
            return value;
        }
    }

    public Inner newInner() {
        return new Inner();
    }

    public int getValue() {
        return value;
    }
}
