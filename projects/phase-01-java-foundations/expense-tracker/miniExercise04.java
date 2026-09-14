import java.util.Scanner;
public class miniExercise04 {
    public static void main(String[] args) {
        String[] descriptions = new String[3];
        double[] amounts = new double[3];
        int expenseCount = 0;
        try (Scanner scanner = new Scanner(System.in)) {
            for (int i = 0; i < descriptions.length; i++) {
                System.out.print("Enter description: ");
                descriptions[i] = scanner.nextLine();

                System.out.print("Enter amount: ");
                amounts[i] = Double.parseDouble(scanner.nextLine());

            }
        }

        for(int i = 0; i < descriptions.length; i++){
            System.out.println(descriptions[i] + " - " + amounts[i]);

            expenseCount++;
        }
        System.out.println("Expense count: " + expenseCount);
    }
}
