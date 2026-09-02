public class Lesson07Exercise {
    public static void main(String[] args) {

        // Part A - Basic Strings
        String firstName = "Justine";
        String lastName = "Laquiorez";
        String language = "Java";

        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(language);

        // Part B - Concatenation
        String fullName = firstName + " " + lastName;
        System.out.println("Full name: " + fullName);

        String message = "I am learning " + language;
        System.out.println(message);

        // Part C - String + Numbers
        int age = 25;
        double price = 1499.99;

        System.out.println("Age: " + age);
        System.out.println("Price: " + price);

        // Part D - String Length
        String word = "Programming";
        System.out.println("Word: " + word);
        System.out.println("Length: " + word.length());

        // Part E - Break It
        // Experiment 1
        // char letter = "A";
        // Error: cannot convert from String to char
        // Why: char stores a single character, but "A" is a String literal.

        // Experiment 2
        // String word2 = 'A';
        // Error: cannot convert from char to String
        // Why: 'A' is a char, not a String. A String requires double quotes.

        // Experiment 3
        String number = "123";
        System.out.println(number + 456);
        // Output: 123456
        // Why: String + number concatenates as text.

        // Experiment 4
        System.out.println(123 + 456);
        // Output: 579
        // Why: both values are numbers, so Java adds them mathematically.

        // Experiment 5
        System.out.println("Result: " + 10 + 5);
        // Output: Result: 105
        // Why: the leftmost String makes concatenation happen left to right.

        System.out.println("Result: " + (10 + 5));
        // Output: Result: 15
        // Why: the parentheses force the addition to happen before concatenation.
    }
}
