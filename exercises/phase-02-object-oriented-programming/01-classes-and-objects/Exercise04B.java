public class Exercise04B {

    static class Student{
        String name;
        int age;
        double grade;
        boolean enrolled;

    }
    public static void main(String[] args) {
        
        Student student1 = new Student();
        Student student2 = new Student();

        student1.name = "John";
        student1.age = 20;
        student1.grade = 85.5;
        student1.enrolled = true;

        student2.name = "Maria";
        student2.age = 21;
        student2.grade = 92.5;
        student2.enrolled = true;
        
    }
}