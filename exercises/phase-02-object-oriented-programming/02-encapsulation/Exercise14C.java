public class Exercise14C {

    static class BankAccount {
        private double balance;

        double getBalance() {
            return balance;
        }

        void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
            } else {
                System.out.println("Invalid amount. Please enter a value greater than 0.");
            }

        }

        void withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
            } else {
                System.out.println("Unable to withdraw. Please enter a valid amount within the available balance.");
            }
        }
    }

    public static void main(String[] args) {

        BankAccount account = new BankAccount();

        account.deposit(1000);
        account.withdraw(300);
        System.out.println(account.getBalance());

        account.withdraw(800);
        System.out.println("Balance: " + account.getBalance());
    }
}