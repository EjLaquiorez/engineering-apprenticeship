public class Exercise24A {
    static class Animal {
        public void eat() {
            System.out.println("Animal is eating");
        }
    }

    static class Dog extends Animal {
        @Override
        public void eat() {
            System.out.println("Dog is eating");
        }
    }

    static class Cat extends Animal {
        @Override
        public void eat() {
            System.out.println("Cat is eating");
        }
    }

    public static void main(String[] args) {
        Animal animal1 = new Dog();
        Animal animal2 = new Cat();
        Animal animal3 = new Dog();

        animal1.eat();
        animal2.eat();
        animal3.eat();


        // Runtime dispatch calls the overridden method for each object's actual type:
        // Dog is eating
        // Cat is eating
    }
}