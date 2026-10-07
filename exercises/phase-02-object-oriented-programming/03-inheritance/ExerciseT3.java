public class ExerciseT3{
    static class Employee{
        private String name;
        private double salary;

        Employee(String name, double salary){
            this.name = name;
            this.salary = salary;
        }


        public void work(){
            System.out.println("Employee is working");
        }
    }

    static class Manager extends Employee{
        private int teamSize;

        Manager(String name, double salary, int teamSize){
            super(name, salary);
            this.teamSize = teamSize;
        }

        @Override 
        public void work(){
            System.out.println("Manager is working");
        }
    }

    static class Developer extends Employee{
        private String programmingLanguage;

        Developer(String name, double salary, String programmingLanguage){
            super(name, salary);
            this.programmingLanguage = programmingLanguage;
        }

        @Override 
        public void work(){
            System.out.println("Developer is working");
        }
    }

    public static void main(String[] args) {
        Manager manager = new Manager("Alice", 75000, 5);
        Developer developer = new Developer("Bob", 68000, "Java");

        manager.work();
        developer.work();
    }
}