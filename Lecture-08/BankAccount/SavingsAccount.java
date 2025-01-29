// Savings Account (inherits from BankAccount)
class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    // Implement the abstract method
    public void applyMonthlyFee() {
        double interest = balance * (interestRate / 100);
        balance += interest;
        System.out.println("Interest of $" + interest + " applied to Savings Account " + accountNumber);
    }

    public String toString() {
        return super.toString() + " | Type: Savings | Interest Rate: " + interestRate + "%";
    }
}
