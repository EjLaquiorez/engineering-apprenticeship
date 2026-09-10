public class Lesson33Exercise {
	public static void main(String[] args) {
		String message = "  Hello Java World  ";
		String filename = "report.pdf";
		String word = "banana";
        String input = "   Hello Java   ";

		System.out.println(message.contains("World"));
		System.out.println(filename.startsWith("report"));
        System.out.println(filename.endsWith("pdf"));
        System.out.println(word.indexOf("a"));
        System.out.println(message.replace("Java", "Programming"));
        System.out.println(message.trim());
		System.out.println(input.trim().toUpperCase());


	}
}
