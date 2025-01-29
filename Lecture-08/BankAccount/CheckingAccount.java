// Checking Account (inherits from BankAccount)
class CheckingAccount extends BankAccount {
    private double monthlyFee;

    public CheckingAccount(String accountNumber, double balance, double monthlyFee) {
        super(accountNumber, balance);
        this.monthlyFee = monthlyFee;
    }

    // Implement the abstract method
    public void applyMonthlyFee() {
        if (balance >= monthlyFee) {
            balance -= monthlyFee;
            System.out.println("Monthly fee of $" + monthlyFee + " deducted from Checking Account " + accountNumber);
        } else {
            System.out.println("Insufficient funds for monthly fee in " + accountNumber);
        }
    }

    public String toString() {
        return super.toString() + " | Type: Checking | Monthly Fee: $" + monthlyFee;
    }
}
