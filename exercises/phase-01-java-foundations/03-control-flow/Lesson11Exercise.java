public class Lesson11Exercise {
	public static void main(String[] args) {
		System.out.println("=== Part A: Basic switch ===");

		int day = 3;
		switch (day) {
			case 1 -> System.out.println("Monday");
			case 2 -> System.out.println("Tuesday");
			case 3 -> System.out.println("Wednesday");
			case 4 -> System.out.println("Thursday");
			case 5 -> System.out.println("Friday");
			default -> System.out.println("Invalid day");
		}

		System.out.println("\n=== Part B: Grade ===");

		char grade = 'B';
		switch (grade) {
			case 'A' -> System.out.println("Excellent");
			case 'B' -> System.out.println("Good");
			case 'C' -> System.out.println("Average");
			case 'D' -> System.out.println("Poor");
			default -> System.out.println("Invalid grade");
		}

		System.out.println("\n=== Part C: Role ===");

		String role = "manager";
		switch (role) {
			case "admin" -> System.out.println("Full access");
			case "manager" -> System.out.println("Management access");
			case "user" -> System.out.println("Standard access");
			default -> System.out.println("Unknown role");
		}

		System.out.println("\n=== Part D: Break It ===");
		System.out.println("With traditional switch syntax, removing the break after case 2 would also print case 3.");
		System.out.println("The break must be restored to stop execution after the matching case.");

		System.out.println("\n=== Part E: Reasoning ===");
		System.out.println("Output: Two, then Three");
		System.out.println("Reason: number matches case 2. Without a break, execution falls through into case 3.");

		System.out.println("\n=== Part F: switch or if? ===");
		System.out.println("1. switch - day is compared with several exact values.");
		System.out.println("2. if - age >= 18 is a condition or range check.");
		System.out.println("3. switch - role is compared with several exact String values.");
		System.out.println("4. if - score between 75 and 89 requires a range condition.");
	}
}
