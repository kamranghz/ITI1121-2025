class MyInteger {
    int value;

    MyInteger(int value) {
        this.value = value;
    }
}

class Test {
    public static void main(String[] args) {
        MyInteger obj1 = new MyInteger(7); // Object with value 7
        MyInteger obj2 = new MyInteger(99); // Object with value 99

        System.out.println("obj1 value: " + obj1.value); 
        System.out.println("obj2 value: " + obj2.value); 

        obj2 = obj1; // obj2 now points to obj1
        System.out.println("After assignment:");
        System.out.println("obj1 value: " + obj1.value); 
        System.out.println("obj2 value: " + obj2.value); 

        // The object with value 99 is no longer referenced
        System.out.println("Object with value 99 is now eligible for garbage collection.");
		
	

    }
}
