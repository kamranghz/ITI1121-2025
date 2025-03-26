public class A {
    private int value = 99;

    public class B {
        private int value;

        public B() {
            this.value = A.this.value + 1;
        }

        public class C {
            private int value;

            public C() {
                this.value = B.this.value + 1;
            }

            public int getValue() {
                System.out.println("A.this.value = " + A.this.value);
                System.out.println("B.this.value = " + B.this.value);
                System.out.println("this.value = " + this.value);
                return value;
            }
        }
    }
}
