public class Exercise15D {
    static class BankAccount {

        private double balance;
        private String accountName;

        public BankAccount(String accountName) {
            this.accountName = accountName;
            this.balance = 0;
        }

        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
            } else {
                System.out.println("Invalid amount: must be greater than 0.");
            }
        }

        public void withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
            } else {
                System.out.println(
                        "Invalid amount: must be greater than 0 and less than or equal to the current balance.");
            }
        }

        public void showAccount() {
            System.out.println(accountName + ": " + balance);
        }
    }

    public static void main(String[] args) {
        BankAccount bankAccount1 = new BankAccount("Savings");

        bankAccount1.deposit(200);
        bankAccount1.withdraw(50);
        bankAccount1.showAccount();
    }
}
