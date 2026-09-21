public class Exercise06C {

    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        account.deposit(100);
        account.withdraw(25);
        System.out.println(account.balance);
    }

    static class BankAccount{
        
        Double balance = 0.0;
        
        double deposit(double amount){
            balance+= amount;
            return balance;
        }

        double withdraw(double amount){
            if(checkBalance(amount)){
                balance -= amount;
            }
            return balance;
        }

        boolean checkBalance(double amount){
            if(amount > balance){
                System.out.println("Not enough balance.");
                return false;
            }
            return true;
        }
    }
}
