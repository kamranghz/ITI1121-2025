public class SimpleBankAccount {
    // Class variable: shared among all accounts
    private static double interestRate = 0.05; // 5% interest rate for all accounts

    // Instance variables: unique to each account
    private String accountHolder; // Name of the account holder
    private double balance; // Current balance of the account

    // Constructor to initialize instance variables
    public SimpleBankAccount(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder; // Assign name to the instance
        this.balance = initialBalance; // Assign initial balance to the instance
    }

    // Instance method: Calculate the interest for this specific account
    public double calculateInterest() {
        return balance * interestRate; // Uses the shared interest rate
    }

    // Class method: Set the interest rate (affects all accounts)
    public static void setInterestRate(double newRate) {
        interestRate = newRate; // Update the shared interest rate
    }

    // Instance method: Display account details
    public void displayAccountDetails() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Current Balance: " + balance);
        System.out.println("Interest Rate: " + interestRate);
    }

    public static void main(String[] args) {
        // Create two instances of SimpleBankAccount
        SimpleBankAccount account1 = new SimpleBankAccount("Alice", 1000);
        SimpleBankAccount account2 = new SimpleBankAccount("Bob", 2000);

        // Display details of both accounts
        account1.displayAccountDetails();
        account2.displayAccountDetails();

        // Update the class variable (shared interest rate)
        SimpleBankAccount.setInterestRate(0.06); // Change interest rate to 6%

        // Display details after changing interest rate
        System.out.println("\nAfter changing interest rate:");
        account1.displayAccountDetails();
        account2.displayAccountDetails();
    }
}



