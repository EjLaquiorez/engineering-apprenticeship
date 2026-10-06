public class Exercise20B{
    static class Animal{
        private String name;
        private int age;

        public void eat(){
            System.out.println("Animal is eating.");
        }

        public void sleep(){
            System.out.println("Animal is sleeping.");
        }
    }

    static class Dog extends Animal{
        public void eat(){
            System.out.println("Dog is eating.");
        }
    }
    public static void main(String[] args) {
        Dog dog1 = new Dog();

        dog1.eat();
        dog1.sleep();
    }
}