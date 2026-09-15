import java.util.Scanner;

public class ExpenseTracker {

    static final int MAX_EXPENSES = 3;
    static final String[] descriptions = new String[MAX_EXPENSES];
    static final double[] amounts = new double[MAX_EXPENSES];
    static int expenseCount = 0;

    public static void main(String[] args) {
        displayChoices();
    }

    static void displayChoices() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("=== Expense Tracker ===");
                System.out.println("1. Add Expense");
                System.out.println("2. View Expenses");
                System.out.println("3. View Total");
                System.out.println("4. Search Expenses");
                System.out.println("5. Exit");

                System.out.print("Choose an option: ");
                String operation = scanner.nextLine().trim();

                if (operation.equalsIgnoreCase("exit") || operation.equals("5")) {
                    System.out.println("Expense tracker closed.");
                    break;
                }

                switch (operation) {
                    case "1":
                        addExpense(scanner);
                        break;
                    case "2":
                        viewExpenses();
                        break;
                    case "3":
                        viewTotal();
                        break;
                    case "4":
                        searchExpenses(scanner);
                        break;
                    default:
                        System.out.println("Invalid operation.");
                }
            }
        }
    }

    static void addExpense(Scanner scanner) {
        if (expenseCount == MAX_EXPENSES) {
            System.out.println("Expense limit reached.");
            return;
        }

        System.out.print("Enter a description: ");
        String description = scanner.nextLine().trim();
        while (description.isEmpty()) {
            System.out.print("Description cannot be empty. Enter a description: ");
            description = scanner.nextLine().trim();
        }

        double amount = readAmount(scanner);
        descriptions[expenseCount] = description;
        amounts[expenseCount] = amount;
        expenseCount++;
        System.out.println("Expense added.");
    }

    static void viewExpenses() {
        if (expenseCount == 0) {
            System.out.println("No expenses recorded.");
            return;
        }

        for (int index = 0; index < expenseCount; index++) {
            System.out.printf("%d. %s - $%.2f%n", index + 1, descriptions[index], amounts[index]);
        }
    }

    static void viewTotal() {
        double total = 0;
        for (int index = 0; index < expenseCount; index++) {
            total += amounts[index];
        }
        System.out.printf("Total expenses: $%.2f%n", total);
    }

    static void searchExpenses(Scanner scanner) {
        System.out.print("Enter a description to search for: ");
        String searchTerm = scanner.nextLine().trim().toLowerCase();
        boolean found = false;

        for (int index = 0; index < expenseCount; index++) {
            if (descriptions[index].toLowerCase().contains(searchTerm)) {
                System.out.printf("%d. %s - $%.2f%n", index + 1, descriptions[index], amounts[index]);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching expenses found.");
        }
    }

    static double readAmount(Scanner scanner) {
        while (true) {
            System.out.print("Enter the amount: ");
            String input = scanner.nextLine().trim();
            try {
                double amount = Double.parseDouble(input);
                if (amount >= 0) {
                    return amount;
                }
            } catch (NumberFormatException ignored) {
            }
            System.out.println("Enter a valid non-negative amount.");
        }
    }
}
