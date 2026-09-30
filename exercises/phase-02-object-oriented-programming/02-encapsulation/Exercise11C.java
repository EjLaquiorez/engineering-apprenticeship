public class Exercise11C {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        account.deposit(500);
    }
}

class BankAccount {
    private double balance; // Private: outside code cannot change it directly.

    public void deposit(double amount) { // Public: outside code can call it.
        if (amount > 0) {
            balance += amount;
            calculateInterest();
        }
    }

    private void calculateInterest() { // Private: only BankAccount uses this helper.
        balance += balance * 0.01;
    }
}