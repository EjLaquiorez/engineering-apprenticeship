public class Lesson31Exercise {
	public static void main(String[] args) {
		String name = "Alexander";
		String message = "Hello World";


        char lastLetter = name.charAt(name.length() - 1);
        char firstLetter = name.charAt(0);
        String subsString = name.substring(0, 4);
        


        System.out.println("Name Length: " + name.length());
        System.out.println("Name first letter: " + firstLetter);
        System.out.println("Name last character: " + lastLetter );
        System.out.println("Name first four letters: " + subsString);
        System.out.println("Name Uppercase: " + name.toUpperCase());
        System.out.println("Name Lowercase: " + name.toLowerCase());
	}
}
