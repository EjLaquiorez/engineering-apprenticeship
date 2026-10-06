import java.util.List;

public class Exercise21B {
    static class Animal {
    }

    static class Dog extends Animal {
    }

    static class Book {
    }

    static class Library {
        private final List<Book> books;

        Library(List<Book> books) {
            this.books = books;
        }
    }

    static class Employee {
    }

    static class Developer extends Employee {
    }

    static class Engine {
    }

    static class Car {
        private final Engine engine;

        Car(Engine engine) {
            this.engine = engine;
        }
    }

    public static void main(String[] args) {
        Dog dog = new Dog();
        Library library = new Library(List.of(new Book()));
        Developer developer = new Developer();
        Car car = new Car(new Engine());

        System.out.println("A. Inheritance: Dog extends Animal.");
        System.out.println("B. Composition: Library contains Book objects.");
        System.out.println("C. Inheritance: Developer extends Employee.");
        System.out.println("D. Composition: Car contains an Engine.");
    }
}