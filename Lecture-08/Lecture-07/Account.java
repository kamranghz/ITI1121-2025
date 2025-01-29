// Define the Account class with properties and methods
public class Account {
    private String accountName;
    private double balance;

    // Constructor to initialize account name and balance
    public Account(String name, double initialBalance) {
        this.accountName = name;
        this.balance = initialBalance;
    }

    // Method to transfer money from one account to another
    public void transfer(Account recipient, double amount) {
        if (amount <= this.balance && amount > 0) {
            this.balance -= amount; // Deduct the amount from the sender's balance
            recipient.balance += amount; // Add the amount to the recipient's balance
            System.out.printf("%s transferred %f to %s.%n", this.accountName, amount, recipient.accountName);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    // Utility method to print the balance of the account
    public void printBalance() {
        System.out.printf("The balance of %s is %f.%n", this.accountName, this.balance);
    }

    public static void main(String[] args) {
        // Create two accounts
        Account angelina = new Account("Angelina", 100000);
        Account brad = new Account("Brad", 45000);

        // Perform a transfer from Angelina to Brad
        angelina.transfer(brad, 100);
        angelina.printBalance();
        brad.printBalance();

        // Perform a self-transfer for demonstration 
        angelina.transfer(angelina, 100);
        angelina.printBalance();
    }
}
