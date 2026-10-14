public class Exercise28A {
    static abstract class LibraryItem {
        public void displayType() {
        System.out.println("Library item");
        }
    }

    static class Book extends LibraryItem {

    }

    public static void main(String[] args) {
        Book book1 = new Book();
        book1.displayType();
    }
}