public class Lesson13Exercise {
	public static void main(String[] args) {
		System.out.println("=== Part A: Basic do-while ===");
		int count = 1;
		do {
			System.out.println(count);
			count++;
		} while (count <= 5);

		System.out.println("\n=== Part B: Countdown ===");
		count = 5;
		do {
			System.out.println(count);
			count--;
		} while (count >= 1);

		System.out.println("\n=== Part C: Prove it runs once ===");
		int number = 10;
		do {
			System.out.println(number);
		} while (number < 5);
		System.out.println("Prediction: 10, because a do-while runs before checking its condition.");

		System.out.println("\n=== Part D: Sum ===");
		number = 1;
		int sum = 0;
		do {
			sum += number;
			number++;
		} while (number <= 5);
		System.out.println("Sum: " + sum);

		System.out.println("\n=== Part E: Break It ===");
		System.out.println("Broken experiment, limited to five iterations:");
		count = 1;
		int safetyLimit = 0;
		do {
			System.out.println(count);
			count--;
			safetyLimit++;
		} while (count <= 5 && safetyLimit < 5);
		System.out.println("The safety limit prevents the broken loop from running forever.");
		System.out.println("With count--, count moves from 1 to 0, -1, and so on.");
		System.out.println("Those values always satisfy count <= 5, so the stopping condition is never reached.");

		System.out.println("Restored version:");
		count = 1;
		do {
			System.out.println(count);
			count++;
		} while (count <= 5);

		System.out.println("\n=== Part F: while vs do-while ===");
		System.out.println("Example 1 output: nothing");
		System.out.println("Example 2 output: 10");
		System.out.println("while checks its condition first, but do-while runs its body once before checking.");

		System.out.println("\n=== Part G: Debugging ===");
		System.out.println("The loop does not terminate because count is never changed.");
		System.out.println("count remains 1, so count <= 5 stays true forever.");
	}
}
