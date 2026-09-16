import java.util.Scanner;
public class miniExercise {
    public static void main(String[] args){
        String[] descriptions = new String[3];
        double[] amounts = new double[3];
        int expenseCount = 0;

        try (Scanner scanner = new Scanner(System.in)) {
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
        System.out.println("Amount accepted: " + amounts[0]);
    
    }
}
