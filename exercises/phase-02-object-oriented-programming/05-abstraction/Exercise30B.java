public class Exercise30B {
    public static void main(String[] args) {
        Book book1 = new Book("Clean Code.");
        Magazine book2 = new Magazine("National Geographic");

        book1.displayTitle();
        book2.displayTitle();
    }

    static abstract class LibraryItem {
        private String title;

        LibraryItem(String title) {
            this.title = title;
        }

        public void displayTitle() {
            System.out.println("Book Title: " + title);
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

    static class Magazine extends  LibraryItem {

        Magazine(String title) {
            super(title);
        }

        @Override
        public double calculateLateFee(int overdueDays) {
            return overdueDays * 2.0;
        }
    }


}