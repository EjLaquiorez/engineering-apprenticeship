public class Exercise10A {

    static class BankAccount {
        double balance;
    }

    public static void main(String[] args) {

        BankAccount account = new BankAccount();

        account.balance = 1000;
        account.balance = -500;

        System.out.println("Balance: " + account.balance);
    }
}