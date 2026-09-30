public class Exercise12C {

    static class Student {
        private int age;

        Student() {
            this.age = 0;
        }

        Student(int age) {
            this.age = age;
        }

        void setAge(int newAge) {
            if (newAge >= 0) {
                age = newAge;
            }
        }

        void displayAge() {
            if (age >= 0) {
                System.out.println("Age: " + age);
            }
        }
    }

    public static void main(String[] args) {
        Student student = new Student();

        student.setAge(20);
        student.displayAge();
    }
}