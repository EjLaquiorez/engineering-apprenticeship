public class Lesson03Exercise {
    public static void main(String[] args) {
        // 1. Age: whole number
        int age = 25;

        // 2. Price: decimal number
        double price = 1499.99;

        // 3. Account status: true or false
        boolean active = true;

        // 4. Grade: single character
        char grade = 'A';

        // 5. Large number: needs long because int is too small
        long largeNumber = 9000000000L;

        System.out.println("Age: " + age);
        System.out.println("Price: " + price);
        System.out.println("Active: " + active);
        System.out.println("Grade: " + grade);
        System.out.println("Large number: " + largeNumber);
    }

    // --- Break It experiments ---
    // These are examples of mistakes Java rejects.
    // They are intentionally commented out so the program still compiles.

    // Experiment 1
    // int number = 10.5;
    // Java error: incompatible types: possible lossy conversion from double to int
    // Reason: int cannot store decimal values.

    // Experiment 2
    // boolean active = 1;
    // Java error: incompatible types: int cannot be converted to boolean
    // Reason: boolean only accepts true/false, not numbers.

    // Experiment 3
    // char grade = "A";
    // Java error: incompatible types: String cannot be converted to char
    // Reason: char stores exactly one character, using single quotes 'A'.

    // Experiment 4
    // byte number = 128;
    // Java error: possible loss of precision
    // Reason: byte ranges from -128 to 127.
}
