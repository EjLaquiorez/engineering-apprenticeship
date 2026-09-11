
public class Lesson35Exercise {
	public static void main(String[] args) {
		String text = "Java programming is fun";

		System.out.println("Character count: " + text.length());
		System.out.println("Contains programming: " + text.contains("programming"));

		int count = 0;
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) == 'a') {
				count++;
			}
		}
		System.out.println("Number of a's: " + count);

		String replacedText = text.replace("Java", "Python");
		System.out.println(replacedText);

		String[] words = text.split(" ");
		for (int i = 0; i < words.length; i++) {
			System.out.println((i + 1) + ". " + words[i]);
		}

		for (int i = 0; i < words.length; i++) {
			System.out.println((i + 1) + ". " + words[i].toUpperCase());
		}
	}
}
