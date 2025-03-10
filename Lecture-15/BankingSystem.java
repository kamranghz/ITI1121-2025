class BankAccount {
    private double balance;

    // Constructor to initialize account balance
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        System.out.println("Attempting to withdraw $" + amount);

        try {
            // Check if the withdrawal amount is greater than the available balance
            if (amount > balance) {
                throw new IllegalArgumentException("Insufficient funds! Your balance is: $" + balance);
            }

            // Simulating transaction processing
            balance -= amount;
            System.out.println("Withdrawal successful! New balance: $" + balance);

        } catch (IllegalArgumentException e) {
            // Handling insufficient funds
            System.out.println("Transaction Failed: " + e.getMessage());

        } finally {
            // Finally block ensures transaction processing is completed
            System.out.println("Transaction complete. Please take your receipt.");
        }
    }

    // Getter method to check balance
    public double getBalance() {
        return balance;
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        // Creating a bank account with an initial balance of $500
        BankAccount account = new BankAccount(500);

        // Trying to withdraw money
        account.withdraw(200); // Valid withdrawal
        System.out.println();

        account.withdraw(400); // This will trigger an exception
    }
}
