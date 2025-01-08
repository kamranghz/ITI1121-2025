public class ByteMultiplicationExamples {
    public static void main(String[] args) {
        // Example 1: Result within byte range
        byte flag1 = 5;      // 1 byte
        byte formula1 = 6;   // 1 byte
        byte result1 = (byte) (flag1 * formula1); // 1 byte for result
        System.out.println("Example 1: Result within byte range -> " + result1 + " (1 byte result)");

        // Example 2: Result exceeds byte range
        byte flag2 = 12;     // 1 byte
        byte formula2 = 15;  // 1 byte
        int result2 = flag2 * formula2; // 4 bytes for result (int)
        System.out.println("Example 2: Result exceeds byte range -> " + result2 + " (4 bytes for result)");

        // Example 3: Using double for result to handle larger values
        byte flag3 = 12;     // 1 byte
        byte formula3 = 15;  // 1 byte
        double result3 = flag3 * formula3; // 8 bytes for result (double)
        System.out.println("Example 3: Result using double -> " + result3 + " (8 bytes for result)");
    }
}
