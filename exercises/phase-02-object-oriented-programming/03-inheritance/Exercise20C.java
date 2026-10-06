public class Exercise20C{
    static class Animal{
        private String name;
        private int age;

        public void eat(){
            System.out.println("Animal is eating.");
        }

        public void sleep(){
            System.out.println("Animal is sleeping.");
        }

        public void makeSound(){
            System.out.println("Animal is making sound.");
        }
    }

    static class Dog extends Animal{
        public void eat(){
            System.out.println("Dog is eating.");
        }
        @Override 
        public void makeSound(){
            System.out.println("Dog is making sound.");
        }

        
    }
    public static void main(String[] args) {
        Dog dog1 = new Dog();

        dog1.eat();
        dog1.sleep();
        dog1.makeSound();
    }
}