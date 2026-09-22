public class Exercise07C {
    static class Student{
        String name;
        int age;
        double grade;

        Student(String name, int age, double grade){
            this.name = name;
            this.age = age;
            this.grade = grade;




        }
    }
	public static void main(String[] args) {

        Student student1 = new Student("Alice", 20, 85.5);
        Student student2 = new Student("Bob", 21, 91.0);
        Student student3 = new Student("Charlie", 19, 78.5);

        System.out.println("Student 1:");
        System.out.println("Name: " + student1.name);
        System.out.println("Age: " + student1.age);
        System.out.println("Grade: " + student1.grade);
        System.out.println();

        System.out.println("Student 2:");
        System.out.println("Name: " + student2.name);
        System.out.println("Age: " + student2.age);
        System.out.println("Grade: " + student2.grade);
        System.out.println();

        System.out.println("Student 3:");
        System.out.println("Name: " + student3.name);
        System.out.println("Age: " + student3.age);
        System.out.println("Grade: " + student3.grade);
        
	}
}
