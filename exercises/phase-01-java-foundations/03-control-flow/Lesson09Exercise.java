public class Lesson09Exercise {
    public static void main(String[] args) {
        System.out.println("=== Part A: Simple if ===");
        int age = 20;
        if (age >= 18) {
            System.out.println("Adult");
        }

        age = 15;
        if (age >= 18) {
            System.out.println("Adult");
        }
        System.out.println("(No output for age 15 because 15 >= 18 is false.)");

        System.out.println("\n=== Part B: if / else ===");
        age = 16;
        if (age >= 18) {
            System.out.println("Adult");
        } else {
            System.out.println("Minor");
        }

        age = 18;
        if (age >= 18) {
            System.out.println("Adult");
        } else {
            System.out.println("Minor");
        }

        System.out.println("\n=== Part C: Grade Classification ===");
        int score = 85;
        if (score >= 90 && score <= 100) {
            System.out.println("Excellent");
        } else if (score >= 75 && score <= 89) {
            System.out.println("Good");
        } else if (score >= 60 && score <= 74) {
            System.out.println("Passing");
        } else {
            System.out.println("Failing");
        }

        int[] scores = {95, 85, 70, 50};
        for (int value : scores) {
            System.out.println("Score: " + value + " -> ");
            if (value >= 90 && value <= 100) {
                System.out.println("Excellent");
            } else if (value >= 75 && value <= 89) {
                System.out.println("Good");
            } else if (value >= 60 && value <= 74) {
                System.out.println("Passing");
            } else {
                System.out.println("Failing");
            }
        }

        System.out.println("\n=== Part D: First True Condition ===");
        int number = 95;
        if (number >= 60) {
            System.out.println("A");
        } else if (number >= 90) {
            System.out.println("B");
        }
        System.out.println("Explanation: the first condition is true (95 >= 60), so Java never checks the else if branch.");

        // Fixed order so 95 produces B
        System.out.println("\nFixed order:");
        if (number >= 90) {
            System.out.println("B");
        } else if (number >= 60) {
            System.out.println("A");
        }

        System.out.println("\n=== Part E: Independent if statements ===");
        age = 25;
        if (age >= 18) {
            System.out.println("Adult");
        }
        if (age >= 21) {
            System.out.println("21 or older");
        }

        age = 20;
        if (age >= 18) {
            System.out.println("Adult");
        }
        if (age >= 21) {
            System.out.println("21 or older");
        }
        System.out.println("Explanation: these are separate conditions, so they are evaluated independently.");

        System.out.println("\n=== Part F: Break It ===");
        System.out.println("Experiment 1 - Assignment");
        System.out.println("This does NOT compile:");
        System.out.println("if (age = 18) { ... }");
        System.out.println("Reason: Java comparisons use ==, not =. A single = is assignment, and it cannot be used as a boolean condition.");

        System.out.println("\nExperiment 2 - Missing Braces");
        age = 20;
        if (age >= 18)
            System.out.println("Adult");
            System.out.println("Can vote");
        System.out.println("Only the first print is controlled by the if. The second print always runs because it is not inside the if block.");

        System.out.println("\nExperiment 3 - Semicolon");
        age = 20;
        if (age >= 18);
        {
            System.out.println("Adult");
        }
        System.out.println("The if has an empty body because of the semicolon, so the block after it always runs regardless of the condition.");

        age = 15;
        if (age >= 18);
        {
            System.out.println("Adult");
        }
        System.out.println("It still prints because the block is not attached to the if condition; the semicolon ends the if immediately.");

        System.out.println("\nExperiment 4 - Wrong Ordering");
        score = 95;
        if (score >= 60) {
            System.out.println("Passing");
        } else if (score >= 90) {
            System.out.println("Excellent");
        }
        System.out.println("Reason: the first condition matches before the second one is even checked, so the else if never runs.");

        System.out.println("Fixed version:");
        if (score >= 90) {
            System.out.println("Excellent");
        } else if (score >= 60) {
            System.out.println("Passing");
        }
    }
}
