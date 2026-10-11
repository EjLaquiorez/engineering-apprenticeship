public class Exercise26A {
    static class Animal {
        public void makeSound(){
            System.out.println("Animal makes a sound.");
        }
    }

    static class Dog extends Animal {
        @Override
        public void makeSound() {
            System.out.println("Dog barks.");
        }
    }

    static class Cat extends Animal {
        @Override
        public void makeSound() {
            System.out.println("Cat meows.");
        }
    }

    public static void main(String[] args) {
        Animal animal1 = new Dog();
        Animal animal2 = new Cat();

        animal1.makeSound();
        animal2.makeSound();

    }
}