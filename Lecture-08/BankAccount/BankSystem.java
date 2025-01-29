class BankSystem {
    public static void sortAccounts(BankAccount[] accounts) {
        if (accounts[0].compareTo(accounts[1]) > 0) {
            BankAccount temp = accounts[0];
            accounts[0] = accounts[1];
            accounts[1] = temp;
        }
    }
}
