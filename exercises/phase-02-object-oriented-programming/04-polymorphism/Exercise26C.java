public class Exercise26C {
    static class Animal {
        public void makeSound() {
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

    static class Bird extends Animal {
        @Override
        public void makeSound() {
            System.out.println("Bird chirps.");
        }
    }

    public static void main(String[] args) {
        Animal[] animals = {new Dog(), new Cat(), new Bird(), new Dog()};

        for (Animal animal : animals) {
            animal.makeSound();
        }
    }
}