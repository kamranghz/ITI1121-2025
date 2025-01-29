public class BankDemo {
    public static void main(String[] args) {
        // Create accounts
        SavingsAccount savings = new SavingsAccount("S001", 5000, 2.5);
        CheckingAccount checking = new CheckingAccount("C001", 2000, 10);

        // Display initial details
        System.out.println("Before applying fees:");
        System.out.println(savings);
        System.out.println(checking);

        // Apply monthly fees
        savings.applyMonthlyFee();
        checking.applyMonthlyFee();

        // Display updated balances
        System.out.println("\nAfter applying fees:");
        System.out.println(savings);
        System.out.println(checking);

        // Sorting accounts
        BankAccount[] accounts = {savings, checking};
        BankSystem.sortAccounts(accounts);

        System.out.println("\nAfter sorting by balance:");
        System.out.println(accounts[0]);
        System.out.println(accounts[1]);
    }
}
