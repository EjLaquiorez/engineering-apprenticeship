public class Lesson15Exercise {
	public static void main(String[] args) {
		System.out.println("=== Part A: break ===");
		for (int number = 1; number <= 10; number++) {
			if (number == 6) {
				break;
			}
			System.out.println(number);
		}

		System.out.println("\n=== Part B: continue ===");
		for (int number = 1; number <= 10; number++) {
			if (number == 5) {
				continue;
			}
			System.out.println(number);
		}

		System.out.println("\n=== Part C: Skip even numbers ===");
		for (int number = 1; number <= 10; number++) {
			if (number % 2 == 0) {
				continue;
			}
			System.out.println(number);
		}

		System.out.println("\n=== Part D: Find a number ===");
		int target = 7;
		for (int number = 1; number <= 10; number++) {
			if (number == target) {
				System.out.println("Target found");
				break;
			}
		}

		System.out.println("\n=== Part E: Break It ===");
		System.out.println("The broken loop repeats number 3 because continue skips number++.");
		int number = 1;
		int safetyLimit = 0;
		while (number <= 5 && safetyLimit < 5) {
			if (number == 3) {
				safetyLimit++;
				continue;
			}
			System.out.println(number);
			number++;
			safetyLimit++;
		}

		System.out.println("Fixed loop:");
		number = 1;
		while (number <= 5) {
			if (number == 3) {
				number++;
				continue;
			}
			System.out.println(number);
			number++;
		}

		System.out.println("\n=== Part F: Reasoning ===");
		System.out.println("break output: 1, 2");
		System.out.println("continue output: 1, 2, 4, 5");
		System.out.println("break exits the loop completely when i reaches 3.");
		System.out.println("continue skips only the current iteration, then the loop continues.");

		System.out.println("\n=== Part G: Debugging ===");
		System.out.println("Actual output: 1, 3, 5");
		System.out.println("At even numbers, continue runs first and skips the rest of the iteration.");
		System.out.println("At 7, the number is odd, so continue is skipped and break runs before printing 7.");
		System.out.println("The code is correct if 7 should not be printed; move break after println to print 7 first.");
	}
}
