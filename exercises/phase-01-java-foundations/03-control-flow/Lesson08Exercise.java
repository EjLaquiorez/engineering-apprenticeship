public class Lesson08Exercise {
    public static void main(String[] args) {
        // ---------------------------
        // Part A - Basic Comparisons
        // ---------------------------
        int a = 10;
        int b = 20;

        System.out.println("Part A");
        System.out.println("a == b: " + (a == b));
        System.out.println("a != b: " + (a != b));
        System.out.println("a > b: " + (a > b));
        System.out.println("a < b: " + (a < b));
        System.out.println("a >= b: " + (a >= b));
        System.out.println("a <= b: " + (a <= b));

        // ---------------------------
        // Part B - Age
        // ---------------------------
        int age = 18;

        boolean isAdult = age >= 18;
        boolean isExactly18 = age == 18;
        boolean isUnder18 = age < 18;
        boolean isAtLeast18 = age >= 18;
        boolean isOver18 = age > 18;

        System.out.println("\nPart B");
        System.out.println("isAdult: " + isAdult);
        System.out.println("isExactly18: " + isExactly18);
        System.out.println("isUnder18: " + isUnder18);
        System.out.println("isAtLeast18: " + isAtLeast18);
        System.out.println("isOver18: " + isOver18);

        // ---------------------------
        // Part C - Scores
        // ---------------------------
        int score = 75;

        boolean passed = score >= 60;
        boolean perfectScore = score == 100;
        boolean failed = score < 60;

        System.out.println("\nPart C");
        System.out.println("passed: " + passed);
        System.out.println("perfectScore: " + perfectScore);
        System.out.println("failed: " + failed);

        // ---------------------------
        // Part D - Character Comparisons
        // ---------------------------
        char first = 'A';
        char second = 'B';

        System.out.println("\nPart D");
        System.out.println("first == second: " + (first == second));
        System.out.println("first != second: " + (first != second));
        System.out.println("first < second: " + (first < second));
        System.out.println("first > second: " + (first > second));
        System.out.println("first <= second: " + (first <= second));
        System.out.println("first >= second: " + (first >= second));

        // ---------------------------
        // Part E - Break It
        // ---------------------------
        // Experiment 1
        // int age = 18;
        // boolean result = age = 18;
        // This does NOT compile because assignment is not a boolean expression.
        // In Java, = is assignment, not comparison.
        // You must use == to compare equality.

        // Experiment 2
        // boolean result = 10;
        // This does NOT compile because boolean variables only accept true/false.
        // A number cannot be assigned to a boolean.

        // Experiment 3
        // int a = 10;
        // int b = 20;
        // boolean result = a > b;
        // This compiles and evaluates to false.
        // The lesson: valid code is not the same as correct logic.

        // Experiment 4
        // Change int age = 18; to int age = 17;
        // Then these comparisons behave differently:
        // age > 18      -> false
        // age >= 18     -> false
        // age < 18      -> true
        // age <= 18     -> true
        // The operators differ in whether they include the boundary value.
    }
}
