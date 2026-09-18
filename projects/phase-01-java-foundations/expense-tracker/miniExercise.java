import java.util.Scanner;
public class miniExercise {
    public static void main(String[] args){
        String[] descriptions = new String[3];
        double[] amounts = new double[3];
        int expenseCount = 0;
        try (Scanner scanner = new Scanner(System.in)) {
            
            while (true) {
                System.out.print("Enter description: ");
                descriptions[expenseCount] = scanner.nextLine().trim();
                if (!descriptions[expenseCount].isEmpty()) {
                    break;
                }
                System.out.println("Description cannot be empty. Try again.");
                System.out.println("-------------------");
            }

            while (true) {
                try {
                    System.out.println("Enter amount");
                    String amountInput = scanner.nextLine().trim();
                    if (amountInput.isEmpty()) {
                        System.out.println("Amount cannot be empty. Try again.");
                        continue;
                    }
                    double amount = Double.parseDouble(amountInput);
                    if (!Double.isFinite(amount)) {
                        throw new NumberFormatException();
                    }
                    if (amount <= 0) {
                        System.out.println("Amount must be greater than 0. Try again.");
                        continue;
                    }
                    amounts[expenseCount] = amount;
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid amount. Try again.");
                }
            }

            expenseCount++;
            System.out.println("Amount accepted: " + amounts[expenseCount - 1]);
            System.out.println(expenseCount);
        }
    }
}
