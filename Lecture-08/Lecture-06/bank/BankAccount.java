package bank;

public class BankAccount {
    // Private variables: Only accessible within this class
    private String accountNumber; // Confidential account number
    private double balance;       // Private balance of the account

    // Default (package-private) variable: Accessible within the same package
    String bankBranch = "Default Branch"; // Branch name, default access

    // Protected variable: Accessible within the same package or by future subclasses
    protected String accountHolderName; // Account holder's name

    // Public final variable: Accessible everywhere, cannot be changed
    public final String bankName = "National Bank";

    // Constructor: Initializes the account
    public BankAccount(String accountNumber, double initialBalance, String accountHolderName) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.accountHolderName = accountHolderName;
    }

    // Public method to deposit money
    public final void deposit(double amount) { // Final to prevent modification
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited $" + amount + ". New balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // Public method to withdraw money
    public final void withdraw(double amount) { // Final to ensure core functionality isn't altered
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew $" + amount + ". Remaining balance: $" + balance);
        } else {
            System.out.println("Withdrawal failed! Insufficient funds or invalid amount.");
        }
    }

    // Public method to check the balance (getter)
    public double getBalance() {
        return balance;
    }

    // Protected method to display account holder information
    protected void displayAccountHolderInfo() {
        System.out.println("Account Holder: " + accountHolderName);
    }

    // Private method to display confidential information
    private void displayConfidentialInfo() {
        System.out.println("Account Number: " + accountNumber);
    }

    // Public method to provide controlled access to the private method
    public void showConfidentialInfo() {
        displayConfidentialInfo();
    }

    // Default (package-private) method to display branch details
    void displayBranchInfo() {
        System.out.println("Bank Branch: " + bankBranch);
    }

    // Main method to test functionality
    public static void main(String[] args) {
        // Create a BankAccount object
        BankAccount account = new BankAccount("123456789", 5000.0, "John Doe");

        // Access public variables and methods
        System.out.println("Bank Name: " + account.bankName);
        account.deposit(1000.0); // Deposit money
        account.withdraw(2000.0); // Withdraw money
        System.out.println("Balance: $" + account.getBalance()); // Check balance

        // Access protected method
        account.displayAccountHolderInfo(); // Show account holder info

        // Access private method indirectly
        account.showConfidentialInfo(); // Displays account number

        // Access default (package-private) method
        account.displayBranchInfo(); // Show branch info
    }
}
