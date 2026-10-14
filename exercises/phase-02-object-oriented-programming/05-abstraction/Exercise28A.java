public class Exercise28A {
    abstract class LibraryItem {
        public void displayType() {
        System.out.println("Library item");
        }
    }

    class Book extends LibraryItem {

    }

    public static void main(String[] args) {
        Book book1 = new Book();
        book1.displayType();
    }
}