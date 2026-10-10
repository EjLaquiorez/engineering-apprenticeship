public class Exercise25B {
    static class Animal {
        void makeSound() {
            System.out.println("Animal make a sound.");
        }
    }

    static class Dog extends Animal {
        @Override
        void makeSound() {
            System.out.println("Dog barks.");
        }
    }

    static class Cat extends Animal {
        @Override
        void makeSound() {
            System.out.println("Cat meows.");
        }
    }

    public static void main(String[] args) {
        Animal[] animals = {new Dog(), new Cat(), new Dog()};

        System.out.println(animals.length);
    }
}
