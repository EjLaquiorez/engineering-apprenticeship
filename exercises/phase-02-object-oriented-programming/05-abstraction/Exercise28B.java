public class Exercise28B {

    static abstract class LibraryItem {
        abstract public void displayType();
    }

    static class Book extends LibraryItem {
        @Override
        public void displayType() {
            System.out.println("This is a book.");
        }
    }

    public static void main(String[] args) {
        Book book = new Book();
        book.displayType();
    }
}