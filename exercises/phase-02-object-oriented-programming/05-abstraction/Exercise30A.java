public class Exercise30A {
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


    }

    static class Book extends LibraryItem {

        Book(String title) {
            super(title);
        }
    }

    static class Magazine extends  LibraryItem {

        Magazine(String title) {
            super(title);
        }
    }


}