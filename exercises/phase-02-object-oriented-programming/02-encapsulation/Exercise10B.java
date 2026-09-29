public class Exercise10B {

    static class BankAccount {
        private double balance;

        BankAccount(double balance){
            this.balance = balance;
        }

        double checkAmount(double amount){
            if(amount > 0 && amount <= balance){
                balance -= amount;
            }
            return balance;
        }
    }

    public static void main(String[] args) {

        BankAccount account = new BankAccount(1000);

        double newBalance = account.checkAmount(1000);

        System.out.println("New balance: " + newBalance);
    }
}