public class Exercise20A {
    static class Animal{
        private String name;
        private int age;

        public void move(){
            System.out.println("Animal is moving.");
        }
    }

    static class Dog extends Animal{
        public void move(){
            System.out.println("Dog is moving.");
        }
    }
    public static void main(String[] args) {
        Dog dog1 = new Dog();
        dog1.move();


    }
}
