import java.util.Scanner;

public class Calculator {
    
    public static void main(String[] args) {
        displayOperation();
    }

    static void displayOperation() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("=== Calculator ===");
                System.out.println("1. Add");
                System.out.println("2. Subtract");
                System.out.println("3. Multiply");
                System.out.println("4. Divide");
                System.out.println("Type 'exit' to quit");

                System.out.print("Choose an operation: ");
                String operation = scanner.nextLine().trim();

                if (operation.equalsIgnoreCase("exit")) {
                    break;
                }

                if (!operation.matches("[1-4]")) {
                    System.out.println("Invalid operation.\n");
                    continue;
                }

                try {
                    System.out.print("Enter the first number: ");
                    int firstNumber = Integer.parseInt(scanner.nextLine().trim());
                    System.out.print("Enter the second number: ");
                    int secondNumber = Integer.parseInt(scanner.nextLine().trim());

                    switch (operation) {
                        case "1":
                            System.out.println("Result: " + addition(firstNumber, secondNumber));
                            break;
                        case "2":
                            System.out.println("Result: " + subtraction(firstNumber, secondNumber));
                            break;
                        case "3":
                            System.out.println("Result: " + multiplication(firstNumber, secondNumber));
                            break;
                        case "4":
                            if (secondNumber == 0) {
                                System.out.println("Cannot divide by zero.");
                            } else {
                                System.out.println("Result: " + division(firstNumber, secondNumber));
                            }
                            break;
                        default:
                            break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Please enter valid whole numbers.");
                }

                System.out.println();
            }
        }

        System.out.println("Calculator closed.");
    }
    static int addition (int a, int b){
        return a + b;
    }

    static int subtraction (int a, int b){
        return a - b;
    }

    static double division (int a, int b){
        return (double) a / b;
    }

    static int multiplication (int a, int b){
        return a * b;
    }

}
