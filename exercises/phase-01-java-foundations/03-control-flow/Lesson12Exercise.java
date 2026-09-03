public class Lesson12Exercise {
	public static void main(String[] args) {
		System.out.println("=== Part A: Basic counting ===");
		int count = 1;
		while (count <= 5) {
			System.out.println(count);
			count++;
		}

		System.out.println("\n=== Part B: Countdown ===");
		count = 5;
		while (count >= 1) {
			System.out.println(count);
			count--;
		}

		System.out.println("\n=== Part C: Even numbers ===");
		count = 2;
		while (count <= 10) {
			System.out.println(count);
			count += 2;
		}

		System.out.println("\n=== Part D: Sum ===");
		int number = 1;
		int sum = 0;
		while (number <= 5) {
			sum += number;
			number++;
		}
		System.out.println("Sum: " + sum);

		System.out.println("\n=== Part E: Break It ===");
		System.out.println("Removing count++ causes count to remain 1.");
		System.out.println("Because count never changes, count <= 5 stays true and the loop continues indefinitely.");
		System.out.println("The increment is restored in the working Part A loop above.");

		System.out.println("\n=== Part F: Reasoning ===");
		System.out.println("Output: 3, then 2, then 1");
		System.out.println("The loop stops because x is decremented each time until x > 0 becomes false at x = 0.");

		System.out.println("\n=== Part G: Important debugging question ===");
		System.out.println("The loop actually prints 2, 3, 4, 5, and 6.");
		System.out.println("count is incremented before it is printed, so the initial value 1 is skipped and 6 is printed before the loop stops.");

		/*
		 * Part E broken version - do not run this without restoring count++:
		 *
		 * int count = 1;
		 * while (count <= 5) {
		 *     System.out.println(count);
		 * }
		 */
	}
}
