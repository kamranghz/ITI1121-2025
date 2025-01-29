public class CreditCard extends BankAccount {
    private double creditLimit;

    // Constructor
    public CreditCard(String accountNumber, double balance, double creditLimit) {
        super(accountNumber, balance);
        this.creditLimit = creditLimit;
    }

    // Withdraw method specific to CreditCard
    public boolean useCredit(double amount) {
        if (amount > 0 && getBalance() - amount >= -creditLimit) {
            withdraw(amount);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + ", Credit Limit: " + creditLimit;
    }
}
