public class Exercise29A {

    static abstract class Animal {
        public abstract void makeSound();
    }

    static class Dog extends Animal {
        @Override
        public void makeSound(){
            System.out.println("Woof!");
        }
    }

    static class Cat extends Animal {
        @Override
        public void makeSound(){
            System.out.println("Meow!");
        }
    }

    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();

        dog.makeSound();
        cat.makeSound();
    }
}