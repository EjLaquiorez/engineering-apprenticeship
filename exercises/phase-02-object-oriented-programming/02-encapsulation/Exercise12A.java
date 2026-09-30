public class Exercise12A {

    static class BankAccount {
        private double balance;

        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
            }
        }

        public double getBalance() {
            return balance;
        }
    }

    public static void main(String[] args) {

        BankAccount account = new BankAccount();

        account.deposit(1000);

        System.out.println("Balance: " + account.getBalance());
        
    }
}