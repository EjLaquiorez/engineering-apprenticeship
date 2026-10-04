public class Exercise18C {

    // Main method: creates different animal objects and calls their behavior.
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

    // Base class for all animals.
    // Every animal has a name and age, and all animals eat and sleep.
    static class Animal {
        private final String name;
        private final int age;

        Animal(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public void eat() {
            System.out.println(name + " (age " + age + ") is eating.");
        }

        public void sleep() {
            System.out.println(name + " (age " + age + ") is sleeping.");
        }
    }

    // Dog-specific features: breed and barking.
    static class Dog extends Animal {
        private final String breed;

        Dog(String name, int age, String breed) {
            super(name, age);
            this.breed = breed;
        }

        public void bark() {
            System.out.println(getName() + " (age " + getAge() + ") the " + breed + " dog is barking.");
        }
    }

    // Cat-specific features: fur color and meowing.
    static class Cat extends Animal {
        private final String furColor;

        Cat(String name, int age, String furColor) {
            super(name, age);
            this.furColor = furColor;
        }

        public void meow() {
            System.out.println(getName() + " (age " + getAge() + ") the " + furColor + " cat is meowing.");
        }
    }

    // Bird-specific features: wing span and flying.
    static class Bird extends Animal {
        private final double wingSpan;

        Bird(String name, int age, double wingSpan) {
            super(name, age);
            this.wingSpan = wingSpan;
        }

        public void fly() {
            System.out.println(getName() + " (age " + getAge() + ") the bird with a " + wingSpan + " cm wing span is flying.");
        }
    }
}