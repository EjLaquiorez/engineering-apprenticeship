public class Lesson06Exercise {
    public static void main(String[] args) {
        // Part A — Widening
        int number = 25;
        double decimalNumber = number;

        System.out.println("Part A");
        System.out.println(number);
        System.out.println(decimalNumber);

        // Part B — Narrowing
        double price = 1499.99;
        int wholePrice = (int) price;

        System.out.println("\nPart B");
        System.out.println(price);
        System.out.println(wholePrice);

        // Part C — Negative Number
        double negativeNumber = -10.9;
        int result = (int) negativeNumber;

        System.out.println("\nPart C");
        System.out.println(result);

        // Part D — Division
        double result1 = 10 / 3;
        double result2 = 10.0 / 3;
        double result3 = (double) 10 / 3;

        System.out.println("\nPart D");
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);

        // Part E — Parentheses
        double resultE1 = (double) (10 / 3);
        double resultE2 = (double) 10 / 3;

        System.out.println("\nPart E");
        System.out.println(resultE1);
        System.out.println(resultE2);

        // Part F — char
        char letter = 'A';
        int asciiNumber = letter;

        System.out.println("\nPart F");
        System.out.println(letter);
        System.out.println(asciiNumber);

        int code = 65;
        char converted = (char) code;

        System.out.println(converted);
    }
}
