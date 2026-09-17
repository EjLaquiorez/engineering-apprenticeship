import java.util.Scanner;
public class ExpenseTrackerPractice {

    static void displayMenu(){
        // Display menu
        System.out.println("=== Expense Tracker ===");
        System.out.println("1. Add Expense");
        System.out.println("2. View Expense");
        System.out.println("3. View Total");
        System.out.println("4. Search Expense");
        System.out.println("5. Exit");
    }

    static int addExpense(Scanner scanner, String[] descriptions, double[] amounts, int expenseCount){

        if (expenseCount == descriptions.length) {
            System.out.println("Expense list is full.\n");
            return expenseCount;
        }

        while (true) {
            System.out.print("Enter description: ");
            descriptions[expenseCount] = scanner.nextLine().trim();

            if (!descriptions[expenseCount].isEmpty()) {
                break;
            }

            System.out.println("Description cannot be empty. Try again.");
        }

        while (true) {
            try {
                System.out.print("Enter amount: ");
                String amountInput = scanner.nextLine().trim();
                if (amountInput.isEmpty()) {
                    System.out.println("Amount cannot be empty. Try again.");
                    continue;
                }

                double amount = Double.parseDouble(amountInput);
                if (!Double.isFinite(amount) || amount <= 0) {
                    System.out.println("Amount must be greater than zero. Try again.");
                    continue;
                }

                amounts[expenseCount] = amount;
                return expenseCount + 1;
            } catch (NumberFormatException e) {
                System.out.println("Invalid amount. Try again.");
            }
        }
    }

    static void viewExpenses(String[] descriptions, double[] amounts, int expenseCount) {
        for (int i = 0; i < expenseCount; i++) {
            System.out.println((i + 1) + ". " + descriptions[i] + " - " + amounts[i]);
        }
    }

    static double calculateTotal(double[] amounts, int expenseCount) {
        double totalExpenses = 0;
        for (int i = 0; i < expenseCount; i++) {
            totalExpenses += amounts[i];
        }
        return totalExpenses;
    }

    static void searchExpenses(Scanner scanner, String[] descriptions, double[] amounts, int expenseCount){
        System.out.print("Enter a search term: ");
        String search = scanner.nextLine().trim();
        boolean foundSearch = false;

        for (int i = 0; i < expenseCount; i++) {
            if (descriptions[i].contains(search)) {
                System.out.println(descriptions[i] + " - " + amounts[i]);
                foundSearch = true;
            }
        }

        if (!foundSearch) {
            System.out.println("No matching expenses found.");
        }
    }
    
    public static void main(String[] args) {
        String[] descriptions = new String[3];
        double[] amounts = new double[3];
        int expenseCount = 0;

        try (Scanner scanner = new Scanner(System.in)) {
            String option;

            do {
                displayMenu();

                System.out.print("Choose an option: ");
                if(!scanner.hasNextLine()){
                    break;
                }
                option = scanner.nextLine().trim();

                // Validate option
                if (!option.matches("[1-5]")) {
                    System.out.println("Invalid operation.\n");
                    continue;
                }

                switch (option) {
                    case "1":
                        expenseCount = addExpense(scanner, descriptions, amounts, expenseCount);
                        break;

                    case "2":
                        viewExpenses(descriptions, amounts, expenseCount);
                        break;

                    case "3":
                        double totalExpenses = calculateTotal(amounts, expenseCount);
                        System.out.println("Total Expenses: " + totalExpenses);
                        break;

                    case "4":
                        searchExpenses(scanner, descriptions, amounts, expenseCount);
                        break;

                    case "5":
                        System.out.println("Exiting...");
                        break;

                }
            } while (!option.equals("5"));
        }
        System.out.println("Goodbye!");
    }
    
}
