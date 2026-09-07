public class Lesson26Exercise {
	public static void main(String[] args) {
		int[] scores = {85, 90, 78, 92, 88};

		System.out.println(scores[0]);
		System.out.println(scores[2]);
		System.out.println(scores[4]);

		// scores[2] reads the value stored in the third array position.
		// scores[2] = 95 replaces the value in the third array position.
		scores[2] = 95;
		System.out.println(scores[2]);

		String[] students = {"John", "Maria", "Alex"};

		System.out.println(students[0]);
		System.out.println(students[1]);
		System.out.println(students[2]);
	}
}
