public class PrimitiveTypesExample {

    public static void main(String[] args) {
        // byte: 8-bit integer. Range: -128 to 127.
        byte byteValue = 100;
        System.out.println("byte size: 1 byte, Range: -128 to 127, Example value: " + byteValue);

        // short: 16-bit integer. Range: -32,768 to 32,767.
        short shortValue = 30000;
        System.out.println("short size: 2 bytes, Range: -32,768 to 32,767, Example value: " + shortValue);

        // int: 32-bit integer. Range: -2^31 to 2^31-1.
        int intValue = 100000;
        System.out.println("int size: 4 bytes, Range: -2^31 to 2^31-1, Example value: " + intValue);

        // long: 64-bit integer. Range: -2^63 to 2^63-1.
        long longValue = 10000000000L; // 'L' suffix indicates long literal
        System.out.println("long size: 8 bytes, Range: -2^63 to 2^63-1, Example value: " + longValue);

        // float: 32-bit floating-point. Approximate range: ±3.40282347E+38F.
        float floatValue = 3.14F; // 'F' suffix indicates float literal
        System.out.println("float size: 4 bytes, Example value: " + floatValue);

        // double: 64-bit floating-point. Approximate range: ±1.79769313486231570E+308.
        double doubleValue = 3.141592653589793;
        System.out.println("double size: 8 bytes, Example value: " + doubleValue);

        // char: 16-bit Unicode character. Range: 0 to 65,535.
        char charValue = 'A';
        System.out.println("char size: 2 bytes, Range: 0 to 65,535, Example value: " + charValue);

        // boolean: 1-bit logical value. Only true or false.
        boolean booleanValue = true;
        System.out.println("boolean size: ~1 bit (not precisely defined), Example value: " + booleanValue);
    }
}
