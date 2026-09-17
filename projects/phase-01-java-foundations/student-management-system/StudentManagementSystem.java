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

    static void displayMenu() {
        System.out.println("\n1. Add Student");
        System.out.println("2. Display Students");
        System.out.println("3. Search Student");
        System.out.println("4. Calculate Average");
        System.out.println("5. Exit");
        System.out.println("Choose an option: ");
    }

    public static void main(String[] args) {

        String[] names = new String[5];
        int[] ages = new int[5];
        double[] grades = new double[5];

        int studentCount = 0;

        try (Scanner scanner = new Scanner(System.in)) {
            int choice;
            do {
                displayMenu();
                choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        studentCount = addStudent(scanner, names, ages, grades, studentCount);
                        break;
                    case 2:
                        displayStudents(names, ages, grades, studentCount);
                        break;
                    case 3:
                        searchStudent(scanner, names, ages, grades, studentCount);
                        break;
                    case 4:
                        double averageGrade = calculateAverageGrade(grades, studentCount);
                        System.out.println("Average grade: " + averageGrade);
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid option.");
                }
            } while (choice != 5);
        }

    }
}
