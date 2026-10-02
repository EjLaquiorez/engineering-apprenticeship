public class Exercise15C {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        account.deposit(100.0);
        System.out.println("Balance after deposit: $" + account.getBalance());

        account.withdraw(30.0);
        System.out.println("Balance after withdrawal: $" + account.getBalance());

        account.withdraw(200.0);
        System.out.println("Balance after invalid withdrawal: $" + account.getBalance());
    }
}

class BankAccount {

    private double balance;

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }
}