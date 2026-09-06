public class Lesson22Exercise {

	public static int getScore() {
        int score = 100;
		return score;
	}

	public static void displayScore(int score) {
		System.out.println("Score: " + score);
	}

	public static void main(String[] args) {
		displayScore(getScore());
	}
}
