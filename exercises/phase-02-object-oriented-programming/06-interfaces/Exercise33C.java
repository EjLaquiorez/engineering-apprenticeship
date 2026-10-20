public class Exercise33C {

    interface Describable {
        void describe();
    }

    interface Printable {
        void print();
    }

    interface Borrowable {
        void borrow();
    }

    static class Book implements Describable, Printable, Borrowable {

        @Override
        public void describe() {
            System.out.println("Describing the book.");
        }

        @Override
        public void print() {
            System.out.println("Printing the book.");
        }

        @Override
        public void borrow() {
            System.out.println("Borrowing the book.");
        }
    }

    static class Magazine implements Describable, Borrowable {

        @Override
        public void describe() {
            System.out.println("Describing the magazine.");
        }

        @Override
        public void borrow() {
            System.out.println("Borrowing the magazine.");
        }
    }

    static class LibraryReport implements Describable, Printable {

        @Override
        public void describe() {
            System.out.println("Describing the library report.");
        }

        @Override
        public void print() {
            System.out.println("Printing the library report.");
        }
    }

    public static void main(String[] args) {
        Book book = new Book();
        book.describe();
        book.print();
        book.borrow();

        Magazine magazine = new Magazine();
        magazine.describe();
        magazine.borrow();

        LibraryReport report = new LibraryReport();
        report.describe();
        report.print();
    }
}