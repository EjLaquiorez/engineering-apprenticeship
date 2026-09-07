public class Lesson23Exercise {

    
    static void displayStudent(String name, int score) {
        System.out.println("Student Name: " + name);
        System.out.println("Score: " + score);
        System.out.println("Status: " + (hasPassed(score) ? "Pass" : "Fail"));
    }

    static boolean hasPassed(int score) {
        return score >= 75;
    }

    public static void main(String[] args) {
        displayStudent("Justine", 99);
    }
}