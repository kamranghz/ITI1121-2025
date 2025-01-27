public class SavingsAccount extends BankAccount {
    private double interestRate;

    // Constructor
    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance); // Call to the parent class constructor
        this.interestRate = interestRate;
    }

    // Method to add interest to the balance
    public void addInterest() {
        deposit(getBalance() * interestRate / 100); // Increase the balance with interest
    }

    @Override
    public String toString() {
        return super.toString() + ", Interest Rate: " + interestRate + "%";
    }
}
