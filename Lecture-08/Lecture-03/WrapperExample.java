public class WrapperExample {
    public static void main(String[] args) {
        // A string containing a numeric value
        String numberAsString = "33";

        // Converting the string to an integer using Integer.parseInt
        int number = Integer.parseInt(numberAsString);

        // Printing the result as an integer
        System.out.println("The number as an integer: " + number);

        // Converting the integer to another data type, e.g., double
        double doubleNumber = (double) number;
        System.out.println("The number as a double: " + doubleNumber);
    }
}
