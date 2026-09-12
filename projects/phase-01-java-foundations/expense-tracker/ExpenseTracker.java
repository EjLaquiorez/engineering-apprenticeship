import java.util.Scanner;

public class ExpenseTracker {

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
                        addExpense();
                        break;
                    case "2":
                        viewExpenses();
                        break;
                    case "3":
                        viewTotal();
                        break;
                    case "4":
                        searchExpenses();
                        break;
                    default:
                        System.out.println("Invalid operation.");
                }
            }
        }
    }

    static void addExpense() {
        System.out.println("Add Expense selected.");
        // Add expense logic here
    }

    static void viewExpenses() {
        System.out.println("View Expenses selected.");
        // View expenses logic here
    }

    static void viewTotal() {
        System.out.println("View Total selected.");
        // Calculate and display total here
    }

    static void searchExpenses() {
        System.out.println("Search Expenses selected.");
        // Search expenses logic here
    }
}
