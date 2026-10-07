public class ExerciseT3{
    static class Employee{
        public void work(){
            System.out.println("Employee is working");
        }
    }

    static class Manager extends Employee{

        @Override 
        public void work(){
            System.out.println("Manager is working");
        }
    }

    static class Developer extends Employee{

        @Override 
        public void work(){
            System.out.println("Developer is working");
        }
    }

    public static void main(String[] args) {
        Manager manager = new Manager();
        Developer developer = new Developer();

        
    }
}