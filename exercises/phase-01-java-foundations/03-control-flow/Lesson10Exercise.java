public class Lesson10Exercise {
	public static void main(String[] args) {
		System.out.println("=== Part A: AND ===");

		int age = 25;
		boolean hasLicense = true;

		boolean canDrive = age >= 18 && hasLicense;
		System.out.println("Can drive: " + canDrive);

		System.out.println("\n=== Part B: OR ===");

		boolean isAdmin = false;
		boolean isManager = true;

		boolean hasManagementAccess = isAdmin || isManager;
		System.out.println("Has management access: " + hasManagementAccess);

		System.out.println("\n=== Part C: NOT ===");

		boolean loggedIn = false;

		if (!loggedIn) {
			System.out.println("Please log in");
		}

		System.out.println("\n=== Part D: Combining Conditions ===");

		int userAge = 25;
		boolean userHasLicense = true;
		boolean licenseSuspended = false;

		boolean userCanDrive = userAge >= 18 && userHasLicense && !licenseSuspended;
		System.out.println("User can drive: " + userCanDrive);

		System.out.println("\n=== Part E: Range ===");

		int score = 85;

		boolean scoreIsInRange = score >= 60 && score <= 100;
		System.out.println("Score is between 60 and 100: " + scoreIsInRange);

		System.out.println("\n=== Part F: OR ===");

		int day = 6;

		boolean isWeekend = day == 6 || day == 7;
		System.out.println("Is weekend: " + isWeekend);

		System.out.println("\n=== Part G: Break It ===");

		System.out.println("Experiment 1 - AND instead of OR");
		boolean bothAdminAndManager = isAdmin && isManager;
		System.out.println("Both admin and manager: " + bothAdminAndManager);

		System.out.println("\nExperiment 2 - Impossible condition");
		boolean impossible = age >= 18 && age < 18;
		System.out.println("Age is at least 18 and younger than 18: " + impossible);
		System.out.println("It can never be true because one age cannot be both at least 18 and younger than 18.");

		System.out.println("\nExperiment 3 - Parentheses change the result");
		isAdmin = false;
		isManager = true;
		loggedIn = false;

		boolean firstExpression = (isAdmin || isManager) && loggedIn;
		boolean secondExpression = isAdmin || (isManager && loggedIn);
		System.out.println("(isAdmin || isManager) && loggedIn: " + firstExpression);
		System.out.println("isAdmin || (isManager && loggedIn): " + secondExpression);
		System.out.println("The results differ because parentheses change which conditions are grouped together.");

		System.out.println("\nExperiment 4 - Short-circuit behavior");
		boolean andResult = false && reportEvaluation("right side of &&");
		boolean orResult = true || reportEvaluation("right side of ||");
		System.out.println("false && ... result: " + andResult);
		System.out.println("true || ... result: " + orResult);
		System.out.println("Java does not evaluate the right side of false && ... or true || ... .");
	}

	private static boolean reportEvaluation(String expression) {
		System.out.println("Evaluated: " + expression);
		return true;
	}
}
