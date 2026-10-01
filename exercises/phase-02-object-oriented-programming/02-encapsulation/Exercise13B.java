public class Exercise13B {

    static class BankAccount {
        private double balance;

        // Create a getter here
        double getBalance(){
            return balance;
        }

        // Create a setter here
        void setBalance(double newBalance){
            balance = newBalance;
        }
    }

    public static void main(String[] args) {

        BankAccount account = new BankAccount();

        // Set the balance to 5000
        account.setBalance(5000);

        // Print the balance
        System.out.println("Balance: " + account.getBalance());

    }
}