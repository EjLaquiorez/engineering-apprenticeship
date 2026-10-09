public class Exercise23C {
    static class Animal {
    }

    static class Dog extends Animal {
        public void bark() {
            System.out.println("Dog is barking");
        }
    }

    public static void main(String[] args) {
        Animal animal = new Dog();

        // The Dog object still has bark(); it is unavailable through an Animal reference
        // because Animal does not declare that method.
        // animal.bark(); // Does not compile.

        // Cast to Dog to access a method specific to Dog.
        ((Dog) animal).bark();
    }
}