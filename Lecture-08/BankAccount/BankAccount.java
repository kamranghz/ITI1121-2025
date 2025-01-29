// Abstract class for all bank accounts
abstract class BankAccount {
    protected String accountNumber;
    protected double balance;

    // Constructor
    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Abstract method (must be implemented by subclasses)
    public abstract void applyMonthlyFee();

    // Deposit money into the account
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited $" + amount + " into " + accountNumber);
    }

    // Withdraw money from the account
    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn $" + amount + " from " + accountNumber);
            return true;
        } else {
            System.out.println("Insufficient funds in " + accountNumber);
            return false;
        }
    }

    // Compare accounts based on balance
    public int compareTo(BankAccount other) {
        if (this.balance > other.balance) {
            return 1;
        } else if (this.balance < other.balance) {
            return -1;
        } else {
            return 0;
        }
    }

    // Display account details
    public String toString() {
        return "Account Number: " + accountNumber + " | Balance: $" + balance;
    }
}
