public class Exercise10C {

    private static class BankAccount {
        private double balance;

        private BankAccount(double balance) {
            if (balance < 0) {
                throw new IllegalArgumentException("Initial balance cannot be negative.");
            }
            this.balance = balance;
        }

        public double getBalance() {
            return balance;
        }

        public double checkAmount(double amount) {
            if (amount <= 0) {
                throw new IllegalArgumentException("Withdrawal amount must be greater than zero.");
            }
            if (amount > balance) {
                throw new IllegalArgumentException("Insufficient funds.");
            }

            balance -= amount;
            return balance;
        }
    }

    public static void main(String[] args) {

        BankAccount account = new BankAccount(1000);

        double newBalance = account.checkAmount(1000);

        System.out.println("New balance: " + newBalance);
    }
}