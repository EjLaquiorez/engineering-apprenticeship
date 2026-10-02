public class Exercise15A {

    static class Student {
        private String name;
        private int age;
        private double grade;

        public void displayStudent() {
            System.out.println(name + " - " + age + " - " + grade);
        }
    }

    public static void main(String[] args) {

        Student student = new Student();

        student.name = "John";
        student.age = -50;
        student.grade = 150;

        student.displayStudent();
    }
}