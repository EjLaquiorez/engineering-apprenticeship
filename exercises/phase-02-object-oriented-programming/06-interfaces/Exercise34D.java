public class Exercise34D {

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

    static class Video implements Describable {
        @Override
        public void describe() {
            System.out.println("Video: The Matrix");
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
        Describable[] items = {new Book(), new Magazine(), new Video(), new LibraryReport()};
        processItems(items);
    }
}