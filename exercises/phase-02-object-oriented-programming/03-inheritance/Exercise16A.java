public class Exercise16A {

    public static void main(String[] args) {
        Dog dog = new Dog("Buddy");
        Cat cat = new Cat("Milo");
        Car car = new Car("Tesla");
        Book book = new Book("Java for Beginners");
        School school = new School("Springfield Academy");

        Library library = new Library(book);
        Student student = new Student(school);

        // YES: Dog is an Animal -> inheritance
        System.out.println(dog.getName() + " is a " + dog.getClass().getSuperclass().getSimpleName());

        // YES: Cat is an Animal -> inheritance
        System.out.println(cat.getName() + " is a " + cat.getClass().getSuperclass().getSimpleName());

        // YES: Car is a Vehicle -> inheritance
        System.out.println(car.getModel() + " is a " + car.getClass().getSuperclass().getSimpleName());

        // YES: Library has a Book -> field relationship
        System.out.println("Library contains: " + library.getBook().getTitle());

        // YES: Student attends a School -> field relationship
        System.out.println("Student attends: " + student.getSchool().getName());
    }

    // Base class
    static class Animal {
        private String name;

        public Animal(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    // YES: Dog is an Animal
    static class Dog extends Animal {
        public Dog(String name) {
            super(name);
        }
    }

    // YES: Cat is an Animal
    static class Cat extends Animal {
        public Cat(String name) {
            super(name);
        }
    }

    // Base class
    static class Vehicle {
        private String model;

        public Vehicle(String model) {
            this.model = model;
        }

        public String getModel() {
            return model;
        }
    }

    // YES: Car is a Vehicle
    static class Car extends Vehicle {
        public Car(String model) {
            super(model);
        }
    }

    // Has-a relationship: Library contains a Book
    static class Book {
        private String title;

        public Book(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }
    }

    static class Library {
        private Book book;

        public Library(Book book) {
            this.book = book;
        }

        public Book getBook() {
            return book;
        }
    }

    // Has-a relationship: Student attends a School
    static class School {
        private String name;

        public School(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    static class Student {
        private School school;

        public Student(School school) {
            this.school = school;
        }

        public School getSchool() {
            return school;
        }
    }
}
