import java.util.Scanner;

public class miniExercise {

    public static void main(String[] args) {
        String description = "";
        double amount = 0.0;

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter item description: ");
            description = scanner.nextLine().trim();
            System.out.println("Enter amount: ");
            amount = scanner.nextDouble();
        }

        System.out.println("Description :" + description);
        System.out.println("Amount: P" + amount);
    }
}
