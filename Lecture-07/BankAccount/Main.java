public class Main {
    public static void main(String[] args) {
        // Create accounts
        CheckingAccount checking = new CheckingAccount("CHK001", 500, 200);
        SavingsAccount savings = new SavingsAccount("SAV001", 1000, 3.5);
        CreditCard creditCard = new CreditCard("CRD001", 0, 1500);

        // Create customers
        Customer customer1 = new Customer("Alice", checking, savings);
        Customer customer2 = new Customer("Bob", savings, creditCard);

        // Perform operations
        System.out.println("Initial State:");
        System.out.println(customer1);
        System.out.println(customer2);

        // Perform some transactions
        System.out.println("\nAlice withdraws $300 from checking:");
        checking.withdrawFromChecking(300);
        System.out.println(customer1);

        System.out.println("\nBob adds interest to savings:");
        savings.addInterest();
        System.out.println(customer2);

        System.out.println("\nAlice transfers $200 from savings to checking:");
        customer1.transfer(savings, checking, 200);
        System.out.println(customer1);
    }
}
