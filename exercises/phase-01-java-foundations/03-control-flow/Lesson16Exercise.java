public class Lesson16Exercise {
	public static void main(String[] args) {
		System.out.println("=== Part A: Find the infinite loop ===");
		System.out.println("The loop is infinite because count is never incremented.");
		System.out.println("Fixed output:");
		int count = 1;
		while (count <= 5) {
			System.out.println(count);
			count++;
		}
		System.out.println("The fixed loop prints 1 through 5.");

		System.out.println("\n=== Part B: Find the off-by-one error ===");
		System.out.println("The less-than condition stops before i reaches 5.");
		System.out.println("Using the less-than-or-equal condition includes 5 and prints 1 through 5.");
		for (int i = 1; i <= 5; i++) {
			System.out.println(i);
		}

		System.out.println("\n=== Part C: Debug the condition ===");
		int score = 85;
		if (score >= 60 && score <= 100) {
			System.out.println("Passing score");
		}
		System.out.println("The original || condition is incorrect because it accepts scores below 60 or above 100.");
		System.out.println("The corrected condition uses && so both limits must be true.");

		System.out.println("\n=== Part D: Trace the loop ===");
		for (int i = 1; i <= 5; i++) {
			if (i == 3) {
				continue;
			}
			System.out.println(i);
		}
		System.out.println("When i is 3, continue skips the print statement and the loop moves to i = 4.");

		System.out.println("\n=== Part E: Nested loop debugging ===");
		for (int row = 1; row <= 2; row++) {
			for (int column = 1; column <= 3; column++) {
				System.out.println("Row " + row + ", Column " + column);
			}
		}
		System.out.println("The inner loop executes 6 times in total: 3 columns for each of 2 rows.");

		System.out.println("\n=== Part F: Break the code ===");
		System.out.println("The broken loop would repeat number 5 forever because continue skips number++.");
		System.out.println("Bounded demonstration of the broken behavior:");
		int number = 1;
		int safetyLimit = 0;
		while (number <= 10 && safetyLimit < 6) {
			if (number == 5) {
				safetyLimit++;
				continue;
			}
			System.out.println(number);
			number++;
			safetyLimit++;
		}

		System.out.println("Fix 1: increment before continue:");
		number = 1;
		while (number <= 10) {
			if (number == 5) {
				number++;
				continue;
			}
			System.out.println(number);
			number++;
		}

		System.out.println("Fix 2: increment in the loop condition expression:");
		number = 1;
		while (number <= 10) {
			if (number != 5) {
				System.out.println(number);
			}
			number++;
		}

		System.out.println("\n=== Part G: Final debugging challenge ===");
		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 0) {
				continue;
			}
			if (i > 7) {
				break;
			}
			System.out.println(i);
		}
		System.out.println("Exact output: 1, 3, 5, 7");
		System.out.println("continue skips 2, 4, 6, 8, and 10.");
		System.out.println("break executes at i = 9.");
		System.out.println("9 is not printed because break exits before the print statement.");
	}
}
