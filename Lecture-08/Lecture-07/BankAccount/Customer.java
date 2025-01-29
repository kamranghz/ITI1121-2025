public class Customer {
    private String name;
    private BankAccount account1;
    private BankAccount account2;

    // Constructor
    public Customer(String name, BankAccount account1, BankAccount account2) {
        this.name = name;
        this.account1 = account1;
        this.account2 = account2;
    }

    // Transfer money between two accounts
    public void transfer(BankAccount from, BankAccount to, double amount) {
        if (from.getBalance() >= amount) {
            from.withdraw(amount);
            to.deposit(amount);
        }
    }

    @Override
    public String toString() {
        return "Customer: " + name + "\nAccount 1: " + account1 + "\nAccount 2: " + account2;
    }
}
