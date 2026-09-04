public class Lesson14Exercise {
	public static void main(String[] args) {
		System.out.println("=== Part A: Basic counting ===");
		for (int count = 1; count <= 5; count++) {
			System.out.println(count);
		}

				// Do not run this version: for (int count = 1; count <= 5; count--) { ... }
		System.out.println("\n=== Part B: Countdown ===");
		for (int count = 5; count >= 1; count--) {
			System.out.println(count);
		}

		System.out.println("\n=== Part C: Even numbers ===");
		for (int number = 2; number <= 10; number += 2) {
			System.out.println(number);
		}

		System.out.println("\n=== Part D: Sum ===");
		int sum = 0;
		for (int number = 1; number <= 5; number++) {
			sum += number;
		}
		System.out.println("Sum: " + sum);

		System.out.println("\n=== Part E: Nested loops ===");
		for (int row = 1; row <= 3; row++) {
			for (int column = 1; column <= 3; column++) {
				System.out.println("Row " + row + ", Column " + column);
			}
		}

		System.out.println("\n=== Part F: Break It ===");
		System.out.println("Using count-- would create an infinite loop:");
		int count = 1;
		int safetyLimit = 0;
		while (count <= 5 && safetyLimit < 5) {
			System.out.println(count);
			count--;
			safetyLimit++;
		}
		System.out.println("count-- moves count away from 5, so count <= 5 stays true.");
		System.out.println("Restored version:");
		for (count = 1; count <= 5; count++) {
			System.out.println(count);
		}

		System.out.println("\n=== Part G: Reasoning ===");
		System.out.println("Output: 0, 1, 2, 3, 4");
		System.out.println("The loop starts at 0 and stops before 5 because its condition is i < 5.");

		System.out.println("\n=== Part H: Debugging ===");
		System.out.println("The loop condition i < 5 excludes 5, so it produces Sum: 10.");
		System.out.println("To calculate 1 + 2 + 3 + 4 + 5, change i < 5 to i <= 5.");
	}
}
