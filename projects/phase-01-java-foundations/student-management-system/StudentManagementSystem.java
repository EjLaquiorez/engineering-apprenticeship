import java.util.Scanner;

public class StudentManagementSystem {

    static int addStudent(Scanner scanner, String[] names, int[] ages,
            double[] grades, int studentCount) {
        if (studentCount >= names.length) {
            return studentCount;
        }
        System.out.println("Enter student name: ");
        names[studentCount] = scanner.nextLine();
        System.out.println("Enter student age: ");
        ages[studentCount] = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter student grade: ");
        grades[studentCount] = Double.parseDouble(scanner.nextLine());
        return studentCount + 1;
    }

    static void displayStudents(String[] names, int[] ages,
            double[] grades, int studentCount){

    }

    public static void main(String[] args) {

        String[] names = new String[5];
        int[] ages = new int[5];
        double[] grades = new double[5];

        int studentCount = 0;

        try (Scanner scanner = new Scanner(System.in)) {

            studentCount = addStudent(scanner, names, ages, grades, studentCount);
        }

        System.out.println("Name: " + names[0]);

    }
}
