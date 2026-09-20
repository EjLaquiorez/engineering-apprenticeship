public class Exercise06B {


    static class Student {

        String name;
        int age;
        double grade;

        void displayInfo(){
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Grade: " + grade);
        }

    }

    public static void main(String[] args) {
        
        Student student1 = new Student();
        
        student1.name = "Varus";
        student1.grade = 98.9;
        student1.age = 22;

        student1.displayInfo();
        
    }
}


