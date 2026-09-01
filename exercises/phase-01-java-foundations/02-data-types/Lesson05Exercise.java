public class Lesson05Exercise {
    public static void main(String[] args) {
        // Part A — Characters
        char firstLetter = 'J';
        char secondLetter = 'A';
        char digit = '5';
        char symbol = '$';

        System.out.println("Part A");
        System.out.println(firstLetter);
        System.out.println(secondLetter);
        System.out.println(digit);
        System.out.println(symbol);

        // Part B — Character Values
        char letter = 'A';

        System.out.println("\nPart B");
        System.out.println(letter);
        System.out.println(letter + 1); // 66, because char is stored as a number

        // Part C — Boolean Variables
        boolean isJavaFun = true;
        boolean isJavaDifficult = false;

        System.out.println("\nPart C");
        System.out.println(isJavaFun);
        System.out.println(isJavaDifficult);

        // Part D — Boolean Expressions
        int age = 25;
        boolean isAdult = age >= 18;
        boolean isTeenager = age >= 13 && age <= 19;
        boolean isExactly25 = age == 25;

        System.out.println("\nPart D");
        System.out.println(isAdult);
        System.out.println(isTeenager);
        System.out.println(isExactly25);

        // Part E — Comparison Investigation
        int a = 10;
        int b = 20;

        System.out.println("\nPart E");
        System.out.println(a == b);
        System.out.println(a != b);
        System.out.println(a > b);
        System.out.println(a < b);
        System.out.println(a >= 10);
        System.out.println(b <= 20);

        // Part F — Character Investigation
        char c = 'A';
        char d = 'B';

        System.out.println("\nPart F");
        System.out.println(c == d);
        System.out.println(c < d);
        System.out.println(c > d);
    }
}