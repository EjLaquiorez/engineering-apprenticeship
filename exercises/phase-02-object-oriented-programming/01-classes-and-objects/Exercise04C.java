    public class Exercise04C {

        static class Student{
            String name;
            int age;
            double grade;
            boolean enrolled;

        }
        public static void main(String[] args) {
            
            Student student1 = new Student();
            

            student1.name = "John";
            student1.age = 20;
            student1.grade = 85.5;
            student1.enrolled = true;


            
            System.out.println("Name: " + student1.name);
            System.out.println("Age: " + student1.age);
            System.out.println("Grade: " + student1.grade);
            System.out.println("Enrolled: " + student1.enrolled);

            student1.name = "Zoe";
            student1.age = 23;

            System.out.println("Name: " + student1.name);
            System.out.println("Age: " + student1.age);
            System.out.println("Grade: " + student1.grade);
            System.out.println("Enrolled: " + student1.enrolled);

        }
    }