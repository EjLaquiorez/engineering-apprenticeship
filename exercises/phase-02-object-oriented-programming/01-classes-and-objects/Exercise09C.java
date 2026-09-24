class BankAccount {
    String ownerName;
    String accountNumber;
    double balance;

    BankAccount(String ownerName, String accountNumber, double balance) {
        this.ownerName = ownerName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void deposit(double amount) {
        balance += amount;
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        }
    }

    void displayBalance() {
        System.out.println("Balance: " + balance);
    }

    void printOwnerName() {
        System.out.println("Owner: " + ownerName);
    }
}