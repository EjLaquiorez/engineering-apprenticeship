public class Exercise30B {
    public static void main(String[] args) {
        LibraryItem book1 = new Book("Clean Code");
        LibraryItem magazine1 = new Magazine("National Geographic");

        double fee1 = book1.calculateLateFee(4);
        System.out.printf("Book late fee: ₱%.2f%n", fee1);

        double fee2 = magazine1.calculateLateFee(5);
        System.out.printf("Magazine late fee: ₱%.2f%n", fee2);

        book1.displayTitle();
        magazine1.displayTitle();
    }

    static abstract class LibraryItem {
        private String title;

        LibraryItem(String title) {
            this.title = title;
        }

        public void displayTitle() {
            System.out.println("Title: " + title);
        }

        abstract double calculateLateFee(int overdueDays);

    }

    static class Book extends LibraryItem {

        Book(String title) {
            super(title);
        }

        @Override
        public double calculateLateFee(int overdueDays) {
            return overdueDays * 5.0;
        }
    }

    static class Magazine extends LibraryItem {

        Magazine(String title) {
            super(title);
        }

        @Override
        public double calculateLateFee(int overdueDays) {
            return overdueDays * 2.0;
        }
    }

}