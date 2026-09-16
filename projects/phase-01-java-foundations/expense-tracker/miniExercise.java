import java.util.Scanner;
public class miniExercise {
    public static void main(String[] args){
        String[] descriptions = new String[3];
        double[] amounts = new double[3];
        int expenseCount = 0;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter description");
        while (true) {
            descriptions[0] = scanner.nextLine().trim();
            if (!descriptions[0].isEmpty()) {
                break;
            }
            System.out.println("Description cannot be empty. Try again.");
        }
        try {
            while (true) {
                try {
                    System.out.println("Enter amount");
                    amounts[0] = Double.parseDouble(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid amount. Try again.");
                }
            }
        }
        expenseCount++;
        System.out.println("Amount accepted: " + amounts[0]);        
        System.out.println(expenseCount);
    }
}
