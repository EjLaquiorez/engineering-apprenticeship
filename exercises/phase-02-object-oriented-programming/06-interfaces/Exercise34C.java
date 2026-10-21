public class Exercise34C {

    interface Describable {
        void describe();
    }

    static class Book implements Describable {
        @Override
        public void describe() {
            System.out.println("Book: Clean Code");
        }
    }

    static class Magazine implements Describable {
        @Override
        public void describe() {
            System.out.println("Magazine: National Geographic");
        }
    }

    static class LibraryReport implements Describable {
        @Override
        public void describe() {
            System.out.println("Report: Monthly Library Summary");
        }
    }

    public static void processItems(Describable[] items) {
        for (Describable item : items) {
            item.describe();
        }
    }

    public static void main(String[] args) {
        Describable[] items = {new Book(), new Magazine(), new LibraryReport()};
        processItems(items);
    }
}