import java.util.Scanner;
public class miniExercise05 {
    public static void main(String[] args) {
        String[] descriptions = new String[3];
        double[] amounts = new double[3];
        int expenseCount = 0;

        try (Scanner scanner = new Scanner(System.in)) {
            String option;

            do {
                // Display menu
                System.out.println("=== Expense Tracker ===");
                System.out.println("1. Add Expense");
                System.out.println("2. View Expense");
                System.out.println("3. View Total");
                System.out.println("4. Search Expense");
                System.out.println("5. Exit");

                System.out.print("Choose an option: ");
                option = scanner.nextLine().trim();

                // Validate option
                if (!option.matches("[1-5]")) {
                    System.out.println("Invalid operation.\n");
                    continue;
                }

                switch (option) {
                    case "1":
                        if (expenseCount == descriptions.length) {
                            System.out.println("Expense list is full.\n");
                            continue;
                        }

                        System.out.print("Enter description: ");
                        descriptions[expenseCount] = scanner.nextLine();

                        System.out.print("Enter amount: ");
                        amounts[expenseCount] = Double.parseDouble(scanner.nextLine());

                        expenseCount++;
                        break;

                    case "2":
                        for(int i = 0; i < expenseCount; i++){
                            System.out.println((i + 1) + ". " + descriptions[i] + " - " + amounts[i]);
                        }


                        break;

                    case "3":
                        double totalExpenses = 0;
                        for(int i = 0; i < expenseCount; i++){
                            totalExpenses+= amounts[i];
                        }
                        System.out.println("Total Expenses: " + totalExpenses);
                        break;

                    case "4":
                        System.out.print("Enter a search term: ");
                        String search = scanner.nextLine();
                        boolean foundSearch = false;

                        for (int i = 0; i < expenseCount; i++) {
                            if(descriptions[i].contains(search)){
                                System.out.println(descriptions[i] + " - " + amounts[i]);
                                foundSearch = true;
                            }
                        }

                        if (!foundSearch) {
                            System.out.println("No matching expenses found.");
                        }
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
