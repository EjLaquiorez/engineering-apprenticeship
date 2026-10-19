public class Exercise32A {

    interface Describable {
        void describe();
    }

    static class Book implements Describable {
        @Override
        public void describe() {
            System.out.println("This is a book.");
        }
    }

    static class Magazine implements Describable {
        @Override
        public void describe() {
            System.out.println("This is a magazine.");
        }
    }

    public static void main(String[] args) {
        Book book = new Book();
        Magazine magazine = new Magazine();

        book.describe();
        magazine.describe();
    }
}