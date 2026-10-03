public class Exercise17A {

    public static void main(String[] args) {
        Dog dog = new Dog("Buddy", 3, "Labrador");
        Cat cat = new Cat("Milo", 2, "Gray");
        Bird bird = new Bird("Tweety", 1, 18.5);

        dog.eat();
        dog.sleep();
        dog.bark();

        cat.eat();
        cat.sleep();
        cat.meow();

        bird.eat();
        bird.sleep();
        bird.fly();
    }

    // Every animal has a name and age, and all animals eat and sleep.
    static class Animal {
        private final String name;
        private final int age;

        Animal(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public void eat() {
            System.out.println(name + " is eating.");
        }

        public void sleep() {
            System.out.println(name + " is sleeping.");
        }
    }

    // Breed and barking are specific to dogs, so they stay in Dog.
    static class Dog extends Animal {
        private final String breed;

        Dog(String name, int age, String breed) {
            super(name, age);
            this.breed = breed;
        }

        public void bark() {
            System.out.println(breed + " dog is barking.");
        }
    }

    // Fur color and meowing are specific to cats, so they stay in Cat.
    static class Cat extends Animal {
        private final String furColor;

        Cat(String name, int age, String furColor) {
            super(name, age);
            this.furColor = furColor;
        }

        public void meow() {
            System.out.println(furColor + " cat is meowing.");
        }
    }

    // Wing span and flying are specific to birds, so they stay in Bird.
    static class Bird extends Animal {
        private final double wingSpan;

        Bird(String name, int age, double wingSpan) {
            super(name, age);
            this.wingSpan = wingSpan;
        }

        public void fly() {
            System.out.println("Bird with a " + wingSpan + " cm wing span is flying.");
        }
    }
}