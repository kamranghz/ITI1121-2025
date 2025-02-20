// A class to represent tokens (numbers and symbols) in an arithmetic expression
public class LexicalToken {

    // Constants to classify token types
    private static final int INTEGER = 1;
    private static final int SYMBOL = 2;

    // Attributes to store values
    private int intValue;      // Stores integer values
    private String symbolValue;   // Stores symbol values
    private int type;          // Determines token type

    // Constructor for integer tokens
    public LexicalToken(int intValue) {
        this.intValue = intValue;
        type = INTEGER;
    }

    // Constructor for symbol tokens
    public LexicalToken(String symbolValue) {
        this.symbolValue = symbolValue;
        type = SYMBOL;
    }

    // Getter method for integer values
    public int getIntValue() {
        if (isInteger()) {
            return intValue;
        } else {
            throw new IllegalStateException("This token is not an integer.");
        }
    }

    // Getter method for symbol values
    public String getSymbolValue() {
        if (isSymbol()) {
            return symbolValue;
        } else {
            throw new IllegalStateException("This token is not a symbol.");
        }
    }

    // Method to check if the token is an integer
    public boolean isInteger() {
        return type == INTEGER;
    }

    // Method to check if the token is a symbol
    public boolean isSymbol() {
        return type == SYMBOL;
    }

    // Method to print token information
    @Override
    public String toString() {
        if (isInteger()) {
            return "INTEGER: " + intValue;
        } else {
            return "SYMBOL: " + symbolValue;
        }
    }

    // Main method to test the LexicalToken class
    public static void main(String[] args) {
        // Creating integer and symbol tokens
        LexicalToken token1 = new LexicalToken(42);
        LexicalToken token2 = new LexicalToken("+");

        // Displaying token information
        System.out.println(token1);
        System.out.println(token2);

        // Checking token types
        System.out.println("Is token1 an integer? " + token1.isInteger());
        System.out.println("Is token2 a symbol? " + token2.isSymbol());
    }
}
