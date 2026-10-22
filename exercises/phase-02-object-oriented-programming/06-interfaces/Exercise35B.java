public class Exercise35B {

    interface Describable {
        void describe();
    }

    interface Printable {
        void print();
    }

    interface Borrowable {
        void borrow();

        void returnItem();
    }

    interface LateFeeCalculable {
        double calculateLateFee(int overdueDays);
    }

    static class Book implements Describable, Printable, Borrowable, LateFeeCalculable {
        private final String title;

        Book(String title) {
            this.title = title;
        }

        @Override
        public void describe() {
            System.out.println("Book: " + title);
        }

        @Override
        public void print() {
            System.out.println("Printing book: " + title);
        }

        @Override
        public void borrow() {
            System.out.println("Borrowing book: " + title);
        }

        @Override
        public void returnItem() {
            System.out.println("Returning book: " + title);
        }

        @Override
        public double calculateLateFee(int overdueDays) {
            return overdueDays * 5.0;
        }
    }

    static class Magazine implements Describable, Borrowable, LateFeeCalculable {
        private final String title;

        Magazine(String title) {
            this.title = title;
        }

        @Override
        public void describe() {
            System.out.println("Magazine: " + title);
        }

        @Override
        public void borrow() {
            System.out.println("Borrowing magazine: " + title);
        }

        @Override
        public void returnItem() {
            System.out.println("Returning magazine: " + title);
        }

        @Override
        public double calculateLateFee(int overdueDays) {
            return overdueDays * 2.0;
        }
    }

    static class LibraryReport implements Describable, Printable {
        private final String title;

        LibraryReport(String title) {
            this.title = title;
        }

        @Override
        public void describe() {
            System.out.println("Library report: " + title);
        }

        @Override
        public void print() {
            System.out.println("Printing report: " + title);
        }
    }

    public static void main(String[] args) {
        Book book = new Book("Clean Code");
        book.describe();
        book.print();
        book.borrow();
        book.returnItem();
        System.out.printf("Book late fee: ₱%.2f%n", book.calculateLateFee(3));

        Magazine magazine = new Magazine("National Geographic");
        magazine.describe();
        magazine.borrow();
        magazine.returnItem();
        System.out.printf("Magazine late fee: ₱%.2f%n", magazine.calculateLateFee(3));

        LibraryReport report = new LibraryReport("Monthly Library Summary");
        report.describe();
        report.print();
    }
}