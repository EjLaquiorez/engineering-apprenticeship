public class Exercise17B {

    static class Animal{
        private String name;
        private int age;

        public Animal(String name, int age) {
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

    static class Dog extends Animal{
        public Dog(String name, int age) {
            super(name, age);
        }

        public void bark(){
            System.out.println("Dog says bark.");
        }
    }

    static class Cat extends Animal {
        public Cat(String name, int age) {
            super(name, age);
        }

        public void meow() {
            System.out.println("Cat says meow.");
        }
    }


    public static void main(String[] args) {
        Dog dog1 = new Dog("Doggy", 3);
        Cat cat1 = new Cat("Mawmaw", 2);

        dog1.bark();
        dog1.sleep();
        dog1.eat();

        cat1.meow();
        cat1.sleep();
        cat1.eat();
    }
}
