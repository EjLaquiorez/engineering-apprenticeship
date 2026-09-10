public class Lesson32Exercise {
	public static void main(String[] args) {
		String username = "admin";
		String input1 = "admin";
		String input2 = "ADMIN";
		String input3 = "user";

		System.out.println(username.equals(input1));
		System.out.println(username.equals(input2));
		System.out.println(username.equals(input3));

        System.out.println();

		if(username.equals(input1)) {
			System.out.println("Login successful");
		} else {
			System.out.println("Invalid username");
		}
	}
}
