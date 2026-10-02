public class Exercise14B {

    static class BankAccount {
        private double balance;

        double getBalance() {
            return balance;
        }

        void deposit(double amount) {
            if(amount > 0){
                balance += amount;
            }
            else{
                System.out.println("Invalid amount. Please enter a value greater than 0.");
            }

            
        }
    }

    public static void main(String[] args) {

        BankAccount account = new BankAccount();

        account.deposit(1000);

        System.out.println("Balance: " + account.getBalance());
    }
}