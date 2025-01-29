public class CheckingAccount extends BankAccount {
    private double overdraftLimit;

    // Constructor
    public CheckingAccount(String accountNumber, double balance, double overdraftLimit) {
        super(accountNumber, balance); // Call to the parent class constructor
        this.overdraftLimit = overdraftLimit;
    }

    // New method specific to CheckingAccount
    public boolean withdrawFromChecking(double amount) {
        if (amount > 0 && getBalance() - amount >= -overdraftLimit) {
            withdraw(amount); // Call the parent class's withdraw method
            return true;
        }
        return false; // Indicates insufficient funds
    }

    @Override
    public String toString() {
        return super.toString() + ", Overdraft Limit: " + overdraftLimit;
    }
}
