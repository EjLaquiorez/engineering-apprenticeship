public class Exercise08B {
    static class Student {
        String name;
        int age;
        double grade;

        Student(String name, int age, double grade) {
            this.name = name;
            this.age = age;
            this.grade = grade;
        }

        Student() {
            this("Unknown", 0, 0.0);
        }

        Student(String name) {
            this(name, 0, 0.0);
        }
    }

    public static void main(String[] args) {
        Student student1 = new Student();
        Student student2 = new Student("Alice");
        Student student3 = new Student("Bob", 21, 91.5);

        System.out.println(student1.name + ", " + student1.age + ", " + student1.grade);
        System.out.println(student2.name + ", " + student2.age + ", " + student2.grade);
        System.out.println(student3.name + ", " + student3.age + ", " + student3.grade);
    }
}
