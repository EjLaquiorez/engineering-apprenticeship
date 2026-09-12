import java.util.Scanner;

public class Calculator {
    
    public static void main(String[] args) {
        displayOperation();
    }

    static int getNumber(Scanner scanner, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine().trim();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter valid whole numbers.");
            }
        }
    }

    static void displayOperation() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {

                // Display menu
                System.out.println("=== Calculator ===");
                System.out.println("1. Add");
                System.out.println("2. Subtract");
                System.out.println("3. Multiply");
                System.out.println("4. Divide");
                System.out.println("Type 'exit' to quit");

                // Get operation
                System.out.print("Choose an operation: ");
                String operation = scanner.nextLine().trim();

                // Exit calculator
                if (operation.equalsIgnoreCase("exit")) {
                    break;
                }

                // Validate operation
                if (!operation.matches("[1-4]")) {
                    System.out.println("Invalid operation.\n");
                    continue;
                }

                // Variables must be declared outside the try
                // so they can be used after the try/catch.
                int firstNumber;
                int secondNumber;

                // Get and validate numbers
                firstNumber = getNumber(scanner, "Enter first number: ");
                secondNumber = getNumber(scanner, "Enter second number: ");

                // Perform operation after we know
                // both numbers are valid.
                performOperation(operation, firstNumber, secondNumber);

                System.out.println();
            }
        }

        System.out.println("Calculator closed.");
    }

    static void performOperation(String operation, int firstNumber, int secondNumber) {
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
