public class Exercise25A{
    static class Animal{

    }

    static class Dog extends Animal{

    }

    static class Cat extends Animal{

    }

    public static void main(String[] args) {
        Animal [] animals = {new Dog(), new Cat()};

        System.out.println(animals.length);
    }
}