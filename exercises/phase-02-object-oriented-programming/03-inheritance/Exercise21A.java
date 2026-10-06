import java.util.List;

public class Exercise21A {
    static class Animal {
    }

    static class Dog extends Animal {
    }

    static class Engine {
    }

    static class Car {
        private final Engine engine;

        Car(Engine engine) {
            this.engine = engine;
        }
    }

    static class Employee {
    }

    static class Manager extends Employee {
    }

    static class Book {
    }

    static class Library {
        private final List<Book> books;

        Library(List<Book> books) {
            this.books = books;
        }
    }

    static class Keyboard {
    }

    static class Computer {
        private final Keyboard keyboard;

        Computer(Keyboard keyboard) {
            this.keyboard = keyboard;
        }
    }

    static class School {
    }

    static class Student {
        private final School school;

        Student(School school) {
            this.school = school;
        }
    }

    public static void main(String[] args) {
        System.out.println("1. IS-A");
        System.out.println("2. HAS-A");
        System.out.println("3. IS-A");
        System.out.println("4. HAS-A");
        System.out.println("5. NEITHER");
        System.out.println("6. HAS-A");
    }
}