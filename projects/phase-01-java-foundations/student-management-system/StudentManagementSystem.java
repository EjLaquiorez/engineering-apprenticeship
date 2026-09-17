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
            double[] grades, int studentCount) {
        for (int i = 0; i < studentCount; i++) {
            System.out.println("Name: " + names[i]);
            System.out.println("Age: " + ages[i]);
            System.out.println("Grade: " + grades[i]);
        }
    }

    static void searchStudent(Scanner scanner, String[] names, int[] ages, double[] grades, int studentCount) {
        System.out.println("Enter student name to search: ");
        String searchInput = scanner.nextLine();
        boolean found = false;

        for (int i = 0; i < studentCount; i++) {
            if (searchInput.equalsIgnoreCase(names[i])) {
                System.out.println("Found!");
                System.out.println("Name: " + names[i]);
                System.out.println("Age: " + ages[i]);
                System.out.println("Grade: " + grades[i]);
                found = true;

            }
        }
        if (!found) {
            System.out.println("Student not found.");
        }

    }

    static double calculateAverageGrade(double[] grades, int studentCount){
        if (studentCount == 0) {
            return 0.0;
        }
        double sum = 0;
        for(int i = 0; i < studentCount; i++){
            sum+= grades[i];
        }
        return sum / studentCount;
    }

    public static void main(String[] args) {

        String[] names = new String[5];
        int[] ages = new int[5];
        double[] grades = new double[5];

        int studentCount = 2;

        names[0] = "John";
        ages[0] = 20;
        grades[0] = 85.0;

        names[1] = "Maria";
        ages[1] = 21;
        grades[1] = 92.5;

        try (Scanner scanner = new Scanner(System.in)) {

            studentCount = addStudent(scanner, names, ages, grades, studentCount);
        }

        displayStudents(names, ages, grades, studentCount);
        double averageGrade = calculateAverageGrade(grades, studentCount);
        System.out.println("Average grade: " + averageGrade);

    }
}
