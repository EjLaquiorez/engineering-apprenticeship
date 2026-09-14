import java.util.Scanner;
public class miniExercise05 {
    public static void main(String[] args) {
        String[] descriptions = new String[3];
        double[] amounts = new double[3];

        try (Scanner scanner = new Scanner(System.in)) {
            String option;

            do {
                // Display menu
                System.out.println("=== Expense Tracker ===");
                System.out.println("1. Add Expense");
                System.out.println("2. View Expense");
                System.out.println("3. Exit");

                System.out.print("Choose an option: ");
                option = scanner.nextLine().trim();

                // Validate option
                if (!option.matches("[1-3]")) {
                    System.out.println("Invalid operation.\n");
                    continue;
                }
            } while (!option.equals("3"));
        }
    }
}
