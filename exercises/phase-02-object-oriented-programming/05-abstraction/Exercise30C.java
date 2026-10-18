public class Exercise30C {
    public static void main(String[] args) {
        LibraryItem book1 = new Book("Clean Code");
        LibraryItem dvd1 = new DVD("Inception");

        ((Book) book1).borrowBook();

        double fee = dvd1.calculateLateFee(5);
        System.out.printf("DVD late fee: ₱%.2f%n", fee);

        book1.displayTitle();
        dvd1.displayTitle();
    }

    static abstract class LibraryItem {
        private String title;

        LibraryItem(String title) {
            this.title = title;
        }

        public void displayTitle() {
            System.out.println("Title: " + title);
        }

    }

    static class Book extends LibraryItem {

        Book(String title) {
            super(title);
        }

        public void borrowBook() {
            System.out.println("Borrowing book:");
            displayTitle();
        }
    }

    static class DVD extends LibraryItem {

        DVD(String title) {
            super(title);
        }

        @Override
        public double calculateLateFee(int overdueDays) {
            return overdueDays * 2.0;
        }
    }

}