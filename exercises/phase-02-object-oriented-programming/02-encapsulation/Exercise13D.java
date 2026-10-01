public class Exercise13D {

    static class Student {
        private int age;

        int getAge() {
            return age;
        }

        void setAge(int newAge) {
            if (newAge > 0 && newAge <= 120) {
                age = newAge;
            } else {
                System.out.println("Invalid age.");
            }
        }
    }

    public static void main(String[] args) {
        Student student1 = new Student();

        
        student1.setAge(20);
        System.out.println(student1.getAge());

        student1.setAge(120);
        System.out.println(student1.getAge());

        student1.setAge(-5);
        System.out.println(student1.getAge());
    }
}
